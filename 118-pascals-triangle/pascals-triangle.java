class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> begin1= new ArrayList<>();
         List<Integer> begin2= new ArrayList<>();
   if(numRows==1)
      {  begin1.add(1);
        ans.add(begin1);
      return ans;
      }
      if(numRows==2)
      {
          begin1.add(1);
        ans.add(begin1);
       begin2.add(1);
        begin2.add(1);
        ans.add(begin2);
        return ans;
      }

        begin1.add(1);
        ans.add(begin1);
       begin2.add(1);
        begin2.add(1);
        ans.add(begin2);
        
    
   int  sum =2;
    for(int i=2;i<numRows;i++)
    {
        List<Integer> list = new ArrayList();
            list.add(1);
            
        for(int j=1;j<i;j++)
        {
            sum = ans.get(i-1).get(j-1) + ans.get(i-1).get(j); 
            list.add(sum);

        }
        list.add(1);
        ans.add(list);
    }
return ans;
    }
}