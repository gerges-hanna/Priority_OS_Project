/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import javax.swing.*;
import os_project_priority.*;

/**
 *
 * @author user
 */
public class ganttchart extends JPanel {
    
    public int x=50 ;
    public int y ;
    
    
    public void init(){
        setSize(1500,720);
    }
    
    public void paint(Graphics g){
        
        g.setColor(Color.black);
        
       for(int i=0; i<Info.finalList.size(); i++){
           x=Info.finalList.get(i).getBT()*13+x+50;
           y=x-Info.finalList.get(i).getBT()*13-50;
           g.drawLine(x, 400, x, 480);
           g.drawString(String.valueOf(Info.finalList.get(i).getPname()), y, 420);
           g.drawString(String.valueOf(Info.finalList.get(i).getStart()), y, 500);
       }
        g.drawRect(50, 400, x-50 , 80);
        
    }
    
}


    
   
    

