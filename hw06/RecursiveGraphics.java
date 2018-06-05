/* File: RecursiveGraphics.java
 * Author:Lai Wei
 * Date: 2/25/15
 * Purpose: This is the code for Problem B.1 in HW 06 in Cs 112, Spring 2015
 */

import java.awt.Color; 

public class RecursiveGraphics {
   
   // Problem one: Draw a series of graphs to illustrate asymptotic complexity: log(N), N*log(N), N, N^2
      private static void drawGraphs() {
         int N = 100;
        
      
      StdDraw.setXscale(0, N);
      StdDraw.setYscale(0, N);
      StdDraw.setPenRadius(.001);
      StdDraw.setPenColor(Color.black);       // Google "Java Color"; the first link gives all the colors
      StdDraw.line(0,0,0,N); 
      StdDraw.line(0,0,N,0);
     
       double prevX = 0;
       double prevY =0;
      // Rewrite this to draw a line of PenRadius 0.001 from each point to the next
      // Hint: store the first point (0.0, 0.0) in two variables prevX and prevY, and then
      // draw from the previous point to the current point, then update the two variables
      // NOTE: Your points should be of radius 0.005 and the line should be of radius 0.001
      StdDraw.setPenColor(Color.green);
      for (int i = 1; i <= N; i++) {
         
         StdDraw.setPenRadius(0.005);
         StdDraw.point(i, Math.log(i));
         StdDraw.setPenRadius(0.001);
         StdDraw.line(prevX,prevY,i,Math.log(i));
         prevX =i;
         prevY =Math.log(i);
                                                        // this is the function log(N) applied to i
      }  
       prevX = 0;
       prevY =0;
      
      StdDraw.setPenColor(Color.blue);
      for ( int i =1; i<=N; i++){
       
        StdDraw.setPenRadius(0.005);
        StdDraw.point(i, i);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(prevX,prevY,i,i);
          prevX =i;
         prevY =i;
      }
       prevX = 0;
       prevY =0;
      
        StdDraw.setPenColor(Color.orange);
       for ( int i =1; i<=N; i++){
       
        StdDraw.setPenRadius(0.005);
        StdDraw.point(i, i*Math.log(i));
        StdDraw.setPenRadius(0.001);
        StdDraw.line(prevX,prevY,i,i*Math.log(i));
          prevX =i;
         prevY =i*Math.log(i);
      }
        prevX = 0;
       prevY =0;
         StdDraw.setPenColor(Color.red);
       for ( int i =1; i<=N; i++){
       
        StdDraw.setPenRadius(0.005);
        StdDraw.point(i, Math.pow(i,2));
        StdDraw.setPenRadius(0.001);
        StdDraw.line(prevX,prevY,i,Math.pow(i,2));
          prevX =i;
         prevY =Math.pow(i,2 );              
       }
                                                                            // Now draw the curve for N in blue, for N*log(N) in orange, and N^2) in red

   }
   
   // Problem Two A: change these two and see what happens!
   //    probably should be in range 0.9 to 0.999
   
   private static double lengthDecrement = 0.99;
   private static double sizeDecrement = 0.99; 
   
   // recursively draw a circle which gets smaller and moves toward a central point in a spiral motion
   private static void drawSpiral(int depth) {
      drawSpiralHelper(0.5, 0.5, 0.0, 0.4, 0.1, depth);
   }
   
   // draw a circle of radius at end of vector which starts at (x,y), has angle, and length
   private static void drawSpiralHelper(double x, double y, double angle, double length, double radius, int depth) {
      if(depth == 0)
         return;
      StdDraw.circle(x+rotateX(angle,length), y+rotateY(angle, length), radius);
      drawSpiralHelper(x,y, angle+0.1, length*lengthDecrement, radius*sizeDecrement, depth-1);
   }
   
   private static double rotateX(double angle, double length) {
      return length * Math.cos(angle); 
   }
   
   private static double rotateY(double angle, double length) {
      return length * Math.sin(angle); 
   }
   
   
   // Problem Two B:   Try commenting in and out the recursive calls to drawHTreeHelper below and
   //     seeing the effect on the drawing; you can also try changing the number of depth 
   
   
   private static void drawHTree(int depth) {
      drawHTreeHelper(0.5, 0.5, 0.5, true, depth);
   }
   
   private static void drawHTreeHelper(double x, double y, double len, boolean horizontal, int depth) {
      if(depth == 0)
         return;
      if(horizontal) {
         StdDraw.line(x-len/2, y, x+len/2, y);
         drawHTreeHelper(x-len/2, y, len*0.67,false, depth-1);
         drawHTreeHelper(x+len/2, y, len*0.67, false, depth-1);
      }
      else {
         StdDraw.line(x, y-len/2, x, y+len/2);
         drawHTreeHelper(x, y-len/2, len*0.67, true, depth-1);
         drawHTreeHelper(x, y+len/2, len*0.67, true, depth-1);
      }
      
   }
   
   //Problem Three: Draw a series of concentric shapes
   
   // Part A
   private static void drawSquares(int depth) {
      drawSqHelper(0.5, 0.5, 0.5, depth);
   }
   
   private static void drawSqHelper(double x, double y, double r, int depth) {
      if(depth == 0)
         return;
      StdDraw.square(x,y,r);
      // must change the next line so that x and y and r change slightly in each recursion
      //   Hint: add a small increment (try 0.001) to x and y and subtract a small increment from r
      drawSqHelper(x+0.001,y+0.001,r-0.005, depth-1);
   }
   
   // Part B
   
   private static void drawCircles(int depth) {
      drawCirHelper(0.5, 0.5, 0.5, depth);
   }
   
   private static void drawCirHelper(double x, double y, double r, int depth) {
         if(depth ==0)
           return;
         StdDraw.circle(x,y,r);
         drawCirHelper(x+0.001,y+0.001,r-0.005,depth-1);
   }
   
   
   // Problem Four: Draw concentric squares and circles in black and white
   
   private static void drawCirclesSquares(int depth) {
      drawCSHelper(0.5, depth);
   }
   
   private static void drawCSHelper(double r, int depth) {
      if(depth == 0)
         return;
      StdDraw.setPenColor(StdDraw.BLACK);
      // Now draw a filledSquare at point x = 0.5 and y = 0.5 (centered in the window) of radius r
     //  StdDraw.filledSquare( etc   );
      StdDraw.setPenColor(StdDraw.WHITE);
      // Now draw a filledCircle at point x = 0.5 and y = 0.5 (centered in the window) of radius r
      // StdDraw.filledCircle(  etc   );
      // Now call the method recursively but divide r by the square root of 2, and subtract 1 from depth
      // drawCSHelper(  etc   );
   }
  
   // Problem Five: Draw a Sierpinski Triangle, using the following method, which draws
   // an upside-down equilateral triangle with lowest point at (x,y) and side s
   
   private static void drawTriangle(double x, double y, double s) {
      double[] xs = new double[3];
      double[] ys = new double[3];
      xs[0] = x; 
      ys[0] = y;
      xs[1] = x-s/2;
      ys[1] = y+s*0.866;
      xs[2] = x+s/2;
      ys[2] = y+s*0.866;
      StdDraw.filledPolygon(xs, ys);      
   } 
   
   private static void drawSierpinskiTriangle(int depth) {
      // draw right-side-up triangle in black
      double[] x = { 0.0, 1.0, 0.5 };
      double[] y = { 0.0, 0.0, 0.866 };
      StdDraw.filledPolygon(x, y);
      // Now recursively fill in with upside-down triangles in white
      StdDraw.setPenColor(StdDraw.WHITE);
      // Draw the first triangle at (0.5, 0.0) half as big
      drawSTHelper(0.5, 0.0, 0.5, depth);
   }
   

   // Draw a white upside-down triangle with lowest point (x,y) with sides of length s
   private static void drawSTHelper(double x, double y, double s, int depth) {
      if(depth == 0)
         return;
      drawTriangle(x,y,s);
      // three recursive calls here
      drawSTHelper(x-0.5*s,y,s*0.5,depth-1);
      drawSTHelper(x,y+s*0.866,s*0.5,depth-1);
      drawSTHelper(x+0.5*s,y,s*0.5,depth-1);
      
      
   }
   
   // Problem Six
   
   private static void drawSierpinskiCarpet(int depth) {
      StdDraw.filledSquare(0.5, 0.5, 0.5);
      StdDraw.setPenColor(StdDraw.WHITE); 
      drawSCHelper(0.5, 0.5, 0.5, depth-1);
   }
   
   // this takes a square centered at (x,y) of radius r, and puts a white square
   // of 1/3 size in the middle (e.g., the center square of a tic-tac-toe board)
   // and then recursively fills the other 8 smaller squares (the rest of the TTT board).
   
   private static void drawSCHelper(double x, double y, double r, int depth) {
      //    System.out.println(x + " " + y + " " + r);
      if(depth == 0)
         return;
      StdDraw.filledSquare(x,y,r/3);               // also try circle or alternate squares and circles
      // eight recursive calls here
      drawSCHelper(x-2.0/3*r,y+2.0/3*r,r/3.0,depth-1);
        drawSCHelper(x+2.0/3*r,y-2.0/3*r,r/3.0,depth-1);
      drawSCHelper(x,y-2.0/3*r,r/3.0,depth-1);        
        drawSCHelper(x,y+2.0/3*r,r/3.0,depth-1);
          drawSCHelper(x-2.0/3*r,y,r/3.0,depth-1);
            drawSCHelper(x+2.0/3*r,y,r/3.0,depth-1);
              drawSCHelper(x-2.0/3*r,y-2.0/3*r,r/3.0,depth-1);
                drawSCHelper(x+2.0/3*r,y+2.0/3*r,r/3.0,depth-1);
   }
   
   
   // Just for fun: The following array and method will allow you to change the fill color at each
   //    recursion level, just call the method before you draw something in the recursion
   
   private static Color[] cs = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };
   
   private static void changeColorByRecursionDepth(int depth) {
      StdDraw.setPenColor(cs[depth % cs.length]); 
   }
   

   
   public static void main(String[] args) {
      

      
      //drawGraphs(); 
      
      //drawSpiral(1000);
      // drawHTree(10); 
      
      
      // drawSquares(100); 
      //  drawCircles(100); 
      
      //  drawCirclesSquares(20);
   //  drawSierpinskiTriangle(10);
      drawSierpinskiCarpet(7);
      

      
      
      
      
      
      
      
   }
   
}
