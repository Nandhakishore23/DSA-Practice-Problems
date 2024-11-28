import java.util.*;

class Flight {
    String source;
    String destination;
    int departure;
    int arrival;
    int price;

    public Flight(String source, String destination, String departure, String arrival, int price) {
        this.source = source;
        this.destination = destination;
        this.departure = parseTime(departure);
        this.arrival = parseTime(arrival);
        this.price = price;
    }

    private int parseTime(String timeStr) {
        int hour = Integer.parseInt(timeStr.substring(0, 2));
        int minute = Integer.parseInt(timeStr.substring(3, 5));
        String meridian = timeStr.substring(5).trim();
        if (meridian.equals("Am") && hour == 12) {
            hour = 0;
        } else if (meridian.equals("Pm") && hour != 12) {
            hour += 12;
        }
        return hour * 60 + minute;
    }
}

public class FlightFinder {
    public static void findCheapestFlight() {
        Scanner scanner = new Scanner(System.in);
        int numFlights = Integer.parseInt(scanner.nextLine());
        List<Flight> flights = new ArrayList<>();
        Map<String, List<Flight>> flightMap = new HashMap<>();

        for (int i = 0; i < numFlights; i++) {
            String[] input = scanner.nextLine().split(" ");
            String source = input[0];
            String dest = input[1];
            String departure = input[2];
            String arrival = input[3];
            int price = Integer.parseInt(input[4]);
            Flight flight = new Flight(source, dest, departure, arrival, price);
            flights.add(flight);
            flightMap.putIfAbsent(source, new ArrayList<>());
            flightMap.get(source).add(flight);
        }

        String[] startEnd = scanner.nextLine().split(" ");
        String start = startEnd[0];
        String end = startEnd[1];
        String[] timeLimits = scanner.nextLine().split(" ");
        int earliestDeparture = new Flight("", "", timeLimits[0], "", 0).parseTime(timeLimits[0]);
        int latestArrival = new Flight("", "", timeLimits[1], "", 0).parseTime(timeLimits[1]);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (Flight flight : flightMap.getOrDefault(start, new ArrayList<>())) {
            if (flight.departure >= earliestDeparture && flight.arrival <= latestArrival) {
                queue.offer(new int[]{flight.price, flight.arrival, flight.destination.hashCode()});
            }
        }

        Map<String, Integer> minCost = new HashMap<>();
        Map<String, Integer> arrivalTime = new HashMap<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cost = current[0];
            int currentArrival = current[1];
            String city = String.valueOf(current[2]);

            if (minCost.containsKey(city) && (cost > minCost.get(city) || (cost == minCost.get(city) && currentArrival >= arrivalTime.get(city)))) {
                continue;
            }
            minCost.put(city, cost);
            arrivalTime.put(city, currentArrival);

            if (city.equals(end.hashCode())) {
                System.out.println(cost);
                return;
            }

            for (Flight flight : flightMap.getOrDefault(city, new ArrayList<>())) {
                if (flight.departure >= currentArrival && flight.departure >= earliestDeparture && flight.arrival <= latestArrival) {
                    queue.offer(new int[]{cost + flight.price, flight.arrival, flight.destination.hashCode()});
                }
            }
        }
        System.out.println("Impossible");
    }

    public static void main(String[] args) {
        findCheapestFlight();
    }
}

