package at.fhv.lab1.commandclient.BookingDomain;

import at.fhv.lab1.commandclient.BookRoomCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private RoomRepository roomRepository;

    public boolean bookRoom(BookRoomCommand command) throws Exception {
        Optional<Booking> existingRoomOpt = roomRepository.findRoomByNumber(command.getRoomNumber());

        if (existingRoomOpt.isPresent()) {
            Booking room = existingRoomOpt.get();
            List<LocalDate> bookedDates = room.getBookedDates();

            for (LocalDate date = command.getStart(); !date.isAfter(command.getEnd()); date = date.plusDays(1)) {
                if (bookedDates.contains(date)) {
                    throw new Exception("Room is already booked for this date: " + date);
                }
            }

            for (LocalDate date = command.getStart(); !date.isAfter(command.getEnd()); date = date.plusDays(1)) {
                bookedDates.add(date);
            }

            System.out.println("Room booked: " + command);
            return true;
        } else {
            throw new Exception("No room found with number: " + command.getRoomNumber());
        }
    }
}
