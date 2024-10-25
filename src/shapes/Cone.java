package shapes;

public class Cone extends Shape
{
    private double radius;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
        
    @Override
    public double calcBaseArea() {        
        return Math.PI * Math.pow(this.radius, 2);    
    }
    
    @Override
    public double calcVolume() {
        return (1/3) * (Math.PI * Math.pow(this.radius, 2) * this.height);
    }
 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cone has a ");
        sb.append("Height of: ").append(this.height);
        sb.append('.');
        return sb.toString();
    }
    
    public String toStringVolume() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cone has a ");
        sb.append("Volume of: ").append(calcVolume());
        sb.append('.');
        return sb.toString();    
    }
    
    public String toStringBaseArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cone has a ");
        sb.append("Base Area of: ").append(calcBaseArea());
        sb.append('.');
        return sb.toString();    
    }
}
