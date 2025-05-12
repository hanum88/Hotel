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
    //* rezervace na 6 nocí*//
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String fromDate = getFromDate().format(formatter);
        String toDate = getToDate().format(formatter);
        if (getOtherGuests().isEmpty()) {
           return "Pokoj číslo " + room.getRoomNr() + " je rezervovaný od: " + fromDate + " do: " + toDate + " na jméno: " + guest.getName() + " " + guest.getSurname();}
        else {
            String others = ""; //do stringu others skládám všechny spolubydlící. Chtělo by je oddělit čárkou, ale co pak s posledním záznamem? udělat nějakou podmínku, že když jde o poslední index tak nedávat na konec čárku ale tečku třeba.
            // nebo to dám pod sebe a vyřešeno zatím
            for (Guest g : getOtherGuests()) {
                       others += g.getName() + " " + g.getSurname() + "\n";
                       }
            return "Pokoj číslo " + room.getRoomNr() + " je rezervovaný od: " + fromDate + " do: " + toDate + " na jméno: " + guest.getName() + " " + guest.getSurname() + ".\nSpolubydlící jsou: \n" + others;
        }
    }
}

