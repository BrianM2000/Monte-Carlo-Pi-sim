import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;

public class MonteCarloPi extends Canvas implements MouseListener{
  
  double points = 1;
  double pointsInCircle = 0;
  double ApproxPi;
  boolean tf = true;
  Random rand = new Random();
  
  Timer timer = new Timer();
  TimerTask count = new TimerTask(){
    public void run(){
      Graphics g = getGraphics();
      
      g.setColor(Color.white);
      g.fillRect(200, 100, 300, 100);
      
      points++;
      int x = rand.nextInt(300) + 200;
      int y = rand.nextInt(300) + 200;
      
      g.setColor(Color.red);
      
      
      if(distTo(x, y, 350, 350) <= 150.0){
        pointsInCircle++;
        g.setColor(Color.blue);
        
      }
      g.fillOval(x, y, 2, 2);
      
      ApproxPi = 4 * (pointsInCircle/points);
        
      g.setColor(Color.black);
      g.drawString(/*String.format("%.10g%n",*/"Pi " + String.valueOf(ApproxPi), 275, 175);
      g.drawString("Total points      " + String.valueOf(points), 275, 150);
      g.drawString("Points in Circle  " + String.valueOf(pointsInCircle), 275, 125);
      
    }
    
  };
  
  public static void main(String [] args){
    JFrame frame = new JFrame();
    Canvas canvas = new MonteCarloPi();
    canvas.setSize(700, 700);
    
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.white);
    
  }
  
  public void paint(Graphics g){
    
    addMouseListener(this);
    g.setColor(Color.white);
    g.fillRect(0, 0, 700, 700);
    
    g.setColor(Color.black);
    g.drawRect(200, 200, 300, 300);
    g.drawOval(200, 200, 300, 300);
    
    
    
  }
  
  public void mousePressed(MouseEvent me){
    
  }
  
  public void mouseReleased(MouseEvent me){
    
  }
      
  public void mouseEntered(MouseEvent me){
    
  }
      
  public void mouseExited(MouseEvent me){
    
  }
      
  public void mouseClicked(MouseEvent me){
    
    if(tf){
      timer.scheduleAtFixedRate(count, 0, 1);
      System.out.println("Hello");
      tf = false;
    }
    else{
      timer.cancel();
      timer.purge();
      System.out.println("goodbye");
      
      tf = true;
    }
   
  }
  
  public double distTo(double x, double y, double px, double py){
    //System.out.println(Math.sqrt(Math.abs(x - px) * Math.abs(x - px) + Math.abs(y - py) * Math.abs(y - py)));
    return Math.sqrt(Math.abs(x - px) * Math.abs(x - px) + Math.abs(y - py) * Math.abs(y - py));
  }
  
}