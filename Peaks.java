package Codility;

import java.util.*;

public class Peaks {
	
    public int solution(int[] A) {
        // write your code in Java SE 8
        int l = A.length;
        int[] pk = new int[l];
        int n_pk = 0;
        
        for (int i = 1; i < l-1; i++) 
        {
            if (A[i-1] < A[i] && A[i+1] < A[i]) 
            {
                pk[i] = 1;
                n_pk++;
            }
        }

        if (n_pk == 0 || l == 0) return (0);
        if (n_pk == 1) return (1);

        int k = 0;
        List<Integer> dev = new ArrayList<Integer>();
        double sqrt = (double)Math.sqrt(l);
        for (int i = 1; i <= sqrt; i++)
        {
            if (l % i == 0) 
            {
                dev.add(i);
                k++;
                dev.add(l / i);
                k++;
            }
        }
        if (k == 1) return (1);
        int[] devs = dev.stream().mapToInt(i->i).toArray();
        Arrays.sort(devs);
        int flag = 0;
        outerloop:
        for (int d: devs)
        {
            innerloop:
            for (int i = 0; i < l; i+=d)
            {
                int[] slice = Arrays.copyOfRange(pk, i, i + d);
                boolean check = Arrays.stream(slice).anyMatch(j -> j == 1);
                if (!check) 
                {
                    flag = 0;
                    break innerloop;
                }
                else flag = d;
            }
            if (flag != 0) break outerloop;
        }

        return (l / flag);
    }

    public static void main(String[] args) 
    {
    	int[]	A = {1,2,3,4,3,4,1,2,3,4,6,2};
    	int		out = new Peaks().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: " + out);
    }

}

//100%

/*
A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
has exactly three peaks: 3, 5, 10.

We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:

A[0], A[1], ..., A[K − 1],
A[K], A[K + 1], ..., A[2K − 1],
...
A[N − K], A[N − K + 1], ..., A[N − 1].
What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).

The goal is to find the maximum number of blocks into which the array A can be divided.

Array A can be divided into blocks as follows:

one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].

The maximum number of blocks that array A can be divided into is three.

Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the maximum number of blocks into which A can be divided.

If A cannot be divided into some number of blocks, the function should return 0.

For example, given:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [0..1,000,000,000].
*/