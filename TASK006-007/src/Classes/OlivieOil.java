package Classes;

import Interfaces.Food;
import Interfaces.Sause;
import org.springframework.stereotype.Component;

@Component
public class OlivieOil implements Sause, Food {
    private String name;
    private final int kkal=300;
    private int mass;

    public OlivieOil(String name,int mass){
        this.name=name;
        this.mass=mass;
    }

    @Override
    public int storageTemperature() {
        return 18;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int storageLife() {
        return 6*30*24;
    }

    @Override
    public int kkal() {
        return mass*kkal/100;
    }

    @Override
    public String levelOfSpiced() {
        return name+ " has bitter taste. It is not sharp.";
    }

    public int getMass() {
        return mass;
    }
}
