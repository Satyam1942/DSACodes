class Solution {

    public int[][] imageSmoother(int[][] img) {
     int M = img.length;
	int N = img[0].length;

	int[][] ans = new int[M][N];

	for(int i=0; i<M; i++) {
		for(int j=0; j<N; j++) {
			setAvg(img, M, N, i, j, ans);
		}
	}

	return ans;
   
    }

     void setAvg(int[][] img, int M, int N, int i, int j, int[][] ans) {
	int sum = img[i][j];
	int countCells = 1;
    int dirs[][] = {{-1,-1} ,{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1}};
	for(int[] dir : dirs) {
		if(isSafe(M, N, i+dir[0], j+dir[1])) {
			sum += img[i+dir[0]][j+dir[1]];
			countCells++;
		}
	}

	ans[i][j] = sum/countCells;
}

   boolean isSafe(int M, int N, int i, int j) {
	return i >= 0 &&
			j >= 0 &&
			i < M &&
			j < N;
}
}
/*
    100 300 400
    200 250 450
    100 300 400

    100 300 400
    300 550 850
    400 850 1250
    
 */