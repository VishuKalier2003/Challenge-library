import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class WorkspaceBuilder {

    public WorkspaceResult buildWorkspace(
            Path challengePath,
            Path submissionPath
    ) throws IOException {

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
                        "src/test/java"
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

    private void generateBuildGradle(
            Path workspaceRoot
    ) throws IOException {

        String gradleFile =
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

                    testImplementation
                        'org.junit.jupiter:junit-jupiter'

                    testRuntimeOnly
                        'org.junit.platform:junit-platform-launcher'
                }

                test {
                    useJUnitPlatform()
                }
                """;

        Files.writeString(
                workspaceRoot.resolve(
                        "build.gradle"
                ),
                gradleFile
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