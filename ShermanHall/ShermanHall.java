/**********************************************
*  Jake Bussa               February 1, 2018  * 
*  CS 250 Spring            Homework 1        *
*                                             *
*  This program uses StdDraw to create a      *
*  picture of something iconic at WIU.        *
*  In this case, Sherman Hall.                *
**********************************************/

/*note: completed assignment prior to lab 2, so
all shapes are manually entered. */

public class ShermanHall
{
    public static void main(String[] args)
    { 
        //will be using a bigger sized canvas so it's easier to see
        StdDraw.setCanvasSize(1080, 720);
        
        //using methods to draw one aspect of the picture at a time
        background(); 
        
        building();
        
        windowsAndDoor();
        
        walkway();
        
        trees();    
    }
    
    //**draws the sky, clouds, and grass
    public static void background()
    {
        //beginning with the sky
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        
        //going to intitially set the whole background as blue, then overlap it
        StdDraw.filledRectangle(.5, .5, 1.0, 1.0);
        
        //creating 2 clouds using elipses
        StdDraw.setPenColor(StdDraw.WHITE);

        //filledElipse(x, y, major axis/ width, minor axis/ height)
        StdDraw.filledEllipse(.25, .9, .07, .06);
        StdDraw.filledEllipse(.3, .9, .05, .04);
        StdDraw.filledEllipse(.2, .9, .05, .04);
        
        StdDraw.filledEllipse(.8, .94, .07, .06);
        StdDraw.filledEllipse(.75, .94, .05, .04);
        StdDraw.filledEllipse(.85, .94, .05, .04);

        //creating the grass
        StdDraw.setPenColor(StdDraw.GREEN);
        
        StdDraw.filledRectangle(.5, .2, .7, .4);
    }
    
    //**prints the Sherman Hall building; consists of buildings and roofs
    public static void building()
    {
        //going to make the main building light brown; setPenColor(R, G, B)
        StdDraw.setPenColor(170, 100, 0);
        
        //the main building; filledRectangle(x, y, halfwidth, halfheight)
        StdDraw.filledRectangle(.5, .6, .35, .2);
        
        /*making the taller buildings using lighter brown;
        leftmost tallish building */
        StdDraw.setPenColor(160, 100, 0);
        StdDraw.filledRectangle(.1, .65, .1, .25);
                
        //center tallish building
        StdDraw.filledRectangle(.5, .65, .1, .25);
        
        //rightmost tallish building
        StdDraw.filledRectangle(.9, .65, .1, .25);
        
        /*now doing the roofs of these buildings;
        leftmost building roof */
        StdDraw.setPenColor(110, 80, 0);
 
        //polygons need arrays for the x-axis and y-axis 
        double[] leftRoofX = {-.05, .1, .25};
        double[] leftRoofY = {.86, 1.0, .86};
        StdDraw.filledPolygon(leftRoofX, leftRoofY);
        
        //center building roof
        double[] centerRoofX = {.35, .5, .65};
        double[] centerRoofY = {.86, 1.0, .86};
        StdDraw.filledPolygon(centerRoofX, centerRoofY);
        
        //rightmost building roof
        double[] rightRoofX = {.75, .9, 1.05};
        double[] rightRoofY = {.86, 1.0, .86};
        StdDraw.filledPolygon(rightRoofX, rightRoofY);
    }    
    
    //**creates all the windows and the door            
    public static void windowsAndDoor()
    {
        //drawing the windows
        StdDraw.setPenColor(StdDraw.WHITE);
        
        /*using two for loops to print out the windows, idea came from 2D arrays;
        initializing the coordinates of the bottom left window (starting point window) */    
        double leftBuildingWindowsX = .05;  
        double leftBuildingWindowsY = .5; 
        
        //first loop will print the windows vertically
        for(int i=0; i<3; i++)
        {
            StdDraw.filledSquare(leftBuildingWindowsX, leftBuildingWindowsY, .02);
            
            //second loop will print windows horizontally 
            for(int j=0; j<3; j++)
            {
                StdDraw.filledSquare(leftBuildingWindowsX, leftBuildingWindowsY, .02);
                
                /*this increments the x-value by .05; since x = .05, this loop will go
                until x = .20 and will need to be reset to maintain horizontal alignment */
                leftBuildingWindowsX = leftBuildingWindowsX + .05;
            }
            
            /*x now equals .20, need to subtract .15 from it so that it can go
            back to starting position (.05)  to maintain alignment */
            leftBuildingWindowsX = leftBuildingWindowsX - .15;
            
            //incrementing the y-value so that the windows go up vertically
            leftBuildingWindowsY = leftBuildingWindowsY + .125;
        }
        
        //printing the center building windows
        double centerBuildingWindowsX = .45; 
        double centerBuildingWindowsY = .5;
        
        for(int i=0; i<3; i++)
        {
            StdDraw.filledSquare(centerBuildingWindowsX, centerBuildingWindowsY, .02);
            
            for(int j=0; j<3; j++)
            {
                /*need an if statement to catch the window that draws where the door is at;
                if it's the "bad window" that shouldn't print */
                if(centerBuildingWindowsX == .5 && centerBuildingWindowsY == .5)
                {
                    //don't draw the center window (does nothing)
                }
                
                //the windows that we do want printed out
                else
                {
                    StdDraw.filledSquare(centerBuildingWindowsX, centerBuildingWindowsY, .02);
                }
                
                centerBuildingWindowsX = centerBuildingWindowsX + .05;
            }
            
            centerBuildingWindowsX = centerBuildingWindowsX - .15;
            centerBuildingWindowsY = centerBuildingWindowsY + .125;
        }
              
        //for the windows on the right side building
        double rightBuildingWindowsX = .85; 
        double rightBuildingWindowsY = .5;
        
        for(int i=0; i<3; i++)
        {
            StdDraw.filledSquare(rightBuildingWindowsX, rightBuildingWindowsY, .02);
            
            for(int j=0; j<3; j++)
            {
                StdDraw.filledSquare(rightBuildingWindowsX, rightBuildingWindowsY, .02);
                rightBuildingWindowsX = rightBuildingWindowsX + .05;
            }
            
            rightBuildingWindowsX = rightBuildingWindowsX - .15;
            rightBuildingWindowsY = rightBuildingWindowsY + .125;
        }
        
        //drawing the door for center building
        StdDraw.setPenColor(190, 90, 0);
        
        StdDraw.filledRectangle(.5, .45, .02, .05);
        
        //unnecessary details like door knob and splitting door into 2
        StdDraw.setPenColor(StdDraw.BLACK);
        
        StdDraw.filledCircle(.51, .45, .003);
        StdDraw.filledCircle(.49, .45, .003);
        
        StdDraw.line(.5, .4, .5, .5); 
    }
    
    //**draws the steps up to Sherman and the roundabout street thing
    public static void walkway()
    {
        //drawing the steps up to Sherman Hall
        StdDraw.setPenColor(StdDraw.GRAY);
        
        double[] walkwayX = {.2, .4, .6, .8};
        double[] walkwayY = {0, .4, .4, 0};
        StdDraw.filledPolygon(walkwayX, walkwayY);
        
        //making the street
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        
        StdDraw.filledEllipse(.5, -.1, .7, .3);        
    }
    
    //**makes the trees and the 2 bushes
    public static void trees()
    {
        //starting with the trunks (from left to right)
        StdDraw.setPenColor(110, 80, 0);
        
        //left trunk
        StdDraw.filledRectangle(.05, .25, .01, .05);
        
        //left center trunk
        StdDraw.filledRectangle(.3, .4, .01, .05);
        
        //right center trunk
        StdDraw.filledRectangle(.7, .4, .01, .05);
        
        //right trunk
        StdDraw.filledRectangle(.95, .25, .01, .05);

        //now for the actual trees
        StdDraw.setPenColor(0, 100, 0);
        
        double[] leftTreeX = {0, .05, .1};
        double leftTreeY[] = {.27, .6, .27};
        StdDraw.filledPolygon(leftTreeX, leftTreeY);
        
        double[] centerLeftTreeX = {.25, .3, .35};
        double[] centerLeftTreeY = {.42, .75, .42};
        StdDraw.filledPolygon(centerLeftTreeX, centerLeftTreeY);
        
        double[] centerRightTreeX = {.65, .7, .75};
        double[] centerRightTreeY = {.42, .75, .42};
        StdDraw.filledPolygon(centerRightTreeX, centerRightTreeY);
        
        double[] rightTreeX = {.9, .95, 1};
        double[] rightTreeY = {.27, .6, .27};
        StdDraw.filledPolygon(rightTreeX, rightTreeY);
      
        //some bushes for good measure; left bush
        StdDraw.filledCircle(.22, .23, .04); 
        StdDraw.filledCircle(.26, .23, .03); 
        
        //right bush
        StdDraw.filledCircle(.74, .23, .03); 
        StdDraw.filledCircle(.78, .23, .04); 
    }
}