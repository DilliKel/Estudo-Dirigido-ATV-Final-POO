// Atividade Final
// Alunos:
// Valeria Alexandra Guevara Parra
// Hugo Lima Romão
// Kelvin Araújo Ferreira

public class TesteAgenda {
  public static void main(String[] args) {
    Agenda agenda = new Agenda();

    String[] subjectsInProgress = { "POO", "Programação estruturada", "Lógica de predicados",
        "Programação em baixo nível" };

    agenda.setName("Hugo\n");
    agenda.setCourse("Ciência da computação");
    agenda.setPeriod(2021.2);
    agenda.setSubjectsInProgress(subjectsInProgress);

    agenda.setSchedule("10:00", "Domingo", "POO");
    agenda.setSchedule("11:00", "Segunda", "Progamação em baixo nível");
    agenda.printSchedules();

    agenda.setHomework("Exame final", "10/03/2022", "POO");
    agenda.setHomework("Atividade avaliativa", "10/03/2022", "POO");
    agenda.setHomework("Atividade avaliativa", "16/03/2022", "MB101");
    agenda.setHomework("Atividade avaliativa", "16/03/2022", "MB205");
    agenda.printPendingHomeworks();

    agenda.printSubjectsInProgress();
  }
}
