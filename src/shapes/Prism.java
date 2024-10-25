/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

/**
 *
 * @author mailt
 */
public abstract class Prism extends Shape {
    
    double side;

    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    
    public abstract double calcBaseArea();
    public abstract double calcVolume();
    
    
    @Override
    public abstract String toString(); 
       
    
    @Override
    public int compareTo(Shape s){
        if ( this.getHeight() > s.getHeight() ) return 1;
        else if ( this.getHeight() < s.getHeight() ) return -1;
        else return 0;
    }    
    
}
