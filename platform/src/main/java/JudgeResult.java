public class JudgeResult {

    private final int exitCode;

    private final String output;

    public JudgeResult(
            int exitCode,
            String output
    ) {
        this.exitCode = exitCode;
        this.output = output;
    }

    public int getExitCode() {
        return exitCode;
    }

    public String getOutput() {
        return output;
    }

    public boolean passed() {
        return exitCode == 0;
    }
}