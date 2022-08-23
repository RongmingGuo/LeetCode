import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
public class Solution2 {
  // Main Method
  public static void main(String[] args){
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = threeSum(nums);
    System.out.println(result);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
      // Initialize Return
      List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
      int target = 0;
      // Start the algorithm (this will work)
     for (int i = 0; i < nums.length - 2; i++) {
         // Individual 2-sum problem
         int num1 = nums[i];
         int subTarget1 = target - num1;
         // Individual HashMap for each iteration
         HashMap<Integer, Integer> memory = new HashMap<>();
         for (int j = i + 1; j < nums.length; j++) {
             int num2 = nums[j];
             int subTarget2 = subTarget1 - num2;
             if (memory.get(subTarget2) != null) {
                 // an answer has been found
                 List<Integer> answer = new LinkedList<Integer>();
                 answer.add(i);
                 answer.add(j);
                 answer.add(memory.get(subTarget2));
                 toReturn.add(answer);
             } else {
                // add failed to hashMap
              memory.put(nums[j], j);
             }
         }
     }
      return toReturn;
  }
}