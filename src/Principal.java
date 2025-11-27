import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=====MENU===== ");
            System.out.println("1 - Criar conta ");
            System.out.println("2 - Depositar ");
            System.out.println("3 - Sacar ");
            System.out.println("4 - Listar contas ");
            System.out.println("0 - Sair ");
            System.out.println("Opção: ");

            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite apenas" +
                        " números.");
                sc.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    sc.nextLine();
                    System.out.println("Nome do cliente: ");
                    String nome = sc.nextLine();

                    try {
                        Cliente cliente = new Cliente(nome);
                        System.out.println("Número da conta: ");
                        int num = sc.nextInt();

                        Conta conta = new Conta(num, cliente);
                        banco.adicionarConta(conta);
                        System.out.println("Conta criada com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro : " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Número da conta inválido.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Número da conta: ");
                        int num = sc.nextInt();

                        Conta conta = banco.buscarConta(num);
                        if (conta == null) {
                            System.out.println("Conta não encontrada. ");
                            break;
                        }
                        System.out.println("Valor do depósito: ");
                        double valor = sc.nextDouble();

                        conta.depositar(valor);
                        System.out.println("Depósito realizado!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida! Tente novamente.");
                        sc.nextLine();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Número da conta: ");
                        int num = sc.nextInt();

                        Conta conta = banco.buscarConta(num);
                        if (conta == null) {
                            System.out.println("Conta não encontrada. ");
                            break;
                        }
                        System.out.println("Valor do saque: ");
                        double valor = sc.nextDouble();

                        conta.sacar(valor);
                        System.out.println("Saque realizado!");
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida! Digite um número.");
                        sc.nextLine();
                    }
                    break;

                case 4:
                    banco.listarContas();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! ");
                    break;

            }
        }
        sc.close();
    }
}
