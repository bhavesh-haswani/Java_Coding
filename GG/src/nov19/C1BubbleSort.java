package nov19;

public class C1BubbleSort {

	public static void bubbleSort(int arr[]) {
		
		for(int i=0; i<arr.length-1; i++) {
			System.out.println("1");
			int swap = 0;
			for(int j=0; j<arr.length-1-i; j++) {
				System.out.println("2");
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap++;
				}
			}
			if(swap == 0) {
				return;
			}
		}
		
	}
	
	public static void printArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

//		int arr[] = {5, 4, 1, 3, 2};
//		int arr[] = {1, 2, 3, 4, 5};
		int arr[] = {5, 4, 3, 2, 1};
		bubbleSort(arr);
		printArr(arr);

	}

}
