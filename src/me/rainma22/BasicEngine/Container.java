package me.rainma22.BasicEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Container {
    private ArrayList<Runnable> runnables;
    public ArrayList<Displayable> displayables,pausedDisplayables;
    private Renderer renderer;
    public JPanel canvas;
    private KeyListener keyListener;
    private MouseListener mouseListener;
    public boolean paused,victory;
    private int fps;
    private RenderThread renderThread;
    public synchronized JPanel getCanvas(){return canvas;}
    public void setFrame(JFrame frame){
        frame.add(canvas);frame.addKeyListener(keyListener);frame.addMouseListener(mouseListener);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public synchronized void setKeyListener(KeyListener kl){
        keyListener=kl;
    }
    public synchronized void setMouseListener(MouseListener ml){
        mouseListener=ml;
    }
    public Container(int fps){
        this.fps=fps;
        paused=true;
        victory=false;
        runnables=new ArrayList<>(1);
        displayables= new ArrayList<>();
        pausedDisplayables=new ArrayList<>();
        renderer=new Renderer(this);
        canvas=new JPanel(){
            private int count=0;
            @Override
            public void paintComponents(Graphics g) {
                super.paintComponents(g);
                Graphics2D g2d=(Graphics2D) g;
                renderer.draw(g2d,count);
                if (paused){
                    renderer.drawWhenPaused(g2d,count);
                    renderer.calculateWhenPaused();
                }else{
                    renderer.calculateWhenPaused();
                    count++;
                }
            }
        };
        renderThread=new RenderThread(this);
    }
    public void init(){
        if (keyListener==null||mouseListener==null){
            throw new NullPointerException("KeyListener/MouseListener not set");
        }
        renderThread.start();
    }
}
