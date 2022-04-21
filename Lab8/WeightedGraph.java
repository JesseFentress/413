import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.HashSet;

public class WeightedGraph<T, V extends Comparable<V>> {

    HashMap<T, Vertex> vertices = new HashMap<>();
    HashSet<Vertex> verticesInMSTPrims = new HashSet<>();

    protected void addVertex(T vertex) {
        if (!vertices.containsKey(vertex)) {
            vertices.put(vertex, new Vertex(vertex));
        }
    }

    protected void addEdge(T vertex1, T vertex2, V weight) {
        if (!vertices.containsKey(vertex1)) {
            vertices.put(vertex1, new Vertex(vertex2));
        }
        if (!vertices.containsKey(vertex2)) {
            vertices.put(vertex2, new Vertex(vertex2));
        }
        vertices.get(vertex1).addAdjacentVertex(vertices.get(vertex2), weight);
    }

    protected List<Vertex> bfs(T start, T end) {
        if (start.equals(end)) { 
            return new ArrayList<Vertex>(Arrays.asList(vertices.get(start))); 
        }
        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        ArrayList<Vertex> queue = new ArrayList<>();
        visitedVertices.add(vertices.get(start));
        queue.add(vertices.get(start));
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove(0);
            for (Vertex adjacentVertex: currentVertex.getAdjacentVertices().keySet()) {
                if (adjacentVertex.equals(vertices.get(end))) {
                    visitedVertices.add(adjacentVertex);
                    return visitedVertices;
                }
                if (!visitedVertices.contains(adjacentVertex)) {
                    queue.add(adjacentVertex);
                    visitedVertices.add(adjacentVertex);
                }
            }
        }
        return null;
    }

    protected List<Vertex> dfs(T start, T end) {
        if (start.equals(end)) {
            return new ArrayList<Vertex>(Arrays.asList(vertices.get(start)));
        }
        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        Stack<Vertex> stack = new Stack<>();
        visitedVertices.add(vertices.get(start));
        stack.push(vertices.get(start));
        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();
            if (!visitedVertices.contains(currentVertex)) {
                visitedVertices.add(currentVertex);
            }
            if (currentVertex.equals(vertices.get(end))) {
                return visitedVertices;
            }
            for (Vertex adjacentVertex: currentVertex.getAdjacentVertices().keySet()) {
                if (!visitedVertices.contains(adjacentVertex)) {
                    stack.push(adjacentVertex);
                }
            }
        }
        return null;
    }

    protected List<Edge> kruskals() {
        List<Edge> edges = new ArrayList<>();
        for (T vertexKey: vertices.keySet()) {
            Vertex currentVertex = vertices.get(vertexKey);
            for (Vertex adjacentVertex: currentVertex.getAdjacentVertices().keySet()) {
                edges.add(new Edge(currentVertex, adjacentVertex, currentVertex.getWeight(adjacentVertex)));
            }
        }
        quickSort(edges, 0, edges.size() - 1);
        HashSet<T> verticesInMST = new HashSet<>();
        List<Edge> mst = new ArrayList<>();
        while (verticesInMST.size() < vertices.size()) {
            for (Edge currentEdge: edges) {
                if (!verticesInMST.contains(currentEdge.getSourceVertex().getID()) || 
                    !verticesInMST.contains(currentEdge.getDestinationVertex().getID())) {
                        verticesInMST.add(currentEdge.getSourceVertex().getID());
                        verticesInMST.add(currentEdge.getDestinationVertex().getID());
                        mst.add(currentEdge);
                }
            }
        }
        for (Edge e: mst) {
            System.out.println(e.getWeight());
        }
        return mst;     
    }

    protected int partition(List<Edge> arr, int low, int high) {
        int index = low - 1;
        for (int i = low; i < high; i++) {
            if (arr.get(i).getWeight().compareTo(arr.get(high).getWeight()) < 0) {
                index++;
                Edge temp = arr.get(i);
                arr.set(i, arr.get(index));
                arr.set(index, temp);
            }
        }
        Edge temp = arr.get(high);
        arr.set(high, arr.get(index + 1));
        arr.set(index + 1, temp);
        return index + 1;
    }


    protected void quickSort(List<Edge> arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    protected List<Edge> prims() {
        List<Edge> mst = new ArrayList<>();
        verticesInMSTPrims.add(vertices.get(vertices.keySet().toArray()[0]));
        while (verticesInMSTPrims.size() < vertices.size()) {
            Edge minEdge = minimumEdge();
            mst.add(minEdge);
        }
        for (Edge e: mst) {
            System.out.println(e.getWeight());
        }
        return mst;
    }

    protected Edge minimumEdge() {  
        Edge minEdge = null;
        for (Vertex vertex: verticesInMSTPrims) {
            for (Vertex adjacentVertex: vertex.getAdjacentVertices().keySet()) {
                if ((minEdge == null) && (!verticesInMSTPrims.contains(vertex) || !verticesInMSTPrims.contains(adjacentVertex))) {
                    minEdge = new Edge(vertex, adjacentVertex, vertex.getWeight((adjacentVertex)));
                }
                if (minEdge != null && ((vertex.getWeight(adjacentVertex).compareTo(minEdge.getWeight()) < 0) &&
                    (!verticesInMSTPrims.contains(vertex) || !verticesInMSTPrims.contains(adjacentVertex)))) {
                    minEdge = new Edge(vertex, adjacentVertex, vertex.getWeight(adjacentVertex));
                }
            }
        }
        verticesInMSTPrims.add(minEdge.getSourceVertex());
        verticesInMSTPrims.add(minEdge.getDestinationVertex());
        return minEdge;
    }

    protected HashMap<Vertex, Integer> dijkstra(T start, T end) {
        HashMap<Vertex, Integer> unvisited = new HashMap<>();
        HashMap<Vertex, Integer> visited = new HashMap<>();
        for (T vertexKey: vertices.keySet()) {
            unvisited.put(vertices.get(vertexKey), Integer.MAX_VALUE / 2);
        }
        Vertex currentVertex = vertices.get(start);
        int current_distance = 0;
        unvisited.put(currentVertex, current_distance);
        while (true) {
            for (Vertex adjacentVertex: currentVertex.getAdjacentVertices().keySet()) {
                if (!unvisited.containsKey(adjacentVertex)) {
                    continue;
                }
                int new_distance = current_distance + (Integer)currentVertex.getWeight(adjacentVertex); //update
                if (!unvisited.containsKey(adjacentVertex) || unvisited.get(adjacentVertex) > new_distance) {
                    unvisited.put(adjacentVertex, new_distance);
                }
            }
            visited.put(currentVertex, current_distance);
            unvisited.remove(currentVertex);
            if (unvisited.isEmpty()) {
                break;
            }
            if (visited.containsKey(vertices.get(end))) {
                return visited;
            }
        } 
        return visited;
    }

     protected class Edge {
        private Vertex sourceVertex;
        private Vertex destinationVertex;
        private V weight;

        Edge(Vertex sourceVertex, Vertex destinationVertex, V weight) {
            this.sourceVertex = sourceVertex;
            this.destinationVertex = destinationVertex;
            this.weight = weight;
        }

        protected V getWeight() {
            return this.weight;
        }

        protected String[] getVertexPair() {
            return new String[] {sourceVertex.getID().toString() + destinationVertex.getID().toString(), 
                                destinationVertex.getID().toString() + sourceVertex.getID().toString()};
        }

        protected Vertex getSourceVertex() {
            return this.sourceVertex;
        }

        protected Vertex getDestinationVertex() {
            return this.destinationVertex;
        }
    }
    protected class Vertex {
        private T id;
        private HashMap<Vertex, V> adjacentVertices;
    
        Vertex(T id) {
            this.id = id;
            this.adjacentVertices = new HashMap<>();
        }

        public T getID() { return this.id; }
    
        protected void addAdjacentVertex(Vertex vertex, V weight) {
            if (!adjacentVertices.containsKey(vertex)) {
                adjacentVertices.put(vertex, weight);
            }
        }

        protected HashMap<Vertex, V> getAdjacentVertices() {
            return this.adjacentVertices;
        }

        protected V getWeight(Vertex vertex) {
            return adjacentVertices.get(vertex);
        }
    }
}
