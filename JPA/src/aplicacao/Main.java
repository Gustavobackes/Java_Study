package aplicacao;

import dominio.Pessoa;

public class Main {
    public static void main (String[]args){
        Pessoa p1 = new Pessoa("Gustavo",18);
        Pessoa p2 = new Pessoa("Gilberto",56);
        Pessoa p3 = new Pessoa("Gabson",43);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
