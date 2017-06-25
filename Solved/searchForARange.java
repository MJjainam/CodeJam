// https://www.interviewbit.com/problems/search-for-a-range/
import java.util.ArrayList;
import java.util.Scanner;

public class tr{
    public static ArrayList<Integer> a;
    public static ArrayList<Integer> ans;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N  =in.nextInt();
        a = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            a.add(in.nextInt());
        }
        int b = in.nextInt();
        System.out.println(bin(a,b));


    }
    public static ArrayList<Integer> bin(ArrayList<Integer> a,int b)
    {
        ans = new ArrayList<>();
        int start = search1(0,a.size()-1,b);   
        int end = search2(0,a.size()-1,b);
        ans.add(start);
        ans.add(end);
        return ans;
    }
    //Search for the lower limit
    public static int search1(int low,int high,int b)
    {
        if(low<=high)
        {
            // System.out.println("first");       
            int mid = (low+high)/2;
            if(a.get(mid)==b && (mid==0 || a.get(mid-1)<b))
            {
                return mid;
            }
            if(a.get(mid)==b)
            {
                return search1(low,mid-1,b);
            }
            if(a.get(mid)<b)
            {
                return search1(mid+1,high,b);
            }
            return search1(low,mid-1,b);
        
        }
        return -1;
    }
    //search for the upper limit
    public static int search2(int low,int high,int b)
    {
        if(low<=high)
        {
            int mid = (low+high)/2;
            if(a.get(mid)==b && (mid==a.size()-1 || a.get(mid+1)>b))
            {
                return mid;
            }
            else{
                if(a.get(mid)==b)
                {
                    return search2(mid+1,high,b);
                }
                else if(a.get(mid)<b)
                {
                    return search2(mid+1,high,b);
                }
                else return search2(low,mid-1,b);
            }
        }
        return -1;
    }
}