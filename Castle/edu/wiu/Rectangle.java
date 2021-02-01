package edu.wiu;
import java.awt.Color;

/** Creates a rectangle object.
@author Jake Bussa
*/
public class Rectangle extends DrawingObject
{
    private double halfWidth;
    private double halfHeight;
    
    /** Creating the Rectangle using a starting Point.
    @param p is the base point
    @param c1 is the color of the rectangle
    @param hw is the rectangle's half width
    @param hh is the rectangle's half height
    @param f is the rectangles filled property
    */
    public Rectangle(Point p, Color c1, double hw, double hh, boolean f)
    {
        super(p, c1, f);
        halfWidth = hw;
        halfHeight = hh;
    }
    
    /** Draws our rectangle */
    public void draw()
    {
        Point base = getBase();
        Color c = StdDraw.getPenColor();
        StdDraw.setPenColor(this.getColor());

        if(!this.isFilled())
        {
            StdDraw.rectangle(base.getX(),base.getY(), halfWidth, halfHeight);
        }
        else
        {
            StdDraw.filledRectangle(base.getX(),base.getY(), halfWidth, halfHeight);
        }
        
        StdDraw.setPenColor(StdDraw.BLACK);
    }
    
    /** Returns whther or not the point passed in is within the rectangle
    @param p is the point passed in to check
    @return true or false depeding on whether the point is passed in
    */
    public boolean contains(Point p)
    {
        //our original starting point when the rectangle was created
        Point base = getBase();
        
        //below prints were used to help me determine what was happening and debug issues
        
        /*System.out.println("Starting point is: " + base.getX() + " " + base.getY());
        System.out.println("Point passed in is: " + p.getX() + " " + p.getY());
        
        System.out.println("halfWidth is: " + halfWidth);
        System.out.println("halfHeight is: " + halfHeight);
        
        System.out.println("left side needed to be inside is: " + Point.distanceX(p, base));
        System.out.println("bottom side needed to be inside is: " + Point.distanceY(p, base));
        
        System.out.println("right side needed to be inside is: " + Point.distanceX(base, p));
        System.out.println("top side needed to be inside is: " + Point.distanceY(base, p));*/
        
        //this is not pretty, we need to check all SIDES of the rectangle to make sure that the point passed in is within
        //notice that we are swapping p and base to represent the different sides of the rectangle
        // LEFT SIDE:                          BOTTOM SIDE:                         RIGHT SIDE:                         TOP SIDE:
        if(p.distanceX(p, base) < halfWidth && p.distanceY(p, base) < halfHeight && p.distanceX(base, p) < halfWidth && p.distanceY(base, p) < halfHeight)
        {
            //System.out.println("Point passed in is within the rectangle!");
            return true;
        }
        
        return false;
    }
}