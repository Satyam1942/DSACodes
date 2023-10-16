class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        int n = rowIndex;
        int r = 1;
        long  val =1;
        res.add(1);
        if(rowIndex==0) return res;

        for(int i=1;i<rowIndex;i++)
        {
            val= (long)(val*(long)n);
            val/=r;
            res.add((int)val);
            n--;
            r++;
        }
        res.add(1);

        return res;
    }
}