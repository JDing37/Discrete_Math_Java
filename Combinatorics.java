package Discrete_Math;

public class Combinatorics {
	
	private long factorial;
	private long combination;
	private long permutation;
	
	public long factorial(int n) {
		int i = 1;
		factorial = 1;
		while(i <= n) {
			factorial *= i;
			i++;
		}
		return factorial;
	}
	
	public long combination(int n, int k) {
		combination = factorial(n)/(factorial(k)*factorial(n-k));
		return combination;
	}
	
	public long permutation(int n, int k) {
		permutation = factorial(n)/factorial(n-k);
		return permutation;
	}
	
	public long starsAndBarsGT0(int n, int k) {
		combination = factorial(n-1)/(factorial(k-1)*factorial((n-1)-(k-1)));
		return combination;
	}
	
	public long starsAndBarsGE0(int n, int k) {
		combination = factorial(n+k-1)/(factorial(k-1)*factorial((n+k-1)-(k-1)));
		return combination;
	}
	
	

}
