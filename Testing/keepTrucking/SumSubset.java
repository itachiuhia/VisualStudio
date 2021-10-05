package keepTrucking;
import java.util.Stack;

public class SumSubset {
    private static final int[] DATA = { 1,2,3,4,5,6,7,8,9 };

    public static void main(String[] args) {
        GetAllSubsetByStack get = new GetAllSubsetByStack();
        get.populateSubset(DATA, 0, DATA.length);
    }
}




class GetAllSubsetByStack {

    /** Set a value for target sum */
    public static final int TARGET_SUM = 10;

    private Stack<Integer> stack = new Stack<Integer>();

    /** Store the sum of current elements stored in stack */
    private int sumInStack = 0;

    public void populateSubset(int[] data, int fromIndex, int endIndex) {

        if (sumInStack == TARGET_SUM) {
            print(stack);
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

            if (sumInStack + data[currentIndex] <= TARGET_SUM) {
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];

                /*
                * Make the currentIndex +1, and then use recursion to proceed
                * further.
                */
                populateSubset(data, currentIndex + 1, endIndex);
                sumInStack -= (Integer) stack.pop();
            }
        }
    }

    /**
    * Print satisfied result. i.e. 15 = 4+6+5
    */

    private void print(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}