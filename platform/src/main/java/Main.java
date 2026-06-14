import java.nio.file.Path;

public class Main {
        public static void main(
            String[] args
    ) throws Exception {
        WorkspaceBuilder builder =
                new WorkspaceBuilder();
        WorkspaceResult result =
                builder.buildWorkspace(

                        Path.of(
                                "../message-queues"
                        ),

                        Path.of(
                                "../candidate-submission"
                        )
                );

        System.out.println(
                result.getWorkspaceRoot()
        );
    }
}