package com.lm.lottomax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class LottomaxApplication {

    private static Set<Integer> generateNumbers()
	{
		int n = 8; // 7 numbers + 1 bonus number
		Set<Integer> numbers = new HashSet<Integer>();
		while (numbers.size() < n) {
		    int rand = (int)((50 * Math.random()) + 1);
		    numbers.add(rand);
		}
		return numbers;
	}

	public static Integer[] convertToArray()
	{
		Object[] array = generateNumbers().toArray();
		Integer [] longarray = new Integer[array.length];

		for(int i=0; i < array.length; i++)
		{
			longarray[i] = (Integer) array[i];
		}
		Arrays.sort(longarray);
		return longarray;
	}

	public static Boolean countingAllEvenOrOdd(Integer arr[])
	{
		int even_count = 0;
		int odd_count = 0;

		int length = arr.length;
		boolean result = false;

		// loop to read all the values in the array
		for(int i = 0 ; i < length ; i++)
		{
			// checking if a number is completely
			// divisible by 2
			if (arr[i] % 2 != 0)
				odd_count ++ ;
			else
				even_count ++ ;
		}

		if(odd_count == 0 || even_count == 0) {
			result = true;
		}
		else {
			result = false;
		}

		return result;
	}


	public static void main(String[] args)
	{
        System.out.print("Enter number of draws: ");
        Scanner numReader = new Scanner(System.in);
        int num = numReader.nextInt();
        System.out.println();
        Set<Integer[]> tempHashSet = new HashSet<Integer[]>();
        for (int i = 1; i <= num; i++) {
        	Integer[] temp =  convertToArray();
			//System.out.println("Draw Number: " + i + " : " +Arrays.toString(temp));
            //System.out.println("Draw Number: " + i + " : " + Arrays.toString(convertToArray()));
            //tempHashSet.add()
			if(!countingAllEvenOrOdd(temp)){
				tempHashSet.add(temp);
			}
        }

        // Display all the draws in the hashset
		for(Integer[] temp : tempHashSet){
			System.out.println(Arrays.toString(temp));
		}

    }
}
