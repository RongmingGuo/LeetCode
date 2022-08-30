import java.util.HashMap;
import java.util.LinkedList;

public class howSum{
	public static void main(String[] args) {
		int target = 20;
		int[] array = {3, 4};
		System.out.println(howSum(target, array));
	}

	public static LinkedList<Integer> howSum(int target, int[] array){
		// base case
		if (target < 0) {
			return null;
		}
		if (target == 0) {
			return new LinkedList<Integer>();
		}
		// regular case
		int i = 0; //looper
		boolean found = false;
		while (!found && i < array.length) {
			LinkedList<Integer> subsolution = howSum(target - array[i], array);
			if (subsolution != null) {
				// correct sub-problem answer found
				found = true;
				subsolution.add(i);
				return subsolution;
			} else {
				// not found
				i++;
			}
		}
		// if exited the loop without ever finding a solution
		return null;
	}
}