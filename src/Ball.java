import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball{
    private int x, y; // position of the ball
    private int size; // size of the ball / diameter of x or y
    private Color color; // colour  the ball 

    //Set Random starting direction and velocity
    Random rd = new Random();
    boolean isMovingUp = rd.nextBoolean();
    boolean isMovingLeft = rd.nextBoolean();
    int velocityx = rd.nextInt(4) + 3; // Generates a random number between 0 and 3, adds 3 to it to get a random number between 3 and 6.
    int velocityy = rd.nextInt(4) + 3;

    public Ball(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void move() {
        if(isMovingLeft) {
             x -= velocityx;
        }
        else {
            x += velocityx;
        }

        if(isMovingUp) {
             y -= velocityy;
        }
        else {
             y += velocityy;
        }
    }

    public void draw(Graphics g) {
        // draw the ball
        g.setColor(color); // assign colour
        g.fillOval(x, y, size, size); // assign circle position and dimensions x & y
    }

    public void checkBounds(int width, int height) {
        // check if the ball hits the walls of the panel
        if (x < 0 || x + size > width) {
            isMovingLeft = !isMovingLeft;
        }
        if (y < 0 || y + size*2 > height) { // *2 helps, it was dipping under
            isMovingUp = !isMovingUp;
        }
    }

    
}
