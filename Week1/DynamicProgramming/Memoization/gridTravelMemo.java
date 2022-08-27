import java.util.HashMap;
import java.util.ArrayList;

public class gridTravelMemo {
	public static void main(String[] args) {
		int m = 30;
		int n = 50;
		// System.out.println(gridTravel(m, n)); // this will take a long time

		// with memoization
		HashMap<ArrayList<Integer>, Integer> memo = new HashMap<>();
		// Add base case entry 1
		ArrayList<Integer> size1 = new ArrayList<>();
		size1.add(1);
		size1.add(1);
		memo.put(size1, 1);
		System.out.println(gridTravelMemo(m, n, memo)); // this is much faster
	}

	public static int gridTravel(int m, int n) {
		// without memoization
		// Base cases
		if (m == 0 || n == 0) {
			return 0;
		} else if (m == 1 && n == 1) {
			return 1;
		} else {
			return gridTravel(m - 1, n) + gridTravel(m, n - 1);
		}
	}

	public static int gridTravelMemo(int m, int n, HashMap<ArrayList<Integer>, Integer> memo) {
		if (m == 0 || n == 0) {
			// base case
			return 0;
		}
		ArrayList<Integer> size = new ArrayList<>();
		size.add(m);
		size.add(n);
		if (memo.get(size) != null) {
			// previously stored
			return memo.get(size);
		} else {
			// not previously stored
			int result = gridTravelMemo(m - 1, n, memo) + gridTravelMemo(m, n - 1, memo);
			memo.put(size, result);
			return result;
		}
	}
}