/*
Name: Shahad Abdulaziz Bin Salman
ID: 2105902
Section: B0B 
 */
package algorithmtwo;

//====================== Prim Class =====================
import java.util.*;

public class MHPrimAlg extends MSTAlgorithm {

    private Graph graph;
    private int cost;

    // --------- Constructor ----------
    public MHPrimAlg(Graph graph) {
        this.graph = graph;
    }

    // --------- Methods ----------
    @Override
    public void displayResultingMST(int req) {
        long start = System.nanoTime();
        primMST(req); // Call the merged primMST method
        long end = System.nanoTime();
        long totalTime = end - start;
        System.out.println("Time taken by Prim's Algorithm: " + totalTime + " ns");
    }

    public int getCost() {
        return cost;
    }

    private void primMST(int req) {
        // Initialize the resulting MST
        List<Edge> mst = new ArrayList<>();

        // Initialize the visited set and the min heap
        boolean[] visited = new boolean[graph.vertices.size()];
        MinHeap<Edge> minHeap = new MinHeap<>();

        // Add the first vertex to the visited set and add its edges to the min heap
        Vertex v = graph.vertices.values().iterator().next();
        visited[v.getId()] = true;
        for (Edge e : v.getEdges()) {
            minHeap.insert(e);
        }

        // Iterate until all vertices are visited
        while (!minHeap.isEmpty()) {
            // Get the edge with the minimum weight from the min heap
            Edge e = minHeap.extractMin();
            Vertex source = e.getSource();
            Vertex dest = e.getDest();

            // Check if the dest is already visited
            if (visited[dest.getId()]) {
                continue;
            }

            // Add the edge to the MST and mark the dest as visited
            mst.add(e);
            visited[dest.getId()] = true;

            // Add the dest's edges to the min heap
            for (Edge next : dest.getEdges()) {
                if (!visited[next.getDest().getId()]) {
                    minHeap.insert(next);
                }
            }
        }

        if (req == 1) {
            // Print the resulting MST
            System.out.println("The phone network generated by Prim's algorithm is as follows:\n");
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

class MinHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(T element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    public T extractMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        T min = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        siftDown(0);
        return min;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            siftDown(smallestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
