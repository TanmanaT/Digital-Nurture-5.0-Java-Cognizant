import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.anyString;

public class MyServiceTest {
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        // Stubbing the void method to do nothing when invoked
        doNothing().when(mockApi).logAccess(anyString());

        MyService service = new MyService(mockApi);
        service.logUserActivity("admin");

        // Verify the void method was called with the exact argument
        verify(mockApi).logAccess("admin");
    }
}
