package l28_Greedy;

public class A11ActivitySelection_maxActivitiesDone {

	public static void main(String[] args) {
		
		
		/*
		
		Below given are the start time and end time of each activity.
		Total there are 3 activities
		Select max no. of activities which can be performed
		
		start = 10, 20, 30
		end   = 20 25 30
		
		//for this type of problem, 
		 we sort the array in ascending order on the basis
		 of END TIME 
		
		 */
		
//		int start[] = {10, 12, 20};
//		int end[] = {20, 25, 30};
		int start[] = {1, 3, 0, 5, 8, 5};
		int end[] = {2, 4, 6, 7, 9, 9};
		
		int lastEndTime = end[0];
		
		int maxActivities = 1;
		for(int i=1; i<start.length; i++) {
			if(start[i] >= lastEndTime) {
				lastEndTime = end[i];
				maxActivities++;
			}
		}
		
		System.out.println("Max activities = " +maxActivities);
		
		
	}

}
