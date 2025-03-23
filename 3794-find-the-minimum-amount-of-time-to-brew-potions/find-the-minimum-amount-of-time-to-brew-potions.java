class Solution {

    boolean isPossible(long startTime, int mana, int skill[], long time[]) {
        long curTime = startTime;
        int noOfWizard =  skill.length;
        for(int j=1;j<=noOfWizard; j++) {
            if(curTime<time[j]) {
                return false;
            }
            curTime+= mana*skill[j-1];
        }
        return true;
    }

    public long minTime(int[] skill, int[] mana) {
        int noOfWizard =  skill.length;
        int manaLength = mana.length;
        long time[] = new long[noOfWizard+1];
        
        for(int i=0; i<manaLength; i++) {
            int curMana = mana[i];
            long left = time[0];
            long right = time[noOfWizard];
            long startTime = right;

            while(left<=right) {
                long mid = (left+right)/2;
                if(isPossible(mid, mana[i], skill, time)) {
                    right = mid-1;
                    startTime = mid;
                } else {    
                    left = mid+1;
                }
            }

            time[0] = startTime;
            for(int j=1;j<=noOfWizard; j++) {
                time[j] = time[j-1]+mana[i]*skill[j-1];
            }
        }

        return time[noOfWizard];
    }
}

/*
    60
    nmlogT
*/