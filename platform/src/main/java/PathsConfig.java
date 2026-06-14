public class PathsConfig {

    private String starter;

    private String solution;

    private String visible_tests;

    private String hidden_tests;

    public PathsConfig() {
    }

    public String getStarter() {
        return starter;
    }

    public void setStarter(String starter) {
        this.starter = starter;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getVisible_tests() {
        return visible_tests;
    }

    public void setVisible_tests(
            String visible_tests
    ) {
        this.visible_tests = visible_tests;
    }

    public String getHidden_tests() {
        return hidden_tests;
    }

    public void setHidden_tests(
            String hidden_tests
    ) {
        this.hidden_tests = hidden_tests;
    }
}