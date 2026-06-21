public class CustomerService {
    private final CustomerRepository customerRepository;

    // Dependency injection via constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomerName(int id) {
        String customerName = customerRepository.findCustomerById(id);
        System.out.println("Customer name retrieved for ID " + id + ": " + customerName);
    }
}
