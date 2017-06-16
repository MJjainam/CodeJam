// import sun.misc.Queue;

class weightedGraph {
    ArrayList<ArrayList<Edge>> graph;
    int N;
    boolean[] visited;

    public weightedGraph(int N) { //Contrsuctor for the class
        this.graph = new ArrayList<ArrayList<Edge>>(N);
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());
        this.N = N;
        visited = new boolean[N];
    }

    public void addEdgeToGraph(Edge e) {
        graph.get(e.u).add(e);
    }

    public long BFS(int i) { // Do a BFS serach and return the number of cities visited
        Queue<Integer> q = new LinkedList<>();
        int visitedCount = 1;
        visited[i] = true;
        q.add(i);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (Edge e : graph.get(v)) {
                if (!visited[e.v]) { //e.v is the gives the node
                    q.add(e.v);
                    visitedCount++;
                    visited[e.v] = true;
                }
            }

        }
        return visitedCount;
    }

    public ArrayList<Long> getComponentSizeList() { //returns the list of components size
        visited = new boolean[N];
        ArrayList<Long> componentSizeList = new ArrayList<>();
        // int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                // count++;
                long size = BFS(i);
                componentSizeList.add(size);
            }

        }
        return componentSizeList;
    }

    //Used only when the graph weights are all equal.
    public findShortestPathBFS()
    {
        visited = new boolean[N];
        int dist = 0;
        int[] distArray = new int[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        distArray[0] = dist;
        visited[0] =true;
        q.add(-1);
        while(q.size()!=1)
        {
            int a = q.remove();
            if(a==-1){
                dist++;
                q.add(-1);
            }
            else{
                //Edge u = graph.get(a);
                for(Edge e: graph.get(a)){
                    if(!visited[e.v])
                    {
                        q.add(e.v);
                        visited[e.v] = true;
                        dist[e.v] = dist;
                    }
                    
                }
            }
        }
    }

}

class Edge {
    int u, v, weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}