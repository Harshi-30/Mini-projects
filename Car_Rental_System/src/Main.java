public class Main {
    public static void main(String[] args) {
        carRentalSystem ces = new carRentalSystem();
        Car car1 = new Car("C001","Toyata","Camry",60.0);
        Car car2 = new Car("C002", "Honda", "Accord", 70.0);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150.0);
        ces.addCar(car1);
        ces.addCar(car2);
        ces.addCar(car3);

        ces.menu();
    }
}
