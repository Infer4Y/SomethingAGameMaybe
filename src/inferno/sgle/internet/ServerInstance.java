package inferno.sgle.internet;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerInstance {
    public ServerSocket listener;

    public ServerInstance() {
        try {
            this.listener = new ServerSocket(27015);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ServerInstance(int port) {
        try {
            this.listener = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GamePacket listen(){
        try {

            Socket returnCall = listener.accept();
            returnCall.getInetAddress().getHostAddress();
            return GamePacket.toPacket(new DataInputStream(returnCall.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
