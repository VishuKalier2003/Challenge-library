import java.nio.file.Path;

public class Main {

    public static void main(
            String[] args
    ) throws Exception {

        WorkspaceBuilder builder =
                new WorkspaceBuilder();

        WorkspaceResult workspace =
                builder.buildWorkspace(

                        Path.of(
                                "../message-queues"
                        ),

                        Path.of(
                                "../candidate-submission"
                        )
                );

        GradleRunner runner =
                new GradleRunner();

        JudgeResult result =
        runner.runTests(
                workspace.getWorkspaceRoot()
        );

XmlResultParser parser =
        new XmlResultParser();

TestSummary summary =
        parser.parse(
                result
        );

System.out.println(
        "Passed: "
                + result.passed()
);

System.out.println(
        "Total Tests: "
                + summary.getTotalTests()
);

System.out.println(
        "Passed Tests: "
                + summary.getPassedTests()
);

System.out.println(
        "Failed Tests: "
                + summary.getFailedTests()
);

System.out.println(
        "Failures:"
);

for (
        String failure :
        summary.getFailures()
) {

    System.out.println(
            failure
    );
}
    }
}