package Classes;

import Interfaces.Food;
import Interfaces.MainCourse;
import org.springframework.stereotype.Component;

@Component
public class MushroomSoup implements Food, MainCourse {
    private String name;
    private final int kkal=249;
    private int mass;

    public MushroomSoup(String name,int mass){
        this.name=name;
        this.mass=mass;
    }

    @Override
    public String inningWith() {
        return name + " served with with croutons and truffle oil";
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
        return 6;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
}
