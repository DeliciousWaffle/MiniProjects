import edu.wiu.*;
import java.awt.Color;
import java.util.Random;

/** Calls various shape objects to create a picture.
    @author Jake Bussa 
*/
public class Castle
{
    public static void main(String[] args)
    {
        StdDraw.setCanvasSize(1000, 800);
        
        //using this as a starting point
        Point startPt = new Point(.5, .5);
        
        background(startPt);
        
        castleBase(startPt);
        
        castleTowers(startPt);
        
        castleDetails(startPt);
        
        scenery(startPt);
    }
    
    /** Draws the background which consists of of sky, stars, moon, and grass. 
        @param pt is the start Point to base other objects on.
    */
    public static void background(Point pt)
    {
        Color c = new Color(0, 0, 0);
        Random r = new Random();
        
        //black background for night sky
        Rectangle night = new Rectangle(pt, c, 1, 1, true);
        night.draw();
        
        Circle stars;                                             
        c = new Color(255, 255, 255);
        
        //generating a lot of stars with random positions and sizes to make things nicer; exceptionally inefficient though
        for(int i=0; i<200; i++)
        {
            pt = new Point(r.nextDouble(), r.nextDouble());
            
            //nextDouble() doesn't accept arguments, need to drastically shrink size so the whole picture isn't all white
            stars = new Circle(pt, c, r.nextDouble() * .003, true);
            stars.draw();
        }
        
        //grass
        c = new Color(34, 139, 34);
        pt.moveTo(.5, .05);
        Rectangle grass = new Rectangle(pt, c, .5, .2, true);
        grass.draw();
        
        //walkway
        double[] x = {.42, .58, .66, .34};
        double[] y = {.25, .25, 0, 0};
        
        StdDraw.setPenColor(160, 82, 45);
        StdDraw.filledPolygon(x, y);
        
        //moon
        c = new Color(255, 255, 0);
        pt.moveTo(.18, .84);
        Circle moon = new Circle(pt, c, .14, true);
        moon.draw();
        
        //moon craters
        c = new Color(0, 0, 0);
        pt.moveTo(.08, .9);
        Circle crater1 = new Circle(pt, c, .04, false);
        crater1.draw();
        
        pt.moveTo(.06, .8);
        Circle crater2 = new Circle(pt, c, .02, false);
        crater2.draw();
        
        pt.moveTo(.14, .76);
        Circle crater3 = new Circle(pt, c, .034, false);
        crater3.draw();
        
        pt.moveTo(.18, .94);
        Circle crater4 = new Circle(pt, c, .026, false);
        crater4.draw();
        
        //not a full moon
        c = new Color(0, 0, 0);
        pt.moveTo(.26, .84);
        Circle shade = new Circle(pt, c, .12, true);
        shade.draw();
    }
    
    /** Draws the center base piece of the castle which includes the bricks. 
        @param pt is the start Point to base other objects on.
    */
    public static void castleBase(Point pt)
    {
        Color c = new Color(200, 200, 200);
        Random r = new Random();
        
        pt.moveTo(.5, .4);
        Rectangle castleBase = new Rectangle(pt, c, .35, .15, true);
        castleBase.draw();
        
        //drawing the bricks for the base building
        c = new Color(0, 0, 0);
        pt.moveTo(.15, .53);
        Point endPt = new Point(.85, .53);
        
        //creating horizontal lines of the bricks
        Line horizontal = new Line(pt, endPt, c);
        double furtherRight = 0;
        
        for(int i=0; i<17; i++)
        {
            horizontal.draw();
            pt.moveTo(.15, .55 + furtherRight);
            horizontal.moveTo(pt);
            furtherRight -= .02;
        }
        
        //creating the vertical lines of the bricks
        //starts at the top row and skips 1 down to give that brick effect
        furtherRight = 0;
        double furtherDown = 0;
        
        pt.moveTo(.2, .53);
        endPt.moveTo(.2, .55);
        Line vertical = new Line(pt, endPt, c);
        
        //looping through our rows and columns        
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<14; j++)
            {
                vertical.draw();
                pt.moveTo(.2 + furtherRight, .53 + furtherDown);
                vertical.moveTo(pt);
                furtherRight += .05;
            }
            
            furtherRight = 0;
            furtherDown -= .04;
        }
        
        //starts at the second row then skips 1 down to give that brick effect
        furtherRight = 0;
        furtherDown = 0;
        
        pt.moveTo(.175, .51);
        endPt.moveTo(.175, .53);
        vertical = new Line(pt, endPt, c);
        
        for(int i=0; i<7; i++)
        {
            for(int j=0; j<15; j++)
            {
                vertical.draw();
                pt.moveTo(.175 + furtherRight, .51 + furtherDown);
                vertical.moveTo(pt);
                furtherRight += .05;
            }
            
            furtherRight = 0;
            furtherDown -= .04;
        }
        
        //drawing stone guard rail thing at the top
        furtherRight = 0;
        c = new Color(211, 211, 211);
        pt.moveTo(.325, .56);
        Rectangle guardRail = new Rectangle(pt, c, .01, .01, true);
        
        for(int i=0; i<9; i++)
        {
            guardRail = new Rectangle(pt, c, .01, .01, true);
            guardRail.draw();
            pt.moveTo(.325 + furtherRight, .56);
            furtherRight += .05;
        }
    }
    
    /** Draws the castle towers on the left and right sides.
        @param pt is the start Point to base other objects on.
    */    
    public static void castleTowers(Point pt)
    {
        //left tower
        Color c = new Color(211, 211, 211);
        pt.moveTo(.215, .63);
        Rectangle leftTower = new Rectangle(pt, c, .065, .08, true);
        leftTower.draw();
        
        //left tower guard rail things
        double furtherRight = 0;
        pt.moveTo(.14, .72);
        Rectangle guardRail = new Rectangle(pt, c, .01, .01, true);
        
        for(int i=0; i<5; i++)
        {
            guardRail = new Rectangle(pt, c, .01, .01, true);
            guardRail.draw();
            pt.moveTo(.14 + furtherRight, .72);
            furtherRight += .05;
        }
        
        //right tower
        pt.moveTo(.785, .63);
        Rectangle rightTower = new Rectangle(pt, c, .065, .08, true);
        rightTower.draw();
        
        //right tower guard rail things
        furtherRight = 0;
        pt.moveTo(.71, .72);
        
        for(int i=0; i<5; i++)
        {
            guardRail = new Rectangle(pt, c, .01, .01, true);
            guardRail.draw();
            pt.moveTo(.71 + furtherRight, .72);
            furtherRight += .05;
        }
        
        //now for the tower bricks; sadly repeating a lot of code here
        c = new Color(0, 0, 0);
        pt.moveTo(.15, .71);
        Point endPt = new Point(.85, .71);
        
        //creating horizontal lines of the tower bricks
        Line horizontal = new Line(pt, endPt, c);
        furtherRight = 0;
        
        for(int i=0; i<9; i++)
        {
            horizontal.draw();
            pt.moveTo(.15, .71 + furtherRight);
            horizontal.moveTo(pt);
            furtherRight -= .02;
        }
        
        //creating vertical lines of the tower bricks
        furtherRight = 0;
        double furtherDown = 0;
        
        pt.moveTo(.2, .69);
        endPt.moveTo(.2, .71);
        Line vertical = new Line(pt, endPt, c);
        
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<14; j++)
            {
                vertical.draw();
                pt.moveTo(.2 + furtherRight, .69 + furtherDown);
                vertical.moveTo(pt);
                furtherRight += .05;
            }
            
            furtherRight = 0;
            furtherDown -= .04;
        }
        
        //starts at the second row then skips 1 down to give that brick effect again
        furtherRight = 0;
        furtherDown = 0;
        
        pt.moveTo(.175, .67);
        endPt.moveTo(.175, .69);
        vertical = new Line(pt, endPt, c);
        
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<15; j++)
            {
                vertical.draw();
                pt.moveTo(.175 + furtherRight, .67 + furtherDown);
                vertical.moveTo(pt);
                furtherRight += .05;
            }
            
            furtherRight = 0;
            furtherDown -= .04;
        }
        
        //below for loops prevent overlapping the stone guards with the lines
        //just draws the vertical lines for each seperate tower
        furtherRight = 0;
        
        for(int i=0; i<3; i++)
        {
            vertical.draw();
            pt.moveTo(.175 + furtherRight, .55);
            vertical.moveTo(pt);
            furtherRight += .05;
        }
        
        furtherRight = 0;
        
        for(int i=0; i<4; i++)
        {
            vertical.draw();
            pt.moveTo(.725 + furtherRight, .55);
            vertical.moveTo(pt);
            furtherRight += .05;
        }
    }
    
    /** Draws some of castle details which include a door and banners.
        @param pt is the start Point to base other objects on.
    */    
    public static void castleDetails(Point pt)
    {
        //creating a gated door
        Color c = new Color(0, 0, 0);
        pt.moveTo(.5, .33);
        Rectangle door = new Rectangle(pt, c, .08, .08, true);
        door.draw();
        
        //top portion of the door
        pt.moveTo(.5, .4);
        Circle topDoor = new Circle(pt, c, .08, true);
        topDoor.draw();
        
        //some red banners
        //banner to the far left
        pt.moveTo(.215, .51);
        c = new Color(200, 0, 0);
        Rectangle banner1 = new Rectangle(pt, c, .03, .2, true);
        banner1.draw();
        
        //banner to far right
        pt.moveTo(.785, .51);
        Rectangle banner2 = new Rectangle(pt, c, .03, .2, true);
        banner2.draw();
        
        //banner to left of door
        pt.moveTo(.35, .43);
        Rectangle banner3 = new Rectangle(pt, c, .03, .12, true);
        banner3.draw();
        
        //banner to right of door
        pt.moveTo(.65, .43);
        Rectangle banner4 = new Rectangle(pt, c, .03, .12, true);
        banner4.draw();
        
        //banner details
        //banner details to far left
        c = new Color(255, 255, 0);
        pt.moveTo(.215, .51);
        Rectangle bd1 = new Rectangle(pt, c, .02, .19, false);
        bd1.draw();
        
        //banner details to far right
        pt.moveTo(.785, .51);
        Rectangle bd2 = new Rectangle(pt, c, .02, .19, false);
        bd2.draw();
        
        //banner details by left of door
        pt.moveTo(.35, .43);
        Rectangle bd3 = new Rectangle(pt, c, .02, .11, false);
        bd3.draw();
        
        //banner details by right of door
        pt.moveTo(.65, .43);
        Rectangle bd4 = new Rectangle(pt, c, .02, .11, false);
        bd4.draw();
    }
    
    /** Creates the trees of the picture. 
        @param pt is the start Point to base other objects on.
    */    
    public static void scenery(Point pt)
    {
        //far left tree
        Color c = new Color(139, 69, 19);
        pt.moveTo(.09, .29);
        Rectangle trunk1 = new Rectangle(pt, c, .01, .04, true);
        trunk1.draw();
        
        //far right tree
        pt.moveTo(.91, .29);
        Rectangle trunk2 = new Rectangle(pt, c, .01, .04, true);
        trunk2.draw();
        
        //center left tree
        pt.moveTo(.24, .12);
        Rectangle trunk3 = new Rectangle(pt, c, .01, .04, true);
        trunk3.draw();
        
        //center right tree
        pt.moveTo(.76, .12);
        Rectangle trunk4 = new Rectangle(pt, c, .01, .04, true);
        trunk4.draw();
        
        //leaves for far left tree
        c = new Color(0, 100, 0);
        pt.moveTo(.09, .38);
        Circle leaves1 = new Circle(pt, c, .08, true);
        leaves1.draw();
        
        //leaves for far right tree
        pt.moveTo(.91, .38);
        Circle leaves2 = new Circle(pt, c, .08, true);
        leaves2.draw();
        
        //leaves for center left tree
        pt.moveTo(.24, .21);
        Circle leaves3 = new Circle(pt, c, .08, true);
        leaves3.draw();
        
        //leaves for center right tree
        c = new Color(0, 100, 0);
        pt.moveTo(.76, .21);
        Circle leaves4 = new Circle(pt, c, .08, true);
        leaves4.draw();
    }
}