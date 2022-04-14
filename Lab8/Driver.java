public class Driver {
  public static void main(String[] args) {
      WeightedGraph<String, Integer> weightedGraph = new WeightedGraph<>();
      WeightedGraph<String, Integer> weightedGraph2 = new WeightedGraph<>();
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
      weightedGraph.addEdge("3", "4", 3);
      weightedGraph.addEdge("3", "6", 9);
      weightedGraph.addEdge("4", "5", 6);
      weightedGraph.addEdge("6", "4", 4);
      weightedGraph.addEdge("5", "6", 13);

      weightedGraph2.addVertex("1");
      weightedGraph2.addVertex("2");
      weightedGraph2.addVertex("3");
      weightedGraph2.addVertex("4");
      weightedGraph2.addVertex("5");
      weightedGraph2.addVertex("6");
      weightedGraph2.addEdge("1", "2", 10);
      weightedGraph2.addEdge("1", "3", 15);
      weightedGraph2.addEdge("3", "4", 3);
      weightedGraph2.addEdge("5", "6", 9);
      weightedGraph2.addEdge("4", "5", 6);
      weightedGraph2.addEdge("6", "1", 4);


      System.out.println("Breadth-First Search (2 to 6):");
      weightedGraph.bfs("2", "6");
      System.out.println("Depth-First Search (3 to 5):");
      weightedGraph.dfs("3", "5");

      System.out.println("Kruskal's (Dense Graph):");
      System.out.println(weightedGraph.kruskals());
      System.out.println("Prim's (Dense Graph):");
      System.out.println(weightedGraph.prims());

      System.out.println("Kruskal's (Sparse Graph):");
      System.out.println(weightedGraph.kruskals());
      System.out.println("Prim's (Sparse Graph):");
      System.out.println(weightedGraph2.prims());
    }
}
