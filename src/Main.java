import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Objeto Scanner para entrada de dados do usuário.
		Usuario usuario = new Usuario(); // Objeto Usuario
		Conta conta = new Conta(); // Obrjeto Conta
		usuario.conta = conta; // Associação da conta ao usuário

		// Mensagem de boas-vindas
		System.out.println("\n#### Bem-vindo ao Gerenciamento Bancário! ####");
		System.out.print("\nPor favor, informe seu nome: ");
		usuario.nome = scanner.nextLine(); // Leitura do nome do usuário

		System.out.print("Informe seu sobrenome: ");
		usuario.sobrenome = scanner.nextLine(); // Leitura do sobrenome do usuário

		System.out.print("Informe seu CPF: ");
		usuario.cpf = scanner.nextLine(); // Leitura do CPF do usuário

		boolean continuar = true;
		do {
			exibirMenu(); // Chamando a função para exibir o menu
			int opcao = scanner.nextInt(); // Lê a opção escolhida

			switch (opcao) { // Verificando a opção escolhida
			case 1:
				System.out.println("Seu saldo atual é: " + usuario.conta.consultarSaldo());
				break;
			case 2:
				System.out.print("Informe o valor do depósito: ");
				double valorDeposito = scanner.nextDouble(); // Lê o valor do depósito
				usuario.conta.depositar(valorDeposito); // Chama o método para realizar depósito na conta do usuário
				System.out.println("Depósito realizado com sucesso!");
				break;
			case 3:
				System.out.print("Informe o valor do saque: ");
				double valorSaque = scanner.nextDouble(); // Lê o valor do saque
				if (usuario.conta.sacar(valorSaque)) { // Verifica se é possível sacar o valor informado
					System.out.println("Saque realizado com sucesso!");
				} else {
					System.out.println("Saldo insuficiente para realizar o saque.");
				}
				break;
			case 4:
				continuar = false; // Encerra o loop, finaliza o programa
				break;
			default:
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");

			}
		} while (continuar); // Repete o loop enquanto 'continuar' for verdadeiro
		System.out.println("#### Obrigado por utilizar o Gerenciamento Bancário. Volte sempre! ####");
		scanner.close(); // Fechando o Scanner
	}

	// Função para exibir o menu de opções
	public static void exibirMenu() {
		System.out.println("\nEscolha uma opção:");
		System.out.println("1 - Consultar saldo");
		System.out.println("2 - Realizar depósito");
		System.out.println("3 - Realizar saque");
		System.out.println("4 - Encerrar");
		System.out.print("Opção: ");
	}

}

//Definição da classe Usuario
class Usuario {
	String nome;
	String sobrenome;
	String cpf;
	Conta conta; //Associação com a classe Conta 
}

//Definição da casse Conta
class Conta {
	private double saldo; //Saldo da conta 

//Método para consultar saldo	
	public double consultarSaldo() {
		return saldo;
	}
	
//Método para realizar depósito
	public void depositar(double valor) {
		saldo += valor;
	}

//Método para realizar saque	
	public boolean sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			return true; // Retorna verdadeiro se o saque foi realizado com sucesso
		} else {
			return false; // Retorna falso se o saldo for insuficiente para o saque
		}
	}
}
