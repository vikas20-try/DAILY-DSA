class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }

    public int maxLength(int[] nums) {
        int maxLen = 1;

        // Try every index 'i' as the starting point of a subarray
        for (int i = 0; i < nums.length; i++) {
            long product = nums[i];
            long lcm_res = nums[i];
            long gcd_res = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                lcm_res = lcm(lcm_res, nums[j]);
                gcd_res = gcd(gcd_res, nums[j]);

                if (product == lcm_res * gcd_res) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    // Once product != lcm * gcd, adding more positive numbers 
                    // can never make them equal again (and prevents overflow)
                    break;
                }
            }
        }

        return maxLen;
    }
}