package pt.ulusofona.deisi.lp2.contaBancaria;

public class ContaBancaria {
    private int saldo;

    public ContaBancaria(int saldo) {
        this.saldo = saldo;
    }

    public void deposita(int quantidade) {
        this.saldo += quantidade;
    }

    public boolean levanta(int quantidade) {
        if (this.saldo >= quantidade) {
            this.saldo -= quantidade;
            return true;
        }
        return false;
    }

    public String getSaldoComoString() {
        return "" + this.saldo;
    }
}
