class Pair
{
    int soldier , index;
    Pair(int soldier ,int index)
    {
        this.soldier = soldier;
        this.index = index;
    }
}

class CustomComparator implements Comparator<Pair>
{
    public int compare(Pair a , Pair b)
    {
        if(a.soldier==b.soldier)return b.index - a.index;
        else return b.soldier - a.soldier;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator());
        int m = mat.length;
        int n = mat[0].length;
        int soldierArray[] = new int[m];
        int ans[] = new int[k];

        for(int i=0;i<m;i++)
        {
            int low = 0;
            int high = n-1;
            int ceilIndex = -1;
            while(low<=high)
            {
                int mid = (low+high)/2;
                if(mat[i][mid]==1) {ceilIndex= mid ; low = mid+1;}
                else high =mid-1;
            }

            soldierArray[i] = ceilIndex+1;
        }

        for(int i=0;i<m;i++)
        {
            pq.add(new Pair(soldierArray[i],i));
            if(pq.size()>k) pq.poll();
        }

        int pointer = k-1;
        while(!pq.isEmpty())
        {
            ans[pointer] = pq.poll().index;
            pointer--;
        }

        return ans;

    }
}