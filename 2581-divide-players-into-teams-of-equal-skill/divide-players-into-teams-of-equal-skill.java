class Solution {
    boolean checkDivideTeams(int[] skill) {
        int length = skill.length;
        int left = 1;
        int right = length-2;
        int sum = skill[0]+skill[length-1];

        while(left<=right) {
            int curSum = skill[left]+skill[right];
            if(sum!=curSum) {
                return false;
            }
            left++;
            right--; 
        }
        return true;
    }

    long calculateTeamChemistry(int[] skill) {
        int length = skill.length;
        int left = 0;
        int right = length-1;
        long chemistry = 0;

        while(left<=right) {
            chemistry += skill[left]*skill[right];
            left++;
            right--;
        }
        return chemistry;
    }

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        boolean isPossible = checkDivideTeams(skill);
        if(isPossible) {    
            long chemistryOfTeam = calculateTeamChemistry(skill);
            return chemistryOfTeam;
        } else {
            return -1;
        }
    }
}

/*

    1,2,3,3,4,5



 */