/*
Name: Shahad Abdulaziz Bin Salman
ID: 2105902
Section: B0B 
 */
package algorithmtwo;

//====================== Kruskal Class =====================

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlg extends MSTAlgorithm {

    private Graph graph;
    private int cost;

    // --------- Constructor ----------
    public KruskalAlg(Graph graph) {
        this.graph = graph;
    }

    // --------- Methods ----------
    @Override
    public void displayResultingMST(int req) {
        long start = System.nanoTime();
        kruskalMST(req); // Call the merged kruskalMST method
        long end = System.nanoTime();
        long totalTime = end - start;
        System.out.println("Time taken by Kruskal's Algorithm: " + totalTime + " ns");
    }

    public int getCost() {
        return cost;
    }

    private void kruskalMST(int req) {
        // Sort the edges by weight
        Collections.sort(graph.getAdjList());

        // Initialize the union-find data structure
        DisjointSet uf = new DisjointSet(graph.vertices.size());

        // Initialize the resulting MST
        List<Edge> mst = new ArrayList<>();

        // Iterate over the sorted edges
        for (Edge e : graph.getAdjList()) {
            Vertex source = e.getSource();
            Vertex dest = e.getDest();
            int sourceId = source.getId();
            int destId = dest.getId();

            // Check if the source and dest are in different components
            if (uf.find(sourceId) != uf.find(destId)) {
                // Add the edge to the MST and merge the components
                mst.add(e);
                uf.union(sourceId, destId);
            }
        }
        if (req == 1) {
            //Print the resulting MST
            System.out.println("The phone network generated by Kruskal algorithm is as follows:\n");
            for (Edge e : mst) {
                System.out.println("Office No." + e.getSource().getName() + " - " + "Office No." + e.getDest().getName() + " : line length: " + e.getWeight());
            }
            System.out.println();
        }
        // Compute and print the cost of the designed phone network
        int cost = 0;
        for (Edge e : mst) {
            cost += e.getWeight();
        }
        System.out.println("The cost of the designed phone network: " + cost);
    }
}


//====================== DisjointSet Class =====================
class DisjointSet {

    private int[] parent;

    // --------- Constructor ----------
    public DisjointSet(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // --------- Methods ----------
    /**
     * Finds the representative/root of the set containing the given element.
     * Implements the find operation in the disjoint set data structure.
     *
     * @param x The element for which to find the representative.
     * @return The representative/root of the set containing the element.
     */
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    /**
     * Unions (merges) the sets that contain the given elements x and y.
     * Implements the union operation in the disjoint set data structure.
     *
     * @param x The first element.
     * @param y The second element.
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }
}
