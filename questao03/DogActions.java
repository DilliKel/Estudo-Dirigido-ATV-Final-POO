public class DogActions extends Racadocao{

    String nomeDog;             //Nome do doguinho
    //Flags
    boolean isTired=false;      //Cansado
    boolean isRecovering=false; //Recuperando-se
    boolean isSick=false;       //Doente

    //CONSTRUTOR
    protected DogActions(String name){
        this.nomeDog=name;
    }

    //Status não binarios
    Integer hunger = 0;     //Sem fome->Faminto
    Integer energy = 10;    //Cansado->Descansado
    Integer bladder = 0;    //Bexiga vazia-> bexiga cheia
    Integer humour = 10;    //Triste->Feliz

    void showStats(){
        //Mostrar status do doguinho
        System.out.println("Sobre o doguinho:\n");
        System.out.printf("Fome: %d%n",hunger);
        System.out.printf("Energia: %d%n",energy);
        System.out.printf("Bexiga: %d%n",bladder);
        System.out.printf("Humor: %d%n",humour);
        if(hunger > 7){
            System.out.println("Seu cachorro está com fome, voce deveria alimenta-lo.\n");
        }
        if(energy < 3){
            System.out.println("Seu cachorro está se sentindo cansado.\n");
        }
        if(bladder > 7){
            System.out.println("Seu cachorro logo logo irá querer fazer as suas necessidades.\n");
        }
        if(humour < 3){
            System.out.println("Seu cachorro está meio triste, você poderia animá-lo ou agita-lo.\n");
        }
        this.checkTired();
    }
    //AÇOES
    void run(){         //Corre se o dog estiver descansado e recuperado
        if (!isSick){
        if(!isTired && !isRecovering){
        System.out.println("Como o vento, seu cachorro corre velozmente!\n");
        this.minusEnergy(4);
        this.plusHunger(3);
        this.plusHumour(4);
        this.plusBladder(3);
        } else if(isTired) 
            System.out.println("Seu cachorro está cansado demais para correr.");
        else if(isRecovering)
            System.out.println("Seu cachorro está se recuperando e não pode correr, experimente andar com ele");
        else
        System.out.println("Seu cachorro está cansado e se recuperando, cuide dele."); 
        }//End if isSick
        else
        System.out.println("Seu cachorro está doente, cuide dele."); 
    }
    void takeAWalk(){
        System.out.println("Hoje é dia de passear :3");
        this.minusEnergy(2);
        this.plusHunger(3);
        this.plusHumour(2);
        this.plusBladder(2);
        this.checkTired();

    }
    void eat(){
        System.out.println("a refeicao esta servida!\n");
        this.minusHunger(7);
        this.plusHumour(2);
        this.plusBladder(4);
    }
    void sleep(){
        this.plusEnergy(6);
        if(energy==10)
            System.out.println("Depois de um bom sono, o seu cachorro está 100% descansado:)");
        else
            System.out.println("Seu cachorro tirou uma soneca e está mais descansado");
        this.plusHunger(1);
        this.checkTired();
    }
    void poo(){
        System.out.println("O dog está realizando as suas necessidades, olhe para o lado.");
        this.plusHumour(1);
        this.minusBladder(5);
    }
    void pee(){
        System.out.println("Número 1 saindo. pssssssssssss");
        this.plusHumour(1);
        this.minusBladder(2);
    }
    void accident(){
        System.out.println("Oh, nao! Seu dog sofreu um acidente\n");
        this.humour = 2;
        this.energy = 2;
        checkTired();
        isRecovering = true;
        System.out.println("Para que seu cachorro se recupere, cuide dele e deixe a fome abaixo de 3 e a energia acima de 7");
    }
    void becomeSick(){
        if(!isSick){
        System.out.println("Seu cachorro adoeceu. Para melhorar, alimente-o e brinque com ele"); 
        this.energy = 2;
        this.hunger = 10;
        this.humour = 2;
        isSick=true;
        }
        //Se o dog já estiver doente, o métoo não faz nada
    }
    void latir(){
        System.out.println("Au Au Au Au Au");
    }
    //METODOS DE CONTROLE
    void recuperar() {              //Se recuperar de acidentes
        if(isRecovering){
        if (energy <= 7 || hunger  >= 3)
            System.out.println("Seu cachorro ainda não tem os status suficientes para se recuperar.\n");
        else {
            System.out.println("Seu cachorro se recuperou do acidente e esta melhor :)\n");
            isRecovering = false;
        }//End else
    }//End if isRecovering
        else{
            System.out.printf("Seu cachorro não precisa se recuperar, ele está ótimo");
        }
     }//End recuperar()
    void curar() {              //Se recuperar de acidentes
        if(isSick){
        if (energy <= 7 || hunger  >= 3)
            System.out.println("Seu cachorro ainda não tem os status suficientes para se curar.\n");
        else {
            System.out.println("Seu cachorro está curado)\n");
            isSick = false;
        }//End else
    }//End if isSick
        else{
            System.out.printf("Seu cachorro não está doente :)");
        }
     }//End recuperar()
     void checkTired(){
         if (energy < 3)
            isTired = true;
            else
            isTired = false;
     }

    //METODOS PRA ADD OU SUB ALGUM STATUS
    void minusHunger(Integer x){
        hunger -= x;
        if(hunger < 0)
            hunger = 0;
    }
    void plusHunger(Integer x){
        hunger += x;
        if(hunger > 10)
            hunger = 10;
    }
    void plusEnergy(Integer x){
        energy += x;
        if(energy > 10)
            energy = 10;
    }
    void minusEnergy(Integer x){
        energy -= x;
        if(energy < 0)
            energy = 0;
    }
    void plusBladder(Integer x){
        bladder += x;
        if(bladder > 10)
            bladder = 10;
    }
    void minusBladder(Integer x){
        bladder -= x;
        if(bladder < 0)
            bladder = 0;
    }
    void plusHumour(Integer x){
        humour += x;
        if (humour > 10)
            humour = 10;
    }
    void minusHumour(Integer x){
        humour -= x;
        if (humour < 0)
            humour = 0;
    }

    //void removerstatus()

}