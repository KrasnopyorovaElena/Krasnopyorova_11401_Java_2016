import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Configuration
public class ConfigForMain {

    @Bean
    public ServerSocket ss() throws IOException{
       return new ServerSocket(4567);
    }

    @Bean
    public Socket s1() throws IOException{
        return ss().accept();
    }

    @Bean
    public Socket s2() throws IOException{
        return ss().accept();
    }

    @Bean
    public ServerThread st1() throws IOException{
        return new ServerThread(s1(),0);
    }

    @Bean
    public ServerThread st2() throws IOException{
        return new ServerThread(s1(),1);
    }

    @Bean
    public Game game() throws IOException{
        return new Game(st1(),st2());
    }
}
