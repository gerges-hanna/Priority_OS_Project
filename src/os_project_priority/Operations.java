/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_project_priority;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class Operations {

    public static int split;
    public static int numPriority;
    public Operations(int split, int processNum) {
        this.sortList();
            this.CountRepeat();
            this.filter(split);
            this.MergePriority();
            this.MoveToFinalAndSort();
            this.putStartAndStop();
    }

    public Operations() {
    }
    
    
    public void sortList()
    {
        Info.list.sort(Comparator.comparing(Info::getPriority));
    }
    public void CountRepeat()
    {
        for (int i =0; i < Info.list.size() ; i++) {
            int flag=0,repeat=0;
            for (int j = 0; j < Info.list.size(); j++) {
                if(i==j)
                {
                    continue;
                }
                if(Info.list.get(i).getPriority()==Info.list.get(j).getPriority())
                {
                    flag=1;
                    repeat=repeat+1;
                }
            }
            if(flag==0)
            {
                Info.finalList.add(Info.list.get(i));
                Info.list.remove(i);
                i--;
            }else
            {
              Info.list.get(i).setRepeat(repeat);
            }
                
            
            
        }
    }
    public void filter(int split)
    {
        while(Info.list.size()!=0)
            {
                int count=0;
                while(count<Info.list.get(0).getRepeat()+1)
                    {
                        count=0;
                        for (int j = 0; j <=Info.list.get(0).getRepeat(); j++) {
                            Info f;
                            if(Info.list.get(j).getBT()==0)
                            {
                                count++;
                                continue;
                            }

                            if(Info.list.get(j).getBT()>=split)
                            {

                                int listbt=Info.list.get(j).getBT()-split;
                                Info.list.get(j).setBT(split);
                                f=new Info(Info.list.get(j).getPname(), Info.list.get(j).getBT(), Info.list.get(j).getPriority());
                                Info.processlist.add(f);
                                Info.list.get(j).setBT(listbt);


                            }else if(Info.list.get(j).getBT()<split && Info.list.get(j).getBT()>0)
                            {
                                f=new Info(Info.list.get(j).getPname(), Info.list.get(j).getBT(), Info.list.get(j).getPriority());
                                Info.processlist.add(f);
                                Info.list.get(j).setBT(0);

                            }


                        }
                    }

                    for (int i = Info.list.get(0).getRepeat(); i >=0 ; i--) {

                    Info.list.remove(i);
                }
                    
            }
    }
    public void MergePriority()
    {
        for (int i = Info.processlist.size()-1; i >0; i--) {
                if(!Info.processlist.get(i).getPname().equalsIgnoreCase(Info.processlist.get(i-1).getPname()))
                {
                    continue;
                }else
                {
                    int bt=Info.processlist.get(i).getBT()+Info.processlist.get(i-1).getBT();
                    Info.processlist.remove(i);
                    Info.processlist.get(i-1).setBT(bt);
                }
        }
    }
    public void MoveToFinalAndSort()
    {
        
            
            for (int i = 0; i < Info.processlist.size();) {
                    
                Info.finalList.add(Info.processlist.get(i));
                Info.processlist.remove(i);
                
                
            }
             Info.finalList.sort(Comparator.comparing(Info::getPriority));
             
    }
    public  void putStartAndStop()
    {
        Info.finalList.get(0).setStop(Info.finalList.get(0).getBT());
        for (int i = 1; i < Info.finalList.size(); i++) {
            Info.finalList.get(i).setStart(Info.finalList.get(i-1).getStop());
            Info.finalList.get(i).setStop(Info.finalList.get(i).getBT()+Info.finalList.get(i-1).getStop());
        }
            for (int i = 0; i < Info.finalList.size(); i++) 
            {
                System.out.println(Info.finalList.get(i).getPname()+" f "+Info.finalList.get(i).getBT()+" "+Info.finalList.get(i).getPriority()+" "+Info.finalList.get(i).getStart()+" "+Info.finalList.get(i).getStop());
            }
    }
    
    public  ArrayList<Info> schudlingTime(int processNum){
        ArrayList<Info> arr = new ArrayList<Info>();
        for(int i = 0; i< processNum;i++){
            Info f = new Info();
            f.setPname("p"+i+1);
            int repeat = -1 ;
            for(int j = 0; i< processNum;j++){
                 if(Info.finalList.get(j).getPname().equalsIgnoreCase(f.getPname())){
                     repeat++;
                 }
           
            }//for 2
            
            f.setRepeat(repeat);
            arr.add(f);
            
            for (int k = 0 ; k < Info.finalList.size() ; k++) {
                if(Info.finalList.get(k).getPname().equals(arr.get(i).getPname() )){
                    arr.get(i).setBT( arr.get(i).getBT() + Info.finalList.get(k).getBT());
                    if(arr.get(i).getRepeat() == repeat){
                        arr.get(i).setWaitingTime(Info.finalList.get(k).getStart());
                        arr.get(i).setRepeat(arr.get(i).getRepeat()-1);
                    }
                    else if(arr.get(i).getRepeat() == 0 && repeat > 0 ){
                        arr.get(i).setTurnaroundTime(Info.finalList.get(k).getStop());
                    }
                    else{
                        arr.get(i).setWaitingTime(Info.finalList.get(k).getStart());
                        arr.get(i).setTurnaroundTime(Info.finalList.get(k).getStop());
                    }
                    
                }
            }//for 3
            arr.get(i).setResponseTime(arr.get(i).getTurnaroundTime()-arr.get(i).getBT());
            
        }//for1
        
        
        
        return arr ;
    }
    
    public int[] schudlingAvgTime(ArrayList<Info> processArr , int processNum){
        int [] arr  = new int[3];
        int avgWitingT  = 0, avgTurnaroundT= 0 , avgResponseT = 0 ;
        for(int i = 0 ; i < processNum ; i++ ){
            avgWitingT += processArr.get(i).getWaitingTime();
        }
        
        for(int i = 0 ; i < processNum ; i++ ){
            avgTurnaroundT += processArr.get(i).getTurnaroundTime();
        }
         
        for(int i = 0 ; i < processNum ; i++ ){
            avgResponseT += processArr.get(i).getResponseTime();
        }
        
        avgWitingT = avgWitingT / processNum;
        avgTurnaroundT = avgTurnaroundT / processNum;
        avgResponseT = avgResponseT /processNum ;
        
        arr[0] = avgWitingT;
        arr[1] = avgTurnaroundT;
        arr[2] = avgResponseT;
        return arr ;
    }
    
}//end class
