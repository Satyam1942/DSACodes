class Solution {

    int getCeilingIndex(int val , List<Integer> lis)
    {
        int left = 0;
        int right=  lis.size()-1;
        int ceilIndex = right;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(lis.get(mid)>val){ceilIndex=mid; right = mid-1;}
            else left = mid+1;
        }
        return ceilIndex;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int length = obstacles.length;
        int ans[] = new int[length];

        List<Integer> lis=  new ArrayList<>();
        lis.add(obstacles[0]);
        ans[0] = 1; 

        for(int i=1;i<length;i++)
        {
            if(obstacles[i]>=lis.get(lis.size()-1))
            {
                lis.add(obstacles[i]);
                ans[i] = lis.size();
            }
            else
            {
                int index = getCeilingIndex(obstacles[i],lis);
                lis.set(index,obstacles[i]);
                ans[i] = index+1;
            }
        }

        return ans;
    }
}

/*
    Find LIS till each index and also include that index
    [2,2,]
 */