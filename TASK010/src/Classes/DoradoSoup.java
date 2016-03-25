package Classes;

import Interfaces.Food;
import Interfaces.MainCourse;
import org.springframework.stereotype.Component;

@Component
public class DoradoSoup implements Food, MainCourse {
    private String name;
    private final int kkal=135;
    private int mass;

    public DoradoSoup(String name,int mass){
        this.name=name;
        this.mass=mass;
    }

    @Override
    public String inningWith() {
        return name+ " served with ciabatta.";
    }

    @Override
    public int storageLife() {
        return 24;
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
        return this.name;
    }

    public int getMass() {
        return mass;
    }
}
