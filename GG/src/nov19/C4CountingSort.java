package nov19;

public class C4CountingSort {
	
	public static void countingSort(int arr[]) {
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		
		int newArray[] = new int[max+1];
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				newArray[arr[i]]++;
			}
		}
		printArray(newArray);
		
		int x = 0, i = 0;
		while(i<arr.length) {
			if(newArray[x] <= 0) {
				x++;
			} else {
				arr[i] = x;
				newArray[x]--;
				i++;
			}
		}
		
	}	
	
	public static void printArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
		printArray(arr);
		countingSort(arr);
		printArray(arr);
		
	}

}
