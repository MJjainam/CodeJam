/**
 * Created by radix3 on 28/1/17.
 */
   // https://www.hackerrank.com/contests/world-codesprint-9/challenges/kingdom-division

import java.util.*;

public class kingdomDivision {

    public static int[] edgeCount;
    public static ArrayList<ArrayList<Integer>> graph;// = new ArrayList<>();
    public static int N;
    public static Scanner in;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> tree;
    public static long[][][] dpArray;
    public static final int CONST = 1000000007;


    public static void main(String[] args) {
        in = new Scanner(System.in);
        N = in.nextInt();
        edgeCount = new int[N];
        graph = new ArrayList<>();
        visited = new boolean[N];
        dpArray = new long[N][2][2];

        for(int i=0;i<N;i++)
        	for(int j=0;j<2;j++)
        		for(int k=0;k<2;k++)
        			dpArray[i][j][k] = -1;
        createGraph();
        //createMarkOMarkS();
        

        
        tree = createTree(0);
                

        if(N>=3) {
            long count = compute(0);
            System.out.println(count%1000000007);
        }
        else
        {
            System.out.println(2);
        }


    }

    public static void createGraph() {
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N - 1; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
            edgeCount[x] += 1;
            edgeCount[y] += 1;

        }
    }

 
    public static long compute(int v) {
        //System.out.println("Starting with this " +(v+1));
        // return func(v);
        return (dp(0,0,0) + dp(0,1,0))%CONST;


    }

    public static long dp(int cur,int color,int ally)
    {
    	if(dpArray[cur][color][ally]==-1)
    	{

	    	if(tree.get(cur).size()==0)
	    	{
	    		if(ally==0) return 0;
	    		else
	    			return 1;
	    	}
	    	else
	    	{
	    		long tt = 1;
	    		for(int i=0;i<tree.get(cur).size();i++)
	    		{
	    			tt = (tt*(dp(tree.get(cur).get(i),1-color,0)	+ dp(tree.get(cur).get(i),color,1)))%CONST;
	    		}
	    		long sub = 0;
	    		if(ally==0)
	    		{
	    			sub = 1;
	    			for(int i=0;i<tree.get(cur).size();i++)
	    			{
	    				sub = (sub*dp(tree.get(cur).get(i),1-color,0))%CONST;	
	    			}
	    			 
	    		}
	    		tt = (tt - sub)%CONST;
	    		tt = (tt+CONST)%CONST;

	    		dpArray[cur][color][ally] = tt;

	    	}

	    }
	    return dpArray[cur][color][ally];

    }


    
    public static ArrayList<ArrayList<Integer>> createTree(int v) {
        boolean[] flag = new boolean[N];
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++)
            tree.add(new ArrayList<Integer>());
        Queue<Integer> q = new LinkedList<>();
        flag[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int r = q.remove();
            ArrayList<Integer> X = getAllChildrenx(r, flag);
          
            for (Integer i : X) {
                tree.get(r).add(i);
                q.add(i);
                flag[i] = true;
            }
        }
        return tree;


    }

    

    public static ArrayList<Integer> getAllChildrenx(int v, boolean[] flag) {

        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer i : graph.get(v)) {

            if (flag[i] == false) {
                ans.add(i);

            }
        }
        return ans;
    }

    
}
