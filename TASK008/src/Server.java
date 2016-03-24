
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4567);
        while(true) {
            System.out.println("Waiting for connections...");
            Socket s1 = ss.accept();
            System.out.println("First connection accepted");
            Socket s2 = ss.accept();
            System.out.println("Game is on!");
            ServerThread st1 = new ServerThread(s1,0);
            ServerThread st2 = new ServerThread(s2,1);
            Game p = new Game(st1, st2);
            st1.setGame(p);
            st2.setGame(p);
            st1.start();
            st2.start();
        }
    }
}

