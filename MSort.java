/*
 *	Author: Tomos Ewe - tomosewe@gmail.com 
 *	Original Upload 25/09/2014
 *	My own Merge Sort method
 *	created as practice
 *	for coding interviews.
 */
 
import java.util.*;

public class MSort {
	
	public static void main (String args[]) {		
	
		int[] array = createRandomArray(10);
		
		System.out.println("Creating an array of 10 random integers.");
		System.out.println();
		System.out.println(Arrays.toString(array));
		System.out.println();		
		
		System.out.println("Sorting array using Merge Sort.");
		System.out.println();
		
		mergesort(array);
		
		//Arrays.sort(array);
		
		System.out.println(Arrays.toString(array));
		System.out.println();
	}


	public static void mergesort(int[] array){	
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length -1);		
	}
	
	public static void mergesort(int[] array, int[] helper, int low, int high){	
		if (low<high){
			int middle = ( low+high ) / 2;
			mergesort(array, helper, low, middle);
			mergesort(array, helper, middle + 1, high);
			merge(array, helper, low, middle, high);
		}			
	}
	
	public static void merge(int[] array, int[] helper, int low, int middle, int high){	
		//copy both halves into a helper array
		for (int i = low; i <= high; i++){
			helper[i] = array[i];			
		}
	
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		while(helperLeft <= middle && helperRight <= high){		
			if (helper[helperLeft] <= helper[helperRight]) {			
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {			
				array[current] = helper[helperRight];
				helperRight++;							
			}			
			current++;		
		}
		
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {		
			array[current + i] = helper[helperLeft + i];		
		}
		//to see each step in merge uncomment code below
		//System.out.println(Arrays.toString(array));		
	}	
	
	public static int[] createRandomArray (int length) {		
		int[] array = new int[length];		
		Random rand = new Random();				
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100) + 1;
		}				
		return array;	
	}
	
	
}