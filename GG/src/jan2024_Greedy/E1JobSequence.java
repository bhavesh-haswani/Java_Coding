package jan2024_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class E1JobSequence {

	public static void main(String[] args) {
		
		//given is dead line and the points
		
		int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
		
		int sortedJobs[][] = new int[jobsInfo.length][3];
		
		for(int i=0; i<jobsInfo.length; i++) {
			sortedJobs[i][0] = i;
			sortedJobs[i][1] = jobsInfo[i][0];
			sortedJobs[i][2] = jobsInfo[i][1];
		}
		
		Arrays.sort(sortedJobs, Comparator.comparingInt(o -> o[2]));
//		System.out.println(Arrays.toString(sortedJobs[0]));
		
		ArrayList<Integer> arrList = new ArrayList<>();
		
		int currentTime = 0;
		for(int i=sortedJobs.length-1; i>=0; i--) {
			if(sortedJobs[i][1] > currentTime) {
				currentTime++;
				arrList.add(sortedJobs[i][0]);
			}
		}
		
		System.out.println(arrList);
	}

}
