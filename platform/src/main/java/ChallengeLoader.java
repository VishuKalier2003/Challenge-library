import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ChallengeLoader {

        public Problem load(Path yamlPath) throws Exception {
        Yaml yaml = new Yaml();
        try (InputStream input = Files.newInputStream(yamlPath))
                {
                return yaml.loadAs(input, Problem.class);
                }
        }

        public List<Problem> loadAllProblems(Path root) throws Exception {
                List<Problem> problems = new ArrayList<>();
                Files.list(root).filter(Files::isDirectory).forEach(folder -> {
                Path yaml = folder.resolve("problem.yaml");
                if (Files.exists(yaml)) {
                        try {
                                problems.add(load(yaml));
                        } catch (Exception e) {
                        throw new RuntimeException(e);
                        }
                }
                });
                return problems;
        }
}