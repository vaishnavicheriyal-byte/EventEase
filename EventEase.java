import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Activity {
    String name;
    String description;
    int registrationFee;
    int cashPrize;
    int capacity;
    String schedule;
    Map<String, String> participants = new LinkedHashMap<>();

    Activity(String name, String description, int registrationFee,
             int cashPrize, int capacity, String schedule) {
        this.name = name;
        this.description = description;
        this.registrationFee = registrationFee;
        this.cashPrize = cashPrize;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    void register(String studentId, String studentName) {
        if (studentId.isEmpty() || studentName.isEmpty()) {
            throw new IllegalArgumentException(
                "Student ID and name cannot be empty.");
        }

        String id = studentId.toLowerCase();

        if (participants.containsKey(id)) {
            throw new IllegalArgumentException(
                "You are already registered for this activity.");
        }

        if (participants.size() >= capacity) {
            throw new IllegalArgumentException(
                "Registration capacity is full.");
        }

        participants.put(id, studentName);
        System.out.println("\nRegistration successful!");
        System.out.println("Activity: " + name);
        System.out.println("Student: " + studentName);
        System.out.println("Student ID: " + studentId);
        System.out.println("Registration Fee: Rs. " + registrationFee);

        if (cashPrize > 0) {
            System.out.println("Cash Prize: Rs. " + cashPrize);
        }
    }

    void displayParticipants() {
        System.out.println("\nPARTICIPANT LIST: " + name);
        System.out.println("--------------------------------------");

        if (participants.isEmpty()) {
            System.out.println("No registrations yet.");
            return;
        }

        int count = 1;

        for (Map.Entry<String, String> entry
                : participants.entrySet()) {
            System.out.println(count++ + ". " + entry.getValue()
                    + " (ID: " + entry.getKey() + ")");
        }

        System.out.println("Total Participants: " + participants.size());
        System.out.println("Available Slots: "
                + (capacity - participants.size()));
    }
}

class CollegeEvent {
    String name;
    LocalDate startDate;
    LocalDate endDate;
    String venue;
    String organizer;
    String additionalDetails;
    List<Activity> activities = new ArrayList<>();

    CollegeEvent(String name, LocalDate startDate, LocalDate endDate,
                 String venue, String organizer,
                 String additionalDetails) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.venue = venue;
        this.organizer = organizer;
        this.additionalDetails = additionalDetails;
    }

    void addActivity(Activity activity) {
        activities.add(activity);
    }

    void displayDetails() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMMM yyyy");

        System.out.println("\n========================================");
        System.out.println(name.toUpperCase());
        System.out.println("========================================");
        System.out.println("Organizer: " + organizer);
        System.out.println("Venue: " + venue);
        System.out.println("Start Date: "
                + startDate.format(formatter));
        System.out.println("End Date: " + endDate.format(formatter));
        System.out.println("Details: " + additionalDetails);

        System.out.println("\nACTIVITIES:");

        for (int i = 0; i < activities.size(); i++) {
            Activity a = activities.get(i);

            System.out.println("\n" + (i + 1) + ". " + a.name);
            System.out.println("Description: " + a.description);
            System.out.println("Schedule: " + a.schedule);
            System.out.println("Registration Fee: Rs. "
                    + a.registrationFee);

            if (a.cashPrize > 0) {
                System.out.println("Cash Prize: Rs. " + a.cashPrize);
            }

            System.out.println("Registered: "
                    + a.participants.size() + "/" + a.capacity);
        }
    }
}

public class EventEase {
    static Scanner sc = new Scanner(System.in);
    static List<CollegeEvent> events = new ArrayList<>();

    public static void main(String[] args) {
        loadEvents();

        int choice = 0;

        while (choice != 6) {
            System.out.println("\n==========================================");
            System.out.println("        EVENTEASE - SNIST");
            System.out.println(" Sreenidhi Institute of Science and Technology");
            System.out.println("==========================================");
            System.out.println("1. View All Events");
            System.out.println("2. View Event Details");
            System.out.println("3. Register for an Event");
            System.out.println("4. View Participant List");
            System.out.println("5. View Contact Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        viewEvents();
                        break;
                    case 2:
                        viewEventDetails();
                        break;
                    case 3:
                        registerStudent();
                        break;
                    case 4:
                        viewParticipants();
                        break;
                    case 5:
                        viewContacts();
                        break;
                    case 6:
                        System.out.println("Thank you for using EventEase!");
                        break;
                    default:
                        System.out.println(
                            "Invalid choice. Enter a number from 1 to 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        sc.close();
    }

    static void loadEvents() {
        CollegeEvent ashwatthama = new CollegeEvent(
            "Ashwatthama 2026",
            LocalDate.of(2026, 10, 12),
            LocalDate.of(2026, 10, 17),
            "SNIST, Hyderabad",
            "Sports Club SNIST",
            "Sports festival under the Department of Physical Education."
        );

        ashwatthama.addActivity(new Activity(
            "Volleyball (Men)", "Men's volleyball tournament",
            2500, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Volleyball (Women)", "Women's volleyball tournament",
            2000, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Basketball (Men)", "Men's basketball tournament",
            3000, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Basketball (Women)", "Women's basketball tournament",
            2500, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Kho-Kho (Men)", "Men's Kho-Kho tournament",
            2500, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Kho-Kho (Women)", "Women's Kho-Kho tournament",
            2000, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Cricket (Men)", "Men's cricket tournament",
            5500, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Kabaddi (Men)", "Men's Kabaddi tournament",
            2500, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Kabaddi (Women)", "Women's Kabaddi tournament",
            2000, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Football (Men)", "Men's football tournament",
            4000, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Throwball (Women)", "Women's throwball tournament",
            2000, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Chess (Men/Women)", "Chess competition",
            1000, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Table Tennis (Men/Women)", "Table tennis competition",
            1500, 0, 100, "12-17 October"
        ));
        ashwatthama.addActivity(new Activity(
            "Carroms - Singles (Men/Women)", "Singles carroms competition",
            1000, 0, 100, "12-17 October"
        ));

        events.add(ashwatthama);

        CollegeEvent roboveda = new CollegeEvent(
            "Roboveda 2026",
            LocalDate.of(2026, 10, 12),
            LocalDate.of(2026, 10, 14),
            "SNIST, Hyderabad",
            "The Robotics Club SNIST",
            "Annual technical fest presented by Epiroc. "
                + "Website: https://www.roboveda.org"
        );

        roboveda.addActivity(new Activity(
            "Ranaveera", "Robot Combat - Open Category",
            0, 90000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Yantraa", "Speed Challenge - Open Category",
            0, 40000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Pushpak", "Drone Challenge - Open Category",
            0, 35000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Samanvayi", "Robotics Challenge - Open Category",
            0, 20000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Sarvaagami", "All-Terrain Robot Challenge",
            0, 20000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Yoddha", "Robo Sumo",
            0, 10000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Goalaa", "Goal Challenge",
            0, 20000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Lakshmanarekha", "Line Follower Bot",
            0, 20000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Gati", "Speed Challenge",
            0, 15000, 100, "12-14 October"
        ));
        roboveda.addActivity(new Activity(
            "Jaladhimatra", "Aqua Robot Challenge",
            0, 15000, 100, "12-14 October"
        ));

        events.add(roboveda);

        CollegeEvent sreevision = new CollegeEvent(
            "Sreevision 2026",
            LocalDate.of(2026, 10, 15),
            LocalDate.of(2026, 10, 17),
            "SNIST, Hyderabad",
            "AP Ranganandha Swamy Memorial, ISTE SNIST & ICSQUARE",
            "Cultural and creative fest. Cult Night on 17 October "
                + "from 5:00 PM onwards, with a surprise chief guest."
        );

        sreevision.addActivity(new Activity(
            "CICC Workshop",
            "Cinematography, Editing and Content Creation",
            59, 0, 100,
            "15-16 October, 10:00 AM onwards; Seminar Hall 1. "
                + "Solo fee Rs. 59; team fee Rs. 199 for 3-4 members."
        ));

        sreevision.addActivity(new Activity(
            "Beyond the Breadboards",
            "Electronics workshop: concepts, components, "
                + "circuit building, hardware programming and mini-projects",
            349, 0, 100,
            "15-16 October, 9:00 AM onwards"
        ));

        sreevision.addActivity(new Activity(
            "Cult Night",
            "Evening cultural event with a surprise chief guest",
            0, 0, 500,
            "17 October, 5:00 PM onwards"
        ));

        events.add(sreevision);
    }

    static void viewEvents() {
        System.out.println("\n========== AVAILABLE EVENTS ==========");

        for (int i = 0; i < events.size(); i++) {
            CollegeEvent e = events.get(i);

            System.out.println("\n" + (i + 1) + ". " + e.name);
            System.out.println("Dates: " + e.startDate + " to " + e.endDate);
            System.out.println("Venue: " + e.venue);
            System.out.println("Organizer: " + e.organizer);
            System.out.println("Activities: " + e.activities.size());
        }
    }

    static CollegeEvent selectEvent() {
        viewEvents();
        System.out.print("\nSelect event number: ");

        int number = Integer.parseInt(sc.nextLine().trim());

        if (number < 1 || number > events.size()) {
            throw new IllegalArgumentException("Invalid event number.");
        }

        return events.get(number - 1);
    }

    static Activity selectActivity(CollegeEvent event) {
        System.out.println("\nACTIVITIES IN " + event.name.toUpperCase());

        for (int i = 0; i < event.activities.size(); i++) {
            Activity a = event.activities.get(i);

            System.out.println((i + 1) + ". " + a.name);
            System.out.println("   " + a.description);
            System.out.println("   Schedule: " + a.schedule);

            if (event.name.equals("Roboveda 2026")) {
                System.out.println("   Cash Prize: Rs. " + a.cashPrize);
                System.out.println("   Registration fee: Check official rules");
            } else {
                System.out.println("   Registration Fee: Rs. "
                        + a.registrationFee);
            }
        }

        System.out.print("\nSelect activity number: ");
        int number = Integer.parseInt(sc.nextLine().trim());

        if (number < 1 || number > event.activities.size()) {
            throw new IllegalArgumentException("Invalid activity number.");
        }

        return event.activities.get(number - 1);
    }

    static void viewEventDetails() {
        try {
            CollegeEvent event = selectEvent();
            event.displayDetails();
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void registerStudent() {
        try {
            CollegeEvent event = selectEvent();

            if (LocalDate.now().isAfter(event.endDate)) {
                throw new IllegalArgumentException(
                    "This event has ended. Registration is closed.");
            }

            Activity activity = selectActivity(event);

            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter student ID: ");
            String id = sc.nextLine().trim();

            activity.register(id, name);

            if (event.name.equals("Roboveda 2026")) {
                System.out.println(
                    "Note: The cash prize is not the registration fee.");
                System.out.println(
                    "Confirm registration charges using official rules.");
            }

            if (event.name.equals("Sreevision 2026")
                    && activity.name.equals("CICC Workshop")) {
                System.out.println(
                    "The displayed Rs. 59 fee is for solo registration.");
                System.out.println(
                    "Team registration costs Rs. 199 for 3-4 members.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    static void viewParticipants() {
        try {
            CollegeEvent event = selectEvent();
            Activity activity = selectActivity(event);
            activity.displayParticipants();
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void viewContacts() {
        System.out.println("\n========== CONTACT DETAILS ==========");

        System.out.println("\nASHWATTHAMA 2026 - SPORTS CLUB SNIST");
        System.out.println("Sahithi (President): 8125503870");
        System.out.println("Pavan (General Secretary): 8341214455");
        System.out.println("Pravalika (Treasurer): 9652288977");
        System.out.println("Dr. Ravi Kumar (Physical Director): 7093050162");

        System.out.println("\nROBOVEDA 2026 - ROBOTICS CLUB SNIST");
        System.out.println("Website: https://www.roboveda.org");
        System.out.println("Instagram: @roboveda");
        System.out.println("Instagram: @theroboticsclubsnist");
        System.out.println("Refer to individual posters for competition contacts.");

        System.out.println("\nSREEVISION 2026 - CICC WORKSHOP");
        System.out.println("Akshay: 8639142541");
        System.out.println("Sannith: 8555965600");

        System.out.println("\nSREEVISION 2026 - BEYOND THE BREADBOARDS");
        System.out.println("Santosh: 9705637599");
        System.out.println("Srivalli: 9573742170");
        System.out.println("Varshitha: 8019871015");

        System.out.println("\nCult Night: 17 October, 5:00 PM onwards");
        System.out.println("Chief guest: To be announced");

        System.out.println("======================================");
    }
}