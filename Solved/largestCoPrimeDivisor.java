// https://www.interviewbit.com/problems/largest-coprime-divisor/
import java.util.*;

public class largestCoPrimeDivisor{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        Prime X = new Prime();
        int x = X.gcd(A,B);
        while(x!=1)  //Keep removeing all factors which are in A and B both from A.
        {
            A = A/x;
            x = X.gcd(A,B);
        }
        // return A; 
        System.out.println(A);
    }

}
class Prime
{
    public static ArrayList<Integer> primes;
    public static int gcd(int x,int y)
    {
        int r=0, a, b;
        a = (x > y) ? x : y; // a is greater number
        b = (x < y) ? x : y; // b is smaller number
 
        r = b;
        while(a % b != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
    
}
