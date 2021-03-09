package me.rainma22.BasicEngine;

import javax.swing.*;

public class RenderThread extends Thread{
    public boolean running=true;
    private Container container;
    private JPanel canvas;
    public RenderThread(Container c){
        container=c;
        canvas=c.getCanvas();
    }
    @Override
    public void run(){
        long now,prev,diff;
        now=System.currentTimeMillis();
        prev=now;
        while (running){
            now=System.currentTimeMillis();
            if (container.paused){
                prev=now;
            }
            diff=now-prev;
            if (diff>=1000/60){
                canvas.repaint();
                prev+=1000/60;
            }else{
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
