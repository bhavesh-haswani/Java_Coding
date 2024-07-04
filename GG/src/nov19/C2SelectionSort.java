package nov19;

public class C2SelectionSort {

	public static void selectionSort(int arr[]) {
		
		for(int i=0; i<arr.length-1; i++) {
			int min = arr[i];
			int minIndex = i+1;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
				System.out.println("minIndex=" +minIndex);
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			System.out.println("print after swap");
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
		
		int arr[] = {5, 4, 1, 3, 2};
		selectionSort(arr);
		printArr(arr);
		
	}

}
