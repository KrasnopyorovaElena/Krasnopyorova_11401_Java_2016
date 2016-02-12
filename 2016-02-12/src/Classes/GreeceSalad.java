package Classes;

import Interfaces.Food;
import Interfaces.Salad;
import org.springframework.stereotype.Component;


@Component
public class GreeceSalad implements Food, Salad {
    private String name;
    private final int kkal=213;
    private int mass;
    private Food sause;

    public GreeceSalad(String name, int mass, Food sause){
        this.name=name;
        this.mass=mass;
        this.sause=sause;
    }

    @Override
    public String cut() {
        return name +" cut into large cubes";
    }

    @Override
    public String inningWithSause() {
        return "Classic "+ name+ " served with " + sause.getName();
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
        return 5;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
    public Food getSause() {
        return sause;
    }
}
