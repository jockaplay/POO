package com;
import java.util.Scanner;

public class ContaBancaria {
    private int conta;
    private String nome;
    private double saldo = 0;
    private Scanner scan = new Scanner(System.in);

    //CONSTRUTOR
    public ContaBancaria (String dono){
        setNome(dono);
        int c = Math.abs(dono.hashCode() + (int)(Math.random() * 99999999 + 1));
        setConta(c);
        System.out.println("Parabéns " + dono + " sua conta foi criada com sucesso.\nO número da sua conta é: " + c);
    };

    //SET-GET NÚMERO DA CONTA
    public int getConta() {
        return conta;
    }
    private void setConta(int conta) {
        this.conta = conta;
    }

    //SET-GET NOME DO DONO DA CONTA
    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    //SET-GET SALDO DA CONTA
    public double getSaldo() {
        return saldo;
    }
    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //MÉTODO DE DEPÓSITO
    public void deposito(double quantia){
        setSaldo(quantia);
    }

    //MÉTODO DE SAQUE
    public void saque(double quantia){
        if (quantia < getSaldo()){
            setSaldo(getSaldo() - quantia);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    //AÇÕES POSSÍVEIS PARA A CONTA
    public void actions() {
        int option = 0;
        double q;
        while (option < 3){
            System.out.println("\n--- Bem-vindo " + getNome() + " - Menu ---\n0. Sacar\n1. Depositar\n2. Ver saldo\n3. Volta");
            option = scan.nextInt();
            switch (option){
                case 0:
                    System.out.print("Quanto deseja sacar: ");
                    q = scan.nextDouble();
                    saque(q);
                    break;
                case 1:
                    System.out.print("Quanto deseja depositar: ");
                    q = scan.nextDouble();
                    deposito(q);
                    break;
                case 2:
                    System.out.print("Saldo: R$ " + getSaldo());
                    break;
            }
        }
    }
}