import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CorrectnessTest {

    @Test
    void shouldReturnMessagesInFIFOOrder() {

        Main.enqueue(
                new Message(
                        "hello"
                )
        );

        Main.enqueue(
                new Message(
                        "world"
                )
        );

        Message first =
                Main.dequeue();

        Message second =
                Main.dequeue();

        assertNotNull(
                first
        );

        assertNotNull(
                second
        );

        assertEquals(
                "hello",
                first.getContent()
        );

        assertEquals(
                "world",
                second.getContent()
        );
    }

    @Test
    void queueDepthShouldIncrease() {

        Main.enqueue(
                new Message(
                        "one"
                )
        );

        Main.enqueue(
                new Message(
                        "two"
                )
        );

        assertEquals(
                2,
                Main.queueDepth()
        );
    }

    @Test
    void queueDepthShouldDecreaseAfterDequeue() {

        Main.enqueue(
                new Message(
                        "one"
                )
        );

        Main.dequeue();

        assertEquals(
                0,
                Main.queueDepth()
        );
    }
}