package inferno.sgle.internet;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class GamePacket {
    public PacketType type;
    private List<Data> dataList = new ArrayList<>();

    public static GamePacket toPacket(DataInputStream stream) throws IOException {
        GamePacket buildingPacket = new GamePacket();
        String input = stream.readUTF();
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        String decodedString = "";
        for (int i = 0; i < decodedBytes.length; i++) {
            decodedString += decodedBytes[i];
        }

        String[] split = decodedString.split(";");

        String[] dataValue;

        String type = null;

        for (int i = 0; i < split.length; i++) {
            dataValue = split[i].split("=");
            if (dataValue.length == 2){
                if (dataValue[0].equals("TYPE")){
                    type = dataValue[1];
                } else {
                    buildingPacket.addData(new Data(dataValue[0], dataValue[1]));
                }
            }
        }

        buildingPacket.type = PacketType.valueOf(type);

        return buildingPacket;
    }

    public void addData(Data data){
        dataList.add(data);
    }

    public void clearData(){
        dataList.clear();
    }

    public List<Data> getDataList() {
        return dataList;
    }

    @Override
    public String toString() {
        String sendingString = "TYPE="+type.type+";";
        for(Data data : dataList){
            sendingString+=data.toString()+";";
        }
        sendingString+="END";
        return Base64.getEncoder().encodeToString(sendingString.getBytes());
    }
}
