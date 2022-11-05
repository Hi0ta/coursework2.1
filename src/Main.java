import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
    Event event1 = new Event("обед", "война войной, обед по расписанию", Event.EventType.PERSONAL, Event.Repeat.DAILY, LocalDate.of(2022, 10, 28), LocalTime.of(13, 30));
    Event event2 = new Event("завтрак", " завтрак съешь сам, обед подели с другом, а ужин отдай врагу", Event.EventType.PERSONAL, Event.Repeat.DAILY, LocalDate.of(2022, 10, 28), LocalTime.of(10, 30));
    Event event3 = new Event("ужин", "вовремя не уснул, считай опять обожрался", Event.EventType.PERSONAL, Event.Repeat.DAILY, LocalDate.of(2022, 10, 28), LocalTime.of(18, 30));
    Event event4 = new Event("вебинар", "разбор домашки", Event.EventType.WORKER, Event.Repeat.WEEKLY, LocalDate.of(2022, 10, 30), LocalTime.of(14,00));
    Event event5 = new Event("комуналка", "нужно передать показания счетчиков и оплатить счета", Event.EventType.PERSONAL, Event.Repeat.MONTHLY, LocalDate.of(2022, 10, 28), null);
    Event event6 = new Event("Днюха", "поздравить друга", Event.EventType.PERSONAL, Event.Repeat.ANNUAL, LocalDate.of(2022, 10, 28), LocalTime.of(17, 00));
    Event event7 = new Event("встреча", "собеседование", Event.EventType.WORKER, Event.Repeat.ONE_TIME, LocalDate.of(2022, 10, 27), LocalTime.of(15,00));
        //System.out.println(event1);
        //System.out.println(event2);
        //System.out.println(event3);
        //System.out.println(event4);
        //System.out.println(event5);
        //System.out.println(event6);
        //System.out.println(event7);
        Planner planner = new Planner();
        planner.addEvent(event7);
        planner.addEvent(event6);
        planner.addEvent(event5);
        planner.addEvent(event4);
        planner.addEvent(event3);
        planner.addEvent(event2);
        planner.addEvent(event1);
        System.out.println();
        //planner.deleteEvent(50);
        for (Map.Entry<Integer, Event> list: planner.getPlanner().entrySet()){
            System.out.println(list.getValue());
        }
        System.out.println();
        System.out.println();
        planner.printPlannerForTheDate(LocalDate.of(2022, 10, 27));
    }
}