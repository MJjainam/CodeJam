// https://www.interviewbit.com/problems/first-missing-integer/
import java.util.*;
public class firstMissingInteger {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // Input:  first take number of array elements 
        // Then take the values
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            a.add(in.nextInt());
        }
        int ans = firstMissingPositive(a);
        System.out.println(ans);

    }
	public static int firstMissingPositive(ArrayList<Integer> a) {
        //Notice that the answer should be in range [1,N].
	    for(int i=0;i<a.size();i++) //removing all the negative numbers
	    {
	        if(a.get(i) <= 0 )
	        {
	            a.remove(i);
	            i--;
	        }
	    }
	    int N = a.size();
	    
	    int ans=-1;
	    for(int i=0;i<N;i++)  
	    {
	        int index = Math.abs(a.get(i))-1;
            //If the index is less than N then I keep track of this by setting the corresponding
            //index to negative value.
            //If index > N then there is no point of keeping track of it as that can't be the answer
            //The range of answer can be [1,N] for which we are using indices [0,N-1] 
	        if(index<N) 
	            a.set(index, Math.abs(a.get(index))*(-1));
	        
	    }
	    for(int i=0;i<a.size();i++)
	    {
            //The index of the first positive integer is the answer
	        if(a.get(i)>0)
	        {
	            ans = i+1;
	            break;
	        }
	    }
	    if(ans==-1)
	    {
	        ans = a.size()+1;
	    }
	    return ans;
	}
}
