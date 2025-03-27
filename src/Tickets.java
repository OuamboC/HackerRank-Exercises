import java.util.*;
public class Tickets {



        public static int Tickets(int nLines, List<String> data) {
            // HashMap to store registration numbers and their timestamps
            HashMap<String, List<Integer>> carTimestamps = new HashMap<>();

            // Parse the input data
            for (String entry : data) {
                // Split the entry into parts
                String[] parts = entry.split(" ");
                String reg = parts[0]; // Registration number
                int hour = Integer.parseInt(parts[1]); // Hours
                int minute = Integer.parseInt(parts[2]); // Minutes
                int second = Integer.parseInt(parts[3]); // Seconds

                // Convert the timestamp to total seconds
                int totalSeconds = hour * 3600 + minute * 60 + second;

                // Add the timestamp to the HashMap
                if (!carTimestamps.containsKey(reg)) {
                    carTimestamps.put(reg, new ArrayList<>());
                }
                carTimestamps.get(reg).add(totalSeconds);
            }

            // Initialize the ticket count
            int ticketCount = 0;

            // Calculate the average speed for each car
            for (String reg : carTimestamps.keySet()) {
                List<Integer> timestamps = carTimestamps.get(reg);
                // Ensure there are exactly two timestamps for each car
                if (timestamps.size() == 2) {
                    int time1 = timestamps.get(0);
                    int time2 = timestamps.get(1);

                    // Calculate the time difference in seconds
                    int timeDifference = Math.abs(time2 - time1);

                    // Convert time difference to hours
                    double timeInHours = timeDifference / 3600.0;

                    // Calculate the average speed (distance = 0.5 miles)
                    double speed = 0.5 / timeInHours;

                    // Check if the speed is 55 mph or more
                    if (speed >= 55) {
                        ticketCount++;
                    }
                }
            }
            return ticketCount;
        }

        // Main method for testing
        public static void main(String[] args) {
            // Test case
            List<String> data = Arrays.asList(
                    "ABC123 1 0 0", // First camera
                    "XYZ456 1 0 0", // First camera
                    "ABC123 1 1 0", // Second camera (1 minute later)
                    "XYZ456 1 2 0"  // Second camera (2 minutes later)
            );

            int nLines = data.size();
            System.out.println(Tickets(nLines, data)); // Expected output: 1
        }
    
}
