package inferno.sgle.internet;

import java.io.IOException;
import java.net.Socket;

public class ClientInstance {
    public Socket senderIGuess;

    public ClientInstance() {
        try {
            senderIGuess = new Socket("127.0.0.1",27015);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientInstance(String ip, int port) {
        try {
            senderIGuess = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sentPacket(GamePacket packet){
        try {
            senderIGuess.getOutputStream().write(packet.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
