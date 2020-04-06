/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_project_priority;
import gui.ganttchart;
import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFrame;
/**
 *
 * @author Gerges hanna FCI-H
 */
public class OS_Project_priority {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Info.list.add(new Info("p1", 10, 1));
        Info.list.add(new Info("p2", 10, 2));
        Info.list.add(new Info("p3", 2, 3));
        Info.list.add(new Info("p4", 1, 3));
        Info.list.add(new Info("p5", 5, 2));
        Operations op=new Operations(5);
        
        
        JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new ganttchart());
      frame.setSize(1500, 720);
      frame.setBackground(Color.LIGHT_GRAY);
      frame.setVisible(true);    
        
            
    }
    
}
