import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
    public Conta buscarConta (int numero){
        for (Conta c : contas){
            if (c.getNumero() == numero){
                return c;
            }
        }
        return null;
    }
    public void listarContas(){
        if (contas.isEmpty()){
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (Conta c : contas){
                System.out.println(c);
            }
        }
    }
}
