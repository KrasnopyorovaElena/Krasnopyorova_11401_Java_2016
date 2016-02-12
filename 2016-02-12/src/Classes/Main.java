package Classes;

public class Main {
    public static void main(String [] args){

        AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        System.out.println(appleJuice.getName());
        System.out.println(appleJuice.decorateTo());
        System.out.println(appleJuice.getName() + " " + appleJuice.getMass() + " g - " + appleJuice.kkal() + "kkal");
        System.out.println(appleJuice.inningsTemperature(15));
        System.out.println(appleJuice.bokal());

        System.out.println();


        Champagne champagne=new Champagne("Moet Chandon",700);
        System.out.println(champagne.bokal());
        System.out.println(champagne.inningsTemperature(8));
        System.out.println(champagne.appetazerTo());
        System.out.println(champagne.getName() + " " + champagne.getMass() + " g - " + champagne.kkal() + "kkal");

        System.out.println();

        Tiramisu tiramisu=new Tiramisu("Tiramisu",200);
        System.out.println(tiramisu.getName());
        System.out.println(tiramisu.goodsFor());
        System.out.println(tiramisu.getName() + " " + tiramisu.getMass() + " g - " + tiramisu.kkal() + "kkal");
        System.out.println(tiramisu.getName() + " has storage life " + tiramisu.storageLife() + " hours");

        System.out.println();

        Coffee coffee=new Coffee("Iced",100,tiramisu);
        System.out.println(coffee.bokal());
        System.out.println(coffee.inningsTemperature(60));
        System.out.println(coffee.getName() + " " + coffee.getMass() + " g - " + coffee.kkal() + "kkal");

        System.out.println();

        DoradoSoup doradoSoup=new DoradoSoup("Dorado Soup",300);
        System.out.println(doradoSoup.getName());
        System.out.println(doradoSoup.inningWith());
        System.out.println(doradoSoup.getName() + " " + doradoSoup.getMass() + " g - " + doradoSoup.kkal() + "kkal");
        System.out.println(doradoSoup.getName() + " has storage life " + doradoSoup.storageLife() +
                " with storage temperature " + doradoSoup.storageTemperature() +" C");

        System.out.println();

        OlivieOil olivieOil=new OlivieOil("Olivie oil",100);
        System.out.println(olivieOil.levelOfSpiced());
        System.out.println(olivieOil.getName() + " " + olivieOil.getMass() + " g - " + olivieOil.kkal() + "kkal");
        System.out.println(olivieOil.getName() + " has storage life " + olivieOil.storageLife() +
                " with storage temperature " + olivieOil.storageTemperature() + " C");

        System.out.println();

        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",300,olivieOil);
        System.out.println(greeceSalad.cut());
        System.out.println(greeceSalad.inningWithSause());
        System.out.println(greeceSalad.getName() + " " + greeceSalad.getMass() + " g - " + greeceSalad.kkal() + "kkal");
        System.out.println(greeceSalad.getName() + " has storage life " + greeceSalad.storageLife() +
                " with storage temperature " + greeceSalad.storageTemperature() + " C");

        System.out.println();

        GrilledShrimps grilledShrimps = new GrilledShrimps("grilled shrimps",250,olivieOil);
        System.out.println(grilledShrimps.InningsWith());
        System.out.println(grilledShrimps.inningWithSause());
        System.out.println(grilledShrimps.getName() + " " + grilledShrimps.getMass() + " g - " + grilledShrimps.kkal() + "kkal");
        System.out.println(grilledShrimps.getName() + " have storage life " + grilledShrimps.storageLife() +
                " with storage temperature " + grilledShrimps.storageTemperature() + " C");

        System.out.println();

        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        System.out.println(beer.bokal());
        System.out.println(beer.inningsTemperature(6));
        System.out.println(beer.appetazerTo());
        System.out.println(beer.getName() + " " + beer.getMass() + " g - " + beer.kkal() + "kkal");

        System.out.println();

        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        System.out.println(mushroomSoup.inningWith());
        System.out.println(mushroomSoup.getName() + " " + mushroomSoup.getMass() + " g - " + mushroomSoup.kkal() + "kkal");
        System.out.println(mushroomSoup.getName() + " has storage life " + mushroomSoup.storageLife() +
                " with storage temperature " + mushroomSoup.storageTemperature() + " C");

        System.out.println();

        Olivie olivie=new Olivie("Salad Olivie",250);
        System.out.println(olivie.cut());
        System.out.println(olivie.inningWithSause());
        System.out.println(olivie.getName() + " " + olivie.getMass() + " g - " + olivie.kkal() + "kkal");
        System.out.println(olivie.getName() + " has storage life " + olivie.storageLife() +
                " with storage temperature " + olivie.storageTemperature() + " C");

        System.out.println();

        Ragout ragout=new Ragout("Vegetable ragout",300,olivieOil);
        System.out.println(ragout.InningsWith());
        System.out.println(ragout.getName() + " " + ragout.getMass() + " g - " + ragout.kkal() + "kkal");
        System.out.println(ragout.getName() + " has storage life " + ragout.storageLife() +
                " with storage temperature " + ragout.storageTemperature() + " C");

        System.out.println();

        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",130);
        System.out.println(salmonTartar.cut());
        System.out.println(salmonTartar.inningWithSause());
        System.out.println(salmonTartar.getName() + " " + salmonTartar.getMass() + " g - " + salmonTartar.kkal() + "kkal");
        System.out.println(salmonTartar.getName() + " has storage life " + salmonTartar.storageLife() +
                " with storage temperature " + salmonTartar.storageTemperature() + " C");

        System.out.println();

        Steak steak=new Steak("Veal steak",350,ragout);
        System.out.println(steak.LevelOfGrilled("medium"));
        System.out.println(steak.InningsWith());
        System.out.println(steak.getName() + " " + steak.getMass() + " g - " + steak.kkal() + "kkal");


    }
}
