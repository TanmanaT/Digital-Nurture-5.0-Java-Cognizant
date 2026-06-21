public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create concrete repository dependency
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject dependency into service class via constructor injection
        CustomerService service = new CustomerService(repository);

        System.out.println("--- Scenario: Finding Customers ---");
        service.displayCustomerName(1);
        service.displayCustomerName(2);
        service.displayCustomerName(3);
    }
}
