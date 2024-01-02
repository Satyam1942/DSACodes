class Solution {
    public String getHint(String secret, String guess) {
        int length = secret.length();
	HashMap<Character,Integer>  freq = new HashMap<>();
	
for(int idx = 0;idx<length;idx++)
	{
		char ch = secret.charAt(idx);
		int curFreq = freq.getOrDefault(ch,0);
		freq.put(ch,curFreq+1);
}


int noOfBulls = 0, noOfCows = 0;
for(int idx = 0;idx<length;idx++)
{
	if(secret.charAt(idx)==guess.charAt(idx))
	{
		noOfBulls++;
		if(freq.get(guess.charAt(idx))==1) 
freq.remove(guess.charAt(idx));
		else 
freq.put(guess.charAt(idx),freq.get(guess.charAt(idx))-1);
}
}


for(int idx =0;idx<length;idx++)
{
	if(secret.charAt(idx)==guess.charAt(idx))continue;
		
if(freq.containsKey(guess.charAt(idx)))
{
noOfCows++;
if(freq.get(guess.charAt(idx))==1) 
		freq.remove(guess.charAt(idx));
		else 
			freq.put(guess.charAt(idx),freq.get(guess.charAt(idx))-1);
}


	}




String hint = String.valueOf(noOfBulls)+"A"+String.valueOf(noOfCows)+"B";
return hint;

    }
}