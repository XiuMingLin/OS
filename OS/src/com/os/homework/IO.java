/**
 * IO??
 * @Author vs
 * @Description //get(IO????)
 * @Date 2019??11??24??17??40??
 * @Param
 * @return
 **/

package com.os.homework;

import java.util.*;

public class IO {
    private ArrayList<process> IO_queue = new ArrayList<process>();    //IO队列

    public ArrayList<process> getIO_queue() {
        return IO_queue;
    }

    public void in_IO_queue(process pro)
    {
        IO_queue.add(pro);
    }

    public process out_IO_queue() {
        process out = IO_queue.get(0);
        IO_queue.remove(0);
        return out;
    }
    public boolean run(){

        if(!IO_queue.isEmpty()) { //io 如果不为空 每秒加一次时间
            process process1 = IO_queue.get(0);
            process1.run();
            IO_queue.set(0,process1);
            if(process1.iofinish()){
                // 完成的返回 就绪队列
                return true;
            }

        }
        return false;
    }
    public boolean ifempty(){
        return IO_queue.isEmpty();
    }
}
