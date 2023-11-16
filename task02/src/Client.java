import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        
        System.out.println("Hit Enter to generate*");
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

            final InputStreamReader isr = new InputStreamReader(sock.getInputStream());
            final BufferedReader br = new BufferedReader(isr);
            final OutputStreamWriter osw = new OutputStreamWriter(sock.getOutputStream());
            final BufferedWriter bw = new BufferedWriter(osw);
            
            Console cons = System.console();
            boolean stop = false;
            
            while (!stop) {
                String line = cons.readLine("> ");
                for(int i=20;i>=0;i--){
                line = line.trim();
                stop = "exit".equals(line);
                bw.write(line + "1\n");
                bw.flush();
                if (stop) continue;
                line = br.readLine();
                System.out.printf(">> result: %s\n", line);}
            }

            

        } catch (IOException error) {
            System.err.println("Error connecting to the server: " + error.getMessage());
        } finally {
            try {
                if (sock != null) {
                    sock.close();
                }
            } catch (IOException error) {
                System.err.println("Error closing socket: " + error.getMessage());
            }
        }
    }
}
