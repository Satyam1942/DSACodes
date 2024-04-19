class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int numberOfNodes) {
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for (int index = 0; index < numberOfNodes; index++) {
            parent.add(index);
            size.add(1);
        }
    }

    int findUltimateParent(int node) {
        if (parent.get(node) == node)
            return node;
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    void unionBySize(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);

        if (ultimateParentU == ultimateParentV)
            return;

        if (size.get(ultimateParentU) > size.get(ultimateParentV)) {
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, ultimateParentU + ultimateParentV);
        } else {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, ultimateParentU + ultimateParentV);
        }
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int numberOfNodes = length * width;

        DisjointSet ds = new DisjointSet(numberOfNodes);

        // node number formula => rowIndex*widthcolumnIndex;

        int delRow[] = { 0, -1, 0, 1 };
        int delCol[] = { 1, 0, -1, 0 };

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {

                if (grid[i][j] == '0')
                    continue;

                int curNode = i * width + j;
                int ultimateParentU = ds.parent.get(curNode);

                for (int k = 0; k < 4; k++) {
                    int newRow = i + delRow[k];
                    int newCol = j + delCol[k];
                    boolean isValid = newRow >= 0 && newRow < length && newCol >= 0 && newCol < width && grid[newRow][newCol] == '1';
                   
                    if (isValid) {
                        int newNode = newRow * width + newCol;
                        int ultimateParentV = ds.parent.get(newNode);
                        if (ultimateParentU != ultimateParentV) {
                           
                            ds.unionBySize(curNode, newNode);
                        }
                    }
                }
            }
        }

        HashSet<Integer> noOfParents = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for(int j=0;j<width;j++){
                if(grid[i][j]=='0')
                    continue;
                int nodeNumber = i*width + j;
                noOfParents.add(ds.findUltimateParent(nodeNumber));
            }
        }
        
        int numberOfIslands = noOfParents.size();

        return numberOfIslands;
    }
}