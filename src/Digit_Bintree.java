public class Digit_Bintree {
    public static int DigitBintree(String S) {
         // General to follow for left, left-left , left right and right partitions
        //Convert   each character to integer
        // then return max val and min val
        // when finding max and min val Make the difference : range = max_val - min_ val
        // then if range > 1 split into to halves or [ For right partitions]  if range < = 1 , No split
        // Base case : If S.length is 1 , it's a valid partition
        if(S.length() == 1){
            return 1;
        }

        // Step 1 :  Find max and min digits in the current partition
        // Initialise min to the highest possible amd max to the lowest possible
        int min = 9; //
        int max = 0;
        for(int i = 0 ; i < S.length(); i++){
            //Convert   each character to integer
            int digit =  S.charAt(i) - '0';
            if(digit < min) min = digit;
            if(digit > max) max = digit;
        }
        //Step2 : Calculate the range
        int range = max - min;
        //Step 3 : Check if Splitting or not
        if( range <= 1){
            return 1; // No split  (therefore count as 1 partition)
        }else {
            //Split into two halves
            int mid = S.length() /2;
            String left = S.substring(0,mid);
            String right = S.substring(mid);
            // Recursively count partitions in  both halves
            return DigitBintree(left) + DigitBintree(right);
        }
    }

    public static void main(String[] args) {
        String test1 = "11112222";
        String test2 = "12123434";
        String test3 = "64444444";
        String test4 = "39448397237498577467837728357822";
        String test = "24354554";

        System.out.println("Total Partitions case0: " + DigitBintree(test));
        System.out.println("Total Partitions case1: " + DigitBintree(test1));
        System.out.println("Total Partitions case2: " + DigitBintree(test2));
        System.out.println("Total Partitions case3: " + DigitBintree(test3));
        System.out.println("Total Partitions case4: " + DigitBintree(test4));

    }
}
