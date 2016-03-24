import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@Configuration
public class Config {

  @Bean
    public Socket s1() throws IOException{
        Socket s1 = mock(Socket.class);
        byte [] bytes = new byte[]{5,6};
        ByteArrayInputStream is2= new ByteArrayInputStream(bytes);
        OutputStream os = mock(OutputStream.class);

        when(s1.getInputStream()).thenReturn(is2);
        when(s1.getOutputStream()).thenReturn(os);

        return s1;
    }

@Bean
    public Socket s2() throws IOException{
        Socket s2 = mock(Socket.class);
        byte [] bytes = new byte[]{5,6};
        ByteArrayInputStream is2= new ByteArrayInputStream(bytes);
        OutputStream os = mock(OutputStream.class);

        when(s2.getInputStream()).thenReturn(is2);
        when(s2.getOutputStream()).thenReturn(os);

        return s2;
    }

    @Bean
    public ServerThread st1()throws IOException{
        return new ServerThread(s1(),0);
    }

    @Bean
    public ServerThread st2() throws IOException{
        return new ServerThread(s2(),1);
    }

    @Bean
    public Game game() throws  IOException{
        return new Game(st1(),st2());
    }
}
