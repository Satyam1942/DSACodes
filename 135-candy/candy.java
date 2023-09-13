class Pair{
    int  num , index;
    Pair(int num ,int index)
    {
        this.num = num;
        this.index= index;
    }
}
class Solution {
    public int candy(int[] ratings) {
        int n =ratings.length;
     PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.num-b.num);
    int noOfChocolates[] = new int[n];

    for(int i=0;i<n;i++) pq.add(new Pair(ratings[i],i));

     while(!pq.isEmpty())
     {
         int num = pq.peek().num;
         int index = pq.peek().index;
         pq.poll();

      if(num>ratings[Math.min(index+1,n-1)]) 
        noOfChocolates[index] = Math.max(noOfChocolates[index],
                                noOfChocolates[Math.min(index+1,n-1)]+1);
    
     if(num>ratings[Math.max(index-1,0)])
     noOfChocolates[index]= Math.max(noOfChocolates[index],
                        noOfChocolates[Math.max(index-1,0)]+1);
    
     if(num<=ratings[Math.min(index+1,n-1)] && 
     num<=ratings[Math.max(index-1,0)])  noOfChocolates[index]= 1;

     }

        int totalCandies=0;
        for(int i:noOfChocolates) { totalCandies+=i;}
        
        return totalCandies;
    }
}