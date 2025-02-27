import java.util.ArrayList;
import java.util.List;

public class TakingSteps {
    public static int TakeSteps(int nArray, int nSteps, List<String> grid) {
        // Write your code here
        // nArray: Size of the grid
        // nSteps : number of steps
        // grid  list of strings  representing the grid

        // Step 1 : Convert each strings into a 2D grid
        char [][] arrows = new char[nArray][nArray];
        //Step 2 : Loop through each row in the grid  each arrow into a character
        for(int i = 0 ; i < nArray; i++) {
            //Convert each row to a char array and store it in the grid
            arrows[i] = grid.get(i).toCharArray();
            //System.out.println(arrows[i]);
        }
        //Step 3
        //Initialise  y ( y - coordinates ) and cell ( x - coordinates )
        //So moves start at y = 0 and x = 0

        int y = 0 ;
        int x = 0 ;
        for ( int i = 0 ; i < nSteps ; i ++){
            //Get the current move arrow
            char currentMove = arrows[y][x];
            //Move based on the direction of arrow
            if(currentMove == '>'){
                //x takes the  coordinates of next coordinate ( on the right)
                x++;
            }else if ( currentMove == '<'){
                //x takes the  coordinates of next coordinates (on the left)
                x--;
            }else if (currentMove == '^'){
                //y takes the above  coordinates ( up)
                y--;
            }else if (currentMove == 'v'){
                //y takes the below  coordinates ( down)
                y++;
            }
            //System.out.println(currentMove);

            //Step : Check not out of bounds
            x = Math.max(0, Math.min(x , nArray -1));
            y = Math.max(0, Math.min(y , nArray -1));

        }
        //Step 6 : Use formula to return the x coordinates of the last moves
        return (nArray * y) + x;
    }
}
