/**
 * PA7 Part 1 worksheet (style not required)
 */
public class Worksheet {

    /**
     * method that stores the result of Q1 in PA7 worksheet
     * @return heap's array representation after insertions
     */
    public static int[] insertionResult(){
        int[] output =  new int[]{84, 75, 59, 31, 70, 5, 15, 2, 30, 25, 68, 1};
        return output;
    }

    /**
     * method that stores the result of Q2 in PA7 worksheet
     * @return heap's array representations for each iteration of element removal, 5 iterations in total
     */
    public static int[][] removalResult(){
        int[][] output = new int[5][12];
        output[0] = new int[]{19, 38, 21, 39, 42, 74, 30, 47, 50, 54, 44, 0};
        output[1] = new int[]{21, 38, 30, 39, 42, 74, 44, 47, 50, 54, 0, 0};
        output[2] = new int[]{30, 38, 44, 39, 42, 74, 54, 47, 50, 0, 0, 0};
        output[3] = new int[]{38, 39, 44, 47, 42, 74, 54, 50, 0, 0, 0, 0};
        output[4] = new int[]{39, 42, 44, 47, 50, 74, 54, 0, 0, 0, 0, 0};
        return output;
    }

    /**
     * method that stores the result of Q3 in PA7 worksheet
     * @return heap's array representations for d-ary heaps, where d = 3,4
     */
    public static int[][] dResult(){
        int[][] output = new int[2][11];
        output[0] = new int[]{79, 43, 65, 75, 27, 33, 38, 36, 60, 11, 4};
        output[1] = new int[]{79, 65, 36, 25, 27, 33, 38, 43, 60, 11, 4};
        return output;
    }

    /**
     * method that stores the result of Q4 in PA7 worksheet
     * @return array representations
     */
    public static int[][] heapOperations(){
        int[][] output = new int[5][12];
        output[0] = new int[]{52, 50, 35, 39, 45, 17, 27, 10, 15, 0, 0, 0};
        output[1] = new int[]{100, 50, 35, 52, 45, 17, 27, 10, 15, 15, 39, 0};
        output[2] = new int[]{52, 50, 35, 39, 45, 17, 27, 10, 15, 15, 0, 0};
        output[3] = new int[]{88, 50, 35, 72, 45, 17, 27, 10, 15, 15, 39, 52};
        output[4] = new int[]{45, 27, 35, 39, 15, 17, 15, 10, 0, 0, 0, 0, 0};
        return output;
    }
}
