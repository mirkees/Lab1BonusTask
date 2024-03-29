package at.fhv.lab1.commandclient.BookingDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private RoomRepository roomRepository;
   

    public boolean bookRoom(BookRoomCommand command) throws Exception {
        Optional<Room> existingRoomOpt = roomRepository.findRoomByNumber(command.getRoomNumber());

        if (existingRoomOpt.isPresent()) {
            Room room = existingRoomOpt.get();
            if (room.getBookedDates().contains(command.getDate())) {
                throw new Exception("Room is already booked for this date: " + command.getDate());
                
            } else {
                room.getBookedDates().add(command.getDate());
                System.out.println("Room booked: " + command);
                return true;
            }
        } else {
            throw new Exception("No room found with number: " + command.getRoomNumber());
        }
       
    }
}
