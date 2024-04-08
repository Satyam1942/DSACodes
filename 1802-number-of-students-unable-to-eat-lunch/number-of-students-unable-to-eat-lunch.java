class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int countOne = 0, countZero = 0;
        int noOfStudents = students.length;
        int noOfSandwiches = sandwiches.length;
        for(int i=0;i<noOfStudents;i++){
            if(students[i]==0)
                countZero++;
            else
                countOne++;
        }

        for(int i=0;i<noOfSandwiches;i++){
            if(sandwiches[i]==0)
                countZero--;
            else
                countOne--;
            if(countZero<0 || countOne<0)
                return noOfSandwiches-i;
        }

        return 0;
    }
}