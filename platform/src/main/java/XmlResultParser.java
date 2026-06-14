import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

import java.nio.file.Files;
import java.nio.file.Path;

public class XmlResultParser {

    public TestSummary parse(
            JudgeResult result
    ) throws Exception {

        TestSummary summary =
                new TestSummary();

        Path xmlDirectory =
                result.getWorkspaceRoot()
                        .resolve(
                                "build/test-results/test"
                        );

        Files.walk(xmlDirectory)
                .filter(
                        path ->
                                path.toString()
                                        .endsWith(".xml")
                )
                .forEach(
                        xmlFile -> {

                            try {

                                parseXmlFile(
                                        xmlFile,
                                        summary
                                );

                            } catch (
                                    Exception e
                            ) {

                                throw new RuntimeException(
                                        e
                                );
                            }
                        }
                );

        return summary;
    }

    private void parseXmlFile(
            Path xmlFile,
            TestSummary summary
    ) throws Exception {

        Document document =
                DocumentBuilderFactory
                        .newInstance()
                        .newDocumentBuilder()
                        .parse(
                                xmlFile.toFile()
                        );

        Element root =
                document.getDocumentElement();

        int tests =
                Integer.parseInt(
                        root.getAttribute(
                                "tests"
                        )
                );

        int failures =
                Integer.parseInt(
                        root.getAttribute(
                                "failures"
                        )
                );

        summary.setTotalTests(
                summary.getTotalTests()
                        + tests
        );

        summary.setFailedTests(
                summary.getFailedTests()
                        + failures
        );

        NodeList testCases =
                document.getElementsByTagName(
                        "testcase"
                );

        for (
                int i = 0;
                i < testCases.getLength();
                i++
        ) {

            Element testCase =
                    (Element)
                            testCases.item(i);

            String testName =
                    testCase.getAttribute(
                            "name"
                    );

            NodeList failureNodes =
                    testCase.getElementsByTagName(
                            "failure"
                    );

            if (
                    failureNodes.getLength()
                            > 0
            ) {

                summary.getFailures()
                        .add(
                                testName
                        );

            } else {

                summary.getPassed()
                        .add(
                                testName
                        );
            }
        }

        summary.setPassedTests(
                summary.getTotalTests()
                        -
                        summary.getFailedTests()
        );
    }
}