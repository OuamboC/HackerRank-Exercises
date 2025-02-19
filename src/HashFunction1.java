public class HashFunction1 {
    public static int HashFunction(String S) {
        //Initialise hash to 0
        long hash = 0;
        //Multiplier constant
        int A = 48271;
        //Large prime number for modulus
        long mod = 2147483647;
        /**
         * Loop through each character in the string
         * For each character :
         *  1. Convert it to its ASCII value.
         *  2. Multiply the previous hash value by A=48271
         * 3. Add the current character’s ASCII value
         *  4. Take modulo M=2147483647 to keep numbers manageable
         * Finally take hash % 256 to get value between 0 and 255
         */
        for (char s : S.toCharArray()){
            //Get the ASCII value of any character
            int value = s;
            //Update the hash value using the formula
            //new_hash  = (previous_hash + ASCII value of character * A) %mod
            hash = (int) (((hash*A +value*A ))%mod);

        }
        //Return the final hash value modulo 256 to fit within 0-255 range
       return (int) (hash%256);
    }
}
