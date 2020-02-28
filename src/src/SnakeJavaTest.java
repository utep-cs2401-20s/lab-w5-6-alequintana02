import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//test the two methods correctness and the running time (at least 5 for each method independently,
//or 10 that test both methods at once). Each test should have a comment describing what is being tested
//justify test cases and if it passed or failed
class SnakeJavaTest {
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
    }//closes test1
    @Test
    public void test2(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailExhaustive());
    }//closes test2

    @Test
    public void test3(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailExhaustive());
    }//closes test3

    @Test
    public void test4(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailExhaustive());
    }//closes test4

    @Test
    public void test5(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailExhaustive());
    }//closes test5

    @Test
    public void test6(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailRecursive());
    }//closes test6

    @Test
    public void test7(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailRecursive());
    }//closes test7

    @Test
    public void test8(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailRecursive());
    }//closes test8

    @Test
    public void test9(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailRecursive());
    }//closes test9

    @Test
    public void test10(){
        SnakeJavaTest test = new SnakeJavaTest();
        assertArrayEquals(SnakeJavaTest.findTailRecursive());
    }//closes test10


}//closes Tester class
