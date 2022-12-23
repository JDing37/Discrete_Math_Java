package Discrete_Math;

import java.util.ArrayList;
import java.util.Arrays;

public class Sets {
	
	private int[] setOfIntegers;
	
	public int[] intersectionArray(int[] set1, int[] set2) {
		int minSetLength = Math.min(set1.length, set2.length);
		int maxSetLength = Math.max(set1.length, set2.length);
		int[] minSet;
		int[] maxSet;
		int setLength = 0;
		int setIterator = 0;
		if(set1.length < set2.length) {
			minSet = set1;
			maxSet = set2;
		} else {
			minSet = set2;
			maxSet = set1;
		}
		for(int i = 0; i < minSetLength; i++) {
			for(int j = 0; j < maxSetLength; j++) {
				if(minSet[i] == maxSet[j]) {
					setLength++;
				}
			}
		}
		setOfIntegers = new int[setLength];
		for(int i = 0; i < minSetLength; i++) {
			for(int j = 0; j < maxSetLength; j++) {
				if(minSet[i] == maxSet[j]) {
					setOfIntegers[setIterator] = minSet[i];
					setIterator++;
				}
			}
		}
		return setOfIntegers;
	}
	
	public ArrayList<Integer> intersectionArrayList(int[] set1, int[] set2) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		int minSetLength = Math.min(set1.length, set2.length);
		int maxSetLength = Math.max(set1.length, set2.length);
		int[] minSet;
		int[] maxSet;
		int setLength = 0;
		int setIterator = 0;
		if(set1.length < set2.length) {
			minSet = set1;
			maxSet = set2;
		} else {
			minSet = set2;
			maxSet = set1;
		}
		for(int i = 0; i < minSetLength; i++) {
			for(int j = 0; j < maxSetLength; j++) {
				if(minSet[i] == maxSet[j]) {
					set.add(minSet[i]);
				}
			}
		}
		return set;
	}
	
	public int[] intersectionArraySort(int[] set1, int[] set2) {
		Arrays.sort(set1);
		Arrays.sort(set2);
		int[] lowSet;
		int[] highSet;
		if(set1[0] < set2[0]) {
			lowSet = set1;
			highSet = set2;
		} else {
			lowSet = set2;
			highSet = set1;
		}
		int k = 0;
		int sizeOfSet = 0;
		int j = 0;
		int setIterator = 0;
		for(int i = 0; i < lowSet.length; i++) {
			while(lowSet[i] > highSet[k]) {
				k++;
				if(k == highSet.length) {
					k--;
					break;
				}
			}
			if(lowSet[i] == highSet[k]) {
				sizeOfSet++;
			}
		}
		setOfIntegers = new int[sizeOfSet];
		for(int i = 0; i < lowSet.length; i++) {
			while(lowSet[i] > highSet[j]) {
				j++;
				if(j == highSet.length) {
					j--;
					break;
				}
			} 
			if(lowSet[i] == highSet[j]) {
				setOfIntegers[setIterator] = lowSet[i];
				setIterator++;
			}
		}
		return setOfIntegers;
	}
	
	public int[] unionArraySort(int[] set1, int[] set2) {
		Arrays.sort(set1);
		Arrays.sort(set2);
		int[] intersection = intersectionArray(set1,set2);
		if(set1 == set2) {
			setOfIntegers = set1;
		} else {
			setOfIntegers = new int[set1.length+set2.length-intersection.length];
			for(int i = 0; i < set1.length; i++) {
				setOfIntegers[i] = set1[i];
			}
			int l = 0;
			boolean check = false;
			for(int j = 0; j < set2.length; j++) {
				for(int k = 0; k < set1.length; k++) {
					if(set2[j] != set1[k]) {
						check = true;
					} else {
						check = false;
					}
				}
				if(check == true) {
					setOfIntegers[set1.length+l] = set2[j];
					l++;
					check = false;
				}
			}
		}
		return setOfIntegers;
	}
	
	/*
	 * Algorithms below have bugs
	 */
	
	
	/* public int[] union(int[] set1, int[] set2) {
	Arrays.sort(set1);
	Arrays.sort(set2);
	int[] minSet;
	int[] maxSet;
	if(set1.length < set2.length) {
		minSet = set1;
		maxSet = set2;
	} else {
		minSet = set2;
		maxSet = set1;
	}
	if(set1 == set2) {
		setOfIntegers = set1;
	} else {	
		int iterator = 0;	
		int[] intersection = intersection(set1,set2);
		setOfIntegers = new int[minSet.length+maxSet.length-intersection.length];
		for(int i = 0; i < minSet.length; i++) {
			setOfIntegers[i] = minSet[i];
		}
		for(int j = 0; j < maxSet.length; j++) {
			if(minSet[minSet.length-1] < maxSet[j] || maxSet[j] < minSet[0]) {
				setOfIntegers[minSet.length+iterator] = maxSet[j];
				iterator++;
			}
		}
	}
	return setOfIntegers; 
}
*/
	
	
}
