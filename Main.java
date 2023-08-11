import com.AgenciaBancaria;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    static ArrayList<AgenciaBancaria> agencias = new ArrayList<AgenciaBancaria>();

    public static void main (String[] args){
        int option = 0;
        while (option < 3){
            System.out.println("\n--- Menu ---\n0. Adicionar agência\n1. Ver agências\n2. Acessar agência\n3. Sair");
            option = scan.nextInt();
            switch (option){
                case 0:
                    System.out.print("\nNúmero da nova agência: ");
                    addAgencia(new AgenciaBancaria(scan.nextInt()));
                    break;
                case 1:
                    System.out.println();
                    viewAgencias();
                    break;
                case 2:
                    System.out.print("\nNúmero da agência: ");
                    accessAgencia(scan.nextInt());
                    break;
            }
        }
    }

    public static void addAgencia (AgenciaBancaria a) {
        for (int i = 0; i < agencias.size(); i++){
            if (agencias.get(i).getAgência() == a.getAgência()){
                System.out.println("\nA agência " + a.getAgência() + " já existe.");
                return;
            }
        }
        agencias.add(agencias.size(), a);
    }

    public static void viewAgencias () {
        for (int i = 0; i < agencias.size(); i++){
            System.out.println("Agência: " + agencias.get(i).getAgência());
        }
    }

    public static void accessAgencia (int x) {
        for (int i = 0; i < agencias.size(); i++){
            if (agencias.get(i).getAgência() == x){
                agencias.get(i).actions();
                return;
            }
        }
        System.out.println("\nEsta agência " + x + " não existe.\n");
    }
}

//40905616