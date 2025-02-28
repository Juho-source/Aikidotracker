import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class AikidoTracker {
    private ArrayList<Object[]> practiceSessions;
    private int totalPracticeTime;

    public AikidoTracker() {
        practiceSessions = new ArrayList<>();
        totalPracticeTime = 0;
    }

    public static void main(String[] args) {
        AikidoTracker tracker = new AikidoTracker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Aikido Tracker === \n 1. Add practice session \n 2. Check graduation eligibility \n 3. Check total practice time \n 4. Exit");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Enter day:");
                    int day = scanner.nextInt();
                    System.out.println("Enter month:");
                    int month = scanner.nextInt();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    System.out.println("Enter duration in minutes:");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    LocalDate date = LocalDate.of(year, month, day);
                    tracker.addPracticeSession(date, duration);
                    System.out.println("Practice session added");
                    break;
                case "2":
                    System.out.println(tracker.checkGraduationEligibility() ? "Eligible for graduation" : "Not eligible for graduation");
                    break;
                case "3":
                    System.out.println("Total practice time: " + tracker.checkTotalPracticeTime() + " minutes");
                    break;
                case "4":
                    System.out.println("Exit");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public void addPracticeSession(LocalDate date, int duration) {
        practiceSessions.add(new Object[]{date, duration});
        totalPracticeTime += duration;
    }

    public boolean checkGraduationEligibility() {
        if (practiceSessions.size() >= 100) {
            return true;
        }

        if (practiceSessions.isEmpty()) {
            return false;
        }

        LocalDate firstDate = (LocalDate) practiceSessions.get(0)[0];
        LocalDate lastDate = firstDate;

        for (Object[] session : practiceSessions) {
            LocalDate sessionDate = (LocalDate) session[0];
            if (sessionDate.isBefore(firstDate)) {
                firstDate = sessionDate;
            }
            if (sessionDate.isAfter(lastDate)) {
                lastDate = sessionDate;
            }
        }

        return firstDate.plusMonths(6).isBefore(lastDate) || firstDate.plusMonths(6).isEqual(lastDate);
    }

    public int checkTotalPracticeTime() {
        return this.totalPracticeTime;
    }
}
