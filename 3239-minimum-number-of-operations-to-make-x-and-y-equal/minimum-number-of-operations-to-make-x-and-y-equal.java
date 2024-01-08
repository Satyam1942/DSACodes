class Solution {
    
    public int minimumOperationsToMakeEqual(int x, int y) {
         if(y>=x) return y-x;
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(x);
        set.add(x);
        int count = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-->0)
            {
                int num = q.poll();
                if(y==num) return count;
                
                if(num%11==0 && !set.contains(num/11)){q.add(num/11); set.add(num/11);}
                if(num%5==0&& !set.contains(num/5)){q.add(num/5); set.add(num/5);}
                if(!set.contains(num-1)){q.add(num-1); set.add(num-1);}
                if(!set.contains(num+1)){q.add(num+1); set.add(num+1);}
                
            }
            count++;
        }
        
        return -1;
       
    }
}