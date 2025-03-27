public class CatOrDog {

    public static String CatOrDog(String word) {
        // Convert the word to lowercase to ignore case sensitivity
        word = word.toLowerCase();

        // Initialize counters for the letters D, O, G and C, A, T
        int dogCount = 0;
        int catCount = 0;

        // Iterate through each character in the word
        for (char ch : word.toCharArray()) {
            // Check if the character is 'd', 'o', or 'g' and increment the dogCount
            if (ch == 'd' || ch == 'o' || ch == 'g') {
                dogCount++;
            }
            // Check if the character is 'c', 'a', or 't' and increment the catCount
            if (ch == 'c' || ch == 'a' || ch == 't') {
                catCount++;
            }
        }

        // Determine if the word is a "DOG" word, "CAT" word, or "NEITHER"
        if (dogCount > catCount) {
            return "DOG";
        } else if (catCount > dogCount) {
            return "CAT";
        } else {
            return "NEITHER";
        }
    }

    // Main method for testing (optional)
    public static void main(String[] args) {
        // Test cases
        System.out.println(CatOrDog("dogmatic")); // Expected: DOG
        System.out.println(CatOrDog("catastrophic")); // Expected: CAT
        System.out.println(CatOrDog("elephant")); // Expected: NEITHER
    }
}