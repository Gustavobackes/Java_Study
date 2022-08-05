package tests;

import entities.Financing;
import org.junit.jupiter.api.*;

import static factory.FinancingFactory.*;
import static org.junit.jupiter.api.Assertions.*;

public class FinancingTest {
//    Valores padrao validos valor: 100000.0 salario: 2000.0 meses: 80

    @Test
    public void DeveCriarFinanciamento_QuandoOsDadosSaoValidos() {
        Financing financing = criaFinancingValido();
        assertEquals(100000.0, financing.getTotalAmount());
        assertEquals(2000.0, financing.getIncome());
        assertEquals(80, financing.getMonths());
    }

    @Test
    public void DeveLancarArgumentException_QuandoDadosNaoSaoValidos() {
        assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = criaFinancingComMesAlteravel(50);
        });
    }

    //-----------------------------------------------------------------------------------------------
    @Test
    public void DeveAtualizarTotalAmount_QuandoForValido() {
        Financing financing = criaFinancingValido();
        financing.setTotalAmount(73000.0);
        assertEquals(73000.0, financing.getTotalAmount());
    }

    @Test
    public void DeveLancarUmArgumentException_QuandoTotalAmountNaoForeValido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = criaFinancingValido();
            financing.setTotalAmount(100020.0);
        });
    }

    @Test
    public void DeveAtualizarIncome_QuandoForValido() {
        Financing financing = criaFinancingValido();
        financing.setIncome(2500.0);
        assertEquals(2500.0, financing.getIncome());
    }

    @Test
    public void DeveLancarUmArgumentException_QuandoIncomeNaoForeValido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = criaFinancingValido();
            financing.setMonths(60);
        });
    }

    @Test
    public void DeveAtualizarMonth_QuandoForValido() {
        Financing financing = criaFinancingValido();
        financing.setMonths(90);
        assertEquals(90, financing.getMonths());
    }

    @Test
    public void DeveLancarUmArgumentException_QuandoMonthNaoForeValido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = criaFinancingValido();
            financing.setMonths(60);
        });
    }

    @Test
    public void DeveCalcularCorretamenteEntry() {
        Financing financing = criaFinancingValido();
        Double entrada = financing.entry();
        Double valorEsperado = financing.getTotalAmount() * 0.2;
        assertEquals(valorEsperado, entrada);
    }

    @Test
    public void deveCalcularCorretamenteQuota() {
        Financing financing = criaFinancingValido();
        Double prestacao = financing.quota();
        Double valorEsperado = (financing.getTotalAmount() - financing.entry()) / financing.getMonths();
        assertEquals(valorEsperado, prestacao);
        System.out.println(prestacao +" "+ valorEsperado);
    }

}

