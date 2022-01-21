import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

    class Result {

        /*
         * Complete the 'toolchanger' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. STRING_ARRAY tools
         *  2. INTEGER startIndex
         *  3. STRING target
         */

        public static int toolchanger(List<String> tools, int startIndex, String target) {
            // Write your codere
            //tools = ["fsdf", "sdfsdf", "adsfs"]
            if(!(startIndex <= tools.size())) {
                return -1;
            }

            int targetIndex= 0;
            for (int i = 0; i < tools.size(); i++) {
                if(target.equals(tools.get(i))) {
                    targetIndex = i;
                    System.out.println("Found target - " +targetIndex);
                }
            }
            int leftMoves = startIndex - targetIndex ; // 1 [1 - 0 = 1]

            int rightMoves = (tools.size() - startIndex) + (targetIndex) ; // 4 -1 [3]

            System.out.println(" Left = "+ leftMoves);
            System.out.println(" right = "+ rightMoves);
            int min = Math.min(Math.abs(leftMoves), Math.abs(rightMoves));
            System.out.println("Min = " +min);
            return min;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int toolsCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> tools = IntStream.range(0, toolsCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                    .collect(toList());

            int startIndex = Integer.parseInt(bufferedReader.readLine().trim());

            String target = bufferedReader.readLine();

            int result = Result.toolchanger(tools, startIndex, target);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

