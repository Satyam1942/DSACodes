class CustomComparator implements Comparator<String>{
    public int compare(String a, String b){
        String c = a+b;
        String d = b+a;
        return d.compareTo(c);
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        String numStr[] = new String[length];
        for(int i=0; i<length;i++){
            numStr[i] =  String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, new CustomComparator());

        StringBuilder largestNumber = new StringBuilder();
        for(int i=0;i<length;i++){
            largestNumber.append(numStr[i]);
        }

        String newStr =  largestNumber.toString();
        if(newStr.charAt(0)=='0')
            return "0";
        else 
            return newStr;
    }
}

/*
    32, 30 , 34
    34,32,30
*/