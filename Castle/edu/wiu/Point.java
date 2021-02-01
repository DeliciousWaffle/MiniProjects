/*
   Updated Point class from CS250, Spring 2018, Western Illinois University
   New for Lab 5, replace old Point file
   
   Updates:    1)getUserPoint has been renamed to: getMousePointWait, as it gets the location
                 of the mouse and pauses all programs until this point is obtained. Note that
                 old version still exists, but is marked as deprecated. Because other code
                 has been written that uses this (your lab 4), we are stuck with keeping it
                 as part of our API. 
               2)overloaded moveTo so a point could be passed as well as an x,y pair of values
               3)added hashCode with brief explanations
*/
package edu.wiu;
/**
   Represents a 2D point that can be drawn in StdDraw
   @version 1.1
   @author Jason Covert
*/
public class Point{
   private double x, y;

   // Constructors  
   /**
      Creates a point at (x0,y0)
      @param x0 x-coordinate of new point
      @param y0 y-coordinate of new point
   */   
   public Point( double x0, double y0 ){
      x = x0;
      y = y0;
   }

   /**
      Creates a point whose x and y coordinates are the same as those of point p2
      @param p2 point to duplicate
   */
   public Point( Point p2 ){
      if( p2 != null ){
         x = p2.x;
         y = p2.y;
      }
      else{
         x = 0;
         y = 0;
      }
   }

   // Accessor methods
      
   /**
      Retrieves the current x-coordinate of this point
      @return x-coordinate of this point
   */   
   public double getX(){
      return x;
   }

   /**
      Retrieves the current y-coordinate of this point
      @return y-coordinate of this point
   */   
   public double getY(){
      return y;
   }

   
   // Mutator/update methods 
     
   /**
      Moves the point to the new cooridintes (x2,y2)
      @param x2 new x-coordinate of this point
      @param y2 new y-coordinate of this point      
   */   
   public void moveTo( double x2, double y2 ){
      x = x2;
      y = y2;   
   }

   /**
      Moves the point to the same cooridintes as p2.
      @param p2 the point to which to move the calling point     
   */
   public void moveTo( Point p2 ){
      x = p2.x;
      y = p2.y;     
   }
   /**
      Moves the point by the offsets supplied.
      If the point begins at (x,y), the new position is (x+dx,y+dy)
      @param dx x offset of new location, may be negative
      @param dy y offset of new location, may be negative    
   */   
   public void moveBy( double dx, double dy ){
      x += dx;
      y += dy;
   }

   
   //   Utility methods follow
   
   /**
      Returns a string representation of this Point and its location.
      @return a string representation of this point
   */
   @Override   
   public String toString(){
      return "Point@(" + x + "," + y + ")" ;
   }
   
   /**
      Compares this Point to the Object passed for equality. Two points are equal if they have the exact same x and y coordinates.
      @param o the object which is being checked for equality
      @return true if o is a Point and this point and o have the same x and y locations
   */
   @Override
   public boolean equals( Object o ){
      if( !( o instanceof Point ) )
         return false;
      Point p2 = (Point) o;
      return p2.x == x && p2.y == y;
   }

   /**
      returns a hash code for this point
   */
   @Override
   public int hashCode(){
      // A hash code is an integer representation of a particular object.
      // if the objects are .equals, they must have the same hash code
      // it is possible for objects that are not equal to have different hash values (no guarantee of uniqueness)
      // failure to implement this method means that parent methods are being used instead which may (or may not)
      // violate expected behaviors
      return (int)(x+y);  // add x and y together, cast to int. Two points with same x and y will always be cast to the same value.
      // note this also implies that a point(y,x) would also hash to the same value. This is ok by the requirements of hashcodes
   }
   
   /**
      Draws the point to StdDraw using the current pen color defined in that class.
      Requires the StdDraw library written by Sedgewick/Wayne at Princeton University.
      Library may be obtained from: <a href = "https://introcs.cs.princeton.edu/java/stdlib/StdDraw.java">StdDraw.java</a>
      <br>Library must be added to the package edu.wiu for use with this class.
   */   
   public void draw(){
      StdDraw.point( x, y );
   }

   /**
      @deprecated  As of release 1.1, replaced by {@link #getMousePointWait()}
      @return Point clicked in StdDraw
    */
   @Deprecated   
   public static Point getUserPoint(){
      return getMousePointWait();
   } 
   
   /**
      Waits for user to press and release mouse button in StdDraw. Returns location where mouse button was released mapped to current StdDraw coordinates.
      @return Point where user released mouse button. 
   */   
   public static Point getMousePointWait(){
      while( !StdDraw.isMousePressed() );
      while( StdDraw.isMousePressed() );
      return new Point( StdDraw.mouseX(), StdDraw.mouseY() );
   } 
   
    //----------------------------------------------------------------------------------------------------------------------------------------------
    
    /** Returns the distance of the x-values between the first and second points.
        @param p1 is the first Point
        @param p2 is the second Point
        @return the difference between the second and first Points' x-values
    */    
    public static double distanceX(Point p1, Point p2)
    {
        return p2.x - p1.x;
    }   
    
    /** Returns the distance of the y-values between the first and second points.
        @param p1 is the first Point
        @param p2 is the second Point
        @return the difference between the second and first Points' y-values
    */
    public static double distanceY(Point p1, Point p2)
    {
        return p2.y - p1.y;
    }  
    
    /** Uses the Pythagorean thereom to find the usigned distance between the first
        and second points.
        @param p1 is the first Point
        @param p2 is the second Point
        @return the hypotenuse of the two Points
    */
    public static double distance(Point p1, Point p2)
    {
        //a^2 + b^2 = c^2
        double a = distanceX(p1, p2) * distanceX(p1, p2);
        double b = distanceY(p1, p2) * distanceY(p1, p2);
        double c = Math.sqrt(a + b);
        
        return c;
    } 
}