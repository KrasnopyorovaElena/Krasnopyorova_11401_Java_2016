package Classes;

import Interfaces.SoftDrinks;
import org.springframework.stereotype.Component;

@Component
public class AppleJuice implements SoftDrinks {
    private String name;
    private final int kkal=100;
    private int mass;

    public AppleJuice(String name,int mass){
        this.name=name;
        this.mass=mass;
    }
    public int getMass() {
        return mass;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String  bokal() {
        return name + " served in a highball.";
    }

    @Override
    public String inningsTemperature(int temperature) {
        return  name+ " has inning temperature " +temperature + " C";
    }

    @Override
    public String decorateTo() {
        return "Insert tube. Ready=)";
    }

    @Override
    public int kkal() {
        return mass*kkal/100;
    }
}
