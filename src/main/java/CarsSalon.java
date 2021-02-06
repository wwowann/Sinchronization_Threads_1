import java.util.ArrayList;
import java.util.List;

public class CarsSalon {
    List<Car> cars = new ArrayList<>(10);

    // вариант кода ниже тоже работает, но только покупатели все вместе
// приходят в магазин, а потом в том же порядке уходят с покупкой

//    public Car sellCar() {
//        System.out.println(Thread.currentThread().getName() + " покупает");
//
//        try {
//            synchronized (this){if (cars.size() == 0) {
//                    wait();
//                }
//            }
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
//        return cars.remove(0);
//    }
//
//    public void acceptCar() {
//        cars.add(new Car());
//            synchronized (this){notify();}
//    }

    public synchronized Car sellCar() {
        System.out.println(Thread.currentThread().getName() + " покупает");

        try {
            if (cars.size() == 0) {
                System.out.println("Автомобилей нет на складе, подождите привоза новых автомобилей");
                wait();
            }
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        return cars.remove(0);
    }

    public synchronized void acceptCar() {
        System.out.println("Производитель выпустил новый автомобиль. Можно продавать");
        cars.add(new Car());
        notify();
    }
}
