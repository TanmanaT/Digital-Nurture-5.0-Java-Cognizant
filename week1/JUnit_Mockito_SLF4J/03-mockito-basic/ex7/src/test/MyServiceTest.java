import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

public class MyServiceTest {
    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        // Stubbing the void method to throw RuntimeException
        doThrow(new RuntimeException("Danger occurred")).when(mockApi).doSomethingDangerous();

        MyService service = new MyService(mockApi);

        assertThrows(RuntimeException.class, () -> {
            service.executeTask();
        });
    }
}
