// https://www.interviewbit.com/problems/prime-sum/
import java.util.ArrayList;
import java.util.Scanner;

public class primeSum{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(findNums(N).toString());
    }
    public static ArrayList<Integer> findNums(int N)
    {
        boolean[] isPrime = getAllPrimesInTheRange(N);
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=2;i<isPrime.length;i++)
        {
            if(isPrime[i] && isPrime[N-i])
            {
                a.add(i);
                a.add(N-i);
                break;
            }
        }
        return a;
        
    }

    //implementation of seive's algorithm
    public static boolean[] getAllPrimesInTheRange(int rMax) // in  range from 2 to rMax efficiency : 
	{
		int n = rMax;

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }
        return isPrime;
	}

}