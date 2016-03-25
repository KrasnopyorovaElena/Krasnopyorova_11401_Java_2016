package tests;


import Classes.*;
import Interfaces.Food;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class testsWithSpringConfig {


    //AppleJuiceTests
    @Test public void JuiceConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        AppleJuice appleJuice=(AppleJuice) ac.getBean("appleJuice");
     //   AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals("apple juice YA",appleJuice.getName());
    }

    @Test public void JuiceConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        AppleJuice appleJuice=(AppleJuice) ac.getBean("appleJuice");
      //  AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals(250,appleJuice.getMass());
    }

    @Test public void JuiceSumOfKkalShouldBeCorrect(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        AppleJuice appleJuice=(AppleJuice) ac.getBean("appleJuice");
       // AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals(250,appleJuice.kkal());
    }

    @Test public void JuiceMethodDecorateShouldShowCorrectLine(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        AppleJuice appleJuice=(AppleJuice) ac.getBean("appleJuice");
    //    AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals("Insert tube. Ready=)",appleJuice.decorateTo());

    }

    @Test public void JuiceMethodDecorateShouldShowCorrectLine1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        AppleJuice appleJuice=(AppleJuice) ac.getBean("appleJuice");
    //   AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals(appleJuice.getName() + " served in a highball.",appleJuice.bokal());

    }

    @Test public void JuiceMethodTemperatureShouldShowCorrectLine(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        AppleJuice appleJuice=(AppleJuice) ac.getBean("appleJuice");
      //  AppleJuice appleJuice=new AppleJuice("Apple juice YA",250);
        Assert.assertEquals(appleJuice.getName()+ " has inning temperature 15 C",appleJuice.inningsTemperature(15));

    }

    // BeerTests

    @Test public void BeerConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals( "Kozel Dark",beer.getName());
    }

    @Test public void BeerConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(700,beer.getMass());
    }

    @Test public void BeerConstructorShouldSetCorrectAppetazer(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=(GrilledShrimps) ac.getBean("grilledShrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals( grilledShrimps,beer.getAppetazer());
    }

    @Test public void BeerConstructorShouldSetCorrectAlcohol(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(true,beer.isAlcohol());
    }

    @Test public void BeerMethodAppetazerShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("Grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals("Excellent snack for " + beer.getName()+ " are " + grilledShrimps.getName(),beer.appetazerTo());
    }

    @Test public void BeerMethodBokalShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(beer.getName() + " served in a beer glass",beer.bokal());
    }

    @Test public void BeerMethodTemperatureShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(beer.getName()+ " has inning temperature 6 C",beer.inningsTemperature(6));
    }

    @Test public void BeerMethodKkalShouldBeCorrect(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(1540,beer.kkal());
    }

    @Test public void BeerMethodKkalShouldBeCorrect2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,false,grilledShrimps);
        Assert.assertEquals(1540,beer.kkal());
    }

    @Test public void BeerMethodDecorateShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        GrilledShrimps grilledShrimps=mock(GrilledShrimps.class);
        when(grilledShrimps.getName()).thenReturn("grilled Shrimps");
        Beer beer=(Beer) ac.getBean("beer");
//        Beer beer=new Beer("Kozel dark",330,true,grilledShrimps);
        Assert.assertEquals(null,beer.decorateTo());
    }

    //ChampangeTests

    @Test
    public void ChanpangeConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Champagne champagne=(Champagne) ac.getBean("champagne");
      //  Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals("Moet Chandon",champagne.getName());
    }

    @Test
    public void ChanpangeConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Champagne champagne=(Champagne) ac.getBean("champagne");
        //  Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals(700,champagne.getMass());
    }

    @Test
    public void ChanpangeKkalShouldBeCorrect(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Champagne champagne=(Champagne) ac.getBean("champagne");
        //Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals(1750,champagne.kkal());
    }

    @Test
    public void ChanpangeMethodBokalShouldShowCorrectLine(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Champagne champagne=(Champagne) ac.getBean("champagne");
        //Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals(champagne.getName() + " served in a glass flyute",champagne.bokal());
    }

    @Test
    public void ChanpangeMethodTemperatureShouldShowCorrectLine(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Champagne champagne=(Champagne) ac.getBean("champagne");
        //Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals("Ok. " + champagne.getName() +" will be served at 7 C.",champagne.inningsTemperature(7));
    }

    @Test
    public void ChanpangeMethodTemperatureShouldShowCorrectLine2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Champagne champagne=(Champagne) ac.getBean("champagne");
        //Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals("Unfortunately, "+ champagne.getName() +" isn't served at 12 C",champagne.inningsTemperature(12));
    }

    @Test
    public void ChanpangeMethodAppetazerShouldShowCorrectLine(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Champagne champagne=(Champagne) ac.getBean("champagne");
        //Champagne champagne=new Champagne("Moet Chandon",700);
        Assert.assertEquals("Excellent appetazer for " + champagne.getName()+ "are fruits",champagne.appetazerTo());
    }


    //Coffee
    @Test
    public void CoffeeConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("Americano");
        //Coffee coffee=new Coffee("Americano",100,tiramisu);
        Assert.assertEquals("Americano",coffee.getName());
    }

    @Test
    public void CoffeeConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("Americano");
        //Coffee coffee=new Coffee("Americano",100,tiramisu);
        Assert.assertEquals(200, coffee.getMass());
    }

    @Test
    public void CoffeeMethodBokalShouldShowCorrectLine(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("espresso");
//        Coffee coffee=new Coffee("Americano",100,tiramisu);
        Assert.assertEquals(coffee.getName() + " served in coffee cups", coffee.bokal());
    }

    @Test
    public void CoffeeMethodTemperatureShouldShowCorrectLine(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("Americano");
//        Coffee coffee=new Coffee("Americano",100,tiramisu);
        Assert.assertEquals(coffee.getName() + " served at 67 C", coffee.inningsTemperature(67));
    }

    @Test
    public void CoffeeMethodTemperatureShouldShowCorrectLine2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("Iced");
//        Coffee coffee=new Coffee("Iced",200,tiramisu);
        Assert.assertEquals(coffee.getName() +" served at less temperature than other coffee. It served at 50 C", coffee.inningsTemperature(67));
    }

    @Test
    public void CoffeeNotOverridingMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("Americano");
//        Coffee coffee = new Coffee("Americano", 200, tiramisu);
        Assert.assertTrue(coffee.storageTemperature() == 0 && coffee.storageLife() == 0 && coffee.decorateTo() == null);
    }


    @Test
    public void CoffeeKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("Americano");
//        Coffee coffee = new Coffee("Iced", 200, tiramisu);
        Assert.assertEquals(200, coffee.kkal());
    }

    @Test
    public void CoffeeKkalMethodsShouldBeCorrect2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("espresso");
//        Coffee coffee = new Coffee("Americano", 200, tiramisu);
        Assert.assertEquals(120, coffee.kkal());
    }

    @Test
    public void CoffeeKkalMethodsShouldBeCorrect3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("cappuccino");
//        Coffee coffee = new Coffee("cappuccino", 200, tiramisu);
        Assert.assertEquals(300, coffee.kkal());
    }

    @Test
    public void CoffeeKkalMethodsShouldBeCorrect4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu = mock(Tiramisu.class);
        when(tiramisu.getName()).thenReturn("tiramisu");
        Coffee coffee=(Coffee) ac.getBean("Iced");
//        Coffee coffee = new Coffee("espresso", 200, tiramisu);
        Assert.assertEquals(100, coffee.kkal());
    }

    //DoradoSoupTests

    @Test public void DoradoSoupConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        DoradoSoup doradoSoup=(DoradoSoup) ac.getBean("doradoSoup");
//        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals("Dorado Soup", doradoSoup.getName());
    }

    @Test public void DoradoSoupConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        DoradoSoup doradoSoup=(DoradoSoup) ac.getBean("doradoSoup");
//        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals(300, doradoSoup.getMass());
    }


    @Test public void BeerMethodInningWithShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        DoradoSoup doradoSoup=(DoradoSoup) ac.getBean("doradoSoup");
//        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals( doradoSoup.getName()+ " served with ciabatta.",doradoSoup.inningWith());
    }

    @Test
    public void DoradoSoupKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        DoradoSoup doradoSoup=(DoradoSoup) ac.getBean("doradoSoup");
//        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals(405, doradoSoup.kkal());
    }

    @Test
    public void DoradoSoupMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        DoradoSoup doradoSoup=(DoradoSoup) ac.getBean("doradoSoup");
//        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals(24,doradoSoup.storageLife());
    }

    @Test
    public void DoradoSoupMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        DoradoSoup doradoSoup=(DoradoSoup) ac.getBean("doradoSoup");
//        DoradoSoup doradoSoup=new DoradoSoup("Dorado soup",300);
        Assert.assertEquals(3,doradoSoup.storageTemperature());
    }

    //GreeceSaladTests

    @Test public void GreeceSaladConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=(GreeceSalad) ac.getBean("greeceSalad");
//        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals( "Greece Salad",greeceSalad.getName());
    }

    @Test public void GreeceSaladConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=(GreeceSalad) ac.getBean("greeceSalad");
//        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals(220,greeceSalad.getMass());
    }

    @Test public void GreeceSaladConstructorShouldSetCorrectSause(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
        GreeceSalad greeceSalad=(GreeceSalad) ac.getBean("greeceSalad");
//        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals(olivieOil ,greeceSalad.getSause());
    }

    @Test public void GreeceSaladMethodInningWithSauseShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("Olivie Oil");
        GreeceSalad greeceSalad=(GreeceSalad) ac.getBean("greeceSalad");
//        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals( "Classic "+ greeceSalad.getName()+ " served with " + olivieOil.getName(),greeceSalad.inningWithSause());
    }

    @Test public void GreeceSaladMethodCutShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        GreeceSalad greeceSalad=(GreeceSalad) ac.getBean("greeceSalad");
//        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals(greeceSalad.getName() + " cut into large cubes"
                ,greeceSalad.cut());
    }

    @Test
    public void GreeceSaladKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=(GreeceSalad) ac.getBean("greeceSalad");
//        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals(468 ,greeceSalad.kkal());
    }

    @Test
    public void GreeceSaladMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=(GreeceSalad) ac.getBean("greeceSalad");
//        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals( 12,greeceSalad.storageLife());
    }

    @Test
    public void GreeceSaladMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GreeceSalad greeceSalad=(GreeceSalad) ac.getBean("greeceSalad");
//        GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",250,olivieOil);
        Assert.assertEquals( 5,greeceSalad.storageTemperature());
    }

    //GrilledShrimpTests

    @Test public void GrilledShrimpsSoupConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals("Grilled Shrimps", grilledShrimps.getName());
    }

    @Test public void GrillegShrimpsConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(333, grilledShrimps.getMass());
    }

    @Test public void GrilledShrimpsConstructorShouldSetCorrectSause(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(olivieOil ,grilledShrimps.getSause());
    }

    @Test public void GrilledShrimpsMethodInningWithSauseShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("Olivie Oil");
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(grilledShrimps.getName() + " served with " + olivieOil.getName() + " or pesto sause",grilledShrimps.inningWithSause());
    }

    @Test public void GrilledShrimpsMethodInningWithShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(grilledShrimps.getName() + " served with grilled vegetables and lemon",
                grilledShrimps.InningsWith());
    }

    @Test
    public void GrilledShrimpsKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(519, grilledShrimps.kkal());
    }

    @Test
    public void GrilledShrimpsSoupMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(36, grilledShrimps.storageLife());
    }

    @Test
    public void GrilledShrimpsMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertEquals(15, grilledShrimps.storageTemperature());
    }

    @Test
    public void ShrimpsNotOverridingMethodsShouldBeCorrect(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("olivie oil");
        GrilledShrimps grilledShrimps =(GrilledShrimps) ac.getBean("grilledShrimps");
//        GrilledShrimps grilledShrimps=new GrilledShrimps("grilled shrimps",250,olivieOil);
        Assert.assertTrue(grilledShrimps.LevelOfGrilled("well done") == null && grilledShrimps.cut() == null);
    }

    //MushroomSoupTests

    @Test public void MushroomSoupConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        MushroomSoup mushroomSoup=(MushroomSoup) ac.getBean("mushroomSoup");
//        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals( "Mushroom Soup",mushroomSoup.getName());
    }

    @Test public void MushroomSoupConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        MushroomSoup mushroomSoup=(MushroomSoup) ac.getBean("mushroomSoup");
//        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals(210, mushroomSoup.getMass());
    }


    @Test public void MushroomSoupMethodInningWithShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        MushroomSoup mushroomSoup=(MushroomSoup) ac.getBean("mushroomSoup");
//        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals( mushroomSoup.getName() + " served with with croutons and truffle oil",mushroomSoup.inningWith());
    }

    @Test
    public void MushroomSoupKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        MushroomSoup mushroomSoup=(MushroomSoup) ac.getBean("mushroomSoup");
//        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals(522, mushroomSoup.kkal());
    }

    @Test
    public void MushroomSoupMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        MushroomSoup mushroomSoup=(MushroomSoup) ac.getBean("mushroomSoup");
//        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals(12, mushroomSoup.storageLife());
    }

    @Test
    public void MushroomSoupMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        MushroomSoup mushroomSoup=(MushroomSoup) ac.getBean("mushroomSoup");
//        MushroomSoup mushroomSoup=new MushroomSoup("Mushroom soup",200);
        Assert.assertEquals(6, mushroomSoup.storageTemperature());
    }

    //OlivieTests

    @Test public void OlivieConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Olivie olivie=(Olivie) ac.getBean("olivie");
//        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals( "Salad Olivie",olivie.getName());
    }

    @Test public void OlivieConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Olivie olivie=(Olivie) ac.getBean("olivie");
//        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals(100, olivie.getMass());
    }

    @Test public void OlivieMethodInningWithSauseShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Olivie olivie=(Olivie) ac.getBean("olivie");
//        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals( olivie.getName() + " served with mayonnaise sauce",
                olivie.inningWithSause());
    }

    @Test public void OlivieMethodCutShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Olivie olivie=(Olivie) ac.getBean("olivie");
//        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals(olivie.getName() + " cut into cubes"
                ,olivie.cut());
    }

    @Test
    public void OlivieKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Olivie olivie=(Olivie) ac.getBean("olivie");
//        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals(250 ,olivie.kkal());
    }

    @Test
    public void OlivieMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Olivie olivie=(Olivie) ac.getBean("olivie");
//        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals( 72,olivie.storageLife());
    }

    @Test
    public void OlivieMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Olivie olivie=(Olivie) ac.getBean("olivie");
//        Olivie olivie=new Olivie("Salad Olivie",350);
        Assert.assertEquals( 3,olivie.storageTemperature());
    }

    //OlivieOilTests

    @Test public void OlivieOilConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
//        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals( "Olivie Oil",olivieOil.getName());
    }

    @Test public void OlivieOilConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
//        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals(500, olivieOil.getMass());
    }


    @Test public void OlivieOilMethodLevelOfSpicedShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
//        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals(olivieOil.getName()+ " has bitter taste. It is not sharp."
                ,olivieOil.levelOfSpiced());
    }

    @Test
    public void OlivieOilKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
//        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals(1500 ,olivieOil.kkal());
    }

    @Test
    public void OlivieOilMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
//        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals( 6*30*24 ,olivieOil.storageLife());
    }

    @Test
    public void OlivieOilMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
//        OlivieOil olivieOil=new OlivieOil("olivie oil",100);
        Assert.assertEquals( 18,olivieOil.storageTemperature());
    }


    //RagoutTests


    @Test public void RagoutConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=(Ragout) ac.getBean("ragout");
//        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals("vegetable ragout", ragout.getName());
    }

    @Test public void RagoutConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=(Ragout) ac.getBean("ragout");
//        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(350, ragout.getMass());
    }

    @Test public void RagoutConstructorShouldSetCorrectSause(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=(OlivieOil) ac.getBean("olivieOil");
        Ragout ragout=(Ragout) ac.getBean("ragout");
//        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(olivieOil, ragout.getSause());
    }

    @Test public void RagoutsMethodInningWithShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        OlivieOil olivieOil=mock(OlivieOil.class);
        when(olivieOil.getName()).thenReturn("Olivie Oil");
        Ragout ragout=(Ragout) ac.getBean("ragout");
//        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(ragout.getName() + " served with tomato sause or " +olivieOil.getName(),
                ragout.InningsWith());
    }

    @Test public void RagoutsMethodLevelOfGrilledShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=(Ragout) ac.getBean("ragout");
//        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(null,
                ragout.LevelOfGrilled("no"));
    }

    @Test
    public void RagoutKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=(Ragout) ac.getBean("ragout");
//        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals(780 ,ragout.kkal()); //490.6
    }

    @Test
    public void RagoutSoupMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=(Ragout) ac.getBean("ragout");
//        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals( 72,ragout.storageLife());
    }

    @Test
    public void RagoutMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        OlivieOil olivieOil=mock(OlivieOil.class);
        Ragout ragout=(Ragout) ac.getBean("ragout");
//        Ragout ragout=new Ragout("vegetable ragout",220,olivieOil);
        Assert.assertEquals( 6,ragout.storageTemperature());
    }


    //SalmonTartarTests


    @Test public void TartarSoupConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        SalmonTartar salmonTartar=(SalmonTartar) ac.getBean("salmonTartar");
//        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals("Salmon Tartar", salmonTartar.getName());
    }

    @Test public void TartarConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        SalmonTartar salmonTartar=(SalmonTartar) ac.getBean("salmonTartar");
//        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals(120, salmonTartar.getMass());
    }


    @Test public void TartarMethodInningWithSauseShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        SalmonTartar salmonTartar=(SalmonTartar) ac.getBean("salmonTartar");
//        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals(salmonTartar.getName()+ " served with with ginger-soy sauce",
                salmonTartar.inningWithSause());
    }

    @Test public void TartarMethodCutShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        SalmonTartar salmonTartar=(SalmonTartar) ac.getBean("salmonTartar");
//        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals(salmonTartar.getName() +" cut into very small cubes",
                salmonTartar.cut());
    }

    @Test
    public void TartarKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        SalmonTartar salmonTartar=(SalmonTartar) ac.getBean("salmonTartar");
//        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals(180 ,salmonTartar.kkal());
    }

    @Test
    public void TartarSoupMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        SalmonTartar salmonTartar=(SalmonTartar) ac.getBean("salmonTartar");
//        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals( 12,salmonTartar.storageLife());
    }

    @Test
    public void TartarMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        SalmonTartar salmonTartar=(SalmonTartar) ac.getBean("salmonTartar");
//        SalmonTartar salmonTartar=new SalmonTartar("Salmon Tartar",150);
        Assert.assertEquals( 2,salmonTartar.storageTemperature());
    }


    //Steak


    @Test public void SteakConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        Food ragout=mock(Ragout.class);
        Steak steak=(Steak) ac.getBean("steak");
//        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals("Veal Steak", steak.getName());
    }

    @Test public void SteakConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        Food ragout=mock(Ragout.class);
        Steak steak=(Steak) ac.getBean("steak");
//        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals(200, steak.getMass());
    }

    @Test public void SteakConstructorShouldSetCorrectGarnish(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Food ragout=(Ragout) ac.getBean("ragout");
        Steak steak=(Steak) ac.getBean("steak");
//        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals(ragout ,steak.getGarnish());
    }

    @Test public void SteakMethodLevelOfGrilledShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
//        Food ragout=mock(Ragout.class);
        Steak steak=(Steak) ac.getBean("steak");
//        Steak steak=new Steak("Veal steak",350,ragout);
        String level="Medium Well";
        Assert.assertEquals(steak.getName() + " will be grilled " + level,
                steak.LevelOfGrilled(level));
    }

    @Test public void SteakMethodInningWithShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Food ragout=mock(Ragout.class);
        when(ragout.getName()).thenReturn("vegetable ragout");
        Steak steak=(Steak) ac.getBean("steak");
//        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals(steak.getName() + " served with garnish "+ ragout.getName()+ " and Rosso sause",
                steak.InningsWith());
    }

    @Test
    public void SteakKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Food ragout=mock(Ragout.class);
        when(ragout.getName()).thenReturn("vegetable ragout");
        Steak steak=(Steak) ac.getBean("steak");
//        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertEquals(600, steak.kkal());
    }

    @Test
    public void SteakNotOverridingShouldBeCorrect(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Food ragout=mock(Ragout.class);
        when(ragout.getName()).thenReturn("vegetable ragout");
        Steak steak=(Steak) ac.getBean("steak");
//        Steak steak=new Steak("Veal steak",350,ragout);
        Assert.assertTrue(steak.storageLife() == 0 && steak.storageTemperature() == 0);
    }


    //TiramisuTests


    @Test public void TiramisuConstructorShouldSetCorrectName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=(Tiramisu) ac.getBean("tiramisu");
        //Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals("Tiramisu", tiramisu.getName());
    }

    @Test public void TiramisuConstructorShouldSetCorrectMass(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=(Tiramisu) ac.getBean("tiramisu");
        //Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(200, tiramisu.getMass());
    }


    @Test public void TiramisuMethodGoodsForShouldShowCorrectline(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=(Tiramisu) ac.getBean("tiramisu");
        //Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(tiramisu.getName() + " - italian dessert, which is made from cookies Savoyardy " + tiramisu.getCoffee().getName(),
                tiramisu.goodsFor());
    }


    @Test
    public void TiramisuKkalMethodsShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=(Tiramisu) ac.getBean("tiramisu");
        //Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(660 ,tiramisu.kkal());
    }

    @Test
    public void TiramisuMethodStorageLifeShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=(Tiramisu) ac.getBean("tiramisu");
        //Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(72, tiramisu.storageLife());
    }

    @Test
    public void TiramisuMethodStorageTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=(Tiramisu) ac.getBean("tiramisu");
        //Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(5, tiramisu.storageTemperature());
    }


    @Test
    public void TiramisuMethodInningTemperatureShouldBeCorrect() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Tiramisu tiramisu=(Tiramisu) ac.getBean("tiramisu");
//      Tiramisu tiramisu=new Tiramisu("Tiramisu",175);
        Assert.assertEquals(9, tiramisu.inningsTemperature());
    }


}
