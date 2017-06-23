// https://www.hackerrank.com/challenges/game-of-two-stacks
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class gameOfTwoStacks {

    public static long[] a;
    public static long[] b;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            a = new long[n];
            a[0] = in.nextLong();
            for(int i=1; i < n; i++){
                a[i] = a[i-1]+in.nextInt();
            }
            b = new long[m];
            b[0] = in.nextLong();
            for(int i=1; i < m; i++){
                b[i] = b[i-1]+in.nextInt();
            }
            int max = 0;
            max = getBinary(x, 0, b.length) + 1;
            for(int i=0;i<a.length;i++)
            {
                long val1 = a[i];
                if(val1>x) break;
                long val2 = x - a[i];
                int j = getBinary(val2,0,b.length);
                max = Math.max(max,i+j+2);
            }
            System.out.println(max);


            
        }
    }
    //returns the max-index such that a[max-index]<=val 
    public static int getBinary(long val,int low,int high) 
    {
        if(low<=high)
        {
            int mid = (high+low)/2;
            if(mid==b.length-1 && b[mid]>val) return -1;
            if(mid==b.length-1 && b[mid]<=val) return mid;
            if(b[mid]<=val && b[mid+1]>val)
            {
                return mid;
            }
            if(b[mid]>val)
            {
                return getBinary(val, low, mid-1);
            }
            else{
                return getBinary(val, mid+1, high);
            }
        }
        else{
            return -1;
        }
    }
}
