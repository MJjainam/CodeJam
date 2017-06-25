// https://www.hackerrank.com/challenges/bigger-is-greater
import java.io.*;
import java.util.*;

public class tr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        while(n > 0){
            String s = in.next();
            System.out.println(ans(s));
            n--;
        }
    }
    public static String ans(String s)
    {
        char[] c = s.toCharArray();
        c = s.toCharArray();
        
        //start from the right end 
        int swapEleIndex1 = c.length-2;
        while(swapEleIndex1>=0)
        {
            if(c[swapEleIndex1] < c[swapEleIndex1+1])
            {
                break;
            }
            swapEleIndex1--;
        }
        if(swapEleIndex1==-1) return "no answer";
        //find the index u will swap it with
        int swapEleIndex2 = swapEleIndex1+1;
        for(int i=swapEleIndex1+1;i<c.length;i++)
        {
            if(c[i] < c[swapEleIndex2] && c[i]>c[swapEleIndex1])
            {
                swapEleIndex2 = i;
            }
        }
        //swap the elements
        char t = c[swapEleIndex1];
        c[swapEleIndex1] = c[swapEleIndex2];
        c[swapEleIndex2] = t;

        //sort the characters to the right of swapElementIndex1
        Arrays.sort(c, swapEleIndex1+1, c.length);
        return new String(c);
    }
}