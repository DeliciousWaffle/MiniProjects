/**************************************************
*  Jake Bussa                  Homework 3         *
*  CS 250 Sec 001              February 20, 2018  *
*                                                 *
*  This program makes a large random dice, which  *
*  is then composed of smaller randomly           *
*  generated dice - Dieception.                   *
**************************************************/

import edu.wiu.Die;
import edu.wiu.StdDraw;

import java.util.Random;

public class DieDraw
{
    public static void main(String[] args)
    {
        StdDraw.setCanvasSize(1000, 800);
        
        //this draws the square outline of the BIG die
        drawDieOutline();
        
        //random die value that will be used for the BIG die
        Random randy = new Random();
        int die = randy.nextInt(6) + 1;
     
        System.out.println("The value of the Die is: " + die);
        
        //our x-coordinate, y-coordinate, and how big the dice are going to be
        double x = .45;
        double y = .45;
        double dieSize = .025;
        
        /*CREDIT: Jason Covert
        similiar to what was done in class Die; except drawing with pips
        made up dice.
        this draws the center pip composed of dice if the die is odd */
        if(die % 2 == 1)
        {
            //this method simply draws the pips that are made up of the dice
            drawWhatWasRolled(x, y, dieSize);
        }
        
        //draws the top left and bottom right pips composed of dice
        if(die > 1)
        {
            //need to set x and y coordinates to top left pip
            x = .2;
            y = .7;
            drawWhatWasRolled(x, y, dieSize);
            
            //bottom right pip
            x = .7;
            y = .2;
            drawWhatWasRolled(x, y, dieSize);
        }
        
        //draws bottom left and top right pips composed of dice
        if(die > 3)
        {
            //bottom left pip
            x = .2;
            y = .2;
            drawWhatWasRolled(x, y, dieSize);
            
            //top right pip
            x = .7;
            y = .7;
            drawWhatWasRolled(x, y, dieSize);
        }
        
        //draws the center left and center right pips composed of dice
        if(die == 6)
        {
            //center left pip
            x = .2;
            y = .45;
            drawWhatWasRolled(x, y, dieSize);
            
            //center right pip
            x = .7;
            y = .45;
            drawWhatWasRolled(x, y, dieSize);
        }
    }
    
    //this method makes the outline of the dice; will always be drawn
    public static void drawDieOutline()
    {
        //making a fairly small die (this is what will compose the large die)     
        double dieSize = .025;
        
        //bottom portion of the die
        double x = 0.1; 
        double y = 0.1;       
        
        //draws the bottom of the die
        for(int i=0; i<17; i++) 
        {
            Die d1 = new Die();
            
            d1.draw(x, y, dieSize);
            
            //need in to increment x in order make a line of dice
            x += .05;
        }
        
        //right portion of the die
        x = 0.9;
        y = 0.1;       
        
        for(int i=0; i<17; i++) 
        {
            Die d1 = new Die();
            
            d1.draw(x, y, dieSize);
            
            y += .05;
        }
        
        //top portion of the die
        x = 0.9;
        y = 0.9;       
        
        for(int i=0; i<17; i++)
        {
            Die d1 = new Die();
            
            d1.draw(x, y, dieSize);
            
            x -= .05;
        }
        
        //left portion of the die
        x = 0.1;
        y = 0.9;        
        
        for(int i=0; i<17; i++)
        {
            Die d1 = new Die();
            
            d1.draw(x, y, dieSize);
            
            y -= .05;
        }
    }    
        
    /* draws the pips of what was rolled; the pips are made up of smaller dice
    x is the x-coordinate
    y is the y-coordinate
    dieSize is the size of the Die */
    public static void drawWhatWasRolled(double x, double y, double dieSize)
    {
        //drawing the dice vertically
        for(int i=0; i<3; i++)
        {
            Die d1 = new Die();
            d1.draw(x, y, dieSize);
                
            //drawing the dice horizontally
            for(int j=0; j<3; j++)
            {
                d1 = new Die();
                d1.draw(x, y, dieSize);
                    
                //shift further right
                x += .05;
            } 
                
            //needs to be reset in order to maintain alignment
            x -= .15;
                
            //shift further up
            y += .05;   
        }     
    }
}