class Solution {
    public int numberOfBeams(String[] bank) {
        int noOfRows = bank.length;
        int noOfCols = bank[0].length();
        int noOfLaserBeams = 0;

        int prevCount = 0;
        for (int row = 0; row < noOfRows; row++) {
            int count = 0;
            for (int col = 0; col < noOfCols; col++) {
                if (bank[row].charAt(col)=='1')
                    count++;
            }
            noOfLaserBeams += prevCount * count;
            if (count > 0)
                prevCount = count;
        }

        return noOfLaserBeams;

    }
}