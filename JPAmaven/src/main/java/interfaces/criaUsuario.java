package interfaces;

import javax.persistence.Column;
import java.util.Scanner;

public interface criaUsuario {
    String nome;

    int idade;

    default void novoUsuario(String nome, int idade){
        this.nome = nome;
        Scanner scan = new Scanner(System.in);
        System.out.println("escreva seu nome: ");
        String nome = scan.next();
        System.out.println("escreva sua idade: ");
        int idade = Integer.parseInt(scan.next());
    }
}
