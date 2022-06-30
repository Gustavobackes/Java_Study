package codandoSimples;

import interfaces.taxi;

public class Main {
    public static void main (String[]args){
        taxi taxi = (lugar) -> {
            double valor = 20.5;
            System.out.print("O local é " + lugar);
            return valor;

        };
    double valorReserva = taxi.reserva("Joinville " + "e o valor da reserva é -> ");
        System.out.println(valorReserva);

    }
}

