class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if(length==k)
            return "0";
        
        Deque<Character> dq = new ArrayDeque<>();

        for(int i=0;i<length;i++){
            char token = num.charAt(i);
            while(!dq.isEmpty() && k>0 && dq.peekLast()>token){
                dq.removeLast();
                k--;
            }
            dq.addLast(token);
        } 

        StringBuilder sb = new StringBuilder();
        while(k>0){
           k--;
           dq.removeLast();
        }

        while(dq.size()>1 && dq.peekFirst()==48){
            dq.removeFirst();
        }

        while(!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }

        return sb.toString();
    }
}

/*
`14567

*/