/**
 * 进程类
 * 用于实现 TODO
 * Float 是对象 float是基本类型数据
 * Float.tofloatValue()返回值为float
 * 所有属性都具有set、get
 */

package com.os.homework;

import java.util.ArrayList;

public class process {
    private float Arrive_time;      //到达时间
    private float Server_time;      //运行时间
    private ArrayList<Float> Critical_stime_List;       //临界资源开始时间的列表（多次）
    private ArrayList<Float> Critical_etime_Liat;       //临界资源结束时间的列表（多次）
    private ArrayList<Float> IO_stime_List;             //IO开始时间（多次）
    private ArrayList<Float> IO_etime_List;             //IO结束时间（多次）
    private float runtime;          //已运行时间

    public float getArrive_time() {
        return Arrive_time;
    }

    public float getServer_time() {
        return Server_time;
    }

    public ArrayList<Float> getCritical_stime_List() {
        return Critical_stime_List;
    }

    public ArrayList<Float> getCritical_etime_Liat() {
        return Critical_etime_Liat;
    }

    public ArrayList<Float> getIO_stime_List() {
        return IO_stime_List;
    }

    public ArrayList<Float> getIO_etime_List() {
        return IO_etime_List;
    }

    public float getRuntime() {
        return runtime;
    }

    public void setArrive_time(float arrive_time) {
        Arrive_time = arrive_time;
    }

    public void setServer_time(float server_time) {
        Server_time = server_time;
    }

    public void setCritical_stime_List(ArrayList<Float> critical_stime_List) {
        Critical_stime_List = critical_stime_List;
    }

    public void setCritical_etime_Liat(ArrayList<Float> critical_etime_Liat) {
        Critical_etime_Liat = critical_etime_Liat;
    }

    public void setIO_stime_List(ArrayList<Float> IO_stime_List) {
        this.IO_stime_List = IO_stime_List;
    }

    public void setIO_etime_List(ArrayList<Float> IO_etime_List) {
        this.IO_etime_List = IO_etime_List;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }
}
