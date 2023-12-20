import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ConcurrentHashMap;

public class RedisMain {

    public static void main(String[] args) throws IOException {
        ExecutorService scheduler = Executors.newCachedThreadPool();
        ServerSocket socket = new ServerSocket();
        socket.bind(new InetSocketAddress("0.0.0.0", 16379));

        System.out.println("App is listening on 0.0.0.0:16379");
        RedisClone clone = new RedisClone();
        while (true) {
            Socket client = socket.accept();
            scheduler.execute(() -> {
                try {
                    clone.handleConnection(client);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

class RedisClone {
    private final ConcurrentHashMap<String, String> state = new ConcurrentHashMap<>();

    public void handleConnection(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)) {

            List<String> args = new ArrayList<>();
            while (true) {
                args.clear();
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                if (line.charAt(0) != '*') {
                    throw new RuntimeException("Cannot understand arg batch: " + line);
                }

                int argsv = Integer.parseInt(line.substring(1));
                for (int i = 0; i < argsv; i++) {
                    line = reader.readLine();
                    if (line == null || line.charAt(0) != '$') {
                        throw new RuntimeException("Cannot understand arg length: " + line);
                    }
                    int argLen = Integer.parseInt(line.substring(1));
                    line = reader.readLine();
                    if (line == null || line.length() != argLen) {
                        throw new RuntimeException("Wrong arg length expected " + argLen + " got: " + line);
                    }

                    args.add(line);
                }

                String reply = executeCommand(args);
                if (reply == null) {
                    writer.write("$-1\r\n");
                } else {
                    writer.write("$" + reply.length() + "\r\n" + reply + "\r\n");
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String executeCommand(List<String> args) {
        switch (args.get(0)) {
            case "GET":
                return state.get(args.get(1));
            case "SET":
                state.put(args.get(1), args.get(2));
                return null;
            default:
                throw new IllegalArgumentException("Unknown command: " + args.get(0));
        }
    }
}
