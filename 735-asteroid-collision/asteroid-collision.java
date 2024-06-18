class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int i=length-1;i>=0;i--){
            if(asteroids[i]>0){
                while(!st.isEmpty() && st.peek()<0 && asteroids[i]>Math.abs(st.peek())){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()<0 && asteroids[i]==Math.abs(st.peek())){
                    st.pop();
                    continue;
                }
                if(st.isEmpty() || st.peek()>0)
                    st.push(asteroids[i]);
            }else{
                st.push(asteroids[i]);
            }
        }

        int remainingAsteroids [] = new int[st.size()];
        int i=0;
        while(!st.isEmpty())
            remainingAsteroids[i++] = st.pop();
        return remainingAsteroids;
    }
}

/*
 left is moving to right and right is moving to left
    left       right
    +num        -num

    add number to monotonic stack
    if current number is +ve 
        while !st.isEmpty() && st.peek()<0 && |+ve|>|-ve|
            poll -ve from both stacks
        push into stack
    else
        push into stack

    return reverse of stack
 */