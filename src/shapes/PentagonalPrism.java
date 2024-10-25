package shapes;

public class PentagonalPrism extends Prism
{

    public PentagonalPrism(double height, double side) {
        super(height, side);
    }
    
    @Override
    public double calcBaseArea() {        
        return (5 * Math.pow(this.side, 2) * Math.tan(Math.toRadians(54))) / 4;
    }
    
    @Override
    public double calcVolume() {
        return calcBaseArea() * this.height;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PentagonalPrism has a ");
        sb.append("Height of: ").append(this.height);
        sb.append('.');
        return sb.toString();
    }
    
    public String toStringVolume() {
        StringBuilder sb = new StringBuilder();
        sb.append("PentagonalPrism has a ");
        sb.append("Volume of: ").append(calcVolume());
        sb.append('.');
        return sb.toString();    
    }
    
    public String toStringBaseArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("PentagonalPrism has a ");
        sb.append("Base Area of: ").append(calcBaseArea());
        sb.append('.');
        return sb.toString();    
    }
}
