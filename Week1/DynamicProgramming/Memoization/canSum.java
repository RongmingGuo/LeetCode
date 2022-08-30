import java.util.HashMap;

public class canSum {
	public static void main(String[] args) {
		int target = 112;
		int[] array = {7, 14};
		System.out.println(canSum(target, array));
		// with memory
		HashMap<Integer, Boolean> memo = new HashMap<>();
		System.out.println(canSum_memo(target, array, memo));
		System.out.println(memo);
	}

	// Non-memoization
	public static boolean canSum(int target, int[] array) {
		// base case
		if (target == 0) {
			return true;
		}
		if (target < 0) {
			// terminating condition
			return false;
		}
		// regular case
		boolean toReturn = false;
		for (int i = 0; i < array.length; i++) {
			if (toReturn) {
				return toReturn; // already found a working example
			} else {
				toReturn = toReturn || canSum(target - array[i], array);
			}
		}
		return toReturn;
	}

	public static boolean canSum_memo(int target, int[] array, HashMap<Integer, Boolean> memo){
		// base cases
		if (target == 0) {
			return true;
		}
		if (target < 0) {
			return false;
		}
		// Regular case
		// 1) search in memory
		if (memo.get(target) != null) {
			// case already calculated
			return memo.get(target);
		} else {
			// new case
			boolean toReturn = false;
			for (int i = 0; i < array.length; i++) {
				if (toReturn) {
					break; // already found a working example
				} else {
					toReturn = toReturn || canSum_memo(target - array[i], array, memo);
				}
			} // toReturn shall now be the correct answer
			// store the answer in the memo
			memo.put(target, toReturn);
			return toReturn;
		}
	}
}