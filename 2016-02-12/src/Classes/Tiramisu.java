package Classes;

import Interfaces.Dessert;
import Interfaces.Food;
import org.springframework.stereotype.Component;

@Component
public class Tiramisu implements Food, Dessert {
    private String name;
    private final int kkal=330;
    private int mass;
    private Food coffee=new Coffee("espresso", 500, null);

    public Tiramisu(String name, int mass){
        this.name=name;
        this.mass=mass;
    }

    public String goodsFor(){
        return name + " - italian dessert, which is made from cookies Savoyardy " + coffee.getName();
    }

    @Override
    public int inningsTemperature() {
        return 9;
    }

    @Override
    public int storageLife() {
        return 72;
    }

    @Override
    public int kkal() {
        return kkal*mass/100;
    }

    @Override
    public int storageTemperature() {
        return 5;
    }

    @Override
    public String getName() {
        return name;
    }
    public Food getCoffee() {
        return coffee;
    }

    public int getMass() {
        return mass;
    }
}
