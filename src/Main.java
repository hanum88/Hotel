import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* nastavení hostů */
        Guest guest1 = new Guest(LocalDate.of(1993, 3, 13), "Adéla", "Malíková");
        Guest guest2 = new Guest(LocalDate.of(1995, 5, 5), "Jan", "Dvořáček");

        /* změna guest2 + výpis */
        guest2.setBirthDate(LocalDate.of(1993, 4,5));
        System.out.println(guest2.getDescription());

        /* nastavení pokojů */
        Room room1 = new Room(1, true, true, 1000, 1);
        Room room2 = new Room(2, true, true, 1000, 1);
        Room room3 = new Room(3, true, false, 2400, 3);



        /* nastavení rezervací */
        List<Booking> bookings = new ArrayList<>();

        List<Guest> otherGuests1 = new ArrayList<>(); //prázdný seznam spolubydlících
        Booking booking1 = new Booking(guest1, room1, otherGuests1, LocalDate.of(2021,7,19), LocalDate.of(2021,7,26), Booking.TypeOfVacation.work );
        bookings.add(booking1);

        List<Guest> otherGuests2 = new ArrayList<>();
        otherGuests2.add(guest2);
        Booking booking2 = new Booking(guest1, room3, otherGuests2, LocalDate.of(2021, 9, 3), LocalDate.of(2021, 9, 14), Booking.TypeOfVacation.holiday);
        bookings.add(booking2);

        /* výpis rezervací */
        bookings.forEach(System.out::println);

        /*rezervace bez data začátku a konce + výpis */
        List<Guest> otherGuests3 = new ArrayList<>();
        otherGuests3.add(guest1);
        Guest otherGuest1 = new Guest(LocalDate.of(2000,05,15), "Milan", "Malý");
        otherGuests3.add(otherGuest1);
        Booking booking3 = new Booking(guest2, room2, otherGuests3);
        bookings.add(booking3);
        System.out.println( "\nvýpis rezervací - nově:");
        bookings.forEach(System.out::println);
        }
    }