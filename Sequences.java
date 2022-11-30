package Discrete_Math;

public class Sequences {
	
	String sequence;
	
	public String thueMorse(int iteration) {
		sequence = "";
		String newsequence = "";
		for(int i = 0; i < iteration; i++) {
			if(sequence.equalsIgnoreCase("")) {
				sequence += 'T';
			} else {
				for(int j = 0; j < sequence.length(); j++) {
					if(sequence.charAt(j) == 'T') {
						newsequence += 'F';
					} else {
						newsequence += 'T';
					}
				}
				sequence += newsequence;
				newsequence = "";
			}
		}
		return sequence;
	}
	
	public int[] fibonacciArray(int n) {
		int[] fibArray = new int[n];
		fibArray[0] = 1;
		fibArray[1] = 1;
		for(int i = 1; i < n-1; i++) {
			fibArray[i+1] = fibArray[i] + fibArray[i-1];
		}
		return fibArray;
	}

}
