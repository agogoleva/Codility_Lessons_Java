package Codility;

import java.util.*;

public class AbsDistinct {
	
	public int dist(int[] A)
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

	public int solution(int[] A)
	{
		int	l = A.length;
		int[] A_abs = new int[l];
		
		for (int i = 0; i < l; i++)
			A_abs[i] = Math.abs(A[i]);
				
		return (dist(A_abs));
	}
	
    public static void main(String[] args) 
    {
    	int[]	A = {-5, -3, -1, 0, 3, 6};
    	int out = new AbsDistinct().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: "+ out);
    }
}

//100%

/*
A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

For example, consider array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.

For example, given array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
array A is sorted in non-decreasing order.
*/
