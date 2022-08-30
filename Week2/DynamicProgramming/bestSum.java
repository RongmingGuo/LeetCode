import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

public class bestSum {
	public static void main(String[] args) {
		//initiate memoization
		HashMap<Integer, LinkedList<Integer>> record = new HashMap<>();
		//
		LinkedList<Integer> errorLabel = new LinkedList<Integer>();
		errorLabel.add(-999);
		//
		int[] nums = {2, 4};
		int target = 2;
		System.out.println(bestSum(target, nums, record, errorLabel));
		System.out.println(record);
	}

	// bestSum with memoization
	public static LinkedList<Integer> bestSum(int target, int[] nums, HashMap<Integer, LinkedList<Integer>> record, LinkedList<Integer> errorLabel){
		// implementation rules
		// 1) bestSum always returns the shortest possible combination of numbers to be summed into target
		// 2) record stores such value

		// Implementation
		// Edge cases
		if (target == 0) {
			LinkedList<Integer> toReturn = new LinkedList<Integer>();
			record.put(0, toReturn);
			return toReturn;
		}
		if (target < 0) {
			return errorLabel;
		}
		// Regular case
		if (record.get(target) != null) {
			//already calculated before
			return record.get(target);
		} else {
			// new case
			int length = -1;
			int num = -1;
			LinkedList<Integer> currAns = errorLabel; //currAns is the answer to the sub-problem
			for (int i = 0; i < nums.length; i++) {
				// finding the result
				int subTarget = target - nums[i];
				LinkedList<Integer> result = errorLabel;
				if (record.get(subTarget) == null) {
					// answer unfound
					result = bestSum(subTarget, nums, record, errorLabel);
				} else {
					result = record.get(subTarget);
				}
				if (!result.equals(errorLabel)){
					// comparing the result with previous ones
					if (length == -1) {
						// the first result found
						length = result.size();
						num = nums[i];
						currAns = result;
					} else {
						if (result.size() < currAns.size()) {
							// better solution found
							length = result.size();
							num = nums[i];
							currAns = result;
						}
					}
				}
			}
			if (currAns.equals(errorLabel)) {
				// never found a solution to the sub-problem
				record.put(target, currAns);
				return currAns;
			} else {
				// correct sub-problem answer found
				currAns.add(num);
				record.put(target, currAns);
				return currAns;
			}
		}
	}
}