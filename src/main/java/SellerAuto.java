public class SellerAuto {
    final CarsSalon carsSalon;
    private int count = 0;

    public SellerAuto(CarsSalon carsSalon, int count) {
        this.carsSalon = carsSalon;
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public synchronized void receiveCars() {
        try {
            System.out.println("Продавец: Принимаю автомобили");
            Thread.sleep(1000);
            carsSalon.getCars().add(new Cars());
            System.out.println("Продавец: прием автомобилей завершен, " +
                    "осталось автомобилей " + carsSalon.getCars().size());
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Cars sellCars() {
        try {

            System.out.println(Thread.currentThread().getName() + "покупает");

            while (carsSalon.getCars().size() == 0) {
                System.out.println("Продавец: не могу продать, автомобили закончились");
                wait();
            }
            Thread.sleep(2000);
            count++;
            System.out.println(Thread.currentThread().getName() +
                    "уехал на новеньком авто!\nВсего продано " + getCount() + " автомобиля\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carsSalon.getCars().remove(0);
    }


}
