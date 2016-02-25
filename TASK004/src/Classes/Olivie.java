package Classes;

import Interfaces.Food;
import Interfaces.Salad;
import org.springframework.stereotype.Component;

@Component
public class Olivie implements Food, Salad {
    private String name;
    private final int kkal=250;
    private int mass;

    public Olivie(String name, int mass){
        this.mass=mass;
        this.name=name;
    }

    @Override
    public String  cut() {return name + " cut into cubes";}

    @Override
    public String inningWithSause() {
        return name + " served with mayonnaise sauce";
    }

    @Override
    public int storageLife() {
        return 72;
    }

    @Override
    public int kkal() {
        return mass*kkal/100;
    }

    @Override
    public int storageTemperature() {
        return 3;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
}
