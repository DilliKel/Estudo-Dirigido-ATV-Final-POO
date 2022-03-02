// Atividade Final
// Alunos:
// Valeria Alexandra Guevara Parra
// Hugo Lima Romão
// Kelvin Araújo Ferreira

import java.util.InputMismatchException;
import java.util.Scanner;

public class cachorro {
  public static void main(String[] args) {
    // Flags pra controle de casos
    boolean sairDWInterno = false; // Sair do Do While ou Do While aninhado
    boolean sairDWExterno = false; // Sair do Do While Externo
    String temNome; // Flag que aponta se o cachorro tem nome
    String nome = " "; // Nome do Dog
    String respostadono; // Flag que define se o usuário quer ser o dono do dog, caso dono=false;
    String dono; // Flag que define que o cachorro tem dono
    String guardadono; // Flag que define que o cachorro irá ter um dono apos ser constatado que ele
                       // não tem dono
    String saude; // Nº feridas do Dog
    String terminaAplicacao; // String para finalizar a aplicação
    String trueFocinho;
    String truePelagem;
    String trueCorDoPelo;
    String trueComportamento;
    Integer acao;
    Scanner input = new Scanner(System.in);
    Racadocao raca = new Racadocao();

    // Limpa a tela (kind of)
    limpatela();

    // Nome do Dog
    System.out.printf("Ola, bem vindo ao sistema de cadastro animal.%n");
    System.out.printf("O dog tem nome? ('s' para SIM, 'n' para NÃO)%n");
    temNome = input.nextLine();

    do { // Recebe o nome
      switch (temNome) {
        case "s":
          System.out.println("Que legal! E qual seria o nome do dog?");
          nome = input.nextLine();
          System.out.printf("%s... que nome bonito :)%n", nome);
          sairDWInterno = true;
          break;
        case "n":
          System.out.printf("Parece que nao...%n Entao vamos nomear o doguinho!%n");
          nome = input.nextLine();
          System.out.printf("%s... que nome bonito :)%n", nome);
          sairDWInterno = true;
          break;

        default:
          tratexcept();
          temNome = input.nextLine();
      }
    } while (sairDWInterno == false);

    sairDWInterno = false; // Reseta a flag pro proximo DoWhile (DW)
    pulaL(); // 100% WORKING

    // Pega Dono
    guardadono = "n";
    System.out.printf("Entao, %s, voce tem um dono?('s' para SIM, 'n' para NAO) %n", nome);
    dono = input.nextLine();

    while (sairDWExterno == false) {
      switch (dono) {
        case "s":
          System.out.println("Muito boom, otimo");
          pulaL();
          sairDWExterno = true;
          break;

        case "n":
          System.out.printf(
              "Parece que %s nao tem dono... %nnesse caso, gostarias de ser o dono do %s?('s' para SIM, 'n' para NÃO)%n",
              nome, nome);
          respostadono = input.nextLine();
          do {
            switch (respostadono) {
              case "s":
                System.out.println("Supimpa!!!");
                guardadono = "s";
                sairDWInterno = true;
                sairDWExterno = true;
                break;
              case "n":
                System.out.println("Tudo bem então.......");
                guardadono = "n";
                sairDWInterno = true;
                sairDWExterno = true;
                break;

              default:
                tratexcept();
                respostadono = input.nextLine();
            }
          } while (sairDWInterno == false);
          break;
        default:
          tratexcept();
          dono = input.nextLine();
      }
    }

    // pega ferimento
    System.out.printf("%s Tem algum ferimento?%n", nome);
    saude = input.nextLine();
    pulaL();

    System.out.println("Agora veremos qual e a raça do doguinho!");
    pulaL();
    pulaL();
    // dá infos sobre as raças!
    System.out.println(
        "Uma raça de cão tem muitas caracteristicas distintas, entre elas o tamanho e cor do pelo, o tipo do crânio, o tipo do latido, alguns até mesmo uivam!");
    System.out.println(
        "Temos no banco um total de 5 raças de cachorros: Pastor Alemao, Pitbull, Husky Siberiano, Pinscher e Dachshund");
    pulaL();
    pulaL();
    System.out.println(
        "Pastor Alemão: uma raça de porte grande, com personalidade leal, TEMPERAMENTO equilibrado, dócil e obediente. podendo ter PELAGEM curta ou longa. possui um FOCINHO do tipo mesocefálico, sua COR DE PELOS VARIA entre preto com marcas marrom e marrom com marcas amarelas, pode UIVAR e seu LATIDO tende a ser grosso");
    divisorAsterisco();
    System.out.println(
        "Pitbull: Ao contrario da crença popular de que são animais de TEMPERAMENTO agressivo e rude, é na verdade uma raça muito generosa, legal e companheira,  de PELAGEM curta, possui um FOCINHO do tipo mesocefálico e a COR DE SEUS PELOS é bastante variada,  LATEM grosso");
    divisorAsterisco();
    System.out.println(
        "Husky Siberiano: SÃO bastante brincalhões e acolhedores, com PELAGEM longa, possui um FOCINHO do tipo mesocefálico e a COR DE SEUS PELOS varia desde o preto até o branco puro,  LATE grosso e pode UIVAR.");
    divisorAsterisco();
    System.out.println(
        "Pinscher: uma raça de porte pequeno, podendo sere acomodado em pequenos apartamentos, tem um TEMPERAMENTO bastante excêntrico, protetor e corajoso. Sua PELAGEM é curta e tem um FOCINHO do tipo braquiocefálico(Curto), a COR DOS PELOS pode ser preto com marcas marrom ou só vermelho cervo ou vermelho castanho. LATE fino(muuuuito).");
    divisorAsterisco();
    System.out.println(
        "Dachshund: TEMPERAMENTO dócil e amigavel, FOCINHO dolicocefálico, sua PELAGEM pode ser longa ou curta. A COR DOS PELOS pode ser bastante variada e latem fino. ");
    pulaL();
    pulaL();
    System.out.println("Com base nessas informaçoes, poderia nos descrever a raça do seu cao?.");
    pulaL();
    pulaL();

    // pega focinho
    System.out.println(
        "Descreva o focinho do cao, digitando o codigo relativo ao tipo\n1 para braquiocefalico\n2 para mesocefalico\n3 para dolicocefAlico:");
    raca.setFocinho(input.nextInt());
    input.nextLine(); // define o código de focinho e consome o resto da linha
    while (!raca.getFocinho().equals(1) && !raca.getFocinho().equals(2) && !raca.getFocinho().equals(3)) {
      try {
        tratexcept();
        raca.setFocinho(input.nextInt());
        input.nextLine(); // Consome resto da linha
      } catch (InputMismatchException e) {
        tratexcept();
        raca.setFocinho(input.nextInt());
        input.nextLine(); // Consome resto da linha
      }
    }

    // pega o tipo de pelagem
    pulaL();
    System.out.println(
        "Descreva agora qual o tipo de pelagem do cão, digitando o codigo relativo ao tipo\n1 para curto\n2 para longo:");
    raca.setPelagem(input.nextInt());
    input.nextLine();// define o código de pelagem e consome o resto da linha
    while (raca.getPelagem().equals(1) && raca.getPelagem().equals(2)) {
      try {
        tratexcept();
        raca.setPelagem(input.nextInt());
        input.nextLine(); // Consome resto da linha
      } catch (Exception e) {
        tratexcept();
        raca.setPelagem(input.nextInt());
        input.nextLine(); // Consome resto da linha
      }
    }

    // pega o comportamento
    pulaL();
    System.out.printf(
        "Descreva o comportamento do animal. variando entre: %n'equilibrado, dócil e obediente' %n'generosa, legal e companheira,' %n'brincalhão e acolhedor' %n'excêntrico, protetor e corajoso' %n'dócil e amigavel' %nrespectivamente seus códigos são 1, 2, 3, 4 e 5: ");
    raca.setComportamento(input.nextInt());
    input.nextLine(); // define o código de comportamento e consome o resto da linha
    while (!raca.getComportamento().equals(1) && !raca.getComportamento().equals(2)
        && !raca.getComportamento().equals(3) && !raca.getComportamento().equals(4)
        && !raca.getComportamento().equals(5)) {
      try {
        raca.setComportamento(input.nextInt());
        input.nextLine(); // consome o resto da linha anterior
      } catch (Exception e) {
        tratexcept();
        raca.setComportamento(input.nextInt());
        input.nextLine(); // consome o resto da linha anterior
      }
    }

    // Pega a cor dos pelos
    pulaL();
    System.out.printf(
        "Descreva agora qual a cor dos pelos do cão: %n1 para preto com marcas marrom%n2 para marrom com marcas amarelas%n3 para variada%n4 para preto%n5 para vermelho%n6 para branco puro%n7 para vermelho cervo%n8 para vermelho castanho %n");
    raca.setCorDoPelo(input.nextInt());
    input.nextLine(); // define o código de cor do pelo e consome o resto da linha
    while (!raca.getCorDoPelo().equals(1) && !raca.getCorDoPelo().equals(2) && !raca.getCorDoPelo().equals(3)
        && !raca.getCorDoPelo().equals(4) && !raca.getCorDoPelo().equals(5) && !raca.getCorDoPelo().equals(6)
        && !raca.getCorDoPelo().equals(7) && !raca.getCorDoPelo().equals(8)) {
      switch (raca.getCorDoPelo()) {
        case 1:
          raca.setCorDoPelo(1);
          break;
        case 2:
          raca.setCorDoPelo(2);
          break;

        case 3:
          raca.setCorDoPelo(3);
          break;

        case 4:
          raca.setCorDoPelo(4);
          break;

        case 5:
          raca.setCorDoPelo(5);
          break;

        case 6:
          raca.setCorDoPelo(6);
          break;

        case 7:
          raca.setCorDoPelo(7);
          break;

        case 8:
          raca.setCorDoPelo(8);
          break;
        default:
          tratexcept();
          raca.setCorDoPelo(input.nextInt());
          input.nextLine();
          break;
      }
    }

    // pega o latido
    pulaL();
    System.out.println("descreva o latido do cão(entre grosso ou fino):");
    raca.setLatido(input.nextLine());
    while (!raca.getLatido().equals("grosso") && !raca.getLatido().equals("fino")) {
      try {
        raca.setLatido(input.nextLine());
      } catch (Exception e) {
        tratexcept();
        raca.setLatido(input.nextLine());
      }
    }

    // pega uivo
    pulaL();
    System.out.println("fale se o cão pode uivar:('s' para sim e 'n' para não)");
    raca.setUivar(input.nextLine());
    while (!raca.getUivar().equals("s") && !raca.getUivar().equals("n")) {
      try {
        raca.setUivar(input.nextLine());
      } catch (Exception e) {
        tratexcept();
        raca.setUivar(input.nextLine());
      }
    }
    limpatela();
    // lógica p determinar a raça do cão //FEITO
    if (raca.getFocinho().equals(2) && (raca.getPelagem().equals(1) || raca.getPelagem().equals(2))
        && (raca.getCorDoPelo().equals(1) || raca.getCorDoPelo().equals(2))
        && (raca.getComportamento().equals(1) || raca.getComportamento().equals(5))
        && raca.getLatido().equals("grosso") && raca.getUivar().equals("s")) {
      raca.setNomeRaca("Provavelmente um Pastor Alemão");
    } else if (raca.getFocinho().equals(2) && raca.getPelagem().equals(1) && raca.getComportamento().equals(2)
        && raca.getCorDoPelo().equals(3) && raca.getLatido().equals("grosso") && raca.getUivar().equals("n")) {
      raca.setNomeRaca("grandes chances de ser um Pitbull");
    } else if (raca.getFocinho().equals(2) && (raca.getPelagem().equals(1) || raca.getPelagem().equals(2))
        && raca.getComportamento().equals(3)
        && (raca.getCorDoPelo().equals(4) || raca.getCorDoPelo().equals(5) || raca.getCorDoPelo().equals(6))
        && raca.getLatido().equals("grosso") && raca.getUivar().equals("s")) {
      raca.setNomeRaca("Husky Siberiano");
    } else if (raca.getFocinho().equals(1) && (raca.getPelagem().equals(1)
        && (raca.getCorDoPelo().equals(1) || raca.getCorDoPelo().equals(7) || raca.getCorDoPelo().equals(8))
        && raca.getComportamento().equals(4) && raca.getLatido().equals("fino")
        && raca.getUivar().equals("n"))) {
      raca.setNomeRaca("pelo tamanho e as outras características diriamos que é um Pinscher");
    } else if (raca.getFocinho().equals(3) && (raca.getPelagem().equals(1) || raca.getPelagem().equals(2))
        && raca.getComportamento().equals(5) && raca.getCorDoPelo().equals(3) && raca.getLatido().equals("fino")
        && raca.getUivar().equals("n")) {
      raca.setNomeRaca("comprido assim só pode ser um salsicha Dachshund");
    }

    // impressão ficha animal
    divisorAsterisco();
    System.out.printf("Bem vindo a sua carteira animal digital! %s%n", nome);
    System.out.printf("Possui dono: %s%n", guardadono);
    System.out.printf("O animal possui algum ferimento ou doença? %s%n", saude);
    divisorAsterisco();
    System.out.println(
        "agora as caracteristicas individuais e a conclusão do nosso sistema sobre a possivel raça do animal");
    pulaL();

    switch (raca.getFocinho()) { // define o tipo de focinho do cão a ser colocado na impressao da ficha
      case 1:
        trueFocinho = "Braquicefálico";
        break;

      case 2:
        trueFocinho = "Mesocefálico";
        break;

      default:
        trueFocinho = "Dolicocefálico";
        break;
    }
    System.out.printf("Tipo do focinho: %s%n", trueFocinho);

    if (raca.getPelagem() == 1) {// define o tipo da pelagem a ser impressa na ficha
      truePelagem = "Pelos Grossos";
    } else {
      truePelagem = "Pelos Finos";
    }
    System.out.printf("Tipo de pelagem: %s%n", truePelagem);

    switch (raca.getCorDoPelo()) { // define a cor do pelo a ser impressa na ficha
      case 1:
        trueCorDoPelo = "Preto com marcas marrom";
        break;
      case 2:
        trueCorDoPelo = "Marrom com marcas amarelas";
        break;
      case 3:
        trueCorDoPelo = "Variado";
        break;
      case 4:
        trueCorDoPelo = "Só preto";
        break;
      case 5:
        trueCorDoPelo = "Só vermelho";
        break;
      case 6:
        trueCorDoPelo = "Branco puro";
        break;
      case 7:
        trueCorDoPelo = "Vermelho cervo";
        break;

      default:
        trueCorDoPelo = "Vermelho castanho";
        break;
    }
    System.out.printf("A cor do pelo do animal é: %s%n", trueCorDoPelo);

    switch (raca.getComportamento()) { // define o comportamento do cao a ser impresso na ficha
      case 1:
        trueComportamento = "equilibrado, dócil e obediente";
        break;
      case 2:
        trueComportamento = "generoso, legal e companheiro";
        break;
      case 3:
        trueComportamento = "brincalhão e acolhedor";
        break;
      case 4:
        trueComportamento = "excêntrico, protetor e corajoso";
        break;

      default:
        trueComportamento = "dócil e amigavel";
        break;
    }
    System.out.printf("O comportamento do animal: %s%n", trueComportamento);
    System.out.printf("O latido do animal é: %s%n", raca.getLatido());
    System.out.printf("O cão pode uivar: %s%n", raca.getUivar());
    if (raca.getNomeRaca() == null) {
      System.out.printf(
          "Nossa! Seu Cachorro é tão extraordinário que não encontramos esta raça na nossa base de dados");
    } else {
      System.out.printf(
          "Por fim, com todas essas informações, a raça mais semelhante dentro do nosso banco de dados com nosso amiguinho de patas %s é: %s",
          nome, raca.getNomeRaca());
    }
    pulaL();
    divisorAsterisco();

    pulaL(); // encerra aplicação ou avança pra etapa rpg do código
    System.out.printf(
        "voce quer encerrar a aplicação ou visualizar os status do %s e brincar com ele?%n Digite 's' para encerrar e 'n' para continuar%n",
        nome);
    terminaAplicacao = input.nextLine();
    do {
      switch (terminaAplicacao) {
        case "s":
          System.out.println("tenha um bom dia/boa tarde/boa noite!");
          System.exit(0);
          break;

        case "n":
          System.out.println("OK! proceguindo para proxima etapa.");
          break;

        default:
          tratexcept();
          terminaAplicacao = input.nextLine();
          break;
      }
    } while (!terminaAplicacao.equals("s") && !terminaAplicacao.equals("n"));
    divisorAsterisco();
    pulaL();

    sairDWInterno = false;
    DogActions dogeA = new DogActions(nome);
    System.out.printf(
        "Bom dia seja bem vindo as açoes do %s. Selecione a ação q o dog vai executar: %n0: sair da aplicação%n1: Mostrar status %n2: correr %n3: levar para passear%n4: comer%n5: dormir%n6: defecar%n7: urinar%n8: se acidentar%n9: ficar doente%n10: latir%n11: se recuperar%n12: se curar%n",
        nome);
    do {
      acao = input.nextInt();
      switch (acao) {
        case 0:
          sairDWInterno = true;
          break;
        case 1:
          dogeA.showStats();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 2:
          dogeA.run();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 3:
          dogeA.takeAWalk();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 4:
          dogeA.eat();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 5:
          dogeA.sleep();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 6:
          dogeA.poo();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 7:
          dogeA.pee();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 8:
          dogeA.accident();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 9:
          dogeA.becomeSick();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 10:
          dogeA.latir();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 11:
          dogeA.recuperar();
          System.out.println("\nDigite o proximo numero\n");
          break;
        case 12:
          dogeA.curar();
          System.out.println("\nDigite o proximo numero\n");
          break;
        default:
          tratexcept();
          System.out.println(
              "Os comandos são:\n0-Sair\n1-Mostrar status\n2- Run\n3- Passear\n4- Comer\n5- Dormir\n6- Defecar\n7- Urinar\n8- Sofrer acidente\n9- Ficar dente\n10- latir\n11- Se recuperar do acidente, se tiver os stats necessários\n12- Se curar, se estiver com os status necessários\n");
      }
    } while (sairDWInterno == false);

    input.close();
  }// fim metodo main

  private static void tratexcept() {
    System.out.println("Perdão amigo mas digite o código certo.");
  }

  public static void limpatela() {
    for (int i = 0; i < 50; i++) {
      pulaL();
    }
  }

  public static void pulaL() {
    System.out.println("");
  }

  public static void divisorAsterisco() {
    System.out.println("\n*****///*****///*****///*****///*****///*****///*****\n");
  }
}// fim classe