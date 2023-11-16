import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket sock = null;

            try {
            if (args.length == 0) {
                sock = new Socket("localhost", 3000);
            } else if (args.length == 1) {
                int port = Integer.parseInt(args[0]);
                sock = new Socket("localhost", port);
            } else if (args.length == 2) {
                String serverName = args[0];
                ///tis means first entry
                int port = Integer.parseInt(args[1]);
                sock = new Socket(serverName, port);
            } else {
                System.out.println("Invalid number of parameters");
                System.exit(1);
            }

            InputStreamReader isr = new InputStreamReader(sock.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            OutputStreamWriter osw = new OutputStreamWriter(sock.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            Console cons = System.console();
            boolean stop = false;

            while (!stop) {
                String line = cons.readLine("> ");
                line = line.trim();
                stop = "exit".equals(line);
                bw.write(line + "\n");
                bw.flush();
                if (stop) continue;
                line = br.readLine();
                System.out.printf(">> result: %s\n", line);
            }

        } catch (IOException e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        } finally {
            try {
                if (sock != null) {
                    sock.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}
