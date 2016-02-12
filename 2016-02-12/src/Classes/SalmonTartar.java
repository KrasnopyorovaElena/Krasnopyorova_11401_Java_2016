package Classes;

import Interfaces.Appetazer;
import Interfaces.Food;
import org.springframework.stereotype.Component;

@Component
public class SalmonTartar implements Appetazer, Food {
    private String name;
    private final int kkal=150;
    private int mass;

    public SalmonTartar(String name, int mass){
        this.name=name;
        this.mass=mass;
    }

    @Override
    public String  cut() {
        return name +" cut into very small cubes";
    }

    @Override
    public String inningWithSause() {
        return name+ " served with with ginger-soy sauce";
    }

    @Override
    public int storageLife() {
        return 12;
    }

    @Override
    public int kkal() {
        return mass*kkal/100;
    }

    @Override
    public int storageTemperature() {
        return 2;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
}
