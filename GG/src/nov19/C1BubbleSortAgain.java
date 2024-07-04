package nov19;

public class C1BubbleSortAgain {

	public static void bubbleSort(int arr[]) {
		
		for(int i=0; i<arr.length; i++) {
			int swaps = 0;
			for(int j=1; j<arr.length-i; j++) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					swaps++;
				}
				System.out.println("Iteration j:" +(j-1));
				printArr(arr);
			}
			if(swaps==0) {
				break;
			}
			System.out.println("Iteration i:" +i);
			printArr(arr);
		}
		
	}
	
	public static void printArr(int arr[]) { 
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int arr[] = {5, 4, 3, 2, 1};
		System.out.println("Original Array:");
		printArr(arr);
		bubbleSort(arr);
		System.out.println("Array after sorting:");
		printArr(arr);
		
	}

}
