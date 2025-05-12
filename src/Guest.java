import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Guest {
    private String name;
    private String surname;
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Guest(LocalDate birthDate, String name, String surname) {
        this.birthDate = birthDate;
        this.name = name;
        this.surname = surname;
    }
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("CZ"));
        String birthDateCZ = birthDate.format(formatter);
        return  name + " " + surname + " , datum narození: " + birthDateCZ;
    }

    //*vyřešeno getDescription
    // @Override
    //public String toString() {
    //    return name + " " + surname + " , datum narození: " + birthDate;} //
}
