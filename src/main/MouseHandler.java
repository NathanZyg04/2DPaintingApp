package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    public int screenX;
    public int screenY;

    @Override
    public void mouseClicked(MouseEvent e) {
        screenX = e.getX();
        screenY = e.getY();
        System.out.println("X: " + screenX + " Y: " + screenY);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
