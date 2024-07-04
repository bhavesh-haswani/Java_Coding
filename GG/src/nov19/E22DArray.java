package nov19;

public class E22DArray {
	
	public static void print2DArr(int arr[][]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int arr[][] = new int[3][];
		
		System.out.println("arr.length=" +arr.length);
		
		arr[0] = new int[]{1,2,3};
		arr[1] = new int[]{4,5,1,2,3};
		System.out.println("arr[0].length=" +arr[0].length);
		System.out.println("arr[1].length=" +arr[1].length);
		
		
		int num = 0;
//		for(int i=0; i<arr.length; i++) {
//			int arr[i] = new int[][3]; 
//			for(int j=0; j<arr[i].length; j++) {
//				arr[i][j] = ++num;
//			}
//		}
		
//		print2DArr(arr);
	}
}
