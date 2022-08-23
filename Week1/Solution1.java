public class Solution1 {
	// Main Method

	// Method
	class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] toReturn = new int[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i + 1] == target) {
                toReturn[0] = i;
                toReturn[1] = i + 1;
            }
        }
        return toReturn;
    }

    
}