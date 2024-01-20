import java.util.Arrays;
import java.util.Scanner;

public class BookStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amount = scanner.nextInt();
        int[] heights = new int[amount];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = scanner.nextInt();
        }

        int[] result = findStacks(heights);
    }

    private static int[] findStacks(int[] heights) {
        Arrays.sort(heights);

        int[] result = new int[heights.length + 1];
        int stacks = 0;

        for (int i = 0; i < heights.length; i++) {
            if (i == 0 || heights[i] != heights[i - 1]) {
                stacks++;
            }
            result[stacks]++;
        }

        result[0] = stacks;

        return result;
    }
}
