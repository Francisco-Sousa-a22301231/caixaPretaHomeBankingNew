package pt.ulusofona.lp2.homeBanking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteContaBancaria {

    @Test public void testCriacaoDeContaComSaldoNegativo() {
        int saldoInicial = -100;
        ContaBancaria conta = new ContaBancaria(saldoInicial);
        String expected = "0";
        String actual = conta.getSaldo();
        assertEquals(expected, actual, "getSaldo inicial failed");
    }

    @Test public void testCriacaoDeContaComSaldoPositivo() {
        int saldoInicial = 100;
        ContaBancaria conta = new ContaBancaria(saldoInicial);
        String expected = "100";
        String actual = conta.getSaldo();
        assertEquals(expected, actual, "getSaldo inicial failed");
    }



    @Test public void testDepositarPositivo() {
        int saldoInicial = 100;
        ContaBancaria conta = new ContaBancaria(saldoInicial);
        String expected = "100";
        String actual = conta.getSaldo();
        assertEquals(expected, actual, "getSaldo inicial failed");

        conta.depositar(saldoInicial);
        expected = "200";
        actual = conta.getSaldo();

        assertEquals(expected, actual, "getSaldo after deposit failed");
    }

    @Test public void testDepositarNegativo() {
        int saldoInicial = 100;
        ContaBancaria conta = new ContaBancaria(saldoInicial);
        String expected = "100";
        String actual = conta.getSaldo();
        assertEquals(expected, actual, "getSaldo inicial failed");

        conta.depositar(-saldoInicial);
        expected = "100";
        actual = conta.getSaldo();

        assertEquals(expected, actual, "getSaldo after deposit failed");
    }

    @Test public void testLevantarPositivo() {
        int saldoInicial = 100;
        ContaBancaria conta = new ContaBancaria(saldoInicial);
        boolean levantar = conta.levantar(saldoInicial/2);
        String expected = "50";
        String actual = conta.getSaldo();

        assertTrue(levantar, "levantar with saldo failed");
        assertEquals(expected,actual, "getSaldo after levantar failed");
    }

    @Test public void testLevantarNegativo() {
        int saldoInicial = 100;
        ContaBancaria conta = new ContaBancaria(saldoInicial);
        boolean levantar = conta.levantar(-saldoInicial/2);
        String expected = "100";
        String actual = conta.getSaldo();

        assertFalse(levantar, "levantar with saldo failed");
        assertEquals(expected,actual, "getSaldo after levantar failed");
    }

    @Test public void testLevantarComSaldoNegativo() {
        int saldoInicial = -100;
        ContaBancaria conta = new ContaBancaria(saldoInicial);
        boolean levantar = conta.levantar(50);
        String expected = "-100";
        String actual = conta.getSaldo();

        assertFalse(levantar, "levantar with saldo failed");
        assertEquals(expected,actual, "getSaldo after levantar failed");
    }

    @Test public void testTransferenciaComSaldo() {
        int saldoInicial = 100;
        ContaBancaria conta1 = new ContaBancaria(saldoInicial);
        ContaBancaria conta2 = new ContaBancaria(saldoInicial);
        boolean transferir = conta1.transferirPara(conta2,10);
        String expected = "110";
        String actual = conta2.getSaldo();
        assertTrue(transferir, "transferir with saldo failed");
        assertEquals(expected,actual, "getSaldo conta 2 after transferir failed");
        expected = "88";
        actual = conta1.getSaldo();
        assertEquals(expected,actual, "getSaldo conta 1 after transferir failed");
    }

    @Test public void testTransferenciaComSaldoNegativo() {
        int saldoInicial = -100;
        ContaBancaria conta1 = new ContaBancaria(saldoInicial);
        ContaBancaria conta2 = new ContaBancaria(-saldoInicial);
        boolean transferir = conta1.transferirPara(conta2,10);
        String expected = "100";
        String actual = conta2.getSaldo();
        assertFalse(transferir, "transferir with saldo failed");
        assertEquals(expected,actual, "getSaldo conta 2 after transferir failed");
        expected = "-100";
        actual = conta1.getSaldo();
        assertEquals(expected,actual, "getSaldo conta 1 after transferir failed");
    }

    @Test public void testTransferenciaComSaldoInsuficiente() {
        int saldoInicial = 2;
        ContaBancaria conta1 = new ContaBancaria(saldoInicial);
        ContaBancaria conta2 = new ContaBancaria(saldoInicial);
        boolean transferir = conta1.transferirPara(conta2,10);
        String expected = "2";
        String actual = conta2.getSaldo();
        assertFalse(transferir, "transferir with saldo failed");
        assertEquals(expected,actual, "getSaldo conta 2 after transferir failed");
        expected = "2";
        actual = conta1.getSaldo();
        assertEquals(expected,actual, "getSaldo conta 1 after transferir failed");
    }

    @Test public void testTransferenciaNegativa() {
        int saldoInicial = 100;
        ContaBancaria conta1 = new ContaBancaria(saldoInicial);
        ContaBancaria conta2 = new ContaBancaria(saldoInicial);
        boolean transferir = conta1.transferirPara(conta2,-10);
        String expected = "100";
        String actual = conta2.getSaldo();
        assertFalse(transferir, "transferir with saldo failed");
        assertEquals(expected,actual, "getSaldo conta 2 after transferir failed");
        expected = "100";
        actual = conta1.getSaldo();
        assertEquals(expected,actual, "getSaldo conta 1 after transferir failed");
    }

    @Test public void testTransferenciaSemSaldoParaTaxa() {
        int saldoInicial = 2;
        ContaBancaria conta1 = new ContaBancaria(saldoInicial);
        ContaBancaria conta2 = new ContaBancaria(saldoInicial);
        boolean transferir = conta1.transferirPara(conta2,2);
        String expected = "2";
        String actual = conta2.getSaldo();
        assertFalse(transferir, "transferir with saldo failed");
        assertEquals(expected,actual, "getSaldo conta 2 after transferir failed");
        expected = "2";
        actual = conta1.getSaldo();
        assertEquals(expected,actual, "getSaldo conta 1 after transferir failed");
    }

}
