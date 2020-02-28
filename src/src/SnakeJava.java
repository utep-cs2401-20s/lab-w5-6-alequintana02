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
        game = new boolean[1][1];
    }//closes default constructor size 1x1

    public SnakeJava(boolean[][] game, int headX, int headY) {
        this.game= game;
        headPosition[0]=headX;
        headPosition[1]=headY;
    }//closes hP constructor
                                                 //end of constructors//


                                                        //methods//

//helper method to count neighbors//
    private int neighbor(int r, int c) {//counts LIVE neighbors//make sure to not go out of bounds
        int neighbor = 0;
       // for (int r = 0; r < game.length; r++) {
        //    for (int c = 0; c < game[r].length; c++) {
                if (game[r][c - 1]) {//left
                    neighbor++;
                } if (game[r - 1][c]) {//straight up
                    neighbor++;
                } if (game[r + 1][c]) {//straight down
                    neighbor++;
                } if (game[r][c + 1]) {//right
                    neighbor++;
                }
            //}//closes col }//closes for loop
        //}//closes neighbors
        return neighbor;
    }//ends helper method


    //will find the tail of the snake by searching across the whole grid to find the grid position where a true element is
// surrounded by only one other true cell (see figure below), but is not the head, and return 3 items: the x and y
// position of the tail in the grid, and the length of the snake on the board. Increments exhaustiveChecks counter with each (x',y') cell that is examined.
    public int[] findTailExhaustive() {
        resetCounters();//need to reset counters at beginning of method
        //neighbors needs to be less than or equal to three
        int result[] = new int[3];//result will give back 3 values, (x&y)position and total length
        int length = 0;
        int tailX;
        int tailY;
        //intTotalLength = 0;
        for (int r = 0; r < game.length; r++) {//row traversal
            for (int c = 0; c < game[r].length; c++) {//col traversal
                exhaustiveChecks++;
                if (game[r][c]) {//we want to make sure the cell is true
                    length++;//increasing length because it is part of the snake THE HEAD ONLY HAS ONE NEIGHBOR
                //}//closes if statement
                int neighbors=neighbor(r,c); //using neighbor method to count neighbors
                if(neighbors == 1) {//could be head or could be tail
                    if (!game[headPosition[0]][headPosition[1]]) {
                        tailX = r;
                        tailY = c;
                        result[0] = tailX;
                        result[1] = tailY;
                    }
                  }result[2] = length;
                }
            }//closes col
        }//closes row
        return result; //array with (x,y, length);
    }//closes findTailExhaustive



        public int[] findTailRecursive () {
        resetCounters();//2 lines of code total for this method
        return findTailRecursive(headPosition, headPosition);//hint given in readme
        }//closes findTailRecursive

//
        private int[] findTailRecursive (int[] currentPosition, int[] previousPosition) {
            // will return the exact same thing as exhaustive
            int result[] = new int[3];//result will give back (x&y)position and total length
            int length = 1;//we are starting at a place other than head
            int tailX = 0;
            int tailY = 0;
            int temp[];
            int neighborsCurrent = neighbor(currentPosition[0], currentPosition[1]);//runs neighbor method with current position
            recursiveChecks++;
            //if neighbor=1 it is either tail or head. here we assume it is the head
             if (neighborsCurrent == 1 && currentPosition == previousPosition) {
                temp = currentPosition;
                currentPosition[0]++;
                currentPosition[1]++;
                previousPosition = temp;
            } if(neighborsCurrent>=2) { //if neigh=2 or more, move to the next cell
                length++;
                findTailRecursive();
           //if neighbor=1 it is either tail or head. here we assume it is the tail
            } if (neighborsCurrent==1 && currentPosition!=previousPosition){
            tailX=currentPosition[0];
            tailY=currentPosition[1];
            } else {//keep looking
        findTailRecursive();
            }
            result[0] = tailX;
            result[1] = tailY;
            result[2] = length;
            return result;

        }
        //closes private findTailRecursive


    public void resetCounters(){//resets both the exhaustiveChecks and recursiveChecks counters to 0.
        this.exhaustiveChecks=0;
        this.recursiveChecks=0;
    } //closes resetCounter

    private static int getRecursiveChecks(){//gets the current state of the recursiveChecks counter.
        return recursiveChecks;
    }//closes getRecurChecks

    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }//closes getExChecks

                                                        //end of methods//
}//closes SnakeJava class
