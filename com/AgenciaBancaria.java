package com;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    private int agência;
    private ArrayList<ContaBancaria> ListaDeContas = new ArrayList<ContaBancaria>();
    Scanner scan = new Scanner(System.in);

    //CONSTRUTOR
    public AgenciaBancaria (int numero) {
        setAgência(numero);
    }

    //SET-GET NÚMERO DA AGÊNCIA
    public void setAgência(int agência) {
        this.agência = agência;
    }
    public int getAgência() {
        return agência;
    }

    //ADICIONAR CONTA
    public void addAccount(ContaBancaria conta){
        //verificar se a pessoa já possúi conta
        for (int i = 0; i < ListaDeContas.size(); i++){
            if (ListaDeContas.get(i).getNome() == conta.getNome()){
                System.out.println("Esta pessoa já possúi uma conta nessa agência.");
                return;
                //O programa para aqui caso tenha.
            }
        }
        //Caso não tenha ele adiciona.
        ListaDeContas.add(ListaDeContas.size(), conta);
    }

    //REMOVER CONTA
    public void removeAccount(int conta){
        for (int i = 0; i < ListaDeContas.size(); i++){
            if (ListaDeContas.get(i).getConta() == conta){
                System.out.println("Deletando a conta de " + ListaDeContas.get(i).getNome());
                ListaDeContas.remove(i);
                return;
            }
        }
        System.out.println("Esta conta não existe.");
    }

    //ACESSAR CONTA
    public void accessAccount(int conta) {
        for (int i = 0; i < ListaDeContas.size(); i++){
            if (ListaDeContas.get(i).getConta() == conta){
                ListaDeContas.get(i).actions();
                return;
            }
        }
        System.out.println("Esta conta não existe.");
    }

    //AÇÕES QUE UMA AGÊNCIA CONSEGUE FAZER
    public void actions () {
        int options = 0;
        int conta = 0;
        while (options < 3){
            //MOSTRAR MENU
            System.out.println("\n--- Menu Agência " + getAgência() + " ---\n0. Adicionar conta\n1. Remover conta\n2. Acessar conta\n3. Voltar");
            //RECEBER UM NÚMERO DO USUÁRIO
            options = scan.nextInt();
            //TRATAR AS OPÇÕES
            switch (options){
                //ADICIONA UMA CONTA
                case 0:
                    scan.nextLine();
                    System.out.println("Nome: ");
                    String nome = scan.nextLine();
                    addAccount(new ContaBancaria(nome));
                    break;
                //REMOVER UMA CONTA
                case 1:
                    conta = scan.nextInt();
                    removeAccount(conta);
                    break;
                //ACESSAR UMA CONTA
                case 2:
                    conta = scan.nextInt();
                    accessAccount(conta);
                    break;
            }
        }
    }
}
