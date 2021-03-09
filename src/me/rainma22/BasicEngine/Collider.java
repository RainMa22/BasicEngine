package me.rainma22.BasicEngine;

public class Collider {
    public static boolean colliding(Displayable displayableA,Displayable displayableB){
        int[] a=displayableA.getColliders(); int[] b=displayableB.getColliders();
        if (a[0]<=b[2]&&a[1]<=b[3]&&b[0]<=a[2]&&b[1]<=a[3]) return true;
        return false;
    }
}
