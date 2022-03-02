import java.util.ArrayList;
import java.util.Arrays;

public class Agenda {
  String name;
  String course;
  Number period;
  String[] subjectsInProgress;
  ArrayList<Schedule> schedules = new ArrayList<Schedule>();
  ArrayList<Homework> homeworks = new ArrayList<Homework>();

  // getters

  String getName() {
    return this.name;
  }

  String getCourse() {
    return this.course;
  }

  Number getPeriod() {
    return this.period;
  }

  String[] getSubjectsInProgress() {
    return this.subjectsInProgress;
  }

  // setters

  void setName(String name) {
    this.name = name;
  }

  void setCourse(String course) {
    this.course = course;
  }

  void setPeriod(Number period) {
    this.period = period;
  }

  void setSubjectsInProgress(String[] courses) {
    this.subjectsInProgress = courses;
  }

  void setSchedule(String time, String day, String subject) {
    schedules.add(new Schedule(time, day, subject));
  }

  void setHomework(String title, String deadline, String subject) {
    homeworks.add(new Homework(title, deadline, subject));
  }

  // print

  void printSubjectsInProgress() {
    if (subjectsInProgress.length > 0) {
      System.out.printf("Disciplínas cadastradas\n");
      for (int i = 0; i < subjectsInProgress.length; i++) {
        System.out.printf("   - %s\n", this.subjectsInProgress[i]);
      }
    } else {
      System.out.printf("Nenhuma disciplína cadastrada");
    }
  }

  void printSchedules() {
    if (schedules.size() > 0) {
      for (int i = 0; i < schedules.size(); i++) {
        System.out.printf("\n%s\n", schedules.get(i).day);
        for (int j = 0; j < schedules.size(); j++) {
          if (i == j) {
            System.out.printf("%s %s\n", schedules.get(i).time, schedules.get(i).subject);
          }
        }

      }
    } else {
      System.out.printf("Nenhuma horário cadastrado! \n");
    }
  }

  void printPendingHomeworks() {
    if (homeworks.size() > 0) {
      System.out.printf("\nAtividades pendentes");
      for (int i = 1; i < homeworks.size(); i++) {
        System.out.printf("\n   %s\n", homeworks.get(i).subject);

        for (int j = 0; j < homeworks.size(); j++) {
          if (homeworks.get(j).status == "Pendente" && homeworks.get(i).subject == homeworks.get(j).subject) {
            System.out.printf("   - %s %s\n", homeworks.get(j).title, homeworks.get(j).deadline);
          }
        }
      }
    } else {
      System.out.printf("Nenhuma atividade pendente, parabéns🎉! \n");
    }
    System.out.printf("\n");
  }

}