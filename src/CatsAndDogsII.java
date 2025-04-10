public class CatsAndDogsII {
    public static String CatOrDog2(String word){
        // Step1: Convert the word to lowercase to ignore case sensitivity
        word = word.toLowerCase();
        // Step 1: Initialise both the maxCatLength and currentCatLength to
        // 0 to easily track the maximum sequence ( Do same for dogs)
        int maxCatLength = 0 ;
        int currentCatLength = 0 ;

        int maxDogLength = 0;
        int currentDogLength = 0;


        // Step 3:Iterate through each character in the word
        for (char ch : word.toCharArray()) {
            // Check if the character is 'd', 'o', or 'g' and increment the dogCount
            if (ch == 'd' || ch == 'o' || ch == 'g') {
                currentDogLength++;
                maxDogLength = Math.max(maxDogLength, currentDogLength);
                //Then restart the Cat counter
                currentCatLength =0;
            }else if (ch == 'c' || ch == 'a' || ch == 't'){
                currentCatLength++;
                maxCatLength = Math.max(maxCatLength, currentCatLength);
                //Thne restart the Dog counter
                currentDogLength = 0;
            }else{
                currentCatLength = 0;
                currentDogLength = 0;

            }
        }

        // Determine if the word is a "DOG" word, "CAT" word, or "NEITHER"
        if (maxDogLength  > maxCatLength) {
            return "DOG";
        } else if (maxCatLength > maxDogLength) {
            return "CAT";
        } else {
            return "NEITHER";
        }
    }
    // Main method for testing (optional)
    public static void main(String[] args) {
        // Test cases
        System.out.println(CatOrDog2("obtain")); // Expected: CAT
        System.out.println(CatOrDog2("suggestion")); // Expected: DOG
        System.out.println(CatOrDog2("german")); // Expected: NEITHER
        System.out.println(CatOrDog2("flOOriNg")); // Expected: DOG
        System.out.println(CatOrDog2("mighty")); // Expected: NEITHER
    }
}
