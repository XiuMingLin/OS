/**
  * 时间片轮转类
  * @Author vs
  * @Description //get(时间片大小、就绪队列、阻塞队列)set(时间片大小)
  * @Date 2019年11月24日17点36分
  * @Param TODO
  * @return
  **/

package com.os.homework;

import com.os.homework.UI.ProcessRuntime;
import com.os.homework.UI.Source;
import com.os.homework.UI.UtilInfos;

import java.sql.SQLOutput;
import java.util.*;
import java.text.SimpleDateFormat;


public class timearound {
    private int nowtime= 0 ;
    IO io = new IO();
    boolean ioflag = false;
    static PV[] pv = new PV[2];
    static {
        pv[0] = new PV();
        pv[1] = new PV();
    }
    process process1 = new process();
    process process2 = new process();
    process process3 = new process();
    process pc = new process();
    private int time_size;            //时间片大小
    private ArrayList<process> ready_queue = new ArrayList<process>(); //就绪队列
    private ArrayList<process> pvblock_queue = new ArrayList<process>(); //阻塞队列

    public void setTime_size(int time_size) {
        this.time_size = time_size;
        System.out.println("时间片大小："+time_size);
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

        //单位时间一个循环
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int whichpvsource = 0 ;
                nowtime++;
                arrive(); //到达进入就绪队列
                io_op();  //io运行 io完成进入就绪队列

                ProcessRuntime.UpdateTime();
                UtilInfos.Updateinfo(null, nowtime);

                if(!ready_queue.isEmpty()) {
                    pc = ready_queue.get(0);
                    UtilInfos.Updateinfo(pc, nowtime);
                    //从就绪进程中选择一个上cpu , 完成、io、pv资源被占用的离开
                    pc.run();

                    if (pc.iffinish()) {
                        ready_queue.remove(0);
                        System.out.println("一个京城结束");
                    } else if (pc.ifio()) {
                        io.in_IO_queue(pc);
                        ready_queue.remove(0);
                    } else if (pc.ifp()) {
                        p();
                    } else if (pc.ifv()) {
                        v();
                    } else {
                        ready_queue.set(0, pc);
                    }


                    if (!ready_queue.isEmpty()&&nowtime % time_size == 0) {   //时间片结束 调度
                        process temp = ready_queue.get(0);
                        ready_queue.remove(0);
                        ready_queue.add(temp);
                    }
                }
            }
        }, delay, cacheTime);
    }

    public void R2B_queue(process pro)
    {
        //就绪队列——阻塞队列

        pvblock_queue.add(pro);
        ready_queue.remove(pro);
    }

    public void B2R_queue(process pro)
    {
        //阻塞队列——就绪队列
        ready_queue.add(pro);
        pvblock_queue.remove(pro);
    }
    public void p(){
        int  whichpvsource = pc.whichp();
        if(whichpvsource!=3){
            if(!pv[whichpvsource-1].ifoccupy)  //资源没有被占用
            {
                pv[whichpvsource - 1].P();
                Source.UpdateSouce(whichpvsource, pc);
            }
            else{
                //资源被占用 进入pv队列
                R2B_queue(pc);
            }
        }
        else{
            if(!pv[0].ifoccupy&&!pv[1].ifoccupy) { //资源没有被占用
                pv[1].P();
                pv[0].P();
            }
            else{
                //资源被占用 进入pv队列
                R2B_queue(pc);
            }
        }


    }
    public void v(){
        //释放资源
        int  whichv = pc.whichv();
        if(whichv == 1 || whichv == 2)
            pv[whichv-1].V();
        else if(whichv == 3){
            pv[0].V();
            pv[1].V();
        }
        //判断pv队列中哪一个进就绪队列
        int which_source;
        for(process i :pvblock_queue){
            which_source = i.whichp();
            if (which_source == 3&&pv[0].ifoccupy==false&&pv[1].ifoccupy==false){
                B2R_queue(i);
            }else {
                if(!pv[which_source-1].ifoccupy){
                    B2R_queue(i);
                }
            }
        }
    }
}
