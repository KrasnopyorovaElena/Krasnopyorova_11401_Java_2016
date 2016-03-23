package Spring;
import Classes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class Config {
        @Autowired
        private OlivieOil olivieOil;
        @Autowired
        private GrilledShrimps grilledShrimps;
        @Autowired
        private Tiramisu tiramisu;
        @Autowired
        Ragout ragout;


        @Bean
        public AppleJuice appleJuice(){
            AppleJuice appleJuice=new AppleJuice("Apple Juice Ya",250);
            return appleJuice;
        }

        @Bean
        public Champagne champagne(){
            Champagne champagne=new Champagne("Moet Chandon",700);
            return champagne;
        }

        @Bean
        public Tiramisu tiramisu(){
            Tiramisu tiramisu=new Tiramisu("Tiramisu",200);
            return tiramisu;
        }

        @Bean
        public Coffee coffee(){
            Coffee coffee=new Coffee("Iced",150,tiramisu);
            return coffee;
        }

        @Bean
        public DoradoSoup doradoSoup(){
            DoradoSoup doradoSoup=new DoradoSoup("Dorado Soup",330);
            return doradoSoup;
        }
        @Bean
        public OlivieOil olivieOil(){
            OlivieOil olivieOil=new OlivieOil("Olivie Oil",500);
            return olivieOil;
        }

        @Bean
        public GreeceSalad greeceSalad(){
            GreeceSalad greeceSalad=new GreeceSalad("Greece Salad",300,olivieOil);
            return greeceSalad;
        }

        @Bean
        public GrilledShrimps grilledShrimps(){
            GrilledShrimps grilledShrimps=new GrilledShrimps("Grilled Shrimps",400,olivieOil);
            return grilledShrimps;
        }

        @Bean
        public Beer beer(){
            Beer beer=new Beer("Kozel Dark",330,true,grilledShrimps);
            return beer;
        }

        @Bean
        public MushroomSoup mushroomSoup(){
            MushroomSoup mushroomSoup=new MushroomSoup("MushroomSoup",300);
            return mushroomSoup;
        }

        @Bean
        public Olivie olivie(){
            Olivie olivie=new Olivie("Salad Olivie",150);
            return olivie;
        }

        @Bean
        public Ragout ragout(){
            Ragout ragout=new Ragout("Vegetable ragout",320,olivieOil);
            return ragout;
        }

        @Bean
        public SalmonTartar salmonTartar(){
            SalmonTartar salmonTartar=new SalmonTartar("SalmonTartar",100);
            return salmonTartar;
        }

        @Bean
        public Steak steak(){
            Steak steak=new Steak("Veal steak",400,ragout);
            return steak;
        }
}
