package Codility;

public class CountDiv {
	
	public int solution(int A, int B, int K)
	{
		int	out = 0;
		
		// B/K give how many numbers that are divisible by K till B
		// A/K give how many numbers that are divisible by K till A
		// the difference is how many are in a range from A to B if B > A
		if (A % K == 0)	
			out = B/K - A/K + 1;
		else
			out = B/K - A/K;
		
		return out;
	}

    public static void main(String[] args) 
    {
    	int	A = 6;
    	int	B = 11;
    	int	K = 2;
    	int	out = new CountDiv().solution(A, B, K);
    	System.out.printf("In: A = %d, B = %d, K = %d \n", A, B, K);
    	System.out.println("Out: " + out);
    }
}

//100%

/*
 Write a function:

class Solution { public int solution(int A, int B, int K); }
that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }
For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
*/
