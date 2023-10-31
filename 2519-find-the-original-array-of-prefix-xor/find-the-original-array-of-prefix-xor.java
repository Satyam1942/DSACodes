class Solution {
    public int[] findArray(int[] pref) {
        int len = pref.length;
        int[] ans = new int[len];
        int preXor = pref[0];
        ans[0] = preXor;
        for(int i=1;i<pref.length;i++)
        {
            ans[i] =  preXor^pref[i];
            preXor ^=ans[i]; 
        }
        return ans;
    }
}