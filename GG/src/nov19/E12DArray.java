package nov19;

public class E12DArray {
	
	public static void print2DArr(int arr[][]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int arr[][] = new int[3][3];
		
		System.out.println("arr.length=" +arr.length);
		
		int num = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j] = ++num;
			}
		}
		
		print2DArr(arr);
	}

}
