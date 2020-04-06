/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_project_priority;

import java.util.ArrayList;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class Info {
    public static ArrayList<Info> list=new ArrayList<Info>();
    public static ArrayList<Info> processlist=new ArrayList<Info>();
    public static ArrayList<Info> finalList=new ArrayList<Info>();
    
    private String Pname;
    private int BT;
    private int Priority;
    private int start;
    private int stop;
    private int repeat;
    private int turnaroundTime ;
    private int waitingTime;
    private int responseTime ;
    

    public Info(String Pname, int BT, int Priority) {
        this.Pname = Pname;
        this.BT = BT;
        this.Priority = Priority;
        this.start=0;
        this.stop=0;
        this.repeat=0;
    }
    

    

    public Info() {
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public int getBT() {
        return BT;
    }

    public void setBT(int BT) {
        this.BT = BT;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }
    
    
}
