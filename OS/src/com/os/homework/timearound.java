/**
  * 时间片轮转类
  * @Author vs
  * @Description //get(时间片大小、就绪队列、阻塞队列)set(时间片大小)
  * @Date 2019年11月24日17点36分
  * @Param TODO
  * @return
  **/

package com.os.homework;

import com.os.homework.UI.LogList;
import com.os.homework.UI.ProcessRuntime;
import com.os.homework.UI.Source;
import com.os.homework.UI.UtilInfos;

import javax.swing.*;
import java.util.*;
import java.util.Timer;


public class timearound {
    public Timer timer;
    public static timearound instance;
    public timearound()
    {
        instance = this;
    }
    private int nowtime= 0 ;
    int refreshtime = 0;
    IO io = new IO();
    boolean ioflag = false;
    static PV[] pv = new PV[2];
    static {
        pv[0] = new PV();
        pv[1] = new PV();
    }
    int count =0;
    process process1 = new process();
    process process2 = new process();
    process process3 = new process();
    process pc = new process();
    private int time_size;            //时间片大小
    private ArrayList<process> ready_queue = new ArrayList<process>(); //就绪队列
    private ArrayList<process> pvblock_queue = new ArrayList<process>(); //阻塞队列
    boolean deadlock = false;

    public void setTime_size(int time_size) {
        this.time_size = time_size;
        System.out.println("时间片大小："+time_size);
        LogList.getInstance().getLogList().append("时间片设置为"+time_size+"\n");
    }

    public process getProcess1() {
        return process1;
    }

    public process getProcess2() {
        return process2;
    }

    public process getProcess3() {
        return process3;
    }

    public void setProcess1(process process1) {
        this.process1 = process1;
    }

    public void setProcess2(process process2) {
        this.process2 = process2;
    }

    public void setProcess3(process process3) {
        this.process3 = process3;
    }

    public int getTime_size() {
        return time_size;
    }

    public ArrayList<process> getReady_queue() {
        return ready_queue;
    }

    public ArrayList<process> getBlock_queue() {
        return pvblock_queue;
    }

    public void init_pro(){
        //初始化三个进程,从界面获取数据

    }
    public void arrive(){
        if (process1.getArrive_time()==nowtime){
            ready_queue.add(process1);
        }
        if (process2.getArrive_time()==nowtime){
            ready_queue.add(process2);
        }
        if (process3.getArrive_time()==nowtime){
            ready_queue.add(process3);
        }
    }
    public void io_op(){
        if(!io.ifempty()){
            UtilInfos.UpdateIO(io.getIO_queue().get(0));
            ioflag = io.run();
            if (ioflag){
                process p = io.out_IO_queue();
                ready_queue.add(p);
                if(!io.ifempty()){
                    UtilInfos.UpdateIO(io.getIO_queue().get(0));
                }
                else{
                    UtilInfos.UpdateIO(new process(""));
            }
            }
        }
        else
        {
            UtilInfos.UpdateIO(new process(""));
        }
    }
    public void RUN(){
        //运行

        int cacheTime = 1000,delay = 2000;
        init_pro();

        if(timer != null) {
            timer = null;
            nowtime = 0;
            count = 0;
            refreshtime = 0;
        }

        //单位时间一个循环
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                arrive(); //到达进入就绪队列

                ProcessRuntime.UpdateTime();

                find_run_process();
                if(count >=3 )
                {
                    LogList._instance.getLogList().append("RunTime:"+nowtime+"运行结束\n");
                    timer.cancel();
                    return;
                }

                if(deadlock)
                {
                    return;
                }
                if(!ready_queue.isEmpty()) {
                    pc.run();
                    LogList._instance.getLogList().append("RunTime:"+nowtime+pc.getPro_name()+"在CPU上运行\n");
                    UtilInfos.Updateinfo(pc, nowtime);
                    ready_queue.set(0, pc);
                }
                else {
                    UtilInfos.Updateinfo(null, nowtime);
                    LogList._instance.getLogList().append("RunTime:"+nowtime+"CPU上无进程运行\n");
                }
                io_op();  //io运行 io完成进入就绪队列

                if (pc!=null&&pc.ifv()) {
                    v();
//                    UtilInfos.Updateinfo(pc, nowtime);
//                    return;
                    //ready_queue.set(0, pc);
                }

                nowtime++;
                refreshtime++;
                if (!ready_queue.isEmpty()&&refreshtime % time_size == 0) {   //时间片结束 调度
                    LogList._instance.getLogList().append("RunTime:"+nowtime+"时间片结束\n");
                    process temp = ready_queue.get(0);
                    ready_queue.remove(0);
//                    if(temp.getRuntime()!=temp.getServer_time())
                        ready_queue.add(temp);
//                    else{
//                        System.out.println(temp.getPro_name()+"结束1"+nowtime);
//                        newcount++;
//                        System.out.println(newcount);
//                        if(newcount >= 3)
//                        {
//                            LogList._instance.getLogList().append("RunTime:"+nowtime+"运行结束\n");
//                            timer.cancel();
//                        }
                    }
                }


//            }
        }, delay, cacheTime);
    }
    public void find_run_process(){
        if(!ready_queue.isEmpty()) {  //就绪队列非空
            pc = ready_queue.get(0);  //获得队首
            if (pc!=null&&pc.iffinish()) {
                ready_queue.remove(pc);
                System.out.println(pc.getPro_name()+"结束2"+nowtime);
                count++;
                while (refreshtime%time_size!=0){
                    refreshtime--;
                }

                find_run_process();
                return;
            }
            if (pc!=null&&pc.ifio()) {
                io.in_IO_queue(pc);
                while (refreshtime%time_size!=0){
                    refreshtime--;
                }
                ready_queue.remove(pc);
                find_run_process();
                return;
            }


            if (pc!=null&&pc.ifp()) {
                p();
                return;
            }

        }
        else{
            pc = null;
        }



    }

    public void R2B_queue(process pro)
    {
        //就绪队列——阻塞队列

        pvblock_queue.add(pro);
        ready_queue.remove(pro);

        LogList._instance.getLogList().append("RunTime:"+nowtime+pro.getPro_name()+"从就绪队列到阻塞队列"+"\n");DeadLock();
    }

    public void B2R_queue(process pro)
    {
        //阻塞队列——就绪队列
        ready_queue.add(pro);
        pvblock_queue.remove(pro);
        LogList._instance.getLogList().append("RunTime:"+nowtime+pro.getPro_name()+"从阻塞队列到就绪队列"+"\n");
    }
    public void p(){
        int  whichpvsource = pc.whichp();
        if(whichpvsource==1||whichpvsource==2){
            if(!pv[whichpvsource-1].ifoccupy)  //资源没有被占用
            {
                pv[whichpvsource - 1].P();
                LogList._instance.getLogList().append("RunTime:"+nowtime+pc.getPro_name()+"获得资源"+whichpvsource+"\n");
                Source.UpdateSouce(whichpvsource, pc);
            }
            else{
                //资源被占用 进入pv队列
                R2B_queue(pc);
//                LogList._instance.getLogList().append(pc.getPro_name()+"进入阻塞队列"+"\n");
                find_run_process();
                while (refreshtime%time_size!=0){
                    refreshtime--;
                }
                return;
            }
        }
        else if(whichpvsource == 3){
            if(!pv[0].ifoccupy&&!pv[1].ifoccupy) { //资源没有被占用
                pv[1].P();
                pv[0].P();
                LogList._instance.getLogList().append("RunTime:"+nowtime+pc.getPro_name()+"获得资源1和2"+"\n");
                Source.UpdateSouce(whichpvsource, pc);
            }
            else{
                //资源被占用 进入pv队列
                R2B_queue(pc);
//                LogList._instance.getLogList().append(pc.getPro_name()+"进入阻塞队列"+"\n");
                find_run_process();

                while (refreshtime%time_size!=0){
                    refreshtime--;
                }
                return;
            }
        }


    }

    public void v(){
        //释放资源
        int  whichv = pc.whichv();
        if(whichv == 1 || whichv == 2) {
            pv[whichv-1].V();
            LogList._instance.getLogList().append("RunTime:"+nowtime+pc.getPro_name()+"释放资源"+whichv+"\n");
            Source.UpdateSouce(whichv, new process(""));
        }
        else if(whichv == 3){
            pv[0].V();
            pv[1].V();
            LogList._instance.getLogList().append("RunTime:"+nowtime+pc.getPro_name()+"释放资源1和2"+"\n");
            Source.UpdateSouce(whichv, new process(""));
        }
        //判断pv队列中哪一个进就绪队列
        int which_source;
        if(!pvblock_queue.isEmpty()){
            for(int i =0 ; i<pvblock_queue.size();i++){
                process processsssssss = pvblock_queue.get(i);
                which_source = processsssssss.whichp();
                if (which_source == 3&&pv[0].ifoccupy==false&&pv[1].ifoccupy==false){
                    B2R_queue(processsssssss);
                    break;
                }
                if((which_source==1||which_source ==2)&&!pv[which_source-1].ifoccupy){
                    B2R_queue(processsssssss);
                    break;
                }

            }
        }
    }

    public void DeadLock()
    {
        if(pvblock_queue.size() == 3-count)
        {
            deadlock = true;
            LogList._instance.getLogList().append("RunTime:"+nowtime+"发生死锁\n");
            Object[] options = { "是" };
            JOptionPane.showOptionDialog(null, "发生死锁","死锁",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options,options);
            timer.cancel();

        }
    }
}
