// https://www.interviewbit.com/problems/prettyprint/
import java.util.*;
public class prettyPrint{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        ArrayList<ArrayList<Integer>> twoD = prettyPrint(a);
        for(int i=0;i<twoD.size();i++)
        {
            for(int j=0;j<twoD.get(0).size();j++)
            {
                System.out.print(twoD.get(i).get(j) +" ");
            }
            System.out.println("");
        }


    }
	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        //N*N will be the size of the 2-D arrayList
        int N = (a-1)*2+1;
        
        for(int i=0;i<N;i++)
        {
            ansList.add(new ArrayList<>());
        }
        int i = 0;
        for(;i<a;i++)
        {
            int Atemp = a;
            int j=0;
            //Decreasing towards the middle
            for(;j<=i;j++)
            {
                ansList.get(i).add(Atemp--);
            }
            //if(i!=3)
            int count = 0;
            int totalCount = (a-i)*2 - 2;
            //Constant in the middle
            for(;count<totalCount;j++)
            {
                ansList.get(i).add(ansList.get(i).get(j-1));
                count++;
            }
            Atemp = ansList.get(i).get(j-1);
            //Increasing towards the end
            for(;j<N;j++)
            {
                ansList.get(i).add(++Atemp);
            }
        }
        //Last (N-1)/2 lines will be equal to first (N-1)/2 lines
        for(;i<N;i++)
        {
            ansList.get(i).addAll(ansList.get(N-1-i));
        }
        return ansList;
    }

}