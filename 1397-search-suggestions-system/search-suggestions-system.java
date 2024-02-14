class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       int left = 0,right = products.length-1;

        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);

       int lengthSearchWord = searchWord.length();
       for(int i =0;i<lengthSearchWord;i++){
            char currentCharacter = searchWord.charAt(i);

            while(left<=right){
                if(i>=products[left].length()){
                    left++;
                    continue;
                }
                if(products[left].charAt(i)==currentCharacter)
                    break;
                left++;
            } 

            while(left<=right){
                if(i>=products[right].length()){
                    right--;
                    continue;
                }
                if(products[right].charAt(i)==currentCharacter)
                    break;
                right--;
            } 

            List<String> temp = new ArrayList<>();
            for(int j=left;j<=Math.min(left+2,right);j++)
                temp.add(products[j]);
            ans.add(new ArrayList<>(temp));
       }    

       return ans;
    }
}