import java.util.Random;

public class FinalLablDriver {
    public static void main(String[] args) {
        WeightedGraph<String, Integer> wg = new WeightedGraph<>();

        String[] flights = {"Philadelphia", "Dallas", "Austin", "Los Angeles", "Los Vegas", "Salt Lake City", "Nashville",
                            "Memphis", "Chicago", "Detroit", "Boston", "Miami", "Orlando", "Phoenix", "Minneapolis", "New Orleans",
                            "New York", "Buffalo", "San Francisco", "Newark", "Denver", "Seattle", "Portland", "Honolulu", "Santa Fey" };

        Random random = new Random();

        for (String flight: flights) {
            wg.addVertex(flight);
        }

        for (String flight: flights) {
            int numberOfFlights = random.nextInt(flights.length - 4);
            for (int i = 0; i <= numberOfFlights; i++) {
                String destination = flights[random.nextInt(flights.length)];
                if (!destination.equals(flight)) {
                    wg.addEdge(flight, destination, random.nextInt(100) *  10);
                }
            }
        }

        System.out.println("########################");
        System.out.println("# Dijkstra's Algoirthm #");
        System.out.println("########################");
        wg.dijkstra("Philadelphia", "Los Vegas");

        System.out.println("############################");
        System.out.println("# Floyd Warshall Algorithm #");
        System.out.println("############################");
        wg.floydWarshall("Philadelphia", "Los Vegas");
        
        
    }


}
