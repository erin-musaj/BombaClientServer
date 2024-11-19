import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 6969;
        try (Socket s = new Socket(serverAddress, port)) {
            System.out.println("Connesso al server");

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            int bomba = 1;
            while (bomba != 0){
                bomba = Integer.parseInt(in.readLine());
                System.out.println(bomba);
                bomba--;
                out.println(bomba);
            }

            in.close();
            out.close();
            s.close();

            System.out.println("Connessione con il Server chiusa.");

        } catch (IOException e) {
            System.err.println("Errore nella comunicazione: " + e.getMessage());
        }
    }
}
