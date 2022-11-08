import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainScanner {
    public static void main(String[] args) {
        Event event = new Event();
        Planner planner = new Planner();

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("Выберите пункт меню: ");
                printMenu();
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            addTask(scanner, event, planner);
                            break;
                        case 2:
                            deleteTask(scanner, planner);
                            break;
                        case 3:
                            printTasksForTheDate(scanner, planner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }

    }
    private static void printMenu() {
        System.out.println("1 Добавить задачу \n" +
                            "2 Удалить задачу \n" +
                            "3 Получить задачу на указанный день \n" +
                            "0 Выход " );

    }
    private static void addTask(Scanner scanner, Event event, Planner planner) {

        System.out.print("Что произойдет? ");
        String heading = scanner.next().concat(scanner.nextLine());
        event.setHeading(heading);

        System.out.print("Подробности: ");
        String description = scanner.nextLine();
        event.setDescription(description);
        // написать условия проверки на случай если ввели не инт или инт не из списка, что бы программа возвращала нас к началу выбора
        System.out.println("1 личное \n" + "2 рабочее ");
        if (scanner.hasNextInt()) {
            int type = scanner.nextInt();
                switch (type) {
                    case 1:
                        event.setEventType(Event.EventType.PERSONAL);
                        break;
                    case 2:
                        event.setEventType(Event.EventType.WORKER);
                        break;
                }
        }
        //написать условия проверки на случай если ввели  не инт или инт не из списка, что бы программа возвращала нас к началу выбора.
        System.out.println("Повторять? \n" + "1 Нет \n" + "2 Ежедневно \n" + "3 Еженедельно \n" + "4 Ежемесячно \n" + "5 Ежегодно ");
        if (scanner.hasNextInt()) {
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    event.setRepeat(Event.Repeat.ONE_TIME);
                    break;
                case 2:
                    event.setRepeat(Event.Repeat.DAILY);
                    break;
                case 3:
                    event.setRepeat(Event.Repeat.WEEKLY);
                    break;
                case 4:
                    event.setRepeat(Event.Repeat.MONTHLY);
                    break;
                case 5:
                    event.setRepeat(Event.Repeat.ANNUAL);
                    break;
            }
        }
        // написать условия проверки что бы при неверном формате введения пользователем программа предлагала ввести дату заново
        System.out.print("Когда? (введите в формате ГГГГ-ММ-ДД) ");
        LocalDate date = LocalDate.parse(scanner.next());
        event.setDate(date);
        // написать условия проверки что бы при неверном формате введения пользователем программа предлагала ввести время заново
        System.out.print("Во сколько? (введите в формате ЧЧ:ММ) ");
        LocalTime time = LocalTime.parse(scanner.next());
        event.setTime(time);

        planner.addEvent(event);
        }
    private static void deleteTask(Scanner scanner, Planner planner){
        System.out.print("Для удаления введите номер эвента ");
        Integer Key = scanner.nextInt();
        //написать условия проверки на случай если ввели неверный ключ/или не существующий, что бы программа снова предложила ввести ключ
        planner.deleteEvent(Key);
    }
    private static void printTasksForTheDate(Scanner scanner, Planner planner){
        System.out.print("На какую дату желаете посмотреть полный список эвентов? (введите в формате ГГГГ-ММ-ДД) ");
        LocalDate date = LocalDate.parse(scanner.next());
        // написать условия проверки на случай если ввели дату на которую нет событий.
        System.out.println();
        planner.printPlannerForTheDate(date);
        System.out.println();
    }
}

