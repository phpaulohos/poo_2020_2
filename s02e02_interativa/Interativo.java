import java.util.Scanner;

class Calango {
    int bucho; //atributos
    int maxBucho;
    int nPatas;
    int vida;
    boolean alive;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int maxBucho){ //parametros
        this.bucho = maxBucho;
        this.maxBucho = maxBucho;
        this.nPatas = 4;
        this.vida = 4;
        this.alive = true;
    }

    void comer(int qtd){
        bucho += qtd;
        if(bucho > maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
    }

    void andar(int dist){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            if(bucho < dist){
                System.out.println("Andei só " + bucho);
                bucho = 0;
                return;
            }
            bucho -= dist;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Ouch! Perdi uma pata");
        }else{
            System.out.println("Já virei cobra!!");
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas  + " Alive:" + alive;
    }

    public static void main(String[] args) {
        //referencia      = criando objeto
        Calango deadlango = new Calango(20);

        System.out.println(deadlango);

        
        for(int i = 0; i < 25; i++)
            deadlango.comer(1);
        System.out.println(deadlango);
        
        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.acidentar();
        System.out.println(deadlango);

        for(int i = 0; i < 25; i++)
            deadlango.andar(1);
        System.out.println(deadlango);
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        System.out.println(deadlango);
        // deadlango.acidentar();
        // deadlango.regenerar();
        // deadlango.bucho = 0;
        // deadlango.maxBucho = 20;
        // deadlango.nPatas = 4;


        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();


        // deadlango.comer();

        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();
    }
}


public class Interativo {
    public static void main(String[] args) {
        Calango calango = new Calango(10);
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(line.equals("end")){
                break;
            }else if(line.equals("show")){
                System.out.println(calango);
            }else if(ui[0].equals("andar")){//andar _dist
                calango.andar(Integer.parseInt(ui[1]));
            }else if(line.equals("regenerar")){
                calango.regenerar();
            }else if(ui[0].equals("comer")){//comer _qtd
                calango.comer(Integer.parseInt(ui[1]));
            }else if(line.equals("brigar")){
                calango.acidentar();
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}