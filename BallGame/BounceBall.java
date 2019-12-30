/*
Name: Aaron Raymond
Description: subclass of Basic ball that will bounce off the borders
of the screen the specified number of times (3) and once it reaches this
number of bounces, the ball will be out of the game.
Date: 4/24/19
*/
import java.awt.Color;

public class BounceBall extends BasicBall
{
    public int numBounces;
    private String name = "bounce";


    public BounceBall (double r, Color c)
    {
        super(r,c);
        numBounces = 0;
    }

    public void move() {
        rx = rx + vx;
        ry = ry + vy;
        if (numBounces == 3)
        {
            isOut = true;
        }
        else
        {
            if ((Math.abs(rx) > .99) || (Math.abs(rx) < -.99))
            {
                vx = vx * -1.0;
                numBounces++;
            }
            if ((Math.abs(ry) > .99) || (Math.abs(ry) < -.99))
            {
                vy = vy * -1.0;
                numBounces++;
            }
        }
    }

    public int getScore() {
    	return 15;
    }

    public String getName()
    {
        return name;
    }
}