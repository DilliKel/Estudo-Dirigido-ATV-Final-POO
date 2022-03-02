public class Homework {
  String title;
  String deadline;
  Number score;
  String status;
  String subject;

  public Homework(String title, String deadline, String subject) {
    this.title = title;
    this.deadline = deadline;
    this.status = "Pendente";
    this.score = 0;
    this.subject = subject;
  }

  void SetCompleteHomework(Number score) {
    this.status = "Entregue";
    this.score = score;
  }
}
