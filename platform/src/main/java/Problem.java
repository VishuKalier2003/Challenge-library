import java.util.List;

public class Problem {

    private String problem_format_version;

    private String id;

    private String name;

    private String title;

    private String slug;

    private String difficulty;

    private String category;

    private String challenge_type;

    private String language;

    private String entry_class;

    private String description;

    private Contract contract;

    private Constraints constraints;

    private List<ScoringRule> scoring;

    private PathsConfig paths;

    private List<String> tags;

    public Problem() {
    }

    public String getProblem_format_version() {
        return problem_format_version;
    }

    public void setProblem_format_version(String problem_format_version) {
        this.problem_format_version = problem_format_version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChallenge_type() {
        return challenge_type;
    }

    public void setChallenge_type(String challenge_type) {
        this.challenge_type = challenge_type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEntry_class() {
        return entry_class;
    }

    public void setEntry_class(String entry_class) {
        this.entry_class = entry_class;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Constraints getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraints constraints) {
        this.constraints = constraints;
    }

    public List<ScoringRule> getScoring() {
        return scoring;
    }

    public void setScoring(List<ScoringRule> scoring) {
        this.scoring = scoring;
    }

    public PathsConfig getPaths() {
        return paths;
    }

    public void setPaths(PathsConfig paths) {
        this.paths = paths;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}