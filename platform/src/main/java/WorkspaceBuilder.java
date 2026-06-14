import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class WorkspaceBuilder {

    public WorkspaceResult buildWorkspace(
            Path challengePath,
            Path submissionPath
    ) throws IOException {

        validateChallenge(
                challengePath
        );

        validateSubmission(
                submissionPath
        );

        Path workspaceRoot =
                Files.createTempDirectory(
                        "judge-workspace-"
                );

        Path mainJava =
                workspaceRoot.resolve(
                        "src/main/java"
                );

        Path testJava =
                workspaceRoot.resolve(
                        "src/test/java"
                );

        Files.createDirectories(
                mainJava
        );

        Files.createDirectories(
                testJava
        );

        copyDirectory(
                submissionPath,
                mainJava
        );

        copyDirectory(
                challengePath.resolve(
                        "tests"
                ),
                testJava
        );

        generateBuildGradle(
                workspaceRoot
        );

        return new WorkspaceResult(
                workspaceRoot
        );
    }

    private void validateChallenge(
            Path challengePath
    ) {

        if (!Files.exists(challengePath)) {

            throw new RuntimeException(
                    "Challenge folder not found: "
                            + challengePath
            );
        }

        if (
                !Files.exists(
                        challengePath.resolve(
                                "problem.yaml"
                        )
                )
        ) {

            throw new RuntimeException(
                    "problem.yaml missing"
            );
        }

        if (
                !Files.exists(
                        challengePath.resolve(
                                "tests"
                        )
                )
        ) {

            throw new RuntimeException(
                    "tests folder missing"
            );
        }
    }

    private void validateSubmission(
            Path submissionPath
    ) {

        if (
                !Files.exists(
                        submissionPath
                )
        ) {

            throw new RuntimeException(
                    "Submission folder missing: "
                            + submissionPath
            );
        }
    }

    private void generateBuildGradle(
            Path workspaceRoot
    ) throws IOException {

        String buildGradle =
        """
        plugins {
            id 'java'
        }

        repositories {
            mavenCentral()
        }

        dependencies {

            testImplementation platform(
                'org.junit:junit-bom:5.12.2'
            )

            testImplementation(
                'org.junit.jupiter:junit-jupiter'
            )

            testRuntimeOnly(
                'org.junit.platform:junit-platform-launcher'
            )
        }

        test {
            useJUnitPlatform()
        }
        """;

        Files.writeString(
                workspaceRoot.resolve(
                        "build.gradle"
                ),
                buildGradle
        );
    }

    private void copyDirectory(
            Path source,
            Path target
    ) throws IOException {

        Files.walk(source)
                .forEach(path -> {

                    try {

                        Path destination =
                                target.resolve(
                                        source.relativize(
                                                path
                                        )
                                );

                        if (
                                Files.isDirectory(path)
                        ) {

                            Files.createDirectories(
                                    destination
                            );

                        } else {

                            Files.copy(
                                    path,
                                    destination,
                                    StandardCopyOption.REPLACE_EXISTING
                            );
                        }

                    } catch (
                            IOException e
                    ) {

                        throw new RuntimeException(
                                e
                        );
                    }
                });
    }
}