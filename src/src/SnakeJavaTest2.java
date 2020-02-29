import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SnakeJavaTest2 {
    @Test
    public void test1(){
        boolean[][]game={
                {false, false, true},//<- is HP is (0,2)
                {false, false, true},
                {false, true, true}};//length should be 4, tail is at (2,1)
        SnakeJava test = new SnakeJava(game,0,2);
        int[]result= test.findTailExhaustive();
        int[]tester=new int[3];
        tester[0]=2;
        tester[1]=1;
        tester[2]=4;
        assertArrayEquals(tester,result);
    }//
}