package com.ssafy.live0816.binary_greedy;
import java.util.*;
public class Ex_동전자판기_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int targetMoney = sc.nextInt();
		
		int[] units = {500, 100, 50, 10, 5,1};
		int[] counts = { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
		
		int totalMoney = 0;
		for (int i = 0, size = units.length; i < size; i++) { // 보유하고있는 모든 동전들로 만들수있는 금액 계산 
			totalMoney += units[i] * counts[i];
		}
		
		int remainMoney = totalMoney - targetMoney; //갖고있는 돈에서 음료수 값을 지불하고 남은 나머지 금액 
		
		//음료수값을 지불하는 데 동전을 최대로 사용하려면, 지불하고 남은금액의 동전수를 최소로 하면 됨
		
		int sum = 0, maxCnt, availCnt;
		for (int i = 0, size = units.length; i < size; i++) {
			maxCnt = remainMoney/units[i]; //해당 금액을 i 화폐단위를 가장 많이 쓸때의 가능한 
			availCnt = maxCnt<=counts[i]? maxCnt:counts[i];
			
			counts[i] -= availCnt;
			remainMoney -= availCnt * units[i];
			
			sum += counts[i]; //사용되고 남은 동전이 지불하기 위해 사용될 동전 수
		}
		
		System.out.println(sum);
		
		for (int i = 0, size = counts.length; i < size; i++) {
			System.out.print(counts[i] + " ");
		}
	}

}
