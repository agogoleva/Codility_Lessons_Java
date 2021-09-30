package Codility;

import java.util.Arrays;

public class Distinct {

	public int solution(int[] A)
	{
		int	out = 0;
		int	l = A.length;
		
		//sort A and loop through values, if next is different from previous add to out
		Arrays.sort(A);
		if (l != 0)
		{
			for (int i = 0; i < l - 1; i++)
			{
				if (A[i] != A[i + 1])
					out++;
			}
			out += 1;
		}
		
		return (out);
	}
	
    public static void main(String[] args) 
    {
    	int[]	A = {2, 1, 1, 2, 3, 1};
    	int		out = new Distinct().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: " + out);
    }
}

//100%

/*
Write a function

class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/