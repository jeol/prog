/* project2 package: working with multiple classes and printf() function
 * author: Kevin J Hoerr
 * date: 11/14/2013
 */

import java.util.Scanner;

public class PlaneGeometry {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter a value for X1: ");
		double x1 = console.nextDouble();
		System.out.print("Please enter a value for Y1: ");
		double y1 = console.nextDouble();
		System.out.print("Please enter a value for X2: ");
		double x2 = console.nextDouble();
		System.out.print("Please enter a value for Y2: ");
		double y2 = console.nextDouble();
		System.out.print("please enter a value for the scalar: ");
		double scalar = console.nextDouble();
		
		Point point1 = new Point(x1,y1);
		Point point2 = new Point(x2,y2);
		LineSegment line = new LineSegment(point1,point2);
		LineSegment scale = line.scaleByFactor(scalar);
		Point endpoint = scale.getEnd();
		
		System.out.printf("Slope: %.2f\n", line.slope());
		System.out.printf("Length: %.2f\n", line.length());
		System.out.printf("Y-Intercept: %.2f\n", line.yIntercept());
		System.out.printf("Equation: %s\n", line.toString());
		System.out.printf("Length after scaling: %.2f\n", scale.length());
		System.out.printf("End point after scaling: %s\n", endpoint.toString());
	}
}
