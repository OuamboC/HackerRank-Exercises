public class SnakeToCamelCase {
    public static String SnakeToCamel(String S) {
        //Condition 1 : If  underscores at the beginning og the string , don't change it , (continue)
        //Condition 2 : If number , continue
        //Condition 3 : If not underscore in the string ; return string
        //Condition 4 : If underscore between 2 letters, remove the underscores, capitalise the letter after underscores
        //Condition 5 : If underscore between letter and number ; remove the underscores

        //Get the length of the String
        int stringLength = S.length();
        //Use StringBuilder to construct the new String
        StringBuilder result = new StringBuilder();
        //Looping through the String
        for(int i = 0 ; i < stringLength; i++){
            char c = S.charAt(i);
            //Check if underscore is between a letter or a digit
            if( i > 0 && i < stringLength -1 && Character.isLetterOrDigit(S.charAt(i-1)) && c == '_'
                 && Character.isLetterOrDigit(S.charAt(i+1))){
                //Skip underscore and capitalise the next letter
                if(Character.isLowerCase(S.charAt(i+1))){
                    result.append(Character.toUpperCase(S.charAt(i+1)));
                    i++; // Skip the next character as it has already been capitalised
                }else {
                    result.append(S.charAt(i+1)); // Just append if it is not lowercase
                    i++ ; //Skip the underscore and next character
                }
            }else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
