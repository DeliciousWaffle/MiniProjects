/*
   Supplied Circle class from CS250, Spring 2018, Western Illinois University
   Use in place of any Circle file you currently have
   
   Updates:    None, same as final version we developed in class
*/
package edu.wiu;
import java.awt.Color;
/**
   Represents a circle object
   @version 1.0
   @author Jason Covert
*/
public class Circle extends DrawingObject{
   private double radius;
   
   /** Creates a circle using the point passed in as a base point and has a fill property.
   @param p is the Point
   @param c1 is the color of the circle
   @param r is the circle's radius
   @param f is whether or not the circle is filled
   */
   public Circle(Point p, Color c1, double r, boolean f ){
      super(p,c1,f);
      radius = r;
   }
   
   /** Creates a circle using the point passed in as a base point, but has no filled property.
   @param p is the Point
   @param c1 is the color of the circle
   @param r is the circle's radius
   */
   public Circle(Point p, Color c1, double r){
      this( p, c1, r, false );
   }   
   
   /** Draws the circle. */
   public void draw(){
      Color current = StdDraw.getPenColor();
      StdDraw.setPenColor( this.getColor() );
      Point base = getBase();
      if(!this.isFilled())
      {
          StdDraw.circle( base.getX(), base.getY(), radius );
      }
      else
      {
          StdDraw.filledCircle(base.getX(), base.getY(), radius);
      }
       
      StdDraw.setPenColor(StdDraw.BLACK);       
   }
   
    //---------------------------------------------------------------------------------------------
    
    /** This checks to see if the point passed in is within the circle.
        @param p is the Point passed in to be checked
        @return true or false depending if the Point is within the circle
    */    
    public boolean contains(Point p)
    {           
        //our starting base point
        Point base = getBase();
        
        //below commented out block was used to troubleshoot errors
        
        /*System.out.println("base x-val: " + base.getX());
        System.out.println("base y-val: " + base.getY());
        
        System.out.println("point x-val:" + p.getX());
        System.out.println("base y-val: " + p.getY());
        
        System.out.println("distance x-val: " + p.distanceX(p, base));
        System.out.println("distance y-val: " + p.distanceY(p, base));
        
        System.out.println("radius " + radius);
        
        System.out.println("distance using pythago: " + p.distance(p, base));*/
        
        //checking to see if point is in circle's radius
        if(p.distance(p, base) < radius)
        {
            //System.out.println("Point is within circle!");
            return true;
        }
        
        return false;
    }
      
}