public class ApiService {
    private final RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String fetchData() {
        String rawResponse = restClient.getResponse();
        return "Fetched " + rawResponse;
    }
}
