import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.mockito.Mockito.inOrder;

public class MyServiceTest {
    @Test
    public void testVerifyInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.runActions();

        // Create InOrder verification container
        InOrder inOrder = inOrder(mockApi);

        // Verify methods are called in the exact order
        inOrder.verify(mockApi).firstAction();
        inOrder.verify(mockApi).secondAction();
    }
}
