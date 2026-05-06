class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int length = boxGrid.length;
        int width = boxGrid[0].length;
        char rotatedBox[][] = new char[width][length];

        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < width; j++) {
                char token = boxGrid[i][j];
                if (token == '*') {
                    int k = j;
                    rotatedBox[k][length-1-i] = '*';
                    while (count-- > 0) {
                        rotatedBox[--k][length-1-i] = '#';
                    }
                    count = 0;
                } else if (token == '#') {
                    count++;
                }
            }
            if (count > 0) {
                int k = width - 1;
                while (count-- > 0) {
                    rotatedBox[k--][length-1-i] = '#';
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (rotatedBox[i][j] == '\0') {
                    rotatedBox[i][j] = '.';
                }
            }
        }

        return rotatedBox;
    }
}