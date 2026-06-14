import java.util.ArrayList;
import java.util.List;

public class TestSummary {

    private int totalTests;

    private int passedTests;

    private int failedTests;

    private final List<String> failures =
            new ArrayList<>();

    public int getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(
            int totalTests
    ) {
        this.totalTests = totalTests;
    }

    public int getPassedTests() {
        return passedTests;
    }

    public void setPassedTests(
            int passedTests
    ) {
        this.passedTests = passedTests;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public void setFailedTests(
            int failedTests
    ) {
        this.failedTests = failedTests;
    }

    public List<String> getFailures() {
        return failures;
    }
}