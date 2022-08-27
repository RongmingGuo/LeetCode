import java.util.HashMap;

public class fibbMemo {
	public static void main(String[] args) {
		HashMap<Integer, Integer> memo = new HashMap<>();
		memo.put(0, 1);
		memo.put(1, 1);
		System.out.println(memo);
		System.out.println(fibbm(40, memo));
		System.out.println(memo);
	}

	public static int fibbm (int n, HashMap<Integer, Integer> memo) {
		// Memoization : use a fast-add & fast-access data structure to store the answer to repetitive sub-problems that
		// might appear in your function call
		if (memo.get(n) != null) {
			// sub-problem already solved
			return memo.get(n);
		} else {
			int result = fibbm(n - 1, memo) + fibbm(n - 2, memo);
			memo.put(n, result);
			return result;
		}
	}
}