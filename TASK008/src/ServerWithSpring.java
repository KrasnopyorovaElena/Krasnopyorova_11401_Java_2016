import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerWithSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigForMain.class);
        while(true) {
            System.out.println("Game is on!");
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game p = (Game) context.getBean("game");
            st1.setGame(p);
            st2.setGame(p);
            st1.start();
            st2.start();
        }
    }
}
