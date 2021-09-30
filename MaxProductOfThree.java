package Codility;

import java.util.Arrays;

public class MaxProductOfThree {

	public int solution(int[] A)
	{
		int	out = 0;
		int	l = A.length;
		
		//sort A and pick: last 3 numbers || first negative 2 and the last
		Arrays.sort(A);
		if (A[l-3]*A[l-2]*A[l-1] >= A[0]*A[1]*A[l-1])
			out = A[l-3]*A[l-2]*A[l-1];
		else
			out = A[0]*A[1]*A[l-1];
		
		return (out);
	}
	
    public static void main(String[] args) 
    {
    	int[]	A = {-3, 1, 2, -2, 5, 6};
    	int		out = new MaxProductOfThree().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: " + out);
    }
}

//100%

/*
A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
*/