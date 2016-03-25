package Classes;

import Interfaces.Food;
import Interfaces.SecondCourse;
import org.springframework.stereotype.Component;

@Component
public class Ragout implements SecondCourse, Food {
    private String name;
    private final int kkal=223;
    private int mass;



    private Food sause;

    public Ragout(String name, int mass, Food sause){
        this.name=name;
        this.mass=mass;
        this.sause=sause;
    }

    @Override
    public int storageLife() {
        return 72;
    }

    @Override
    public int storageTemperature() {
        return 6;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String  LevelOfGrilled(String level) {
        return null;

    }

    @Override
    public String InningsWith() {
        return name + " served with tomato sause or " +sause.getName();
    }

    @Override
    public int kkal() {
        return mass*kkal/100;
    }

    public int getMass() {
        return mass;
    }
    public Food getSause() {
        return sause;
    }
}
