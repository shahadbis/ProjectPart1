/*
Name: Shahad Abdulaziz Bin Salman
ID: 2105902
Section: B0B 
 */
package algorithmtwo;
import java.io.*;
import java.util.*;

//====================== Graph Class =====================
public class Graph {

    Map<String, Vertex> vertices;
    private List<Edge> adjList;
    private boolean isDigraph;
    private boolean isVisited;
    private int verticesNo;
    private int edgeNo;

    // --------- Constructor ----------
    public Graph() {
        vertices = new HashMap<>();
        adjList = new ArrayList<>();
    }

    // --------- Methods ----------
    // --------- readGraphFromFile method ----------
    public void readGraphFromFile(String fileEdges) throws FileNotFoundException {
        File inputFile = new File(fileEdges);
        Scanner sc = new Scanner(inputFile);

        // Read the graph type: 0 for undirected, 1 for directed
        sc.next();
        if (sc.nextInt() == 0) {
            this.isDigraph = false;
        } else {
            this.isDigraph = true;
        }
        sc.nextLine();

        // Read the number of vertices and edges
        verticesNo = sc.nextInt();
        edgeNo = sc.nextInt();
        sc.nextLine();

        // Read and create vertices and edges from the file
        do {
            String sourceName = sc.next();
            String targetName = sc.next();
            int weight = sc.nextInt();

            // Create vertices if they don't exist
            if (!vertices.containsKey(sourceName)) {
                createVertex(sourceName);
            }
            if (!vertices.containsKey(targetName)) {
                createVertex(targetName);
            }

            // Get the source and destination vertices
            Vertex source = vertices.get(sourceName);
            Vertex target = vertices.get(targetName);

            // Create an edge between the source and destination vertices
            createEdge(source, target, weight);

            // If the graph is directed, create an additional edge in the reverse direction
            if (isDigraph) {
                createEdge(target, source, weight);
            }

            sc.nextLine();
        } while (sc.hasNext());

        sc.close();
    }

    // --------- make_Graph method ----------
    public void make_Graph(int n, int m) {
        Random random = new Random();

        // Create vertices with labels ranging from 0 to n-1
        for (int i = 0; i < n; i++) {
            createVertex(String.valueOf(i));
        }

        // Create edges between randomly selected vertices with random weights
        for (int i = 0; i < m; i++) {
            int u = random.nextInt(n);
            int v = random.nextInt(n);
            int weight = random.nextInt(50) + 1;

            // Get the source and destination vertices based on their labels
            Vertex source = vertices.get(String.valueOf(u));
            Vertex dest = vertices.get(String.valueOf(v));

            // Create an edge between the source and destination vertices with the random weight
            createEdge(source, dest, weight);
        }
    }

    // --------- createVertex method ----------
    public void createVertex(String name) {
        Vertex v = new Vertex(name);
        vertices.put(name, v);
    }

    // --------- createEdge method ----------
    public void createEdge(Vertex source, Vertex dest, int weight) {
        Edge e = new Edge(source, dest, weight);
        adjList.add(e);
    }

    // --------- Setter & Getter ----------
    public Map<String, Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getAdjList() {
        return adjList;
    }

    public boolean isIsDigraph() {
        return isDigraph;
    }

    public int getVeticesNo() {
        return verticesNo;
    }

    public int getEdgeNo() {
        return edgeNo;
    }

    public boolean isIsVisited() {
        return isVisited;
    }
}
