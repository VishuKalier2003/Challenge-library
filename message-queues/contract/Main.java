import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final Queue<Message> queue =
            new LinkedList<>();

    public static void enqueue(
            Message message
    ) {
        queue.add(message);
    }

    public static Message dequeue() {
        return queue.poll();
    }

    public static int queueDepth() {
        return queue.size();
    }
}