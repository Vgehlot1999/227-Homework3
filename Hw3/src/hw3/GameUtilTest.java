package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import api.Direction;
import api.Move;
import api.TilePosition;

public class GameUtilTest {
	public static void main(String[] args) {
        testShiftArray();
        testGetScoreForValue();
        testGenerateRandomTileValue();
        testGenerateRandomTilePosition();
    }

    public static void testShiftArray() {
        GameUtil util = new GameUtil();
        ArrayList<Move> testList = new ArrayList<Move>();
        int[] testOrig = {6, 3, 3, 3, 3};
        int[] test = testOrig.clone();
        int[] expected = {6, 6, 3, 3, 0};
        testList = util.shiftArray(test);
        System.out.println("Began with " + Arrays.toString(testOrig) + " Expected " + Arrays.toString(expected) + ", actual: <" + Arrays.toString(test) + ">");
        System.out.println("The moves made were: " + testList.toString()); // should be
                                                                           // merged 1 to
                                                                           // 0, moved 2
                                                                           // to 1, moved
                                                                           // 3 to 2
    }

    public static void testGetScoreForValue() {
        GameUtil util = new GameUtil();
        int test = util.getScoreForValue(2);
        System.out.println("Expected 0, actual: <" + test + ">");
        test = util.getScoreForValue(48);
        System.out.println("Expected 243, actual: <" + test + ">");
        test = util.getScoreForValue(96);
        System.out.println("Expected 729, actual: <" + test + ">");
    }

    public static void testGenerateRandomTilePosition() {
        //the array is in the format of [rows][columns]  
        GameUtil util = new GameUtil();
        int[][] test = {{0, 2, 3, 1}, {0, 1, 3, 2}, {0, 2, 3, 0}, {0, 1, 2, 0}};
        Random rand = new Random();
        TilePosition tp = util.generateRandomTilePosition(test, rand, Direction.UP);
        System.out.println("Tile position is: " + tp);
    }

    public static void testGenerateRandomTileValue() {
        GameUtil util = new GameUtil();
        int[] result = new int[4];
        int iters = 100000;
        int randValue = 0;

        //gives a new random value each time so your results are going to be a little inconsistent
        Random rand = new Random();
        for (int i = 0; i < iters; i++) {
            randValue = util.generateRandomTileValue(rand);
            switch (randValue) {
                case 1 :
                    result[0]++;
                    break;
                case 2 :
                    result[1]++;
                    break;
                case 3 :
                    result[2]++;
                    break;
                case 6 :
                    result[3]++;
                    break;
            }
        }
        // in order to see what we got in easily viewable format(percentages)
        double[] resultPercentage = new double[4];
        for (int i = 0; i < 4; i++) {
            resultPercentage[i] = (result[i] / (double) iters * 100);
        }
        System.out.println(iters
                + " random values generated should look like [40, 40, 10, 10], actual: <"
                + Arrays.toString(resultPercentage) + ">");
    }
}
