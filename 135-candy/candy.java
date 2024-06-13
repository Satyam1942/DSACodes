class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        Integer candies[] = new Integer[length];
        if(length==1)
            return 1;

        //first pass
        for(int i=0;i<length;i++){
            if(i==0){
                if(ratings[i+1]>=ratings[i])
                    candies[i] =1;
            }else if(i==length-1){
                if(ratings[i]<=ratings[i-1])
                    candies[i] =1;
            }else{
                if(ratings[i]<=ratings[i+1] && ratings[i]<=ratings[i-1])
                    candies[i] =1;
            }
        }

        //second pass
        for(int i=1;i<length-1;i++){
            if(ratings[i]>ratings[i-1] && ratings[i]<=ratings[i+1]){
                if(candies[i-1]!=null)
                    candies[i] = candies[i-1]+1;
            }else if(ratings[i]<=ratings[i-1] && ratings[i]>ratings[i+1]){
                if(candies[i+1]!=null)
                    candies[i] = candies[i+1]+1;
            }
        }
        
        // System.out.println(Arrays.toString(candies));

        for(int i=length-2;i>=1;i--){
            if(ratings[i]>ratings[i-1] && ratings[i]<=ratings[i+1]){
                candies[i] = candies[i-1]+1;
            }else if(ratings[i]<=ratings[i-1] && ratings[i]>ratings[i+1]){
                candies[i] = candies[i+1]+1;
            }
        }
        //  System.out.println(Arrays.toString(candies));
        
        //third pass
        for(int i=0;i<length;i++){
            if(candies[i]==null){
                if(i==0)
                    candies[i] = 1+candies[i+1];
                else if(i==length-1)
                    candies[i] = 1+candies[i-1];
                else
                    candies[i]= 1+Math.max(candies[i+1],candies[i-1]);
            }
        }


        int totalCandy = 0;
        for(int candy: candies)
            totalCandy+=candy;

        return totalCandy;
    }
}

/*
    [1,4,3,8,7,6,5,9,3]
    [1,2,1,2,3,4,1,2,1] = 17
    in 1st pass ; mark all students whose rating is less than or equal to both neighbours
    in 2nd pass : mark all students whose rating is less than or equal to  one of the neighbors'
    in 3rd pass: mark all highest rated students
 */