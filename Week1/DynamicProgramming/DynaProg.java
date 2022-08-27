public class DynaProg {
	public static void main(String[] args) {
		/*
		int n = 3;
		System.out.println(fibbr(n));
		System.out.println(fibbnr(n));
		*/
		/*
		int n = 4;
		System.out.println(Cr(4));
		System.out.println(Cnr(4));
		*/
		int[] coefficients = {50, 10, 40, 30, 5};
		System.out.println(matmultcount(coefficients));
	}
	// Recursive Fibb
	public static int fibbr(int n) {
		int counter = 0;
		if (n == 0) {
			//System.out.println("fibb 0 is called.");
			//counter++;
			//System.out.println("counter is " + counter);
			return 1;
		} else if (n == 1) {
			//System.out.println("fibb 1 is called.");
			//counter++;
			//System.out.println("counter is " + counter);
			return 1;
		} else {
			//System.out.println("fibb " + (n - 1) + " is called.");
			//System.out.println("fibb " + (n - 2) + " is called.");
			//System.out.println("-------------");
			//counter += 2;
			//System.out.println("counter is " + counter);
			return (fibbr(n - 1) + fibbr(n - 2));
		}
	}

	public static int fibbnr(int n){
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			int[] table = new int[n + 1];
			// Initial Conditions
			table[0] = 1;
			table[1] = 1;
			for (int i = 2; i < n + 1; i++) {
				table[i] = table[i - 1] + table[i - 2];
			}
			return table[n];
		}
	}

	// A more advanced Fibbonacci -- recursive matehmatica formulas

	public static int Cr(int n) {
		if (n == 0) {
			return 1;
		}
		// recursive function to find C
		int result = 0;
		for (int i = n - 1; i >= 0; i--) {
			result += Cr(i);
		}
		result += n;
		return result;
	}

	public static int Cnr(int n) {
		// solve the problem without using recurtion
		if(n == 0) {
			return 1;
		} else {
			int[] table = new int[n + 1];
			// Terminating Conditions
			table[0] = 1;
			for (int i = 1; i < n + 1; i++) {
				for (int j = i - 1; j >= 0; j--) {
					table[i] += table[j];
				}
				table[i] += i;
			}
			return table[n];
		}
	}

	// Optimal matrix ordering
	public static int matmultcount(int[] coefficients) {
		// you can assume that the coefficients.length >=3
		int multiplier = coefficients[0];
		int result = 0;
		for (int i = 1; i < coefficients.length - 1; i++) {
			result += (multiplier * coefficients[i] * coefficients[i + 1]);
		}
		return result;
	}
}