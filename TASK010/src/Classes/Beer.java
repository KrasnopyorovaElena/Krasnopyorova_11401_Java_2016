package Classes;

import Interfaces.AlcoholDrinks;
import Interfaces.Food;
import Interfaces.SoftDrinks;
import org.springframework.stereotype.Component;

@Component
public class Beer implements SoftDrinks, AlcoholDrinks {
    private String name;
    private int mass;
    private boolean alcohol;
    private Food appetazer;


    public Beer(String name, int mass, boolean alcohol, Food appetazer){
        this.name=name;
        this.mass=mass;
        this.alcohol=alcohol;
        this.appetazer=appetazer;
    }

    public Food getAppetazer() {return appetazer;}
    public boolean isAlcohol() {return alcohol;}
    public int getMass() {return mass;}
    @Override public String appetazerTo() {return
            "Excellent snack for " + getName()+ " are " + appetazer.getName();}

    @Override public String  bokal() {return name + " served in a beer glass";}

    @Override public String inningsTemperature(int temperature) {
        return  name+ " has inning temperature " +temperature + " C";}

    @Override public String decorateTo() {return null;}

    @Override public int kkal() {
        if(alcohol)
            return 220*mass/100;
        else return 130*mass/100;}

    @Override
    public String getName() {
        return name;
    }


}
