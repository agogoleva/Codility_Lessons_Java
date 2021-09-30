package Codility;

import java.util.*;

public class CountSemiprimes {

    private int findMin(int[] P)
    {
    int min = P[0];

    for (int i = 1; i < P.length; i++) 
        if (P[i] < min) min = P[i];

    return min;
    }

    private int[] findPrime(int min, int max)
    {
        List<Integer> nondiv = new ArrayList<Integer>();
        int flag = 0;

        if (min <= 2) 
        {
            nondiv.add(2);
            nondiv.add(3);
            min = 5;
        }

        for (int i = min; i <= max; i++)
        {
            innerloop:
            for (int j = 2; j<= (double)Math.sqrt(i); j++)
            {
                flag = 0;
                if (i % j == 0) break innerloop;
                else flag = i;
            }
            if (flag != 0) nondiv.add(flag);
        }
        int[] out = nondiv.stream().mapToInt(i->i).toArray();
        Arrays.sort(out);

        return out;
    }

    private int[] findSemiPrime(int[] prime, int max)
    {
        List<Integer> semiPrime = new ArrayList<Integer>();
 
        for (int i: prime)
        {
            for (int j: prime)
            {
                if ( i * j > max) break;
                semiPrime.add(i * j);
            }
        }

        int[] out = semiPrime.stream().mapToInt(i->i).toArray();
        Arrays.sort(out);
        out = Arrays.stream(out).distinct().toArray();

        return out;
    }

    public int[] solution(int N, int[] P, int[] Q) 
    {
        // write your code in Java SE 8
        int l = P.length;
        int min = findMin(P);
        int max = N;
        int[] out = new int [l];
        int[] prime = findPrime(min, (int)max/2);
        int[] semiPrime = findSemiPrime(prime, max);

        for (int i = 0; i<l; i++)
        { 
            for (int c = P[i]; c <= Q[i]; c++)
            {
                for (int j: semiPrime)
                {
                    if (c == j) out[i]++;
                }
            }
        }

        return (out);
    }

    public static void main(String[] args) 
    {
    	int		N = 26;
    	int[]	P = {1,4,16};
    	int[]	Q = {26,10,20};
    	int[]	out = new CountSemiprimes().solution(N,P,Q);
    	System.out.println("In: N = " + N);
    	System.out.println("In: P = " + Arrays.toString(P));
    	System.out.println("In: Q = " + Arrays.toString(Q));
    	System.out.println("Out: " + Arrays.toString(out));
    }
	
}

//100%

/*
A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
The number of semiprimes within each of these ranges is as follows:

(1, 26) is 10,
(4, 10) is 4,
(16, 20) is 0.
Write a function:

class Solution { public int[] solution(int N, int[] P, int[] Q); }
that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..50,000];
M is an integer within the range [1..30,000];
each element of arrays P, Q is an integer within the range [1..N];
P[i] ≤ Q[i].
*/