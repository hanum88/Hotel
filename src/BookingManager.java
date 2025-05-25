import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();

    //přidání jedné rezervace do seznamu
    public void addOneBooking(Guest guest, Room room, List otherGuests, LocalDate fromDate, LocalDate toDate, Booking.TypeOfVacation typeOfVacation) {
        Booking bookingTemporary = new Booking(guest, room, otherGuests, fromDate, toDate, typeOfVacation);
        bookingList.add(bookingTemporary);
    }

    //načtení jedné rezervace
    public Booking getBooking(int index) {
        return bookingList.get(index);
    }

    //načtení celého listu rezervací
    public List<Booking> getBookings() {
        return bookingList;
    }

    //smaž všechny rezervace
    public void clearBookings() {
        bookingList.clear();
    }

    //počet pracovních pobytů
    public int getNumberOfWorkingBookings() {
        int output = 0;
        Booking temporaryBooking;
        for (int i = 0; i < bookingList.size(); i++) {
            temporaryBooking = bookingList.get(i);
            if (temporaryBooking.getTypeOfVacation().equals("work")) {
                output++;
            } else {
            }
        }
        return output;
    }

    //průměrný počet hostů
    public double getAverageGuests() {
        double output = 0;
        Booking temporaryBooking;
        List<Guest> temporaryOtherGuests;
        if (bookingList.size() == 0) {
            output = 0;
        } else {
            for (int i = 0; i < bookingList.size(); i++) {
                temporaryBooking = bookingList.get(i);
                temporaryOtherGuests = temporaryBooking.getOtherGuests();
                output = output + 1 + temporaryOtherGuests.size();            //na hlavní rezervaci je vždycky 1 člověk, proto +1 a k tomu počet hostů v otherGuests.
            }
            output = output / (bookingList.size());
        }
        return output;
    }

    public List<Booking> getTopNHolidayBookings(int countOfBookings) {
        Booking temporaryBooking;
        List<Booking> outputList = new ArrayList<>();
        for (int i = 0; i < bookingList.size(); i++) {
            temporaryBooking = bookingList.get(i);
            if (outputList.size() <= (countOfBookings-1) && temporaryBooking.getTypeOfVacation().equals("holiday")) {
                outputList.add(temporaryBooking);
            } else {
            }
        }
        return outputList;
    }

    public void printGuestStatistics() {
        Booking temporaryBooking;

        int oneGuest = 0, twoGuests = 0, moreGuests = 0, guestsInReservation;
        if (bookingList.size() == 0) {
            System.out.println("Neexistují žádné rezervace.");
        } else {
            for (int i = 0; i < bookingList.size(); i++) {
                temporaryBooking = bookingList.get(i);
                guestsInReservation = 1 + temporaryBooking.getOtherGuests().size();
                switch (guestsInReservation) {
                    case 1:
                        oneGuest++;
                        break;
                    case 2:
                        twoGuests++;
                        break;
                    default:
                        moreGuests++;
                }
            }
            System.out.println("Celkový počet rezervací s jedním hostem: " + oneGuest);
            System.out.println("Celkový počet rezervací se dvěma hosty: " + twoGuests);
            System.out.println("Celkový počet rezervací s více než dvěma hosty: " + moreGuests);
        }
    }


}