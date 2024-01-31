class Pair{
    int val,index;
    Pair(int val , int index)
    {
        this.val = val;
        this.index = index; 
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

            int n =temperatures.length;
            for(int i=n-1;i>=0;i--)
            {
                while(!st.isEmpty() &&  st.peek().val<=temperatures[i])
                {
                    st.pop();
                }

                if(!st.isEmpty())
                list.add(st.peek().index-i);
                else list.add(0);

                st.push(new Pair(temperatures[i],i));

            }

            int arr[] = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[n-i-1] = list.get(i);
            }

            return arr;
    }
}