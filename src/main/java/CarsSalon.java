import java.util.ArrayList;
import java.util.List;

public class CarsSalon {
    SellerAuto sellerAuto = new SellerAuto(this, 0);
    List<Cars> cars = new ArrayList<>(10);

    public Cars sellCars (){
        return sellerAuto.sellCars();
    }
    public void acceptCars(){
        sellerAuto.receiveCars();
    }
    public List<Cars> getCars() {
        return cars;
    }
    public  int getCount(){return sellerAuto.getCount();}

}
