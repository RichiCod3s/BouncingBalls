
import javax.swing.JPanel;


public class BallRunnable implements Runnable {
	
	private Ball ball; // ball class
    private JPanel panel; // JPane;
    private int panelWidth; // dimensions of the panel
    private int panelHeight;

    public BallRunnable(Ball ball, JPanel panel, int panelWidth, int panelHeight) {
    	this.ball = ball;
        this.panel = panel;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    // run method for the runnable 
    @Override
    public void run() {
    		// print out the thread thats running - just to see
    	   System.out.println(Thread.currentThread().getName()
                   + ", executing run() method!");
    	
        while (true) {
            // Move the ball and check bounds
            ball.move();
            ball.checkBounds(panelWidth, panelHeight); //check bounds against the panel dimensions
            
            // Repaint panel to show updated ball position
            panel.repaint();
            
            // Pause before updating the ball again
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
