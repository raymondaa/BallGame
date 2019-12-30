/*
Name: Aaron Raymond
Description: Keeps track of players statistics.
Date: 4/24/19
*/
public class Player
{
    private int score;
    private int numberOfTimesHitBasicBall;
    private int numberOfTimesHitBounceBall;
    private int numberOfTimesHitShrinkBall;
    private int numberOfTimesHitSplitBall;

    public Player()
    {
    score = 0;
    }

    public int getScore()
    {
        return score;
    }

    public void addScore(int points)
    {
        score += points;
    }

	public void updateBallsHit(String name)
	{
		if (name.equals("basic"))
		{
			numberOfTimesHitBasicBall++;
		}
		if (name.equals("bounce"))
		{
			numberOfTimesHitBounceBall++;
		}
		if (name.equals("shrink"))
		{
			numberOfTimesHitShrinkBall++;
		}
		if (name.equals("split"))
		{
			numberOfTimesHitSplitBall++;
		}
	}

    public String mostHitBall ()
	{
		int mostHitBall = Math.max(numberOfTimesHitBasicBall, Math.max(numberOfTimesHitBounceBall, Math.max(numberOfTimesHitSplitBall, numberOfTimesHitShrinkBall)));
		if (mostHitBall == numberOfTimesHitBasicBall)
		{
			return "Basic Ball";
		}
		else if (mostHitBall == numberOfTimesHitBounceBall)
		{
			return "Bounce Ball";
		}
		else if (mostHitBall == numberOfTimesHitShrinkBall)
		{
			return "Shrink Ball";
		}
        else
        {
            return "Split Ball";
        }
	}
}