package l28_Greedy;

import java.util.*;

public class D1IndianCoins {

	public static void main(String[] args) {
		
		Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
		int amount = 590;
		
		ArrayList<Integer> arrList = new ArrayList<>();
		
		Arrays.sort(coins, Comparator.reverseOrder());
		
		int i = 0;
		while(amount != 0) {
					
			System.out.println("gg " +i +"coins[i] = " +coins[i] +" amount = " +amount);
			
			if(amount >= coins[i]) {
				System.out.println("ggx");
				amount = amount - coins[i];
				arrList.add(coins[i]);
			} else {
				i++;
			}
			
		}
		
		System.out.println(arrList);
		
		
		
		
	}

}
