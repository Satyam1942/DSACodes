class Solution {
    boolean checkDivideTeams(int[] skill) {
        int length = skill.length;
        int i = 1;
        int j = length-2;
        int sum = skill[0]+skill[length-1];

        while(i<=j) {
            int curSum = skill[i]+skill[j];
            if(sum!=curSum) {
                return false;
            }
            i++;
            j--; 
        }
        return true;
    }

    long calculateTeamChemistry(int[] skill) {
        int length = skill.length;
        int i = 0;
        int j = length-1;
        long chemistry = 0;

        while(i<=j) {
            chemistry += skill[i]*skill[j];
            i++;
            j--;
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