package at.fhv.lab1.eventbus.events;

import java.time.LocalDate;



public class RoomBookedEvent {
    private String bookingID;
    private String customer;
    private String roomID;
    private String content;
    

    private LocalDate duration;

    public LocalDate getDuration() {
        return duration;
    }

    public void setDuration(LocalDate duration) {
        this.duration = duration;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public void setContent(String content){
        this.content = content;
    }


    public String getContent (){
        return content;
    }


    


    @Override
    public String toString() {
        return "RoomBookedEvent{" +
                "bookingID=" + bookingID +
                ", customer='" + customer + '\'' +
                ", roomID=" + roomID +
                ", duration=" + duration +
                '}';
    }
}
