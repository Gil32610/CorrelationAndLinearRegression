public class Pair {
    private double xAxis;
    private double yAxis;

    public Pair (double x, double y){
        this.xAxis = x;
        this.yAxis = y;
    }

    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getyAxis() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    @Override
    public String toString() {
        return "Pair [xAxis=" + xAxis + ", yAxis=" + yAxis + "]";
    }

    
}
