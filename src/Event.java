import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Event {
    public enum EventType{
        PERSONAL("личное"),
        WORKER("рабочее");

        private String name;
        EventType(String name) {
            this.name = name;
        }
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
    }
    public enum Repeat{
        ONE_TIME("однократно"),
        DAILY("ежедневно"),
        WEEKLY("еженедельно"),
        MONTHLY("ежемесячно"),
        ANNUAL("ежегодно");

        private String name;
        Repeat(String name) {
            this.name = name;
        }
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
    }
    private int id;
    private static int counter = 1;
    private String heading;
    private String description;
    private EventType eventType;
    private Repeat repeat;
    private LocalDate date;
    private LocalTime time;

    public Event() {
        this.id = counter++;
        this.heading = "Событие";
        this.description = "подробности";
        this.eventType = EventType.PERSONAL;
        this.repeat = Repeat.ONE_TIME;
        this.date = LocalDate.now();
        this.time = LocalTime.of(12, 00);
    }

    public Event(String heading, String description, EventType eventType, Repeat repeat, LocalDate date, LocalTime time) {
        this.id = counter++;
        this.setHeading(heading);
        this.setDescription(description);
        this.setEventType(eventType);
        this.setRepeat(repeat);
        this.setDate(date);
        this.setTime(time);
    }

    public int getId() {return id;}
    public String getHeading() {return heading;}
    public String getDescription() {return description;}
    public EventType getEventType() {return eventType;}
    public Repeat getRepeat() {return repeat;}
    public LocalDate getDate() {return date;}
    public LocalTime getTime() {return time;}

    public void setHeading(String heading) {
        if (heading == null || heading.isBlank()){
            throw new IllegalArgumentException("Заголовок обязательно должен быть заполнен");
        }else {
            this.heading = heading;
        }
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()){
            throw new IllegalArgumentException("Описание обязательно должно быть заполнено");
        }else {
            this.description = description;
        }
    }
    public void setEventType(EventType eventType) {
        if (eventType == null){
            throw new IllegalArgumentException("обязательно выберите один из двух существующих типов");
        }else {
            this.eventType = eventType;
        }
    }
    public void setRepeat(Repeat repeat) {
        if (repeat == null) {
            throw new IllegalArgumentException("обязательно выберите один из пяти существующих типов");
        } else {
            this.repeat = repeat;
        }
    }
    public void setDate(LocalDate date) {
        if (date == null) {
            this.date = LocalDate.now();
        } else {
            this.date = date;
        }
    }
    public void setTime(LocalTime time) {
        if (time == null) {
            this.time = LocalTime.of(12, 00);
        } else {
            this.time = time;
        }
    }

    @Override
    public int hashCode() {return Objects.hash(heading, description, date);}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return heading.equals(event.heading) && description.equals(event.description) && date.equals(event.date);
    }

    @Override
    public String toString() {
        return "Событие: " + " № " + id + ", что произойдет: " + heading + ", подробности: " + description +
                ", когда: " + date + ", во сколько: " + time + ", тип: " + eventType.name + ", повтор: " + repeat.name;
    }

}
