import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class GradleRunner {

    public JudgeResult runTests(
            Path workspace
    ) throws Exception {

        ProcessBuilder processBuilder =
                new ProcessBuilder(
                        "gradle",
                        "test"
                );

        processBuilder.directory(
                workspace.toFile()
        );

        processBuilder.redirectErrorStream(
                true
        );

        Process process =
                processBuilder.start();

        StringBuilder output =
                new StringBuilder();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        process.getInputStream()
                                )
                        )
        ) {

            String line;

            while (
                    (line = reader.readLine())
                            != null
            ) {

                output.append(line)
                        .append("\n");
            }
        }

        int exitCode =
                process.waitFor();

        return new JudgeResult(
                exitCode,
                output.toString()
        );
    }
}