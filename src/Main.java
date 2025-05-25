import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
//bacha tu fillBookings musím mít před mainem, když jsem ju měla až po tak to za boha nefungovalo.
public class Main {
    private static BookingManager bookingManager = new BookingManager();

    public static void fillBookings (Guest guest, Room room, List<Guest> otherGuests, LocalDate fromDate, LocalDate toDate, Booking.TypeOfVacation typeOfVacation) {
        bookingManager.addOneBooking(guest, room, otherGuests, fromDate, toDate, typeOfVacation);
    }
    public static void main(String[] args) {
        // nastavení hostů
        //Guest guest1 = new Guest(LocalDate.of(1993, 3, 13), "Adéla", "Malíková");
        //Guest guest2 = new Guest(LocalDate.of(1995, 5, 5), "Jan", "Dvořáček");

        // změna guest2 + výpis
       // guest2.setBirthDate(LocalDate.of(1993, 4,5));
       // System.out.println(guest2.getDescription());

        //nastavení pokojů
        Room room1 = new Room(1, true, true, 1000, 1);
        Room room2 = new Room(2, true, true, 1000, 1);
        Room room3 = new Room(3, true, false, 2400, 3);



        /* nastavení rezervací */
        //List<Booking> bookings = new ArrayList<>();

        //List<Guest> otherGuests1 = new ArrayList<>(); //prázdný seznam spolubydlících
        //Booking booking1 = new Booking(guest1, room1, otherGuests1, LocalDate.of(2021,7,19), LocalDate.of(2021,7,26), Booking.TypeOfVacation.work );
        //bookings.add(booking1);

        //List<Guest> otherGuests2 = new ArrayList<>();
        //otherGuests2.add(guest2);
        //Booking booking2 = new Booking(guest1, room3, otherGuests2, LocalDate.of(2021, 9, 3), LocalDate.of(2021, 9, 14), Booking.TypeOfVacation.holiday);
        //bookings.add(booking2);

        /* výpis rezervací */
        //bookings.forEach(System.out::println);

        /*rezervace bez data začátku a konce + výpis */
        //List<Guest> otherGuests3 = new ArrayList<>();
        //otherGuests3.add(guest1);
        //Guest otherGuest1 = new Guest(LocalDate.of(2000,05,15), "Milan", "Malý");
        //otherGuests3.add(otherGuest1);
        //Booking booking3 = new Booking(guest2, room2, otherGuests3);
        //bookings.add(booking3);
        //System.out.println( "\nvýpis rezervací - nově:");
        //bookings.forEach(System.out::println);

        //druhý domácí úkol
            List<Guest> otherGuests1 = new ArrayList<>();
            Guest guest1 = new Guest(LocalDate.of(1990, 05,15), "Karel" , "Novák");
            fillBookings(guest1, room3, otherGuests1, LocalDate.of(2023,06,01), LocalDate.of(2023,06,07), Booking.TypeOfVacation.work);

            List<Guest> otherGuests2 = new ArrayList<>();
            Guest guest2 = new Guest(LocalDate.of(1979, 01,03), "Karel" , "Novák");
            bookingManager.addOneBooking(guest2, room2, otherGuests2, LocalDate.of(2023,07,18), LocalDate.of(2023,07,21), Booking.TypeOfVacation.holiday);

            List<Guest> otherGuests3 = new ArrayList<>();
            otherGuests3.add(guest1);
            Guest guest3 = new Guest(LocalDate.of(1992, 10,1), "Karolína" , "Tmavá");
            bookingManager.addOneBooking(guest3, room3, otherGuests3, LocalDate.of(2023, 8,1), LocalDate.of(2023,8,31), Booking.TypeOfVacation.work);

            //cyklus pro 10 rezervací
            LocalDate startDate = LocalDate.of(2023,8, 1);
            LocalDate endDate = LocalDate.of(2023,8,2);
            List<Guest> otherGuestsCycle = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                bookingManager.addOneBooking(guest3, room2, otherGuestsCycle, startDate, endDate, Booking.TypeOfVacation.holiday);
                startDate = startDate.plusDays(2);
                endDate = endDate.plusDays(2);
            }

        System.out.println("Počet pracovních pobytů: " + bookingManager.getNumberOfWorkingBookings());
        System.out.println("\nPrůměrný počet hostů: " + bookingManager.getAverageGuests());
        System.out.println("\nPrvních 8 rekreačních rezervací:");
        for (int i = 0; i < bookingManager.getTopNHolidayBookings(8).size(); i++) {
            System.out.println(bookingManager.getBooking(i).toString());
        }
        System.out.println("\nStatistiky hostů:");
        bookingManager.printGuestStatistics();
        System.out.println("\nFormátovaný výpis všech rezervací v systému:");
        for (int i = 0; i < bookingManager.getBookings().size(); i++) {
        System.out.println(bookingManager.getBookings().get(i).getFormattedSummary());
    }
        }
}

