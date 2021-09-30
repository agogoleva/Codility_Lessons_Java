package Codility;

public class ChocolatesByNumbers {

    long gcd(long a, long b, long res)
    {
        if (a ==b ) return res*a;
        else if ((a % 2 == 0) && (b % 2 == 0)) return gcd(a / 2, b /2 , res * 2);
        else if (a % 2 == 0) return gcd(a / 2, b, res);
        else if (b % 2 == 0) return gcd(a, b / 2, res);
        else if (a > b) return gcd(a - b, b, res);
        else return gcd(a, b - a, res);
    }

    long lcm(int a, int b)
    {
        long A = (long)a;
        long B = (long)b;

        return (A*B / gcd(A,B,1));
    }
    public int solution(int N, int M) 
    {
    	// write your code in Java SE 8
    	return (int)(lcm(N,M) / M);
    }
    
    public static void main(String[] args) 
    {
    	int	N = 10;
    	int	M = 4;
    	int	out = new ChocolatesByNumbers().solution(N, M);
    	System.out.println("In: N = " + N);
    	System.out.println("In: M = " + M);
    	System.out.println("Out: " + out);
    }
}

//100%

/*
Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

You stop eating when you encounter an empty wrapper.

For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

The goal is to count the number of chocolates that you will eat, following the above rules.

Write a function:

class Solution { public int solution(int N, int M); }
that, given two positive integers N and M, returns the number of chocolates that you will eat.

For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..1,000,000,000].

*/