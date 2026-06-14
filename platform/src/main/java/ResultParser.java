import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultParser {

    public TestSummary parse(
            JudgeResult result
    ) {

        TestSummary summary =
                new TestSummary();

        String output =
                result.getOutput();

        extractTestCounts(
                output,
                summary
        );

        extractFailures(
                output,
                summary
        );

        return summary;
    }

    private void extractTestCounts(
            String output,
            TestSummary summary
    ) {

        Pattern pattern =
                Pattern.compile(
                        "(\\d+) tests completed, (\\d+) failed"
                );

        Matcher matcher =
                pattern.matcher(
                        output
                );

        if (
                matcher.find()
        ) {

            int total =
                    Integer.parseInt(
                            matcher.group(1)
                    );

            int failed =
                    Integer.parseInt(
                            matcher.group(2)
                    );

            summary.setTotalTests(
                    total
            );

            summary.setFailedTests(
                    failed
            );

            summary.setPassedTests(
                    total - failed
            );
        }
    }

    private void extractFailures(
            String output,
            TestSummary summary
    ) {

        Pattern pattern =
                Pattern.compile(
                        "[A-Za-z0-9_]+Test\\s*>\\s*(.*?)\\s*FAILED"
                );

        Matcher matcher =
                pattern.matcher(
                        output
                );

        while (
                matcher.find()
        ) {

            summary.getFailures()
                    .add(
                            matcher.group(1)
                                    .trim()
                    );
        }
    }
}