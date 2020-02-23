public class SnakeJava {
    //headPosition is a 1D array (x,y)
//exhaustive search+ look every possible way. needs nested for loops
    //recursive: your base case is when you find the tail/empty spaces after tail
    //recursive call should start at head. use "neighbors" until you find the tail
    //both ex and rec will find the exact same thing
    private boolean[][] game;//true if part of snake ;false if in the background
    private int[] headPosition;//size =2;
    private static int exhaustiveChecks;
    private static int recursiveChecks;


                                                //constructors//
// default constructor
    public SnakeJava() {
        this.game = new boolean[1][1];
}//closes default constructor size 1x1

    public SnakeJava(boolean[][] game,int[]headPosition) {
        this.headPosition = headPosition;

    }//closes hP constructor
//index[0] should be first position=head
                                                //end of constructors//

                                                        //methods//


    private int neighbors (boolean[][]game) {//counts LIVE neighbors//make sure to not go out of bounds
        int neighbors=0;
        for (int r = 0; r < game.length; r++) {
            for (int c = 0; c < game[r].length; c++) {
                if (game[r][c - 1]==true) {//left
                    neighbors++; ;
                } if (game[r - 1][c]==true) {//straight up
                    neighbors++;
                } if (game[r + 1][c]==true) {//straight down
                    neighbors++;
                } if (game[r][c + 1]==true) {//right
                    neighbors++;
                } else {
                    neighbors--;
                }
            }//closes col }//closes for loop
        }//closes neighbors
       return neighbors;
    }//




//will find the tail of the snake by searching across the whole grid to find the grid position where a true element is
// surrounded by only one other true cell (see figure below), but is not the head, and return 3 items: the x and y
// position of the tail in the grid, and the length of the snake on the board. Incremenets the exhaustiveChecks counter with each (x',y') cell that is examined.
    public int[] findTailExhaustive(int neighbors){
        resetCounters();//need to reset counters at beginning of method
        //neighbors needs to be less than or equal to three
        int result[]=new int[3];
        int length=0;
        int tailX=0;
        int tailY=0;
    for (int r=0;r<game.length;r++){
        for(int c=0;c<game[r].length;c++){
            if (game[r][c]==true){
                exhaustiveChecks++;
                length++;
            }//closes if statement
            else if (game[r][c]=false) {
                exhaustiveChecks++;
                length--;
            }//closes else if
        }//closes col
        tailX = result[0];
        tailY = result[1];
        length =result[2];
//if neighbor=1 it is either tail or head.
        //if neigh=2 or more, move to the next cell
    }//closes
    return result;
    //(x,y position);
    }//closes findTailExhaustive

    public int[] findTailRecursive(){

    recursiveChecks++;
    }//closes findTailRecursive

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){

    }//closes private findTailRecursive


    private void resetCounters() {//resets both the exhaustiveChecks and recursiveChecks counters to 0.
        exhaustiveChecks=0;
        recursiveChecks=0;
    } //closes resetCounter

    private static int getRecursiveChecks(){//gets the current state of the recursiveChecks counter.
        return recursiveChecks;
    }//closes getRecurChecks

    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }//closes getExChecks

                                                        //end of methods//
}//closes SnakeJava class
