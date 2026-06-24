public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void runActions() {
        externalApi.firstAction();
        externalApi.secondAction();
    }
}
