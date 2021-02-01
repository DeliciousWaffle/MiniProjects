/** Main purpose of the program is to create a random dice and draw it. CREDIT: About 90%
of this material came from class/ Prof. Covert.
@author Jason Covert
@author Jake Bussa */

//this essentially makes the scope of this class visible to other classes that import it
package edu.wiu;                 

import java.util.Random;

//interface that tells us what the die value should be
interface Comparable <Die>
{
    public void roll();
    public int getValue();
}

/** A six-sided dice class that will give us the value of the die. */

public class Die
{    
   //private means varibles are only available to this class
   private static Random rand = new Random();
   private int value;                      
   
   /** Constructor that generates a random dice roll. */
   
   public Die()
   {   
      //this means that value is taken from the method roll and that's what the constructor becomes
      this.roll();  
   }
   
   /** This checks to make sure that the input from the user is within range.
   Returns that value if it is. Otherwise, it just rolls a random dice.
   @param v the value from user */
   
   public Die(int v)
   {
       //input is correct; make the user's input the value to be returned
       if(v >= 1 || v <= 6)
       {
           value = v;
       }  
       
       //if another value is passed, make it as if the other constructor was called
       else 
       {
           roll();
       } 
   }
   
   /** This rolls the die and gives a random value between 1 and 6. */
   
   public void roll()
   {
       value = rand.nextInt(6) + 1;
   }
   
   /** Returns the value of the dice roll from method roll.
   @return value the value of the dice */
       
   public int getValue()
   {
       return value;
   }
   
   /** Returns the die value concatinated with a String.
   @return value the value of the dice concatinated with a String */
   
   public String toString()
   {
       return "Die: " + value;
   }
   
   /** Returns the difference between two dice and allows method equals to see
   if the dice are equal or not.
   @param d the value of the dice being passed in
   @return difference between the dice */
   
   public int compareTo(Die d)
   {
       return this.value - d.value;
   }
      
   /** Uses the result of method compareTo to see if the two dice being compared
   are equal or not.
   @param o which is an Object
   @return true or false to represent if they are equal, or not equal */
   
   //overriding the method of the parent class; let's me know if there is no function to override with error 
   @Override
   public boolean equals(Object o)
   {
       //this checks to see if the values are of the same type
       if(!(o instanceof Die))
       {
           return false;
       }
       
       //casting Object o as a Die
       Die d = (Die) o;
       
       //the two dice are equal
       if(d.value == this.value)
       {
           return true;
       }
       
       //dice are not equal
       else
       {
           return false;
       }
   }
   
   /** Draws the pips of the dice based on what was rolled.
   @param x is the x-coordinate
   @param y is the y-coordinate
   @param r is how large the dice is */
   
   public void draw(double x, double y, double r)
   {
       //need to reset color back to black
       StdDraw.setPenColor(StdDraw.BLACK);
       
       //this is our black cube
       StdDraw.filledSquare(x, y, r);
       
       //yellow color for this pips
       StdDraw.setPenColor(StdDraw.YELLOW);
       
       /*following if statements attempt to make life easier by drawing the pips
       if they satisfy certain condtitions.
       this checks to see if the dice is odd, draws only center pip */
       if(this.value % 2 == 1)
       {
           StdDraw.filledCircle(x, y, .1 * r);
       }
       
       //draws the top left and bottom right pip
       if(this.value > 1)
       {
           //top left
           StdDraw.filledCircle(x - .5 * r, y + .5 * r, .1 * r); 
           
           //bottom right
           StdDraw.filledCircle(x + .5 * r, y - .5 * r, .1 * r);  

       }
       
       //draws bottom left and top right pip
       if(this.value > 3)
       {
           //bottom left
           StdDraw.filledCircle(x - .5 * r, y - .5 * r, .1 * r);
           
           //top right
           StdDraw.filledCircle(x + .5 * r, y + .5 * r, .1 * r);
       }
       
       //draws left center and right center pip
       if(this.value == 6)
       {
           //left center
           StdDraw.filledCircle(x - .5 * r, y, .1 * r);
           
           //right center
           StdDraw.filledCircle(x + .5 * r, y, .1 * r);
       }
       
       //setting color back to black so the "Done!" text can be seen
       StdDraw.setPenColor(StdDraw.BLACK);
   }
}