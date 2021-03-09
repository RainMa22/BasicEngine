package me.rainma22.BasicEngine;

import java.awt.image.BufferedImage;

public interface Displayable {
    BufferedImage getImage(int i);
    int getX();
    void setX();
    int getY();
    void setY();
    int[] getColliders();
    void setImage(BufferedImage image);
    default boolean collidesWith(Displayable d){
        return Collider.colliding(this,d);
    }
}
