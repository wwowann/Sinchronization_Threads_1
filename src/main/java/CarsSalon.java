import java.util.ArrayList;
import java.util.List;

public class CarsSalon {
    List<Car> cars = new ArrayList<>(10);

    public void sellCar() {

        System.out.println(Thread.currentThread().getName() + " покупает");
        try {
            synchronized (this) {
                if (cars.size() == 0) {
                    System.out.println("Автомобилей нет на складе, подождите привоза новых автомобилей");
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        if (Thread.currentThread().isAlive() && cars.size() > 0) {
            cars.remove(0);
        }
    }

    public void acceptCar() {
        int count = 0;
        try {
            while (count < 11) {
                System.out.println("Производитель выпустил новый автомобиль. Можно продавать");
                synchronized (this) {
                    cars.add(new Car());
                    count++;
                    notifyAll();
                    Thread.sleep(3000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Производство автомобилей закончено, кина не будет");
    }
}
