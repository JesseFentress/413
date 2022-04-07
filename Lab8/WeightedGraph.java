import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class WeightedGraph<T, V extends Comparable<V>> {

    HashMap<T, Vertex> vertices = new HashMap<>();

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
            return this. adjacentVertices;
        }
    }
}
