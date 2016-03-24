import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ServerThread extends Thread {
    private Scanner sc;
    private PrintWriter pw;
    private Game p;
    private int number;

    public ServerThread(Socket s, int number) throws IOException {
        sc = new Scanner(s.getInputStream());
        pw = new PrintWriter(s.getOutputStream());
        this.number = number;
    }

    public void setGame(Game p) {
        this.p = p;
    }

    public void sendMessage(int p, String s) {
        pw.println("Player " + p + " said " + s);
        pw.flush();
    }

    public void sendMessage(String s) {
        pw.println(s);
        pw.flush();
    }

    public void run() {
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            p.getTurn(number, s);
        }
    }
}


