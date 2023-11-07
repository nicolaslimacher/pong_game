import javax.swing.*;
import java.awt.*;

public class PongGame extends JPanel {
    
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;

    private Ball gameBall;

    public PongGame(){
        
        gameBall = new Ball(320, 220, 3, 3, 3, Color.YELLOW, 5);
        
    }

    public void paintComponent(Graphics g){
   
        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        gameBall.paint(g);
    }

    public void setGameBall(Ball gameBall) {
        this.gameBall = gameBall;
    }

}