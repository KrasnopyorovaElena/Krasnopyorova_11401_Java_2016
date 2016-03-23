package Classes;

import Interfaces.Food;
import Interfaces.SoftDrinks;
import org.springframework.stereotype.Component;


@Component
public class Coffee implements SoftDrinks, Food {
    private String name;
    private int kkal;
    private int mass;
    private Food dessert;

    public Coffee(String name,int mass, Food dessert){
        this.name=name;
        this.mass=mass;
        this.dessert=dessert;
    }

    @Override
    public String  bokal() {
        return name + " served in coffee cups";
    }

    @Override
    public String inningsTemperature(int temperature) {
        String s="iced";
        if(name.equalsIgnoreCase(s))
        return s +" served at less temperature than other coffee. It served at 50 C";
        else return name + " served at "+ temperature + " C";
    }

    @Override
    public String decorateTo() {
        return null;
    }

    @Override
    public int storageLife() {
        return 0;
    }

    @Override
    public int kkal() {
        int kkal=100;
        switch (name){
            case "Iced": kkal=260*mass/100;
                break;
            case "Americano": kkal= mass;
                break;
            case "cappuccino":kkal= 150*mass/100;
                break;
            case "espresso":kkal= 60*mass/100;
                break;
        }
        return kkal;
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
}
