import javax.swing.*;
import java.awt.*;

public class PongGame extends JPanel {
    
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;

    public void paintComponent(Graphics g){
        //background color
        g.setColor(Color.black);
        g.fillRect(x:0, y:0, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

}