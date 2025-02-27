import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayfairCodeSquare {
    public static String PlayfairCode(String plainText, String codePhrase) {
        //Step 1 : Create an ArrayList to store unique character of codePhrase ( in order, as HashSet couldn't do it )
        List<Character> myCodePhrase = new ArrayList<>();
        //Loop through codePhrase to populate myCodePhrase Arraylist
        for(char s : codePhrase.toCharArray()){
            // Capitalise each character of the codePhrase if not already
            char capitaliseCharacter = Character.toUpperCase(s);
            if (capitaliseCharacter == 'J'){
                capitaliseCharacter = 'I'; // Convert 'J' to 'I'
            }
            // Check if teh character it's letter and if not already in the list
            if(Character.isLetter(capitaliseCharacter) && !myCodePhrase.contains(capitaliseCharacter)){
                 myCodePhrase.add(capitaliseCharacter);// populate myCodePhrase Arraylist
            }
        }
        //System.out.println(myCodePhrase);
        //Step 2 :Create a grid of size 5*5
        char [][] gridCodePhrase = new char[5][5];
        //Step 3: Populate the grid
        int count = 0 ;       //Initialise the count to 0 to track moves in the grid
        for (char c : myCodePhrase){  //Loop through myCodePhrase Arraylist
            //Compute row and columns
            int row = count /5 ;
            int col = count % 5;
            gridCodePhrase[row][col] = c;
            count++;
        }
//        for (char[] rowArray : gridCodePhrase){
//            System.out.println( rowArray);
//        }

        //Step 4: Focus on plainText
        plainText =  plainText.trim(); // Removes leading and trailing spaces
        plainText = plainText.replace('J', 'I');
        //Use StringBuilder to  convert to uppercase and remove spaces
        StringBuilder plainTextConversion = new StringBuilder();
        for(char c : plainText.toCharArray()){
            char capitaliseCharacter = Character.toUpperCase(c);
            if(!Character.isWhitespace(capitaliseCharacter)){
              plainTextConversion.append(capitaliseCharacter);
            }
        }
        //Store the conversion back in plainText
        plainText = plainTextConversion.toString();
        //System.out.println(plainText);
        //Step 5 : Check if consecutive letter , insert 'X' before the second redundancy
        //Use StringBuilder for new Modified
        StringBuilder removeLetterRedundancyPlainText = new StringBuilder();
        for(int i = 0 ; i < plainText.length(); i++){
            char c = plainText.charAt(i);
            removeLetterRedundancyPlainText.append(c);

            //Check if next character exists and is the same as current character
            if( i < plainText.length() - 1  && c == plainText.charAt(i+1)){
                removeLetterRedundancyPlainText.append('X'); // insert 'X' before the second redundancy
            }
        }
        plainText = removeLetterRedundancyPlainText.toString();
        System.out.println(plainText);

        //Step 6 :  Now , let's split the plaintext by 2 pairs of charcters to be able to encrypted message
        // Create another arrayLists to form pairs
        List<String> cipherPairs = new ArrayList<>();
        // Check if plaintext has an even length by appending 'X' is necessary
        if(plainText.length() %2 != 0){
            plainText += "X";
        }
        //Loop through the plaintext , to take  2 characters each time
        for(int i = 0 ; i < plainText.length(); i=i+2) {
            String couples = "" + plainText.charAt(i) + plainText.charAt(i +1);
            cipherPairs.add(couples);
        }
        //System.out.println(cipherPairs);

        // Step 7: Add remaining letters into the grid
        char[] letters = "ABCDEFGHIKLMNOPQRSTUVWXYZ".toCharArray();
        for (char letter : letters) {
            if (!myCodePhrase.contains(letter)) {
                int row = count / 5;
                int col = count % 5;
                gridCodePhrase[row][col] = letter;
                count++;
            }
        }
        for (char[] rowArray : gridCodePhrase){
           System.out.println( rowArray);
       }

        //Step  8: Focus on grid  ny applying  Playfair-Cipher
        // if shape : Rectangle , Rules : same rows , opposite ccorners ,
        //if shape : Column , Rules : Pick items below each letter , wrap to top if needed
        //if shape : Row ; Rules : Pick items to right of each letter , wrap to left  if needed
        // return all pairs forms together with no spaces
        StringBuilder cipherText = new StringBuilder();
        for (String pair : cipherPairs) {
            char first = pair.charAt(0);
            char second = pair.charAt(1);

            int row1 = -1;
            int col1 = -1;
            int row2 = -1;
            int col2 = -1;

            // Find positions of couples characters in the grid
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (gridCodePhrase[row][col] == first) {
                        row1 = row;
                        col1 = col;
                    }
                    if (gridCodePhrase[row][col] == second) {
                        row2 = row;
                        col2 = col;
                    }
                }
            }

            // Apply Playfair-Cipher Rules
            if (row1 == row2) { // Same row SO shift right
                cipherText.append(gridCodePhrase[row1][(col1 + 1) % 5]);
                cipherText.append(gridCodePhrase[row2][(col2 + 1) % 5]);
            } else if (col1 == col2) { //Same column S0 shift down
                cipherText.append(gridCodePhrase[(row1 + 1) % 5][col1]);
                cipherText.append(gridCodePhrase[(row2 + 1) % 5][col2]);
            } else { //Rectangle swap
                cipherText.append(gridCodePhrase[row1][col2]);
                cipherText.append(gridCodePhrase[row2][col1]);
            }
        }

        return cipherText.toString();

    }
}
