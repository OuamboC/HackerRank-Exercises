public class PowersOfTree {
    public static String IsPowerThree(long x) {
        //Powers of three :Divisible by 3 -> Return "YES" ( e.g27, 24, 21, 18, 15, 12,9,6,3):
        //Otherwise if  ( result not integer such as 10/3 = 3.33) return "NO"
        //Check if a power of three ( the same number must be divisble multiple times until it reach 1)
         if ( x <= 0){
             return "NO";
         }
         while(x %3 == 0){
             x /=3;
         }
         if (x==1){
             return "YES";
         }else{
             return "NO";
         }

    }

    public static void main(String[] args) {
        System.out.println( "case 1: " + PowersOfTree.IsPowerThree(81));
        System.out.println( "case 2: " + PowersOfTree.IsPowerThree(705));
        System.out.println( "case 3: " + PowersOfTree.IsPowerThree(531441));
       // System.out.println( "case 4" + PowersOfTree.IsPowerThree(282429536481));

    }
}
