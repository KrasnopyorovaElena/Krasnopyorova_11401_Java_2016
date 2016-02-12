package Classes;

import Interfaces.AlcoholDrinks;
import org.springframework.stereotype.Component;

@Component
public class Champagne implements AlcoholDrinks {
    private String name;
    private final int kkal=250;
    private int mass;
    private final int tmin=6;
    private final int tmax=9;


    public Champagne(String name, int mass){
       this.name=name;
       this.mass=mass;
    }

    @Override
    public String  bokal() {
        return name + " served in a glass flyute";
    }

    @Override
    public String  inningsTemperature(int temperature) {
        if(temperature<=9 &&temperature>=6) return "Ok. " + name +" will be served at " +temperature +" C.";
        else return "Unfortunately, "+ name +" isn't served at " +temperature+ " C";
    }

    @Override
    public String appetazerTo() {
        return "Excellent appetazer for " + getName()+ "are fruits";
    }

    @Override
    public int kkal() {
        return mass*kkal/100;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
}
