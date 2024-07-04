package dec10;

public class A2BacktrackingOnArray {

	public static void changeArr(int arr[], int pointer) {
		
		//base case
		if(pointer == arr.length) {
			return;
		}
		
		//recursion
		arr[pointer] = pointer+1;
//		printArr(arr);
		changeArr(arr, pointer+1);
//		printArr(arr);
//		System.out.println("pointer=" +pointer);
		arr[pointer] = arr[pointer]-2;
		
	}
	
	public static void printArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		int arr[] = new int[n];
		
		printArr(arr);
		changeArr(arr, 0);
		printArr(arr);
		
	}

}
