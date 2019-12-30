/*
Name: Aaron Raymond
Description: subclass of Basic ball that will shrink to 2/3 of its 
current size each time it is clicked until it reaches less than or equal to
25% of its original size, in which case it will revert back to its original size.
Date: 4/24/19
*/

import java.awt.Color;

public class ShrinkBall extends BasicBall
{
    public double orgRadius;
    private String name = "shrink";

    public ShrinkBall (double r, Color c)
    {
        super(r,c);
        orgRadius = r;
    }

    public int getScore() {
    	return 20;
    }

    public boolean isHit(double x, double y) {
    	if ((Math.abs(rx-x)<=radius) && (Math.abs(ry-y)<=radius))
            {
                radius = radius *.66;
                if (radius <= (orgRadius/4))
                {
                    radius = orgRadius;
                }
			    return true;
            }
		else return false; 
    }

    public String getName()
    {
        return name;
    }
}