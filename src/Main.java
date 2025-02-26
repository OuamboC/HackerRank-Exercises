import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        keyboardRow test = new keyboardRow();
        String[] words = { "Dad", "Alaska", "The", "MyNames " };
        String[] result = test.findWords(words);

        for(String word : result){
            System.out.println(word);
        }

        MajorityElementII testing = new MajorityElementII();

        int[] nums1 = {3,2,3};
        List<Integer> answer1 = testing.majorityElement(nums1);
        System.out.println(answer1);

        int[] nums2 = {1};
        List<Integer> answer2 = testing.majorityElement(nums2);
        System.out.println(answer2);

        int[] nums3 = {1,2};
        List<Integer> answer3 = testing.majorityElement(nums3);
        System.out.println(answer3);

      CountUniqueHashSet testingSol = new CountUniqueHashSet();
      List<Integer> values1 = Arrays.asList(4,5,7,5,5);
        System.out.println(testingSol.UniquePairs(values1.size(), values1));

        HashFunction1 tests = new HashFunction1();
        String example = "Hello, world";
        String example2 = "Friends, Romans, countrymen, lend me your ears; I come to bury Caesar, not to praise him.The evil that men do lives after them; The good is oft interred with their bones; So let it be with Caesar. The noble Brutus Hath told you Caesar was ambitious : If it were so, it was a grievous fault, And grievously hath Caesar answer'd it.";
        String example3 = "Habcdefghijklmnop";
        System.out.println(tests.HashFunction(example));
        System.out.println(tests.HashFunction(example2));
        System.out.println(tests.HashFunction(example3));

        ParkingTicket parkingTickets = new ParkingTicket();
        List<String> registrations = List.of("ABQ","CWS","HGDUUD","ABQ","CWS","HGDUUD");
        List<Integer> times = List.of(20,30,30,40,90,101);
        System.out.println(parkingTickets.ParkingTickets(6,registrations,times));

        SnakeToCamelCase snakeToCamelCase = new SnakeToCamelCase ();
        System.out.println(SnakeToCamelCase.SnakeToCamel("var_name_1"));

        System.out.println(SnakeToCamelCase.SnakeToCamel("__var_name_1"));

        System.out.println(SnakeToCamelCase.SnakeToCamel("var"));


        System.out.println(MorseCodeEquivalent .MorseEquivalent("abc","wske"));
        System.out.println(MorseCodeEquivalent.MorseEquivalent("abcdefg", "tesaetdmneaae"));
        System.out.println(MorseCodeEquivalent.MorseEquivalent("helloworld", "ihdrwntotenetfe"));
        System.out.println(MorseCodeEquivalent.MorseEquivalent("eeeee", "see"));
        System.out.println(MorseCodeEquivalent.MorseEquivalent("ttttt", "ao"));

    }

}