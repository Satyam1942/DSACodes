class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int length = nums.length;
        StringBuilder missingStr = new StringBuilder();
        HashSet<String> dictionary = new HashSet<>();

        for(int i =0; i<length; i++) {
            missingStr.append("0");
            dictionary.add(nums[i]);
        }

        if(!dictionary.contains(missingStr.toString())) {
            return missingStr.toString();
        }

        for(int i=0; i<length; i++) {
            missingStr.setCharAt(i, '1');
            if(!dictionary.contains(missingStr.toString())) {
                return missingStr.toString();
            }
        }

        return "";
    }
}