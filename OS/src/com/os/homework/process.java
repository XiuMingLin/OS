/**
 * ������
 * ����ʵ�� TODO
 * �������Զ�����set��get
 */

package com.os.homework;

import java.util.ArrayList;

public class process {
    private int Arrive_time;      //����ʱ��
    private int Server_time;      //����ʱ��
    private ArrayList<Integer> Critical_stime_List;       //�ٽ���Դ��ʼʱ����б���Σ�
    private ArrayList<Integer> Critical_etime_Liat;       //�ٽ���Դ����ʱ����б���Σ�
    int p1_s_time = -1;
    int p1_e_time = -1;
    int p2_s_time = -1;
    int p2_e_time = -1;
    private int IO_stime;             //IO��ʼʱ�䣨��Σ�
    private int IO_etime;             //IO����ʱ�䣨��Σ�
    private int runtime;          //������ʱ��
    private String pro_name;

    public process(String name)
    {
        this.pro_name = name;
    }

    public process(){}

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getArrive_time() {
        return Arrive_time;
    }

    public int getServer_time() {
        return Server_time;
    }

    public ArrayList<Integer> getCritical_stime_List() {
        return Critical_stime_List;
    }

    public ArrayList<Integer> getCritical_etime_Liat() {
        return Critical_etime_Liat;
    }

    public int getIO_stime() {
        return IO_stime;
    }

    public int getIO_etime() {
        return IO_etime;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setArrive_time(int arrive_time) {
        Arrive_time = arrive_time;
    }

    public void setServer_time(int server_time) {
        Server_time = server_time;
    }

    public void setCritical_stime_List(ArrayList<Integer> critical_stime_List) {
        Critical_stime_List = critical_stime_List;
    }

    public void setCritical_etime_Liat(ArrayList<Integer> critical_etime_Liat) {
        Critical_etime_Liat = critical_etime_Liat;
    }

    public void setIO_stime(int IO_stime) {
        this.IO_stime = IO_stime;
    }

    public void setIO_etime(int IO_etime) {
        this.IO_etime = IO_etime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void run()
    {
        this.runtime ++;

    }

    public boolean ifp(){
        if(p1_s_time == runtime || p2_s_time == runtime){
            return true;
        }
        return false;
    }
    public boolean ifio(){
        if(IO_stime == runtime){
            return true;
        }
        return false;
    }
    public boolean iffinish(){
        if(this.Server_time == runtime){
            return true;
        }
        return false;
    }
    public boolean iofinish(){
        if(IO_etime == runtime){
            return true;
        }
        return false;
    }
    public boolean ifv(){
        if(p1_e_time == runtime || p2_e_time == runtime){
            return true;
        }
        return false;
    }
    public int whichv(){
        if(runtime == p2_s_time&&runtime == p1_s_time)
            return 3;
        else if(runtime == p2_s_time){
            return 2;
        } else if(runtime == p1_s_time){
            return 1;
        }
        return 0;
    }
    public int whichp(){
        if(runtime == p2_s_time&&runtime == p1_s_time)
            return 3;
        else if(runtime == p2_s_time){
            return 2;
        }
        else if(runtime == p1_s_time){
        return 1;}
        return 0;
    }

    public void setP1_s_time(int p1_s_time) {
        this.p1_s_time = p1_s_time;
    }

    public void setP1_e_time(int p1_e_time) {
        this.p1_e_time = p1_e_time;
    }

    public void setP2_s_time(int p2_s_time) {
        this.p2_s_time = p2_s_time;
    }

    public void setP2_e_time(int p2_e_time) {
        this.p2_e_time = p2_e_time;
    }

    public int getP1_s_time() {
        return p1_s_time;
    }

    public int getP1_e_time() {
        return p1_e_time;
    }

    public int getP2_s_time() {
        return p2_s_time;
    }

    public int getP2_e_time() {
        return p2_e_time;
    }
}
