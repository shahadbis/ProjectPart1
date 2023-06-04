/*
Name: Shahad Abdulaziz Bin Salman
ID: 2105902
Section: B0B 
 */

package algorithmtwo;
import java.util.ArrayList;
import java.util.List;

//====================== Vertex Class =====================

public class Vertex {
    private static int nextId = 0;
    private int id;
    private String name;
    private List<Edge> adjList;

    // --------- Constructor ----------
    public Vertex(String name) {
        this.id = nextId++;
        this.name = name;
        this.adjList = new ArrayList<>();
    }

    // --------- Methods ----------
    public void addEdge(Edge e) {
        adjList.add(e);
    }
    // --------- Setters & Getters ----------
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return adjList;
    }

    public String toString() {
        return name;
    }


}
