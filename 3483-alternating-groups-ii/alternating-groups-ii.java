class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        List<Integer> modifiedInput = new ArrayList<>();
        int length = colors.length;
        for(int i=0;i<length;i++){
            modifiedInput.add(colors[i]);
        }
        
        for(int i=0;i<k-1;i++){
            modifiedInput.add(colors[i]);
        }
        
        int left = 0;
        int right = 1;
        int newLength = modifiedInput.size();
        int prev = modifiedInput.get(0);
        int alternatingGroupCount = 0;

        while(right<newLength){
            
            if(modifiedInput.get(right)==prev){
                    left = right;
            }
            
            prev = modifiedInput.get(right);
            if(right-left+1>=k){
                alternatingGroupCount++;
            }
            right++;
        }
        
        return alternatingGroupCount;
    }
}