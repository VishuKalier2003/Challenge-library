public class Constraints {

    private int max_messages;

    private boolean thread_safe;

    private boolean persistence_required;

    private int max_execution_time_ms;

    public Constraints() {
    }

    public int getMax_messages() {
        return max_messages;
    }

    public void setMax_messages(int max_messages) {
        this.max_messages = max_messages;
    }

    public boolean isThread_safe() {
        return thread_safe;
    }

    public void setThread_safe(boolean thread_safe) {
        this.thread_safe = thread_safe;
    }

    public boolean isPersistence_required() {
        return persistence_required;
    }

    public void setPersistence_required(
            boolean persistence_required
    ) {
        this.persistence_required =
                persistence_required;
    }

    public int getMax_execution_time_ms() {
        return max_execution_time_ms;
    }

    public void setMax_execution_time_ms(
            int max_execution_time_ms
    ) {
        this.max_execution_time_ms =
                max_execution_time_ms;
    }
}