package Codility;

import java.util.*;

public class MissingInteger {

	public int solution(int[] A)
	{
		//limitations
		int	l = A.length;
		if (l == 0)
			return (1);
		
		//sort array to exclude negative sequence
		Arrays.sort(A);
		if (A[l - 1] <= 0)
			return (1);
		
		//algo based on removing encountered elements from a set
		Set<Integer> range = new HashSet<Integer>();
		for (int i = 0; i < l; i++)	//populate set with A
			range.add(A[i]);
		for (int i = 1; i <= l; i++)	//going through the range & if it's missing => return it
			if (!range.contains(i))
				return (i);

		return (l + 1);	//if non is mssing return next int in line
	}
	
    public static void main(String[] args) 
    {
    	int[]	A = {1, 3, 6, 4, 1, 2};
    	int		out = new MissingInteger().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: " + out);
    }
}

//100%

/*
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/