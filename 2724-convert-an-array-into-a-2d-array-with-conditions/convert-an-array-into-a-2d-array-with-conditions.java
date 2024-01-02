class Pair
{
	int element , freq;
	Pair(int element,int freq)
	{
		this.element = element;
		this.freq = freq;
	}
}
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int length = nums.length;
	HashMap<Integer,Integer> freq = new HashMap<>();
	Queue<Pair> q = new LinkedList<>();

	//storing frequency ; O(n)
	for(int idx =0;idx<length;idx++)
	{
		int curNum = nums[idx];
		int curFreq = freq.getOrDefault(curNum,0);
		freq.put(curNum,curFreq+1);
	}
	
	//Initializing Queue O(n)
	for(Map.Entry<Integer,Integer> i : freq.entrySet())
	{
		int key = i.getKey();
		int val = i.getValue();
		q.add(new Pair(key,val));
	}
	
	//BFS algorithm; O(n)
	List<List<Integer>> convertedArray = new ArrayList<>();
	while(!q.isEmpty())
	{
	    int size = q.size();
	   List<Integer> temp = new ArrayList<>();
	   while(size-->0)
	   {
		int element = q.peek().element;
		int frequency = q.peek().freq;
		q.poll();
		temp.add(element);
		if(frequency>1)q.add(new Pair(element,frequency-1));
	    }
		convertedArray.add(new ArrayList<>(temp));
	}

	return convertedArray;	

    }
}