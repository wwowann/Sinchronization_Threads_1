public class Main {
    public static void main(String[] args) throws InterruptedException {
        CarsSalon carsSalon = new CarsSalon();
        int counter = 0;
        System.out.println("Всего машин в салоне " + carsSalon.cars.size());

        while (counter < 11) {
            new Thread(null, carsSalon::sellCar, "Покупатель 1 ").start();
            new Thread(null, carsSalon::sellCar, "Покупатель 2 ").start();
            new Thread(null, carsSalon::sellCar, "Покупатель 3 ").start();

            for (int i = 0; i < 3; i++) {
                new Thread(null, carsSalon::acceptCar, "Продавец ").start();
                counter++;
                Thread.sleep(2000);
            }
        }
      }
}




