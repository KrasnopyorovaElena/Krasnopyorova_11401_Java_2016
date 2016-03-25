package Classes;

import Interfaces.Appetazer;
import Interfaces.Food;
import Interfaces.SecondCourse;
import org.springframework.stereotype.Component;

@Component
public class GrilledShrimps implements Appetazer, Food, SecondCourse {
    private String name;
    private final int kkal = 156;
    private int mass;
    private Food sause;

    public GrilledShrimps(String name, int mass, Food sause) {
        this.name = name;
        this.mass = mass;
        this.sause = sause;
    }

    @Override
    public String cut() {
        return null;
    }

    @Override
    public String inningWithSause() {
        return name + " served with " + sause.getName() + " or pesto sause";
    }

    @Override
    public int storageLife() {
        return 36;
    }

    @Override
    public String LevelOfGrilled(String level) {
        return null;
    }

    @Override
    public String InningsWith() {
        return name + " served with grilled vegetables and lemon";
    }

    @Override
    public int kkal() {
        return kkal * mass / 100;
    }

    @Override
    public int storageTemperature() {
        return 15;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getMass() {
        return mass;
    }

    public Food getSause() {
        return sause;
    }
}