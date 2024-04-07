package at.fhv.lab1.commandclient.RoomDomain;


import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {

private final List <Room> rooms = new ArrayList<>();


public void createRoom(Room room){
    rooms.add(room);
    System.out.println("Room was create with the following number: " + room.getRoomNumber());
}

public List <Room> getAllRooms(){
    return rooms;
}


}
