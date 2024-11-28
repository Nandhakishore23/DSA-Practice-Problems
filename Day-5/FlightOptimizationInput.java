import java.util.*;

public class FlightOptimizationInput {
    public static int 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of flights: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter flight details (from to take-off landing cost):");
        List<String> flights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String flightDetails = sc.nextLine();
            flights.add(flightDetails);
        }
        System.out.println("Enter travel details (startCity endCity preferredStartTime preferredEndTime):");
        String travelDetails = sc.nextLine();
        sc.close();
    }
}
