package tests;


import Classes.*;
import Interfaces.Food;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class tests {


    //AppleJuiceTests
    @Test public void JuiceConstructorShouldSetCorrectName(){
        AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals("Apple juice YA",appleJuice.getName());
    }

    @Test public void JuiceConstructorShouldSetCorrectMass(){
        AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals(250,appleJuice.getMass());
    }

    @Test public void JuiceSumOfKkalShouldBeCorrect(){
        AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals(250,appleJuice.kkal());
    }

    @Test public void JuiceMethodDecorateShouldShowCorrectLine(){
        AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals("Insert tube. Ready=)",appleJuice.decorateTo());

    }

    @Test public void JuiceMethodDecorateShouldShowCorrectLine1(){
        AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals(appleJuice.getName() + " served in a highball.",appleJuice.bokal());

    }

    @Test public void JuiceMethodTemperatureShouldShowCorrectLine(){
        AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals(appleJuice.getName()+ " has inning temperature 15 C",appleJuice.inningsTemperature(15));

    }

    // BeerTests

    @Test public void BeerConstructorShouldSetCorrectName(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals( "Kozel dark",beer.getName());
    }

    @Test public void BeerConstructorShouldSetCorrectMass(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(330,beer.getMass());
    }

    @Test public void BeerConstructorShouldSetCorrectAppetazer(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals( grilledShrimps,beer.getAppetazer());
    }

    @Test public void BeerConstructorShouldSetCorrectAlcohol(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(true,beer.isAlcohol());
    }

    @Test public void BeerMethodAppetazerShouldShowCorrectline(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals("Excellent snack for " + beer.getName()+ " are " + grilledShrimps.getName(),beer.appetazerTo());
    }

    @Test public void BeerMethodBokalShouldShowCorrectline(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(beer.getName() + " served in a beer glass",beer.bokal());
    }

    @Test public void BeerMethodTemperatureShouldShowCorrectline(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(beer.getName()+ " has inning temperature 6 C",beer.inningsTemperature(6));
    }

    @Test public void BeerMethodKkalShouldBeCorrect(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(726,beer.kkal());
    }

    @Test public void BeerMethodKkalShouldBeCorrect2(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,false,grilledShrimps);
        Assert.assertEquals(429,beer.kkal());
    }

    @Test public void BeerMethodDecorateShouldShowCorrectline(){
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(null,beer.decorateTo());
    }

    //ChampangeTests

    @Test
      public void ChanpangeConstructorShouldSetCorrectName(){
        Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals("Moet Chandon",champagne.getName());
    }

    @Test
    public void ChanpangeConstructorShouldSetCorrectMass(){
        Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals(700,champagne.getMass());
    }

    @Test
    public void ChanpangeKkalShouldBeCorrect(){
        Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals(1750,champagne.kkal());
    }

    @Test
    public void ChanpangeMethodBokalShouldShowCorrectLine(){
        Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals(champagne.getName() + " served in a glass flyute",champagne.bokal());
    }

    @Test
    public void ChanpangeMethodTemperatureShouldShowCorrectLine(){
        Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals("Ok. " + champagne.getName() +" will be served at 7 C.",champagne.inningsTemperature(7));
    }

    @Test
    public void ChanpangeMethodTemperatureShouldShowCorrectLine2(){
        Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals("Unfortunately, "+ champagne.getName() +" isn't served at 12 C",champagne.inningsTemperature(12));
    }

    @Test
    public void ChanpangeMethodAppetazerShouldShowCorrectLine(){
        Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals("Excellent appetazer for " + champagne.getName()+ "are fruits",champagne.appetazerTo());
    }


    //Coffee
    @Test
      public void CoffeeConstructorShouldSetCorrectName(){
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=new Coffee("Americano",100,tiramisu);
        Assert.assertEquals("Americano",coffee.getName());
    }

    @Test
    public void CoffeeConstructorShouldSetCorrectMass(){
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=new Coffee("Americano",100,tiramisu);
        Assert.assertEquals(100, coffee.getMass());
    }

    @Test
    public void CoffeeMethodBokalShouldShowCorrectLine(){
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=new Coffee("Americano",100,tiramisu);
        Assert.assertEquals(coffee.getName() + " served in coffee cups", coffee.bokal());
    }

    @Test
    public void CoffeeMethodTemperatureShouldShowCorrectLine(){
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=new Coffee("Americano",100,tiramisu);
        Assert.assertEquals(coffee.getName() + " served at 67 C", coffee.inningsTemperature(67));
    }

    @Test
    public void CoffeeMethodTemperatureShouldShowCorrectLine2(){
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=new Coffee("iced",200,tiramisu);
        Assert.assertEquals(coffee.getName() +" served at less temperature than other coffee. It served at 50 C", coffee.inningsTemperature(67));
    }

    @Test
    public void CoffeeNotOverridingMethodsShouldBeCorrect() {
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee = new Coffee("Americano", 200, tiramisu);
        Assert.assertTrue(coffee.storageTemperature() == 0 && coffee.storageLife() == 0 && coffee.decorateTo() == null);
    }


    @Test
    public void CoffeeKkalMethodsShouldBeCorrect() {
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee = new Coffee("Iced", 200, tiramisu);
        Assert.assertEquals(520, coffee.kkal());
    }

    @Test
      public void CoffeeKkalMethodsShouldBeCorrect2() {
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee = new Coffee("Americano", 200, tiramisu);
        Assert.assertEquals(200, coffee.kkal());
    }

    @Test
    public void CoffeeKkalMethodsShouldBeCorrect3() {
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee = new Coffee("cappuccino", 200, tiramisu);
        Assert.assertEquals(300, coffee.kkal());
    }

    @Test
    public void CoffeeKkalMethodsShouldBeCorrect4() {
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee = new Coffee("espresso", 200, tiramisu);
        Assert.assertEquals(120, coffee.kkal());
    }

    //DoradoSoupTests

    @Test public void DoradoSoupConstructorShouldSetCorrectName(){
        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals("Dorado soup", doradoSoup.getName());
    }

    @Test public void DoradoSoupConstructorShouldSetCorrectMass(){
        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals(300, doradoSoup.getMass());
    }


    @Test public void BeerMethodInningWithShouldShowCorrectline(){
        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals( doradoSoup.getName()+ " served with ciabatta.",doradoSoup.inningWith());
    }

    @Test
    public void DoradoSoupKkalMethodsShouldBeCorrect() {
        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals(405, doradoSoup.kkal());
    }

    @Test
    public void DoradoSoupMethodStorageLifeShouldBeCorrect() {
        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals(24,doradoSoup.storageLife());
    }

    @Test
    public void DoradoSoupMethodStorageTemperatureShouldBeCorrect() {
        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals(3,doradoSoup.storageTemperature());
    }

    //GreeceSaladTests

    @Test public void GreeceSaladConstructorShouldSetCorrectName(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals( "Greece Salad",greeceSalad.getName());
    }

    @Test public void GreeceSaladConstructorShouldSetCorrectMass(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals(250,greeceSalad.getMass());
    }

    @Test public void GreeceSaladConstructorShouldSetCorrectSause(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals(olivieOil ,greeceSalad.getSause());
    }

    @Test public void GreeceSaladMethodInningWithSauseShouldShowCorrectline(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals( "Classic "+ greeceSalad.getName()+ " served with " + olivieOil.getName(),greeceSalad.inningWithSause());
    }

    @Test public void GreeceSaladMethodCutShouldShowCorrectline(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals(greeceSalad.getName() + " cut into large cubes"
                ,greeceSalad.cut());
    }

    @Test
    public void GreeceSaladKkalMethodsShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals(532 ,greeceSalad.kkal());
    }

    @Test
    public void GreeceSaladMethodStorageLifeShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals( 12,greeceSalad.storageLife());
    }

    @Test
    public void GreeceSaladMethodStorageTemperatureShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals( 5,greeceSalad.storageTemperature());
    }

    //GrilledShrimpTests

    @Test public void GrilledShrimpsSoupConstructorShouldSetCorrectName(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals("grilled shrimps", grilledShrimps.getName());
    }

    @Test public void GrillegShrimpsConstructorShouldSetCorrectMass(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(250, grilledShrimps.getMass());
    }

    @Test public void GrilledShrimpsConstructorShouldSetCorrectSause(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(olivieOil ,grilledShrimps.getSause());
    }

    @Test public void GrilledShrimpsMethodInningWithSauseShouldShowCorrectline(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(grilledShrimps.getName() + " served with " + olivieOil.getName() + " or pesto sause",grilledShrimps.inningWithSause());
    }

    @Test public void GrilledShrimpsMethodInningWithShouldShowCorrectline(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(grilledShrimps.getName() + " served with grilled vegetables and lemon",
                grilledShrimps.InningsWith());
    }

    @Test
    public void GrilledShrimpsKkalMethodsShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(390, grilledShrimps.kkal());
    }

    @Test
    public void GrilledShrimpsSoupMethodStorageLifeShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(36, grilledShrimps.storageLife());
    }

    @Test
    public void GrilledShrimpsMethodStorageTemperatureShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(15, grilledShrimps.storageTemperature());
    }

    @Test
       public void ShrimpsNotOverridingMethodsShouldBeCorrect(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertTrue(grilledShrimps.LevelOfGrilled("well done") == null && grilledShrimps.cut() == null);
    }

    //MushroomSoupTests

    @Test public void MushroomSoupConstructorShouldSetCorrectName(){
        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals( "Mushroom soup",mushroomSoup.getName());
    }

    @Test public void MushroomSoupConstructorShouldSetCorrectMass(){
        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals(200, mushroomSoup.getMass());
    }


    @Test public void MushroomSoupMethodInningWithShouldShowCorrectline(){
        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals( mushroomSoup.getName() + " served with with croutons and truffle oil",mushroomSoup.inningWith());
    }

    @Test
    public void MushroomSoupKkalMethodsShouldBeCorrect() {
        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals(498, mushroomSoup.kkal());
    }

    @Test
    public void MushroomSoupMethodStorageLifeShouldBeCorrect() {
        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals(12, mushroomSoup.storageLife());
    }

    @Test
    public void MushroomSoupMethodStorageTemperatureShouldBeCorrect() {
        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals(6, mushroomSoup.storageTemperature());
    }

    //OlivieTests

    @Test public void OlivieConstructorShouldSetCorrectName(){
        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals( "Salad Olivie",olivie.getName());
    }

    @Test public void OlivieConstructorShouldSetCorrectMass(){
        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals(350, olivie.getMass());
    }

    @Test public void OlivieMethodInningWithSauseShouldShowCorrectline(){
        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals( olivie.getName() + " served with mayonnaise sauce",
                olivie.inningWithSause());
    }

    @Test public void OlivieMethodCutShouldShowCorrectline(){
        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals(olivie.getName() + " cut into cubes"
                ,olivie.cut());
    }

    @Test
    public void OlivieKkalMethodsShouldBeCorrect() {
        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals(875 ,olivie.kkal());
    }

    @Test
    public void OlivieMethodStorageLifeShouldBeCorrect() {
        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals( 72,olivie.storageLife());
    }

    @Test
    public void OlivieMethodStorageTemperatureShouldBeCorrect() {
        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals( 3,olivie.storageTemperature());
    }

    //OlivieOilTests

    @Test public void OlivieOilConstructorShouldSetCorrectName(){
        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals( "olivie oil",olivieOil.getName());
    }

    @Test public void OlivieOilConstructorShouldSetCorrectMass(){
        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals(100, olivieOil.getMass());
    }


    @Test public void OlivieOilMethodLevelOfSpicedShouldShowCorrectline(){
        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals(olivieOil.getName()+ " has bitter taste. It is not sharp."
                ,olivieOil.levelOfSpiced());
    }

    @Test
    public void OlivieOilKkalMethodsShouldBeCorrect() {
        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals(300 ,olivieOil.kkal());
    }

    @Test
    public void OlivieOilMethodStorageLifeShouldBeCorrect() {
        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals( 6*30*24 ,olivieOil.storageLife());
    }

    @Test
    public void OlivieOilMethodStorageTemperatureShouldBeCorrect() {
        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals( 18,olivieOil.storageTemperature());
    }


    //RagoutTests


    @Test public void RagoutConstructorShouldSetCorrectName(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals("vegetable ragout", ragout.getName());
    }

    @Test public void RagoutConstructorShouldSetCorrectMass(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(220, ragout.getMass());
    }

    @Test public void RagoutConstructorShouldSetCorrectSause(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(olivieOil, ragout.getSause());
    }

    @Test public void RagoutsMethodInningWithShouldShowCorrectline(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(ragout.getName() + " served with tomato sause or " +olivieOil.getName(),
                ragout.InningsWith());
    }

    @Test public void RagoutsMethodLevelOfGrilledShouldShowCorrectline(){
        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(null,
                ragout.LevelOfGrilled("no"));
    }

    @Test
    public void RagoutKkalMethodsShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(490 ,ragout.kkal()); //490.6
    }

    @Test
    public void RagoutSoupMethodStorageLifeShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals( 72,ragout.storageLife());
    }

    @Test
    public void RagoutMethodStorageTemperatureShouldBeCorrect() {
        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals( 6,ragout.storageTemperature());
    }


    //SalmonTartarTests


    @Test public void TartarSoupConstructorShouldSetCorrectName(){
        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals("Salmon Tartar", salmonTartar.getName());
    }

    @Test public void TartarConstructorShouldSetCorrectMass(){
        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals(150, salmonTartar.getMass());
    }


    @Test public void TartarMethodInningWithSauseShouldShowCorrectline(){
        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals(salmonTartar.getName()+ " served with with ginger-soy sauce",
                salmonTartar.inningWithSause());
    }

    @Test public void TartarMethodCutShouldShowCorrectline(){
        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals(salmonTartar.getName() +" cut into very small cubes",
                salmonTartar.cut());
    }

    @Test
    public void TartarKkalMethodsShouldBeCorrect() {
        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals(225 ,salmonTartar.kkal());
    }

    @Test
    public void TartarSoupMethodStorageLifeShouldBeCorrect() {
        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals( 12,salmonTartar.storageLife());
    }

    @Test
    public void TartarMethodStorageTemperatureShouldBeCorrect() {
        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals( 2,salmonTartar.storageTemperature());
    }


    //Steak


    @Test public void SteakConstructorShouldSetCorrectName(){
        Food ragout=mock(Ragout.class);
        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals("Veal steak", steak.getName());
    }

    @Test public void SteakConstructorShouldSetCorrectMass(){
        Food ragout=mock(Ragout.class);
        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals(350, steak.getMass());
    }

    @Test public void SteakConstructorShouldSetCorrectGarnish(){
        Food ragout=mock(Ragout.class);
        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals(ragout ,steak.getGarnish());
    }

    @Test public void SteakMethodLevelOfGrilledShouldShowCorrectline(){
        Food ragout=mock(Ragout.class);
        Steak steak=new Steak("Veal steak",350,ragout);
        String level="Medium Well";
        Assert.assertEquals(steak.getName() + " will be grilled " + level,
                steak.LevelOfGrilled(level));
    }

    @Test public void SteakMethodInningWithShouldShowCorrectline(){
        Food ragout=mock(Ragout.class);
        when(ragout.getName()).thenReturn("vegetable ragout");
        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals(steak.getName() + " served with garnish "+ ragout.getName()+ " and Rosso sause",
                steak.InningsWith());
    }

    @Test
    public void SteakKkalMethodsShouldBeCorrect() {
        Food ragout=mock(Ragout.class);
        when(ragout.getName()).thenReturn("vegetable ragout");
        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals(1050, steak.kkal());
    }

    @Test
    public void SteakNotOverridingShouldBeCorrect(){
        Food ragout=mock(Ragout.class);
        when(ragout.getName()).thenReturn("vegetable ragout");
        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertTrue(steak.storageLife() == 0 && steak.storageTemperature() == 0);
    }


    //TiramisuTests


    @Test public void TiramisuConstructorShouldSetCorrectName(){
        Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals("Tiramisu", tiramisu.getName());
    }

    @Test public void TiramisuConstructorShouldSetCorrectMass(){
        Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(175, tiramisu.getMass());
    }


    @Test public void TiramisuMethodGoodsForShouldShowCorrectline(){
        Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(tiramisu.getName() + " - italian dessert, which is made from cookies Savoyardy " + tiramisu.getCoffee().getName(),
                tiramisu.goodsFor());
    }


    @Test
    public void TiramisuKkalMethodsShouldBeCorrect() {
        Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(577 ,tiramisu.kkal());
    }

    @Test
    public void TiramisuMethodStorageLifeShouldBeCorrect() {
        Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(72, tiramisu.storageLife());
    }

    @Test
    public void TiramisuMethodStorageTemperatureShouldBeCorrect() {
        Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(5, tiramisu.storageTemperature());
    }


    @Test
    public void TiramisuMethodInningTemperatureShouldBeCorrect() {
        Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(9, tiramisu.inningsTemperature());
    }


}
