import java.util.*;

public class Kruskals {
    int N;
    public int[] rootArray;
    public ArrayList<Edge> edgeList;

    public Kruskals(int N,ArrayList<Edge> edgeList) {
        this.N = N;
        this.edgeList = edgeList;
        rootArray = new int[N];
    }
    

    /*returns the list of edges which will be in 
    the Minimum spanning tree. */
    public ArrayList<Edge> getEdgeList() {
        ArrayList<Edge> MSTedgeList = new ArrayList<>(); //Minimum spanning tree edge list.
        Collections.sort(edgeList, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                //If both weights are equal take the one whose u+v is lesser/
                if (e2.weight == e1.weight) {
                    return ((e1.u + e1.v) - (e2.u + e2.v));
                } else {
                    return e1.weight - e2.weight;
                }
            }
        });

        for (int i = 0; i < rootArray.length; i++)
            rootArray[i] = i;
        
        for (int i = 0; i < edgeList.size(); i++) {
            Edge e = edgeList.get(i);
            // System.out.println(e.weight);
            if (getRoot(e.u) != getRoot(e.v)) {
                union(e.u, e.v);
                MSTedgeList.add(e);
                // totalWeight += e.weight;
            }

        }
        return MSTedgeList;
    }
    

    public int getRoot(int i) {
        //int i=ind;
        while (rootArray[i] != i) {
            // rooElement = rootArray[i];
            rootArray[i] = rootArray[rootArray[i]];
            i = rootArray[i];
        }
        return i;

    }

    /*
    add an edge between i and j and change the root element 
    */
    public void union(int i, int j) {
        int rooti = getRoot(i);
        int rootj = getRoot(j);

        //This ensures that all the components root node will be the one which has lowest 
        //node value. For e.g: if 1<->2 and 3<->4 then when you connect 3<->1 the root of
        //'3' will now be '1'
        rootArray[Math.max(rooti, rootj)] = Math.min(rooti, rootj);

    }

}
/*public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        //int queries = in.nextInt();
        ArrayList<Edge> edgeList = new ArrayList<>();
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int weight = in.nextInt();
            Edge e = new Edge(u, v, weight);
            edgeList.add(e);
        }
        
    }*/

