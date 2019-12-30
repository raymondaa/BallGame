/******************************************************************************
 *  Compilation:  javac BallGame.java
 *  Execution:    java BallGame n
 *  Dependencies: BasicBall.java StdDraw.java
 *
 *  Creates a BasicBall and animates it
 *
 *  Part of the animation code is adapted from Computer Science:   An Interdisciplinary Approach Book
 *  
 *  Run the skeleton code with arguments : 1  basic  0.08
 *******************************************************************************/
/*
Name: Aaron Raymond
Description: Runs the BallGame
Date: 4/24/19
*/

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class BallGame { 

    public static void main(String[] args) {
  
    	// number of bouncing balls
    	int numBalls = Integer.parseInt(args[0]);
    	//ball types
    	String ballTypes[] = new String[numBalls];
    	//sizes of balls
    	double ballSizes[] = new double[numBalls];
    	
    	//retrieve ball types
    	int index =1;
    	for (int i=0; i<numBalls; i++) {
    		ballTypes[i] = args[index];
    		index = index+2;
    	}
    	//retrieve ball sizes
    	index = 2;
    	for (int i=0; i<numBalls; i++) {
    		ballSizes[i] = Double.parseDouble(args[index]);
    		index = index+2;
    	}

    	Player p1 = new Player();

        //keeps track of player's total hits
        int totalHits = 0;
    	
    	//number of active balls
    	int numBallsinGame = 0;
        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(800, 800);
        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        // create colored balls 
        ArrayList<BasicBall> balls = new ArrayList<BasicBall>();
        for (int i = 0; i < numBalls; i++)
        {
            if (ballTypes[i].equals("basic"))
            {
                balls.add(new BasicBall(ballSizes[i], Color.RED));
                numBallsinGame++;
            }
            if (ballTypes[i].equals("bounce"))
            {
                balls.add(new BounceBall(ballSizes[i], Color.BLUE));
                numBallsinGame++;
            }
            if (ballTypes[i].equals("shrink"))
            {
                balls.add(new ShrinkBall(ballSizes[i], Color.GREEN));
                numBallsinGame++;
            }
            if (ballTypes[i].equals("split"))
            {
                balls.add(new SplitBall(ballSizes[i], Color.YELLOW));
                numBallsinGame++;
            }
        }

        // do the animation loop
        StdDraw.enableDoubleBuffering();
        boolean hit = false;
        while (numBallsinGame > 0) {
            hit = false;

            for (BasicBall b : balls)
            {
                b.move();
            }

            //Check if the mouse is clicked
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
 
                //could not get the SplitBall to work using "for (BasicBall b : balls)"
                for (int i = 0; i < balls.size(); i++)
                {
                    if (balls.get(i).isHit(x,y))
                    {
                        balls.get(i).reset();
                       if (balls.get(i) instanceof SplitBall)
                       {
                           balls.add(new SplitBall(balls.get(i).getRadius(),Color.YELLOW));
                       }
                    p1.updateBallsHit(balls.get(i).getName());
                    p1.addScore(balls.get(i).getScore());
                    totalHits++;
                    }
                }
            }
                
            numBallsinGame = 0;
            // draw the n balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            
            for (BasicBall b : balls)
            {
                    if (b.isOut == false)
                    {
                        b.draw();
                        numBallsinGame++;
                    }
            }  
            //Print the game progress
            StdDraw.setPenColor(StdDraw.YELLOW);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            StdDraw.text(-0.65, 0.90, "Number of balls in game: "+ String.valueOf(numBallsinGame));
            Font font2 = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font2);
            StdDraw.text(-0.65, 0.80, "Number of Hits: "+ String.valueOf(totalHits));
            Font font3 = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font3);
            StdDraw.text(-0.65, 0.70, "Total Score: "+ String.valueOf(p1.getScore()));
            StdDraw.show();
            StdDraw.pause(20);
        }
        while (true) {
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.RED);
            Font font = new Font("Arial", Font.BOLD, 60);
            StdDraw.setFont(font);
            StdDraw.text(0, 0, "GAME OVER");
            StdDraw.setPenColor(StdDraw.GREEN);
            Font font4 = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font4);
            StdDraw.text(0, -.5, "Total Score: "+ String.valueOf(p1.getScore()));
            StdDraw.setPenColor(StdDraw.GREEN);
            Font font5 = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font5);
            StdDraw.text(0, -.6, "Most Hit Ball: "+ String.valueOf(p1.mostHitBall()));
            StdDraw.show();
            StdDraw.pause(10);           
        }
    }
}
