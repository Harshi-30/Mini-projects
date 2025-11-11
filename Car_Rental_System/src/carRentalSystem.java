import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class carRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public carRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }
    public  void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car,Customer customer,int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental (car,customer,days));
        }
        else {
            System.out.println("Car is not available for rent");
        }
    }
    public void returnCar(Car car){
            Rental rentalToRemove = null;
            for(Rental rental : rentals){
                if(rental .getCar() == car){
                    rentalToRemove = rental;
                    break;
                }
            }
            if(rentalToRemove != null){
                rentals.remove(rentalToRemove);
            }
            else {
                System.out.println("Car was not rented");
            }
        }
        public void menu(){
        Scanner sr = new Scanner(System.in);

        while (true){
            System.out.println("==== Car Rental System ====");
            System.out.println("1. Rental a car");
            System.out.println("2. Return a car ");
            System.out.println("3. Exit ");
            System.out.print("Enter your choice: ");

            int choice = sr.nextInt();
            sr.nextLine();//This “cleans up” the input buffer.

            if(choice == 1){
                System.out.println("\n== Rental a Car ==\n");
                System.out.print("Enter your name: ");
                String customerName = sr.nextLine();

                System.out.println("\nAvailable Cars: ");
                for(Car car: cars){
                    if(car.isAvailable()){
                        System.out.println(car.getcarId()+" - "+car.getBrand()+" - "+car.getModel());
                    }
                }
                System.out.println("\nEnter the car ID you want to rent: ");
                String carId = sr.nextLine();

                System.out.println("Enter the number of day for rental: ");
                int rentalDay = sr.nextInt();
                sr.nextLine();

                Customer newCustomer = new Customer("CUS"+(customers.size()+1),customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car : cars){
                    if(car.getcarId().equals(carId)&& car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }
                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDay);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID:"+newCustomer.getCustomerId());
                    System.out.println("Customer name:"+newCustomer.getName());
                    System.out.println("Car:"+selectedCar.getBrand()+" "+selectedCar.getModel());
                    System.out.println("Rental Days"+rentalDay);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);
                    System.out.print("\nConfirm rental (Y/N):");
                    String confirm = sr.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar,newCustomer,rentalDay);
                        System.out.println("\nCar rented Successfully. ");
                    }else{
                        System.out.println("\nRental canceled");
                    }

                }else{
                    System.out.println("\nInvalid car selection or car not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n==Return a car ==\n");
                System.out.print("Enter the car Id you want to return: ");
                String carId = sr.nextLine();

                Car carToReturn = null;
                for (Car car : cars){
                    if(car.getcarId().equals( carId) && !car.isAvailable()){
                        carToReturn = car;
                        break;
                    }
                }
                if(carToReturn != null){
                    Customer customer = null;
                    for(Rental rental : rentals){
                        if(rental.getCar()==carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if(customer != null){
                        returnCar(carToReturn);
                        System.out.println("Car returned Successfully by "+customer.getName());
                    }else{
                        System.out.println("Car was not return or return Information is missing");
                    }
                }else {
                    System.out.println("Invalid car ID or car is not rented. ");
                }
            }else if(choice == 3){
                break;
            }else{
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
            System.out.println("\n Thank you for using the car Rental System!");
        }


}
