class Solution {
    public int numSub(String bStr) {
    long mod = (long)(1e9+7);
	int length = bStr.length();
	long contigiousCountOfOne = 0;
	long countOfSubarray = 0l;
	for(int idx = 0;idx<length;idx++)
	{	
		char bit = bStr.charAt(idx);
	    if(bit=='1')contigiousCountOfOne++;
	    else
        {	
	        long newSum = (contigiousCountOfOne*(contigiousCountOfOne+1l))/2l;
	        countOfSubarray = (countOfSubarray+newSum)%mod;
	        contigiousCountOfOne = 0;
        }
	
    }
	
    long newSum = (contigiousCountOfOne*(contigiousCountOfOne+1l))/2l;
    countOfSubarray = (countOfSubarray+newSum)%mod;
	return (int)countOfSubarray;
  
    }
}