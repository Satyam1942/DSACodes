class Solution {
    public int[] mostCompetitive(int[] nums, int k) {

        PriorityQueue<int[]> pq=  new PriorityQueue<>((a,b)->((a[0]==b[0])?a[1]-b[1]:a[0]-b[0]));
        int newArr[][] = new int[k][2];
        int n = nums.length;
        int prevIndex = -1;
        for(int i=0;i<nums.length;i++)
        {
            int temp[] = new int[2];
            temp[0] = nums[i] ;
            temp[1] = i;
            pq.add(temp);
        }

        for(int i=0;i<k;i++)
        {
            for(int j=0;j<2;j++) newArr[i][j] = -1;
        }
        
        for(int i=0;i<k;)
        {
            if(newArr[i][0]!=-1) 
            {
                prevIndex = newArr[i][1];
                i++;
                continue;
            }

            int val = pq.peek()[0]; 
            int idx = pq.peek()[1];
            pq.poll();
            if(idx<prevIndex)continue;

            int elementsRemaining = k-i-1;
            int indicesRemaining = n-idx-1;

            if(indicesRemaining>=elementsRemaining)
            {
                 newArr[i][0] = val;
                 newArr[i][1] = idx;
                 prevIndex = idx;
                i++;
            }
            else
            {
                 int newIdx = k-indicesRemaining-1 ;
                 newArr[newIdx][0] = val;
                 newArr[newIdx][1] = idx;
            }
        }

        int ans[] = new int[k];
        for(int i=0;i<k;i++) ans[i] = newArr[i][0];

        return ans; 
    }
}