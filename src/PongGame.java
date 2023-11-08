import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener{
    
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;

    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;
    private int userMouseY, userScore, pcScore, bounceCount;

    public PongGame(){
        
        gameBall = new Ball(320, 220, 3, 3, 3, Color.YELLOW, 5);

        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);
        bounceCount = 0;

        userMouseY = 0;
        addMouseMotionListener(this);
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

        //update the score
        g.setColor(Color.WHITE);
        g.drawString("SCORE:  User[" + userScore + "] -- PC [" + pcScore + "]", 250, 20);

    }

    public void setGameBall(Ball gameBall) {
        this.gameBall = gameBall;
    }

    public void gameLogic(){

        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
        gameBall.moveBall();

        userPaddle.moveTowards(userMouseY);
        pcPaddle.moveTowards(gameBall.getY());

        if(userPaddle.checkCollision(gameBall)){
            gameBall.reverseX();
            bounceCount++;
        }

        if(pcPaddle.checkCollision(gameBall)){
            gameBall.reverseX();
            bounceCount++;
        }

        if(gameBall.getX() < 0 ){
            pcScore++;
            reset();
        }
        else if(gameBall.getX() > WINDOW_WIDTH){
            userScore++;
            reset();
        }
    }

    public void reset  (){
        gameBall = new Ball(320, 220, 3, 3, 3, Color.YELLOW, 5);
        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);
        bounceCount = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        userMouseY = e.getY();

    }
}