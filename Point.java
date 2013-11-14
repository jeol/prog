public class Point {

		private final double x;
		private final double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
    public double getX() {
        return this.x;
    }
    public double getY() {
    	return this.y;
    }
    
    @Override
    public String toString() {
    	return "(" + (Math.round(getX() * 100) / 100.0) + ", " + (Math.round(getY() * 100) / 100.0) + ")";
    }
}
