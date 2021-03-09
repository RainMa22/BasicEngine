package me.rainma22.BasicEngine;

import java.awt.*;
import java.util.ArrayList;

public class Renderer {
    private Container container;
    public Renderer(Container c){
        container=c;
    }
    public void draw(Graphics2D g,int count){
        ArrayList<Displayable> displayables=container.displayables;
        for (int i = 0; i < displayables.size(); i++) {
            Displayable disp=displayables.get(i);
            g.drawImage(disp.getImage(count),disp.getX(),disp.getY(),null);
        }
    }
    public void drawWhenPaused(Graphics2D g,int count){
        ArrayList<Displayable> displayables=container.pausedDisplayables;
        for (int i = 0; i < displayables.size(); i++) {
            Displayable disp=displayables.get(i);
            g.drawImage(disp.getImage(count),disp.getX(),disp.getY(),null);
        }
    }
    public void calculate(){

    }
    public void calculateWhenPaused(){

    }
}
