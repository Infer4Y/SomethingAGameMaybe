package inferno.bamr;

import inferno.sgle.internet.*;

import java.util.Base64;

public class Main {
    static ServerInstance serverInstance = new ServerInstance();

    static ClientInstance clientInstance = new ClientInstance();

    public static void main(String[] args) {
        System.out.println(clientInstance.senderIGuess.getInetAddress().toString());
        System.out.println(serverInstance.listener.getInetAddress().toString());
        GamePacket packetToSend = new GamePacket();
        packetToSend.type = PacketType.CHAT;
        packetToSend.addData(new Data("USER", "4452367-124"));
        packetToSend.addData(new Data("TEXT", "Testing testing."));
        while (true) {

            clientInstance.sentPacket(packetToSend);
            System.out.println("Send/Result");
            System.out.println(new String(Base64.getDecoder().decode(packetToSend.toString())));
            System.out.println(new String(Base64.getDecoder().decode(serverInstance.listen().toString())));
        }
    }
}
