import java.nio.file.Path;

public class WorkspaceResult {

    private final Path workspaceRoot;

    public WorkspaceResult(
            Path workspaceRoot
    ) {
        this.workspaceRoot =
                workspaceRoot;
    }

    public Path getWorkspaceRoot() {
        return workspaceRoot;
    }
}