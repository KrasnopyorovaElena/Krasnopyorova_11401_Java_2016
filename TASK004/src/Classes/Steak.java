package Classes;

import Interfaces.Food;
import Interfaces.SecondCourse;
import org.springframework.stereotype.Component;


@Component
public class Steak implements Food, SecondCourse {
    private String name;
    private final int kkal=300;
    private int mass;
    private Food garnish;

    public Steak(String name, int mass,Food garnish){
        this.name=name;
        this.mass=mass;
        this.garnish=garnish;
    }


    @Override
    public int storageLife() {
        return 0;
    }

    @Override
    public String LevelOfGrilled(String level) {

        return name + " will be grilled " + level ;
    }

    @Override
    public String  InningsWith() {
        return name + " served with garnish "+ garnish.getName()+ " and Rosso sause";
    }

    @Override
    public int kkal() {
        return kkal*mass/100;
    }

    @Override
    public int storageTemperature() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
    public Food getGarnish() {
        return garnish;
    }
}
