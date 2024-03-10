class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length;
        int length2=  nums2.length;

        int i =0,j=0;
       HashSet<Integer> intersectedArray = new HashSet<>();
        while(i<length1 &&  j<length2){
            if(nums1[i]==nums2[j]){
                intersectedArray.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }


        int ans[] = new int[intersectedArray.size()];
        int pointer = 0;
        for(int k: intersectedArray){
            ans[pointer++] = k;
        }

        return ans;
    }
}