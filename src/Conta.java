public class Conta {
    private int numero;
    private Cliente cliente;
    private double saldo;

    public Conta(int numero, Cliente cliente){
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Valor inválido: o depósito deve ser maior que zero.");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque!");
        }
        saldo -= valor;
    }

    public int getNumero(){
        return numero;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString(){
        return "Conta: " + numero + " - Cliente: " + cliente.getNome() + " - Saldo: R$ " + saldo;
    }
}
