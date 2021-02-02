public class Main {
    public static void main(String[] args) {
        CarsSalon carsSalon = new CarsSalon();
        Runnable shopping = carsSalon::sellCars;
        new Thread(null, shopping, "Покупатель 1 ").start();
        new Thread(null, shopping, "Покупатель 2 ").start();
        new Thread(null, shopping, "Покупатель 3 ").start();
        for (int i = 0; i < 10; i++) {
       new Thread(null, carsSalon::acceptCars, "Продавец ").start();
           }
    }

}




