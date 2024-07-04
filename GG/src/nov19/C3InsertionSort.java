package nov19;

public class C3InsertionSort {
	
	public static void insertionSort(int arr[]) {
		
		for(int i=1; i<arr.length; i++) {
			int toSortIndex = i;
			int toSortValue = arr[i];
			for(int j=i-1; j>=0; j--) {
//				System.out.println("i=" +i +" j=" +j);
//				System.out.println("Print before swap cond ");
//				printArr(arr);
				if(arr[j] > toSortValue) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
//					System.out.println("Print after swap");
//					printArr(arr);
				} else {
					break;
				}
				printArr(arr);
//				System.out.println("---");
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
		
		int arr[] = {5, 4, 1, 3, 2};
		printArr(arr);
		insertionSort(arr);
		printArr(arr);

	}

}
