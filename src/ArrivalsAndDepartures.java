import java.util.*;

public class ArrivalsAndDepartures {
    public static int MaxConcurrent(int n, List<List<Integer>> timesAndIDs) {
        //Step 1 : Leverage HashMap to store  the ids with their arrivals and departures
        // Then populate the created HashMap
        HashMap<Integer, List<Integer>> entitiesRecords = new HashMap<>();
        for (List<Integer> entity : timesAndIDs) {
            int time = entity.get(0);
            int id = entity.get(1);
            //Add the list to entitiesRecords
            if (!entitiesRecords.containsKey(id)) {
                //Create a list for Ids
                entitiesRecords.put(id, new ArrayList<>());
            }
            //Add time to entitiesRecords
            entitiesRecords.get(id).add(time);
        }

        // Step 2 : Create a list to store timestamp , eventType=arrival/departure and id
        List<int[]> trackingEvents = new ArrayList<>();

        //Step 3 : Loop through the created HashMap to the compare the key (ids ) and values (arrival and departures) to find the lowest and  the highest value
        // If the lowest  set it to arrival and if the highest set it to departures
        List<Integer> timestamps = null;
        for (Integer id : entitiesRecords.keySet()) {
            timestamps = entitiesRecords.get(id);
            // Ensure there are exactly two timestamps for each id
            if (timestamps.size() == 2) {
                //Sort the timestamps
                Collections.sort(timestamps);

                //Lowest  timestamp is arrival
                int arrival = timestamps.get(0);
                //Highest timestamp is departure
                int departure = timestamps.get(1);

                //Populate trackingEvent list
                // Assume that the arrival is 1 : meaning that in case of arrival increase the  tracking event  by 1
                //Assume that the departure is -1 : meaning that in case of departure decrease the  tracking event  by 1
                trackingEvents.add(new int[]{arrival, 1, id});
                trackingEvents.add(new int[]{departure, -1, id});
            }

        }

        //Step 4 : sort trackingEvent by timestamps
//        TreeSet<int[]> sortingTimestamps = new TreeSet<>();
//        for(int[] timestamp : trackingEvents){
//            sortingTimestamps.add(timestamp);
//
//        }
        // Step 4: Use TreeMap to sort events by timestamp
        TreeMap<Integer, List<int[]>> sortedTimestamps = new TreeMap<>();
        for (int[] event : trackingEvents) {
            int timestamp = event[0];
            if (!sortedTimestamps.containsKey(timestamp)) {
                sortedTimestamps.put(timestamp, new ArrayList<>());
            }
            sortedTimestamps.get(timestamp).add(event);
        }

        // Clear the original list and repopulate with sorted events
        trackingEvents.clear();
        for (Map.Entry<Integer, List<int[]>> entry : sortedTimestamps.entrySet()) {
            trackingEvents.addAll(entry.getValue());
        }

        // Step 5: loop through the sorted events in timestamp order
        // Loop all events at each timestamp
        // Calculate timeDifference , update current occupancy , and there update max occupancy if cuurrent is greater
        // Initialise the currentOccupancy to 0
        int currentOccupancy = 0 ;
        //Initialise the maxOccupancy to 0
        int maxOccupancy = 0 ;
        //Initialise the current timestamps to 0
        int i = 0 ;
        //Loop all events at each timestamp
        while(i < trackingEvents.size()){
            int currentTime = trackingEvents.get(i)[0];
            int timeDifference = 0;
            while(i < trackingEvents.size() && trackingEvents.get(i)[0] == currentTime){
                // Add the event type ( arrival/departure)
                timeDifference += trackingEvents.get(i)[1];
                i++;
            }
            //Update currentOccupancy
            currentOccupancy += timeDifference;
            //Update max occupancy if currentOccupancy is greater
            maxOccupancy = Math.max(maxOccupancy, currentOccupancy);
        }


        return maxOccupancy;
    }

    public static void main(String[] args) {
        List<List<Integer>> timesAndIDs = new ArrayList<>();
        int n = 10;
        // Parse the input into timesAndIDs
        int[] sampleZero = {
                5, 11209,
                6, 59752,
                8, 11209,
                13, 39712,
                19, 39013,
                4, 39013,
                3, 66310,
                11, 39712,
                17, 59752,
                14, 66310
        };
        for (int i = 0; i < sampleZero.length; i += 2) {
            List<Integer> entry = new ArrayList<>();
            entry.add(sampleZero[i]);     // Time
            entry.add(sampleZero[i + 1]); // ID
            timesAndIDs.add(entry);
        }
        //Call MaxOccurent
        int result = MaxConcurrent(n, timesAndIDs);
        System.out.println(result);

    }
}
