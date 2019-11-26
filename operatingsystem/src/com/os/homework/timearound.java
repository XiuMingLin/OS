/**
  * 时间片轮转类
  * @Author vs
  * @Description //get(时间片大小、就绪队列、阻塞队列)set(时间片大小)
  * @Date 2019年11月24日17点36分
  * @Param TODO
  * @return
  **/

package com.os.homework;

import java.util.Queue;

public class timearound {
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

    public void RUN()
    {
        //运行
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
