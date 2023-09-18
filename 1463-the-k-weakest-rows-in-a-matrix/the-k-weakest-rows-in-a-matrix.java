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
            int tempCount=0;
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==1) tempCount++;
            }
            soldierArray[i] = tempCount;
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