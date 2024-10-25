package shapes;

public class SquarePrism extends Prism
{

    public SquarePrism(double height, double side) {
        super(height, side);
    }
    
    @Override
    public double calcBaseArea() {        
        return Math.pow(this.side, 2);    
    }
    
    @Override
    public double calcVolume() {
        return Math.pow(this.side, 2) * this.height;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SquarePrism has a ");
        sb.append("Height of: ").append(this.height);
        sb.append('.');
        return sb.toString();
    }
    
    public String toStringVolume() {
        StringBuilder sb = new StringBuilder();
        sb.append("SquarePrism has a ");
        sb.append("Volume of: ").append(calcVolume());
        sb.append('.');
        return sb.toString();    
    }
    
    public String toStringBaseArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("SquarePrism has a ");
        sb.append("Base Area of: ").append(calcBaseArea());
        sb.append('.');
        return sb.toString();    
    }
}
