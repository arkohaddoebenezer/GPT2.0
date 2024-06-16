import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsTest {
        @Test
        public void testStatisticsWithSampleInput1() {
            String[] input = {"2", "20" , "21", "22", "23", "30", "48", "49", "50", "55", "60" ,"65" ,"72" ,"63" ,"76" ,"80", "68" ,"90" ,"85" ,"98"};
            String expectedOutput = """
                    Values:
                    
                    Maximum grade: 98
                    Minimum grade: 2
                    Average grade: 54.25
                    Graph:
                    8\t>\t       \t       \t       \t       \t       \t
                    7\t>\t       \t       \t       \t       \t       \t
                    6\t>\t       \t       \t       \t#######\t       \t
                    5\t>\t       \t       \t#######\t#######\t       \t
                    4\t>\t       \t#######\t#######\t#######\t       \t
                    3\t>\t       \t#######\t#######\t#######\t       \t
                    2\t>\t#######\t#######\t#######\t#######\t#######\t
                    1\t>\t#######\t#######\t#######\t#######\t#######\t
                    \t+------------+-----------+-----------+-----------+------------+
                    \tI    0-20    I   21-40   I   41-60   I   61-80   I   81-100   I
                    """;
            String actualOutput = getStatisticsOutput(input);
            assertEquals(expectedOutput, actualOutput);
        }

        private String getStatisticsOutput(String[] input) {

            java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outContent));

            Statistics.statistics(input);

            System.setOut(System.out);

            return outContent.toString();
        }

}
