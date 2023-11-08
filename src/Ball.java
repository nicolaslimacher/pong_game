import java.awt.*;
public class Ball {
    
    private int x, y, cx, cy, speed, size;
    private Color color;

    static final int MAX_SPEED = 6;

    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size){

        this.x=x;
        this.y=y;
        this.cx=cx;
        this.cy=cy;
        this.speed=speed;
        this.color=color;
        this.size=size;

    }

    public void paint(Graphics g){

        g.setColor(color);
        g.fillOval(x,y, size, size);
    }

    public void moveBall (){

        x += cx;
        y += cy;
    }

    public void bounceOffEdges(int top, int bottom){

        if (y > bottom - size){
            reverseY();
        }

        if (y < top){
            reverseY();
        }
    }

    private void reverseY() {

        cy *= -1;

    }

    public void reverseX() {

        cx *= -1;

    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

    public int getSize(){
        return size;
    }

    public void increaseSpeed(){

        if (speed < MAX_SPEED){
            speed++;
        }
        //update cy and cx with the new speed
        cx = (cx / Math.abs(cx)*speed);
        cy = (cy / Math.abs(cy)*speed);
        
    }

}
