import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Planner {
    Map<Integer, Event> planner;
    public Planner() {planner = new HashMap<>();}
    public Map<Integer, Event> getPlanner() {return planner;}
    @Override
    public String toString() {return "" + planner.values();}

    public void addEvent(Event event) {
        planner.put(event.getId(), event);
        if (event.getRepeat() == Event.Repeat.ANNUAL) {
            for (int i = 1; i < 10; i++) {
                Event copy = new Event(event.getHeading(), event.getDescription(), event.getEventType(), event.getRepeat(), event.getDate(), event.getTime());
                copy.setDate(copy.getDate().plusYears(i));
                planner.put(copy.getId(), copy);
            }
        }
        if (event.getRepeat() == Event.Repeat.MONTHLY) {
                for (int i = 1; i < 12; i++) {
                    Event copy = new Event(event.getHeading(), event.getDescription(), event.getEventType(), event.getRepeat(), event.getDate(), event.getTime());
                    copy.setDate(copy.getDate().plusMonths(i));
                    planner.put(copy.getId(), copy);
                }
        }
        if (event.getRepeat() == Event.Repeat.WEEKLY) {
            for (int i = 1; i < 8; i++) {
                Event copy = new Event(event.getHeading(), event.getDescription(), event.getEventType(), event.getRepeat(), event.getDate(), event.getTime());
                copy.setDate(copy.getDate().plusWeeks(i));
                planner.put(copy.getId(), copy);
            }
        }
        if (event.getRepeat() == Event.Repeat.DAILY) {
            for (int i = 1; i < 7; i++) {
                Event copy = new Event(event.getHeading(), event.getDescription(), event.getEventType(), event.getRepeat(), event.getDate(), event.getTime());
                copy.setDate(copy.getDate().plusDays(i));
                planner.put(copy.getId(), copy);
            }
        }
    }

    public void deleteEvent(Integer key){planner.remove(key);}

    public void printPlannerForTheDate(LocalDate localDate) {
        for (Map.Entry<Integer, Event> list: getPlanner().entrySet()){
            if(list.getValue().getDate().isEqual(localDate)){
                System.out.println(list.getValue());
            }
        }
    }

}
