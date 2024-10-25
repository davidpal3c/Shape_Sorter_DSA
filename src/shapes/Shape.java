/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;



/**
 *
 * @author mailt
 */
public abstract class Shape implements Comparable<Shape>{
    protected double height;

    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public abstract String toString();
    
    public abstract String toStringVolume();
    public abstract String toStringBaseArea();
    
    public abstract double calcVolume();
    public abstract double calcBaseArea();
        
    @Override
    public int compareTo(Shape s){
        if ( this.getHeight() > s.getHeight() ) return 1;
        else if ( this.getHeight() < s.getHeight() ) return -1;
        else return 0;
    }
    


}
