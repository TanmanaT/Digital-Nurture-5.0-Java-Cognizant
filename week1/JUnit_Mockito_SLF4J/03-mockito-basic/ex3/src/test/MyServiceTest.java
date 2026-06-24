import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

public class MyServiceTest {
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        // Stubbing the method to return "Matched" for any string argument passed
        when(mockApi.getData(anyString())).thenReturn("Matched");

        MyService service = new MyService(mockApi);
        String result = service.fetchData("some-key");

        assertEquals("Matched", result);
        // Verify it was called with any string
        verify(mockApi).getData(anyString());
    }
}
