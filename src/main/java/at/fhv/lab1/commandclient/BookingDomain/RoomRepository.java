package at.fhv.lab1.commandclient.BookingDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {

    private final List<Booking> rooms = new ArrayList<>();


    public Optional<Booking> findRoomByNumber(String roomNumber){
        return rooms.stream().filter(room -> room.getRoomNumber().equals(roomNumber)).findFirst();
    }

    public void addRoom(Booking room){
        System.out.println("The room with the following ID was added to the repository: " + room.getRoomNumber());
        rooms.add(room);
    }
}
