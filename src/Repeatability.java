import java.time.LocalDate;

public interface Repeatability {
        LocalDate getDaily();
        LocalDate getWeekly();
        LocalDate getMonthly();
        LocalDate getAnnual();

}
