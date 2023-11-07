import javax.swing.*;
import java.awt.*;

public class PongGame extends JPanel {
    
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;

    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;

    public PongGame(){
        
        gameBall = new Ball(320, 220, 3, 3, 3, Color.YELLOW, 5);

        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);


    }

    public void paintComponent(Graphics g){
   
        //make background
        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        //make the ball
        gameBall.paint(g);

        //paint the paddles
        userPaddle.paint(g);
        pcPaddle.paint(g);


    }

    public void setGameBall(Ball gameBall) {
        this.gameBall = gameBall;
    }

    public void gameLogic(){

        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);

        gameBall.moveBall();
    }
}