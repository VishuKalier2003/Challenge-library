import java.nio.file.Path;

public class JudgeResult {

    private final int exitCode;

    private final String output;

    private final Path workspaceRoot;

    public JudgeResult(
            int exitCode,
            String output,
            Path workspaceRoot
    ) {

        this.exitCode =
                exitCode;

        this.output =
                output;

        this.workspaceRoot =
                workspaceRoot;
    }

    public int getExitCode() {
        return exitCode;
    }

    public String getOutput() {
        return output;
    }

    public Path getWorkspaceRoot() {
        return workspaceRoot;
    }

    public boolean passed() {
        return exitCode == 0;
    }
}