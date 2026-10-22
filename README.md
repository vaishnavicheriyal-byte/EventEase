#EventEase — College Event Management System

A Core Java console-based application designed to help students explore college events, view activity details, and register for activities.

# 📌 Project Overview

EventEase is a beginner-friendly Java project that demonstrates object-oriented programming, collections, input handling, and basic registration management through an interactive console menu.

The application includes sample college events, activities, schedules, registration fees, participant limits, and organizer details.

# ✨ Features

- View All Events: Browse available college events, dates, venues, organizers, and activities.
- View Event Details: Explore event descriptions, activity schedules, fees, and available capacity.
- Activity Registration: Register using a student name and student ID.
- Duplicate Registration Checks: Prevent repeated registrations for the same activity using the student ID.
- Capacity Management: Prevent registrations after an activity reaches its configured capacity.
- Participant Lists: View registered participants and remaining slots.
- Contact Information: Access the contact details provided by the application.
- Input Validation: Handle invalid menu selections and certain invalid registration inputs.
- Event Date Validation: Prevent registration after an event's configured end date.

# 🛠️ Technologies Used

- Language: Java
- Concepts: Object-Oriented Programming (OOP), classes, objects, methods, exception handling, and collections
- Java Libraries: java.util, java.time
- Development Environment: Eclipse IDE
- Interface: Command-line / console

# 📂 Project Structure

```text
EventEase/
├── EventEase.java
└── README.md
```

The Java source file contains the main application and the supporting `CollegeEvent` and `Activity` classes.

# ▶️ How to Run

# Prerequisites

- Java Development Kit (JDK) 8 or later
- A terminal or an IDE such as Eclipse

# Run using Command Prompt

1. Download or clone this repository.
2. Open Command Prompt in the folder containing "EventEase.java".
3. Compile the program:

    bash
   javac EventEase.java
   

4. Run the application:

   ```bash
   java EventEase
   ```

# Run using Eclipse IDE

1. Open Eclipse.
2. Create or open a Java project.
3. Add "EventEase.java" to the project's source folder.
4. Run the file as a Java Application.

## 🧠 What I Learned

- Applying object-oriented programming concepts to a practical project.
- Organising related data using classes and collections.
- Using ArrayList and LinkedHashMap to manage events and participants.
- Working with Java's date and time API.
- Validating user input and handling exceptions.
- Implementing registration rules and activity capacity checks.

## ⚠️ Current Limitations

- Event and activity information is predefined in the source code.
- Registration data is stored in memory and is not saved after the application exits.
- The application uses a console interface rather than a graphical or web interface.
- The event dates are sample data and should be updated before a future demonstration.

## 🚀 Future Enhancements

- Integrate a database such as MySQL for persistent storage.
- Add student and administrator authentication.
- Develop a web interface using Java, Spring Boot, and frontend technologies.
- Add event creation and management features for administrators.
- Add registration confirmation and notification features.
- Introduce automated tests and improve input validation.

👩‍💻 Author

Vaishnavi Cheriyal

B.Tech Computer Science and Engineering Student

Interested in Java development, Artificial Intelligence, Machine Learning, and building practical software applications.

GitHub: [@vaishnavicheriyal-byte](https://github.com/vaishnavicheriyal-byte)

---

*This project was developed as a learning project to practise Core Java and object-oriented programming.*
