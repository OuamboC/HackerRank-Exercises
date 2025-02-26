import java.util.HashMap;

public class MorseCodeEquivalent {
    public static boolean MorseEquivalent(String A, String B) {

        //Store the conversion
        StringBuilder Aconversion = new StringBuilder();
        StringBuilder Bconversion = new StringBuilder();

        // Create an array of letters
        char[] letters = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        // Create a String arrays of morse code
        String[] morseCode = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        //Create a HashMap to Populate make letters key associated with their values
        HashMap<Character, String> mapAlphabet = new HashMap<>();
        for(int i = 0 ; i < letters.length ; i++){
            mapAlphabet.put(letters[i],morseCode[i]);
        }
        //System.out.println(mapAlphabet);
        // Convert And B into Morse code
        // To do so I need to loop through the key of mapAlphabet  and if matches , then convert each char of the  String  to the respective value
        for ( int i = 0 ; i < A.length() ; i ++){
            char c_a = A.charAt(i);
            if(mapAlphabet.containsKey(c_a)){
                Aconversion.append(mapAlphabet.get(c_a));
            }
        }
        //System.out.println(Aconversion);

        for ( int i = 0 ; i < B.length() ; i ++){
            char c_b = B.charAt(i);
            if(mapAlphabet.containsKey(c_b)){
                Bconversion.append(mapAlphabet.get(c_b));
            }
        }
        // System.out.println(Bconversion);

        //Now by removing ,adding and /or moving spaces . I need to return true of they are equivalent otherwise False

        //Step 1 : Remove spaces

//        if (Aconversion.toString().trim().equals(Bconversion.toString().trim())) {
//
//            return true;
//        } else {
//
//            return false;
//        }


        //Step 1: Remove spaces
        boolean isEquivalent = Aconversion.toString().trim().equals(Bconversion.toString().trim());

        // Step 2: Print "TRUE" or "FALSE" based on the comparison
        System.out.println(isEquivalent ? "TRUE" : "FALSE");

        return isEquivalent;
    }
}


