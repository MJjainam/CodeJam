class Edge {
    int u, v, weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Start: " + Integer.toString(this.u) + " End: " + Integer.toString(this.v) + " Weight: "
                + Integer.toString(this.weight);
    }
}