package edu.wiu;
import java.awt.Color;

/** Creates a line using two points.
    @author Jake Bussa
*/
public class Line extends DrawingObject
{   
    private Point startPoint;
    private Point endPoint; 
    
    /** Creating our line using a starting point and ending point.
    @param startPt is the first point passed in
    @param endPt is the second point passed in
    @param c1 is the color of the line
    */
    public Line(Point startPt, Point endPt, Color c1)
    {
        super(startPt, c1, false);
        startPoint = new Point(startPt);
        endPoint = new Point(endPt);
    }
    
    /** Moves the start point and end point relative to start point's location.
    @param p2 is the new location for our first point
    */
    @Override
    public void moveTo(Point p2)
    {
        //will be used for endPoint's new location
        double x = p2.distanceX(startPoint, endPoint);
        double y = p2.distanceY(startPoint, endPoint);
                
        //below code block was used for trouble shooting
        
        /*System.out.println("p2's location: " + p2.getX() + " " + p2.getY());
        
        System.out.println("startPoints location " + startPoint.getX() + " " + startPoint.getY());
        System.out.println("endPoints location: " + endPoint.getX() + " " + endPoint.getY());
        System.out.println("x and y values after disatance is: " + x + " " + y);
        
        System.out.println("endPoints new location is:" + (x + p2.getX()) + " " + (y + p2.getY()));*/
        
        //moving the startPoint to a new location
        startPoint.moveTo(p2);
        
        //moving endPoint to a new location relative to startPoint's location
        endPoint.moveTo(x + p2.getX(), y + p2.getY());
        
    }
    
    /** Draws the line. */
    public void draw()
    {
        Color c = StdDraw.getPenColor();
        StdDraw.setPenColor(this.getColor());
        
        StdDraw.line(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
        
        StdDraw.setPenColor(StdDraw.BLACK);
    }
}