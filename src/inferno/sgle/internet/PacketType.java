package inferno.sgle.internet;

public enum PacketType {
    CHAT("CHAT"),
    COMMAND("COMMAND"),
    MOVEMENT("MOVEMENT"),
    LOGGING("LOGGING");

    String type;

    PacketType(String type){
        this.type=type;
    }
}
