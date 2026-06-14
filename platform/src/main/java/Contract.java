import java.util.List;

public class Contract {

    private List<String> required_methods;

    private List<String> required_files;

    public Contract() {
    }

    public List<String> getRequired_methods() {
        return required_methods;
    }

    public void setRequired_methods(
            List<String> required_methods
    ) {
        this.required_methods = required_methods;
    }

    public List<String> getRequired_files() {
        return required_files;
    }

    public void setRequired_files(
            List<String> required_files
    ) {
        this.required_files = required_files;
    }
}