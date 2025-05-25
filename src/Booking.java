import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Booking {
    private Guest guest;
    private Room room;
    private List<Guest> otherGuests;
    private LocalDate fromDate;
    private LocalDate toDate;
    private TypeOfVacation typeOfVacation;


    public Booking(Guest guest, Room room, List otherGuests, LocalDate fromDate, LocalDate toDate, TypeOfVacation typeOfVacation) {
        this.guest = guest;
        this.room = room;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.otherGuests = otherGuests;
        this.typeOfVacation = typeOfVacation;
    }

    // rezervace na 6 nocí
    public Booking(Guest guest, Room room, List otherGuests) {

        this.guest = guest;
        this.room = room;
        this.fromDate = LocalDate.now();
        this.toDate = this.fromDate.plusDays(6);
        this.otherGuests = otherGuests;
        this.typeOfVacation = TypeOfVacation.holiday;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }


    public List<Guest> getOtherGuests() {
        return otherGuests;
    }

    public enum TypeOfVacation {
        work,
        holiday
    }

    public String getTypeOfVacation() {
        return typeOfVacation.toString();
    }

    public int getBookingLength() {
        int output = fromDate.until(toDate).getDays();
        return output;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal output = BigDecimal.ZERO;
        output = BigDecimal.valueOf((getBookingLength()) * room.getRoomPrice());
        return output;
    }

   @Override
    public String toString() {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
       String fromDate = getFromDate().format(formatter);
       String toDate = getToDate().format(formatter);
       if (getOtherGuests().isEmpty()) {
           return "Pokoj číslo " + room.getRoomNr() + " je rezervovaný od: " + fromDate + " do: " + toDate + " na jméno: " + guest.getName() + " " + guest.getSurname();
       } else {
           String others = ""; //do stringu others skládám všechny spolubydlící. Chtělo by je oddělit čárkou, ale co pak s posledním záznamem? udělat nějakou podmínku, že když jde o poslední index tak nedávat na konec čárku ale tečku třeba.
           // nebo to dám pod sebe a vyřešeno zatím
           for (Guest g : getOtherGuests()) {
               others += g.getName() + " " + g.getSurname();
           }
           return "Pokoj číslo " + room.getRoomNr() + " je rezervovaný od: " + fromDate + " do: " + toDate + " na jméno: " + guest.getName() + " " + guest.getSurname() + ". Spolubydlící jsou: " + others;
       }
   }


    public String getFormattedSummary() {
        String output = "";
        output = (
                this.fromDate + " až " +
                this.toDate + ": " +
                this.guest.getDescription() + "[" +
                (1+otherGuests.size()) + ", " +
                this.room.hasSeaView() + "] za: " +
                getTotalPrice() + " Kč");


        //BookingManager bookingManager = null;
        //List<Booking> listOfBookings;
        //listOfBookings = bookingManager.getBookings();

        //if (listOfBookings.isEmpty()) {
        //    System.out.println("Seznam neobsahuje žádné rezervace");
        //} else {
        //    for (int i = 0; i < listOfBookings.size(); i++) {
        //output = (
        //       listOfBookings.get(i).getFromDate()
        //+ " až " +
        //        listOfBookings.get(i).getToDate()
        //        + ": " +
        //        listOfBookings.get(i).getGuest().getDescription()
        //        + "[" +
        //        listOfBookings.get(i).getOtherGuests().size()
        //        + "\n");


               //dodělat

          //  }

return output;
    }
}


