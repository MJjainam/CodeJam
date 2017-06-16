import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// https://www.hackerrank.com/challenges/happy-ladybugs
public class ladybugs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
            int[] alph = new int[27];
            char arr[] = b.toCharArray();
            for(int i=0;i<arr.length;i++)
                {
                if(arr[i]=='_')
                    alph[26]++;
                else
                {
                    alph[(int)arr[i] - 65]++;
                }
            }
            if(alph[26]>0)
                {
                    boolean flag = true;
                    for(int i=0;i<26;i++)
                        {
                            if(alph[i]==1)
                                {
                                 flag  = false;
                                break;
                            }
                    }
                if(flag)
                    {
                    System.out.println("YES");
                }
                else
                    System.out.println("NO");
            }
            else
                {
                boolean flag = true;
                for(int i=1;i<arr.length-1;i++)
                    {
                        if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1])
                            {
                            flag = false;
                            break;
                        }
                }
                if(arr.length>=2)
                    {
                if(arr[0] != arr[1]) flag = false;
                if(arr[arr.length-1]!=arr[arr.length-2]) flag = false;
                }
                if(arr.length==1)
                    flag = false;
                
                if(flag)
                    System.out.println("YES");
                else
                    System.out.println("NO");
                
                
            }
            /*boolean empty=false,satisfied=true;
            int arr2[] = new int[26];
            for(int i=0;i<arr.length;i++) {
                if(arr[i]=='_') {empty=true;continue;}
                if(arr.length==1) satisfied=false;
                if(i==0&&arr.length!=1&&arr[i]!=arr[i+1]) satisfied=false;
                else if(i==arr.length-1&&arr.length!=1&&arr[i-1]!=arr[i]) satisfied = false;
                else if(i!=0&&i!=arr.length-1&&arr[i]!=arr[i-1]&&arr[i]!=arr[i+1]) satisfied = false;
                arr2[arr[i]-65]++;
            }
            boolean flag = false;
            for(int i=0;i<26;i++) {
                if(arr2[i]==1) {flag = true;System.out.println("NO");}
            }
            if(!flag) {
                if(satisfied||(!satisfied&&empty)) {System.out.println("YES");}
                else System.out.println("NO");
            }*/
        }
        in.close();
    }
}
