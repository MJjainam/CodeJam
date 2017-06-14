// https://www.hackerrank.com/challenges/torque-and-development
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class roadsAndLibraries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt(); //Queries
        for (int q = 0; q < Q; q++) {
            int cities = in.nextInt(); //Number of cities
            int roads = in.nextInt(); //Number of roads
            long cLib = in.nextInt(); //Cost of library
            long cRoad = in.nextInt(); //Cost of a road
            weightedGraph G = new weightedGraph(cities);
            for (int i = 0; i < roads; i++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                int weight = 1;
                Edge e = new Edge(u, v, weight);
                G.addEdgeToGraph(e);
                G.addEdgeToGraph(new Edge(v,u,weight));
            }
            //Getting the sizes of the components
            ArrayList<Long> componentList = G.getComponentSizeList(); 
            long totalCost = 0;
            for(Long compSize:componentList)
            {
                //Gets the cost of making library accessible to everyone
                //Can build a library in all the citied or make them connected, whichever is cheaper
                //And add it to the totalCost
                totalCost =totalCost+ cLib + Math.min(cLib,cRoad)*(compSize-1);  
            }
            // System.out.println(componentList.toString());
            System.out.println(totalCost);
            
            
        }

    }

}

class weightedGraph {    
    ArrayList<ArrayList<Edge>> graph;
    int N;
    boolean[] visited;

    public weightedGraph(int N) {
        this.graph = new ArrayList<ArrayList<Edge>>(N);
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());
        this.N = N;
        visited = new boolean[N];
    }

    public void addEdgeToGraph(Edge e) {
        graph.get(e.u).add(e);
    }

    public long BFS(int i) {  // Do a BFS serach and return the number of cities visited
        Queue<Integer> q = new LinkedList<>();
        int visitedCount = 1;
        visited[i] = true;
        q.add(i);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (Edge u : graph.get(v)) {
                if (!visited[u.v]) {
                    q.add(u.v);
                    visitedCount++;
                    visited[u.v] = true;
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
    

}

class Edge { //This is an innerClass. Stores the edge parameters
    int u, v, weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}