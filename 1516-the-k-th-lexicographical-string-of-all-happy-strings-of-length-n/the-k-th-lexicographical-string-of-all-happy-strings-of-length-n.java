class Solution {
    public String getHappyString(int n, int k) {
        if(k>(3*(1<<(n-1)))) {
            return "";
        }
    
        StringBuilder sb = new StringBuilder();
        k--;
        
        int index  = k/(1<<(n-1));
        char token = (char)(index+97);
        char prev = token;
        sb.append(token);
        k = k%(1<<(n-1));
        n--;

        while(n>0) {
            index  = k/(1<<(n-1));
            // System.out.println(index);
            if(index==0) {
                if(prev=='a') {
                    token = 'b';
                } else {
                    token = 'a';
                }
            } else {
                if(prev=='c') {
                    token = 'b';
                } else {
                    token = 'c';
                }
            }

            prev = token;
            sb.append(token);
            k = k%(1<<(n-1));
            n--;
        }

        return sb.toString();
    }
}

/*
 k/2^n-1
 k = k%2^n-1 ; n--;

 9/4  = 2 => c
 k = 1, n = 2;
 1/2 =  0 => a
 k = 1 ; n = 1
 1/1 = 1 =>b
 k = 0 ; n = 0;
 break; 



*/