import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PowerSum {

    // Internal Result class prevents package naming conflicts
    static class Result {

        public static int powerSum(int X, int N) {
            // Start the recursive search with the first natural number, 1
            return calculatePowerSum(X, N, 1);
        }

        // Recursive helper method to find combinations
        private static int calculatePowerSum(int target, int power, int num) {
            // Calculate num^power
            int value = (int) Math.pow(num, power);

            // Base case: if target becomes 0, we found a valid combination
            if (target == 0) {
                return 1;
            }

            // Base case: if target becomes negative or the current value exceeds the target, stop searching
            if (target < 0 || value > target) {
                return 0;
            }

            // Choice 1: Include the current number's power and subtract it from the target
            int includeCount = calculatePowerSum(target - value, power, num + 1);

            // Choice 2: Exclude the current number's power and look at the next number
            int excludeCount = calculatePowerSum(target, power, num + 1);

            // Return the sum of combinations from both choices
            return includeCount + excludeCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}