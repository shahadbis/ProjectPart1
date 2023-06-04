/*
Name: Shahad Abdulaziz Bin Salman
ID: 2105902
Section: B0B 
 */

package algorithmtwo;

//====================== Edge Class =====================
public class Edge implements Comparable<Edge> {
    private Vertex source;
    private Vertex dest;
    private Vertex parent;
    private int weight;

    // --------- Constructor ----------
    public Edge(Vertex source, Vertex dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
        source.addEdge(this);
    }

    // --------- Methods ----------
    public int compareTo(Edge other) {
        return Integer.compare(weight, other.weight);
    }

    // --------- Setters & Getters ----------
    public Vertex getSource() {
        return source;
    }

    public Vertex getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getParent() {
        return parent;
    }
    
}
