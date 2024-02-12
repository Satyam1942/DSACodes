class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> monotonicStack = new Stack<>();
        int length = heights.length;
        int noOfPeopleVisible[] = new int[length];

        for(int i=length-1;i>=0;i--){
            int countPop = 0;
            
            while(!monotonicStack.isEmpty() && monotonicStack.peek()<heights[i]){
                countPop++;
                monotonicStack.pop();
            }

            if(!monotonicStack.isEmpty())
                noOfPeopleVisible[i] = countPop+1;
            else 
                noOfPeopleVisible[i] = countPop;

            monotonicStack.push(heights[i]);
        }

        return noOfPeopleVisible;
    }
}
/*
 So by problem stetment we have to find the number of people which each index can see
 so as I can only see person if:
 i) its ahead of me 
 ii) all numbers in between 2 indices are less than either of the two numbers

 [10,6,8,5,11,9]
 10 can see 6,8,11  = 3
 
 if we prepare  some monotonic stack kind of stuff to get next greater I think we can figure it out
 to get next greater set

Approach 1:
 for each index caculate size of increasing array O(n^2)
Approach 2:
    iterate from backward
    use a monotonic stack and check how many elements ahead of you are less than you ; 
    you will be able to see them + 1 (that is if there is one element left which was greater ) as
    you will be able to see that as well, (The other greater elements are not visible according to the question)

*/