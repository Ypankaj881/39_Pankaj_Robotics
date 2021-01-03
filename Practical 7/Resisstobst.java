/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract9;

import ch.aplu.robotsim.*;
import ch.aplu.util.QuitPane;

public class Resisstobst {
    
    public Resisstobst()
    {
        LegoRobot robot=new LegoRobot();
        Gear g=new Gear();
        TouchSensor t1=new TouchSensor(SensorPort.S1);
        TouchSensor t2=new TouchSensor(SensorPort.S2);
        robot.addPart(g);
        robot.addPart(t1);
        robot.addPart(t2);
        g.forward();
        while(!QuitPane.quit())
        {
            boolean v1= t1.isPressed();
            boolean v2= t2.isPressed();
            if(v1)
            {
               g.backward(500);
               g.left(400);
               g.forward();
            }
            else
            {
                if(v2)
                {
                   g.backward(500);
                   g.right(400);
                   g.forward();  
                }
            
               else
                {
                    if(v1&& v2)
                    {
                        g.backward(500);
                        g.left(400);
                        g.forward();
                        
                    }
                }
        }
            
    }
        robot.exit();
    }
   public static void main(String arg[]) 
   {
       Resisstobst r=new Resisstobst();
   }
   static
   {
       RobotContext.setLocation(10, 10);
       RobotContext.setStartDirection(5);
       RobotContext.setStartPosition(100, 240);
       RobotContext.useObstacle(RobotContext.channel);
   }
}
