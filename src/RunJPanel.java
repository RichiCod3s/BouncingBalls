
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunJPanel {
 public static void main(String[] args) throws InterruptedException {
	 //creates JPanel
	 // Creating a ball object and thread for each object
	 System.out.println("Main thread is- "
             + Thread.currentThread().getName());
	 	
	 	// create JFrame
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //dimensions of panel and x & y diameter of ball (ballSize to be used twice)
        int panelHeight = 400;
        int panelWidth = 400;
        int ballSize = 30;  // diameter
        
        // create instance of Random class
        Random rand = new Random();
        // random starting positions
        int randX = rand.nextInt(panelWidth - ballSize);
        int randY = rand.nextInt(panelHeight - ballSize);
       
        // ball object
        Ball ball = new Ball(randX, randY, ballSize, getRandomColour());
       // Ball ball2 = new Ball(randX, randY, ballSize, Color.RED);
        JPanel panel = new JPanel() {
     
			private static final long serialVersionUID = 1L; // IDE asked for this

			@Override
            protected void paintComponent(Graphics g) {
            	
                super.paintComponent(g);
                ball.draw(g);
            }
        };
        
        //set panel 
        panel.setBackground(Color.WHITE);
        panel.setDoubleBuffered(true);
        frame.add(panel); // add panel to frame
        frame.setSize(panelWidth, panelHeight); // set dimensions of the panel
        frame.setVisible(true); // make frame visible

        
       //Create a BallRunnable object from the Ball object and start a new thread
        BallRunnable ballRunnable = new BallRunnable(ball, panel, panelWidth, panelHeight);
        new Thread(ballRunnable).start();// start the thread
        
   
        

    }
 		// don't need this but makes a random colour for the ball
	 public static Color getRandomColour() {
	     Random rand = new Random();
	     float r = rand.nextFloat();
	     float g = rand.nextFloat();
	     float b = rand.nextFloat();
	     return new Color(r, g, b);
	 }

}
