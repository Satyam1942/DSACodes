class Solution {
    public int minCost(String colors, int[] neededTime) {
        
	int noOfBallons = neededTime.length;

	char prevBalloonColor = colors.charAt(0);

	int sum = neededTime[0];
	int maximumTime = neededTime[0];

	int minimumTime = 0;
	
        for(int index = 1;index<noOfBallons;index++)
        {
	        if(prevBalloonColor==colors.charAt(index))
            {
	            maximumTime = Math.max(maximumTime,neededTime[index]);
                sum+=neededTime[index];
            }
            else
            {
	            /*minimumTime = sum of all time required to remove repeating 
                Balloons-maximum of all time because I want the time to be minimum*/

	            minimumTime += sum-maximumTime; 

	            //resetting the parameters
                prevBalloonColor = colors.charAt(index);
	            sum = neededTime[index];
	            maximumTime = neededTime[index];
            }

        }

     minimumTime += sum-maximumTime; 
    return minimumTime;

    }
}