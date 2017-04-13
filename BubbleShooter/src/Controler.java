import java.awt.event.*;

public class Controler implements KeyListener,MouseMotionListener,MouseListener {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W)
            Player.up = true;

        if(key == KeyEvent.VK_S)
            Player.down = true;

        if(key == KeyEvent.VK_D)
            Player.right = true;

        if(key == KeyEvent.VK_A)
            Player.left = true;

        if(key == KeyEvent.VK_UP){
            Player.fireUp = true;
            Player.fireDown = false;
            Player.fireRight = false;
            Player.fireLeft = false;}

        else if(key == KeyEvent.VK_RIGHT) {
            Player.fireRight = true;
            Player.fireDown = false;
            Player.fireUp = false;
            Player.fireLeft = false;}

        else if(key == KeyEvent.VK_DOWN){
            Player.fireDown = true;
            Player.fireUp = false;
            Player.fireRight = false;
            Player.fireLeft = false;}

        else if(key == KeyEvent.VK_LEFT){
            Player.fireLeft = true;
            Player.fireDown = false;
            Player.fireRight = false;
            Player.fireUp = false;}


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W)
            Player.up = false;

        if(key == KeyEvent.VK_S)
            Player.down = false;

        if(key == KeyEvent.VK_D)
            Player.right = false;

        if(key == KeyEvent.VK_A)
            Player.left = false;

        if(key == KeyEvent.VK_UP)
            Player.fireUp = false;

        else if(key == KeyEvent.VK_RIGHT)
            Player.fireRight = false;

        else if(key == KeyEvent.VK_DOWN)
            Player.fireDown = false;

        else if(key == KeyEvent.VK_LEFT)
            Player.fireLeft = false;

        if(key == KeyEvent.VK_ESCAPE)
            GamePanel.state = GamePanel.STATES.MENU;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        GamePanel.LCM = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        GamePanel.LCM = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        GamePanel.mouseX = e.getX();
        GamePanel.mouseY = e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        GamePanel.mouseX = e.getX();
        GamePanel.mouseY = e.getY();
    }
}
