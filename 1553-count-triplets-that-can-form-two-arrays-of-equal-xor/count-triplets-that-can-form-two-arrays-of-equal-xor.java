class Solution {
    public int countTriplets(int[] nums) {
        int length = nums.length;
        int prefixXor[] = new int[length];
        int xor = 0;
        for (int i = 0; i < length; i++) {
            xor ^= nums[i];
            prefixXor[i] = xor;
        }

        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int k = i + 1; k < length; k++) {

                int xorItoK = (i == 0) ? prefixXor[k] : prefixXor[k] ^ prefixXor[i - 1];
                if (xorItoK == 0)
                    count+=(k-i);
            }
        }

        return count;

    }
}