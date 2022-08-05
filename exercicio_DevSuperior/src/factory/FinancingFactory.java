package factory;

import entities.Financing;

public class FinancingFactory {
    public static Financing criaFinancingValido() {
        return new Financing(100000.0, 2000.0, 80);
    }

    public static Financing criaFinancingComMesAlteravel(Integer mes) {
        return new Financing(100000.0, 2000.0, mes);
    }

    public static Financing criaFinancingComSalarioAlteravel(Double income) {
        return new Financing(100000.0, income, 80);
    }

    public static Financing criaFinancingComValorAlteravel(Double valor) {
        return new Financing(valor, 2000.0, 80);
    }
}
