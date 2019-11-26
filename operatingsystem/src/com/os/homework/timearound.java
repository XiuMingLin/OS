/**
  * 时间片轮转类
  * @Author vs
  * @Description //get(时间片大小、就绪队列、阻塞队列)set(时间片大小)
  * @Date 2019年11月24日17点36分
  * @Param TODO
  * @return
  **/

package com.os.homework;

import java.sql.SQLOutput;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;


public class timearound {
    private int nowtime= 0 ;
    process process1 = new process();
    process process2 = new process();
    process process3 = new process();
    private float time_size;            //时间片大小
    private Queue<process> ready_queue; //就绪队列
    private Queue<process> block_queue; //阻塞队列

    public void setTime_size(float time_size) {
        this.time_size = time_size;
    }

    public float getTime_size() {
        return time_size;
    }

    public Queue<process> getReady_queue() {
        return ready_queue;
    }

    public Queue<process> getBlock_queue() {
        return block_queue;
    }

    public void init_pro(){
        //初始化三个进程,从界面获取数据

    }
    public void RUN()
    {
        //运行
        int cacheTime = 1000,delay = 2000;
        init_pro();
        int whichpro = 0;

        //单位时间一个循环
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

                if(nowtime%time_size ==0 ) {   //时间片结束 调度
                    //判断谁进就绪队列


                }
                nowtime++;

                //从就绪进程中选择一个上cpu , 完成、io、pv资源被占用的离开
                if(whichpro == 1){
                    process1.run();

                    if(process1.iffinish()) {
                        //出就绪队列
                    }
                    if(process1.ifio()){
                        //进入io队列
                    }
                    if (process1.ifpv()){
                        //进入pv队列
                    }
                }else if(whichpro == 2){
                    process1.run();
                    if(process1.iffinish()) {
                        //出就绪队列
                    }
                    if(process1.ifio()){
                        //进入io队列
                    }
                    if (process1.ifpv()){
                        //进入pv队列
                    }
                }else if(whichpro == 3){
                    process1.run();
                    if(process1.iffinish()) {
                        //出就绪队列
                    }
                    if(process1.ifio()){
                        //进入io队列
                    }
                    if(process1.ifpv()){
                        //进入pv队列
                    }
                }
                //更新就绪队列
            }
        }, delay, cacheTime);


    }

    public void R2B_queue(process pro)
    {
        //就绪队列——阻塞队列
    }

    public void B2R_queue(process pro)
    {
        //阻塞队列——就绪队列
    }
}
