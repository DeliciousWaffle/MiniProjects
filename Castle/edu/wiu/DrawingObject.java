/*
   Updated DrawingObject class from CS250, Spring 2018, Western Illinois University
   New for Lab 5, replace old DrawingObject file from class
   
   Updates:    multiple methods added from example in class.
*/
package edu.wiu;
import java.awt.Color;
/**
   Abstract drawing object. Contains data common to all such objects such as a base location (point) for this object, its color, and its fill status.
   @author Jason Covert
   @version 1.1
*/
public abstract class DrawingObject{
   private Point base;
   private Color color;
   private boolean fill;

   /**
      Creates a drawing object the point, color, and fill status specified.
      @param p Point at which to define this drawing object.
      @param c Color for this drawing object.
      @param f fill status for this drawing object. A value of true denotes a filled object, false an unfilled object.
   */      
   public DrawingObject( Point p, Color c, boolean f ){  
      // note, no need to check null here, as we are checking these in the methods called
      base = new Point(p);
      setColor(c);
      fill = f;
   }

   /**
      Moves a drawing object to the point p. Unless otherwise specified, moves the drawing object's base point to the same coordinates as p.
      @param p the Point that contains the new (x,y) coordinates for this object
      @throws IllegalArgumentException if user attempts to move the drawing object to a null Point
   */
   public void moveTo( Point p ) throws IllegalArgumentException{
      // we could call this "setBase" as well, but the name is more descriptive of what the method does
      if( p == null )
         throw new IllegalArgumentException( "A DrawingObject cannot be moved to a null Point!" );
      base.moveTo(p); 
   }
 
   /**
      Sets the drawing object's color to the color passed. Passed null values result color being set to RGB(0,0,0).
      @param c the color to set as this drawing object's color
   */  
   public void setColor( Color c ){
      if( c == null ){  color = new Color( 0, 0, 0 ); }
      else{ color = c; }  
   }

   /**
      Causes the drawing object to be a filled drawing object, where possible.
   */
   public void setFill(){ fill = true; }
   /**
      Causes the drawing object to be an unfilled drawing object, where possible.
   */   
   public void clearFill() { fill = false; }
   
   /**
      Retrieves the current color of the drawing object.
      @return the color of this drawing object
   */   
   public Color getColor(){ return color; }
   /**
      Retrieves a Point containing the current coordinates of the drawing object.
      @return a point containing the coordinates of the base location of this object   
   */     
   public Point getBase(){ return new Point(base); }
   /**
      Retrieves the current fill setting for the drawing object.
      @return true if the drawing object is a filled drawing object, false otherwise
   */     
   public boolean isFilled() { return fill; }

   // utility methods
   public abstract void draw();

   /**
      Compares this DrawingObject to the Object passed for equality. Two drawing objects are equal if they
      have the base point, same color, and same fill status.
      @param o the object which is being checked for equality
      @return true if o is a Point and this point and o have the base, color, and fill.
   */   
   @Override
   public boolean equals( Object o ){
      if( !( o instanceof DrawingObject ) )
         return false;
      DrawingObject d2 = (DrawingObject) o;
      // below uses the equals methods already defined for the instance variables as well as comparing fill values
      return this.base.equals(d2.base) && this.color.equals(d2.color) && this.fill == d2.fill;
      // Note: Any child of a DrawingObject can be cast to DrawingObject. By this definition, a circle and square can be equal.
      // use caution!
   }
   /**
      returns a hash code for this point
   */   
   @Override
   public int hashCode(){
      return base.hashCode() + color.hashCode() + (fill?1:0);
      // uses presumed implementations of hashCode for base (which is now done) and Color (which really exists)
      // modifies this by fill value. If fill = true, adds 1, otherwise adds zero. A better hash code might modify
      // how distant these are each time a program uses DrawingObject, but more on that in CS351.
   }
   
   /**
      Returns a string representation of this DrawingObject
      @return a string representation of this point
   */
   @Override   
   public String toString(){
      return "DrawingObject@ " + base + "\n" + color;
   }
      
}