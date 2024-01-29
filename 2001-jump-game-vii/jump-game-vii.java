class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int minFarReach = minJump;
        int maxFarReach = maxJump;
        int length = s.length();
        int finalPos = length - 1;

        if (s.charAt(finalPos) == '1')
            return false;

        if (finalPos >= minFarReach && finalPos <= maxFarReach)
            return true;

        int i = minFarReach;
        boolean flag = false;
        while (i<length) {

            int tempMin = Integer.MAX_VALUE;
            int tempMax = Integer.MIN_VALUE;

            while(i<length && i<=maxFarReach && s.charAt(i)=='0' && i>=minFarReach){
                flag = true;
                tempMax = i+maxJump;
                tempMin = Math.min(tempMin,i+minJump);
                if (finalPos >= minFarReach && finalPos <= maxFarReach)
                    return true;
                i++;
            }

            if(flag){
                flag = false;
                maxFarReach = tempMax;
                minFarReach = tempMin;
                i--;
            }
            i++;
        }
        return false;

    }
}