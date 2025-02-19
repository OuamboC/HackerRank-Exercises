import java.util.*;

public class ParkingTicket {
    public static int ParkingTickets(int numEvents, List<String> registrations, List<Integer> times) {
        // Use HashMap to store each registration and their times(t2 and t1)
        HashMap<String, List<Integer> > myMap = new HashMap<>();
        //Extract each  registration and timestamps of each registration
        for(int i = 0 ; i < numEvents; i++){
            String registration = registrations.get(i);
            int time = times.get(i);
            //Check if myMap contains registration
            if(!myMap.containsKey(registration)){
                //Populate myMap with registration and t2 and t1 of each
                myMap.put(registration,new ArrayList<>());
            }
            myMap.get(registration).add(time);
        }
        System.out.println(myMap.entrySet());
            //return myMap.size();
        //
        /**
         * Loop through myMap to
         * 1.Check for each key if all times given , there is a ticket
         * Conditions of ticket:
         * Rule 1: Parking free for  T0 = 1hours = 60 min
         *  Rule 2 : if a leave after T0 , return may be made at T1 = 3hours =180min
         *  Rule 3 : if return at T1 = 2hours=120min , grant ticket
         *  Rule 4 : Ticket = count(1per day)
         *  Rule 5 : if ((T > 60) || (|T3-T2| <60) -Grant Ticket )
         *  Rule 6: if ((T = 60) || (|T3-T2| = 60) - Do not  Grant Ticket )
         */
        //Create an ArrayList to store  Tickets
        ArrayList<String> ticket = new ArrayList<>();

        for(String registration : myMap.keySet()){
            for(int time : myMap.get(registration)){
                if(time == 60){
                    continue;
                }
                if(time == 120){
                    if(!ticket.contains(registration))
                        ticket.add(registration);
                }
                if(time == 180){
                    continue;
                }
                if(time > 60 || Math.abs(time) < 60){
                    if(!ticket.contains(registration))
                        ticket.add(registration);
                }
                if( Math.abs(time) == 60){
                    break;
                }
            }

        }
        return ticket.size();
    }


}

