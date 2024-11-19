//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        int port = 6969;
        int bomba = new Random().nextInt(100)+1;
        try (ServerSocket ss = new ServerSocket(port)) {
            System.out.println("Server in ascolto sulla porta " + port);

            Socket cs = ss.accept();
            System.out.println("Connessione stabilita con il client");

            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

            while (bomba != 0){
                System.out.println(bomba);
                bomba--;
                out.println(bomba);
                bomba = Integer.parseInt(in.readLine());
            }

            cs.close();
            in.close();
            out.close();
            System.out.println("Connessione con il Client chiusa.");

        } catch (IOException e) {
            System.err.println("Errore nella comunicazione: " + e.getMessage());
        }
    }
}