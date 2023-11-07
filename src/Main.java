import javax.swing.JFrame;
import javax.swing.WindowConstants;

//basic hello world
public class Main {

    static JFrame f = new JFrame("Pong");
    public static void main(String[] args) {
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.setSize(650,495);

        //show that window
        f.setVisible(true);
    }
}