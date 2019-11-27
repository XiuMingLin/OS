/**
 * IO??
 * @Author vs
 * @Description //get(IO????)
 * @Date 2019??11??24??17??40??
 * @Param
 * @return
 **/

package com.os.homework;

import java.util.Queue;

public class IO {
    private Queue<process> IO_queue;    //IO队列

    public Queue<process> getIO_queue() {
        return IO_queue;
    }

    public void in_IO_queue()
    {
        //??IO????
    }

    public void out_IO_queue()
    {
        //??IO????
    }
    public void run(){

        process process1 = new process();
        //io 如果不为空 每秒加一次时间
        process1.run();
        if(process1.iofinish()){
            // 完成的返回就绪队列

        }

    }
}
