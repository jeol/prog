public class LineSegment {
	
		private final Point start;
		private final Point end;
	
	public LineSegment(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public double slope() {
		return (end.getY() - start.getY()) / (end.getX() - start.getX());
	}
	
	public double yIntercept() {
		return start.getY() - (this.slope() * start.getX());
	}
	
	public Point getStart() {
		return this.start;
	}
	public Point getEnd() {
		return this.end;
	}
	
	public double length() {
		return Math.sqrt(Math.pow(end.getX() - start.getX(),2) + Math.pow(end.getY() - start.getY(),2));
	}
	
    public LineSegment scaleByFactor(double scalar) {
    	double newLength = scalar * this.length();
    	double x = start.getX() + newLength/(Math.sqrt(1 + Math.pow(this.slope(),2)));
    	Point end = new Point(x,this.slope()*x + this.yIntercept());
    	LineSegment fin = new LineSegment(this.getStart(),end);
        return fin;
    }
    
    @Override
    public String toString() {
        return "y = " + this.slope() + " x + " + this.yIntercept();
    }
}
