public class Customer {
    private String name;
    private String customerId;

    public Customer(String name,String customerId) {
        this.customerId = customerId;
        this.name = name;
    }
    public String getCustomerId(){
        return customerId;
    }
    public String getName(){
        return name;
    }
}
