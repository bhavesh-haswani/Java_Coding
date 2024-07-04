package nov19;

import java.util.Random;

public class C5MergeSort {
	
	public static void MergeSort(int arr[], int startIndex, int endIndex) {
		
		if(startIndex >= endIndex) {
			return;
		}
		
		int mid = (startIndex + endIndex)/ 2;
		MergeSort(arr, startIndex, mid);
		MergeSort(arr, mid+1, endIndex);
		merge(arr, startIndex, mid, endIndex);
		
	}
	
		
	public static void merge(int arr[], int startIndex, int mid, int endIndex) {
		
		int i = startIndex;
		int j = mid + 1;
		int temp[] = new int[endIndex-startIndex + 1];
		int k = 0; //index for temp array
		
		while(i<=mid && j<=endIndex) {
			
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid) {
			temp[k++] = arr[i++];
		}
		
		while(j<=endIndex) {
			temp[k++] = arr[j++];
		}
		
		for(k=0, i=startIndex; k<temp.length; i++, k++) {
			arr[i] = temp[k];
		}
		
	}
	
	public static void printArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int arr[] = new int[10];
		
		Random rand = new Random();
		for(int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt(10);
		}
		System.out.println("Before Sorting: ");
		printArr(arr);
		MergeSort(arr, 0, arr.length-1);
		printArr(arr);
		
	}

}
