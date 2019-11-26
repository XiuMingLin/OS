/**
 * IO类
 * @Author vs
 * @Description //get(IO队列)
 * @Date 2019年11月24日17点40分
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
        //入IO队列
    }

    public void out_IO_queue()
    {
        //出IO队列
    }
}
