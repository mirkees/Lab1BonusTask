package at.fhv.lab1.commandclient.RoomDomain;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Room {

    private String content;
    private boolean isBarrierFree;
    

    public Room(String content, boolean isBarrierFree){
        this.content = content;
        this.isBarrierFree = isBarrierFree;
    }
}
