import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class keyboardRow {
    public String[] findWords(String[] words) {
        // Create a list to store words which all characters are on the same line
        List<String> result = new ArrayList<>();
        // Use HashMap to store the frequency appearance of a character in a specified row (Integer)
        HashMap<Character,Integer> myMap = new HashMap<>();
        // Populate the HashMap
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        //Convert the string to a char array
        char[] myArray1 = row1.toCharArray();
        char[] myArray2 = row2.toCharArray();
        char[] myArray3 = row3.toCharArray();
        // Loop through each row to store each character in the HashMap
        /**
         * Loop through each row to store each character in the HashMap
         * Step1: Check if the character exist already in the HashMap
         * Step 2 : If not , populate the HashMap by respect the key(Character) and the Value(Integer)
         */
        for(char c : myArray1){
            if(!myMap.containsKey(c))
                myMap.put(c,1);
        }
        for(char c : myArray2){
            if(!myMap.containsKey(c))
                myMap.put(c,2);
        }
        for(char c : myArray3){
            if(!myMap.containsKey(c))
                myMap.put(c,3);
        }

        // Loop through each word to check all characters appears on the same row
        for(String word : words){
            //Initialise rowToCheck to the first row
            /**
             *  Initialise rowToCheck to the first row
             *  As HashMap only store lowercase letters , c and letter might be converted to lowercase
             */
            char c = Character.toLowerCase(word.charAt(0));
            int rowToCheck = myMap.get(c);
            boolean isValid = true;
            for(char letter : word.toLowerCase().toCharArray()){
                int currentRow = myMap.get(letter);
                if(currentRow != rowToCheck){
                    //do not add this string-break
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                result.add(word);
            }
        }
        //Return validate words
        return result.toArray(new String[0]);
    }
}
