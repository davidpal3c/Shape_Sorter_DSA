package shapes;

public class Pyramid extends Shape
{
    private double side;

    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    
    @Override
    public double calcBaseArea() {        
        return Math.pow(this.side, 2);    
    }
    
    @Override
    public double calcVolume() {
        return (1/3) * (Math.pow(this.side, 2) * this.height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pyramid has a ");
        sb.append("Height of: ").append(this.height);
        sb.append('.');
        return sb.toString();
    }
    
    public String toStringVolume() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pyramid has a ");
        sb.append("Volume of: ").append(calcVolume());
        sb.append('.');
        return sb.toString();    
    }  
    
    public String toStringBaseArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pyramid has a");
        sb.append("Base Area of: ").append(calcBaseArea());
        sb.append('.');
        return sb.toString();    
    }

}
