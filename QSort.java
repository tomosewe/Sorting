/*
 *	Author: Tomos Ewe - tomosewe@gmail.com 
 *	Uploaded 24/09/2014
 *	My own Quick Sort method
 *	created as practice
 *	for coding interviews.
 */
 
 import java.util.*; 

public class QSort {	
	public static void main (String args[]) {	
		int[] array = createRandomArray(10);
		
		System.out.println("Creating an array of 10 random integers.");
		System.out.println();
		System.out.println(Arrays.toString(array));
		System.out.println();		
		
		System.out.println("Sorting array using Quick Sort.");
		System.out.println();
		quickSort(array, 0, array.length - 1);
		
		//Arrays.sort(array);
		
		System.out.println(Arrays.toString(array));
		System.out.println();
	}		
	
	public static void quickSort(int[] array, int left, int right){
		int index = partition(array, left, right);
		if (left < index -1) { // sort left half
			quickSort(array, left, index -1); 
		}
		if (index < right) { // sort right half
			quickSort(array, index, right);
		}	
	}
	
	public static int partition(int[] array, int left, int right) {	
		int pivot = array[(left + right) / 2]; // pick pivot point
		while (left <= right) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;				
			}
		}
		return left;	
	}
	
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;	
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

