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
        //Use HashSet to store only one tickets  : Rule 4
        //HashSet<String> registrationticket = new HashSet<>();
            //Initialise the count of egistrationticket to 0
        int registrationticket =0 ;
        for(String registration : myMap.keySet()){
            for(int i=0;i< myMap.get(registration).size();i=i+2){
                if((myMap.get(registration).get(i+1) -myMap.get(registration).get(i)) > 60){
                    registrationticket ++;
                    break;
                }
                if(i+2 < myMap.get(registration).size()){
                    if((myMap.get(registration).get(i+2) - myMap.get(registration).get(i+1)) < 60){
                        registrationticket++;
                        break;
                    }
                }

            }

        }
        return registrationticket;
    }


}

