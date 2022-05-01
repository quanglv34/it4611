package lab01.client_server;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 80);
        BufferedReader in = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println(in.readLine());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();
            if(userInput == null || userInput.isEmpty()) {
                break;
            }

            out.println(userInput);
            System.out.println(in.readLine());
        }

        socket.close();
        scanner.close();
        System.out.println("Connection closed");

    }

}
