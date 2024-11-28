import java.util.*;

class FlightOptimization {
    static class Flight {
        String from, to;
        int takeOff, landing, cost;

        Flight(String from, String to, int takeOff, int landing, int cost) {
            this.from = from;
            this.to = to;
            this.takeOff = takeOff;
            this.landing = landing;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of flights
        System.out.print("Enter the number of flights: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Flight> flights = new ArrayList<>();

        // Input flight details
        System.out.println("Enter flight details (from to take-off landing cost):");
        for (int i = 0; i < n; i++) {
            String[] flightDetails = sc.nextLine().split(" ");
            flights.add(new Flight(
                flightDetails[0],
                flightDetails[1],
                parseTime(flightDetails[2]),
                parseTime(flightDetails[3]),
                Integer.parseInt(flightDetails[4])
            ));
        }

        // Input travel details
        System.out.println("Enter travel details (startCity endCity preferredStartTime preferredEndTime):");
        String[] travelDetails = sc.nextLine().split(" ");
        String startCity = travelDetails[0];
        String endCity = travelDetails[1];
        int preferredStart = parseTime(travelDetails[2]);
        int preferredEnd = parseTime(travelDetails[3]);

        // Find the minimum cost
        int result = findMinimumCost(flights, startCity, endCity, preferredStart, preferredEnd);
        if (result == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(result);
        }
    }

    private static int parseTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}(Am|Pm)")) {
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
        boolean isPm = time.endsWith("Pm");
        String[] parts = time.substring(0, time.length() - 2).split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        if (isPm && hours != 12) hours += 12;
        if (!isPm && hours == 12) hours = 0;

        return hours * 60 + minutes;
    }

    private static int findMinimumCost(List<Flight> flights, String startCity, String endCity, int preferredStart, int preferredEnd) {
        // Build the graph
        Map<String, List<Flight>> graph = new HashMap<>();
        for (Flight flight : flights) {
            graph.computeIfAbsent(flight.from, k -> new ArrayList<>()).add(flight);
        }

        // PriorityQueue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // {currentCity, cost, time}
        pq.offer(new int[]{0, 0, preferredStart}); // Initial state: {currentCity, cost, time}

        Map<String, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            String currentCity = current[0];
            int currentCost = current[1];
            int currentTime = current[2];

            // If we reach the destination
            if (currentCity.equals(endCity)) {
                return currentCost;
            }

            // If this city was visited before with an earlier time, skip it
            if (visited.containsKey(currentCity) && visited.get(currentCity) <= currentTime) {
                continue;
            }

            // Mark this city as visited with the current time
            visited.put(currentCity, currentTime);

            // Explore all outgoing flights from the current city
            if (graph.containsKey(currentCity)) {
                for (Flight flight : graph.get(currentCity)) {
                    // Check if the flight respects the time constraints
                    if (flight.takeOff >= currentTime && flight.landing <= preferredEnd) {
                        pq.offer(new int[]{flight.to, currentCost + flight.cost, flight.landing});
                    }
                }
            }
        }

        // If no path to the destination was found
        return Integer.MAX_VALUE;
    }
}
	