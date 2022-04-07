public class Driver {
  public static void main(String[] args) {
      WeightedGraph<String, Integer> weightedGraph = new WeightedGraph<>();
      weightedGraph.addVertex("1");
      weightedGraph.addVertex("2");
      weightedGraph.addVertex("3");
      weightedGraph.addVertex("4");
      weightedGraph.addVertex("5");
      weightedGraph.addVertex("6");
      weightedGraph.addEdge("1", "2", 10);
      weightedGraph.addEdge("1", "3", 15);
      weightedGraph.addEdge("1", "6", 5);
      weightedGraph.addEdge("2", "3", 7);
      weightedGraph.addEdge("3", "4", 7);
      weightedGraph.addEdge("3", "6", 10);
      weightedGraph.addEdge("4", "5", 7);
      weightedGraph.addEdge("6", "4", 5);
      weightedGraph.addEdge("5", "6", 13);
      System.out.println("Breadth-First Search (2 to 6):");
      weightedGraph.bfs("2", "6");
      System.out.println("Depth-First Search (3 to 5):");
      weightedGraph.dfs("3", "5");
    }
}
