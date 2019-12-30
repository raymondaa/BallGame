/*
Name: Aaron Raymond
Description: subclass of Basic ball that will split into two
separate balls when clicked.
Date: 4/24/19
*/
import java.awt.Color;

public class SplitBall extends BasicBall
{
    private String name = "split";

    public SplitBall(double r, Color c)
    {
        super(r,c);
    }

    public int getScore() {
    	return 10;
    }

    public String getName()
    {
        return name;
    }
}