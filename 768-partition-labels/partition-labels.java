class Solution {
    public List<Integer> partitionLabels(String s) {
        int length = s.length();
        int lastIndex[] = new int[26];
        int splitIndex = 0;
        int splitLength = 0;
        List<Integer> splitList = new ArrayList<>();

        for(int i=0; i<length; i++) {
            char token = s.charAt(i);
            lastIndex[(int)token-97] = i;
        }

        for(int i=0; i<length; i++) {
            char token = s.charAt(i);
            splitIndex = Math.max(splitIndex, lastIndex[(int)token-97]);
            splitLength++;
            if(splitIndex == i) {
                splitList.add(splitLength);
                splitLength = 0;
            }
        }

        return splitList;
    }
}


/*
calculate lastIndex Array of each character of s

ababcc
a-2
b-3
c-5

ababcc
indexSplit = 3
if indexSplit == curIndex
    split => add Length to ans list and 


*/