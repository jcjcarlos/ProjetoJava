package view;
import model.ContatosModel;
import java.util.List;
import java.util.Scanner;

public class ContatosView {
	private String nome;
	private String email;
	private String endereco;
	
	public void readNome() {
		System.out.println("Digite o nome");
		Scanner scanner = new Scanner(System.in) ;
		this.nome = scanner.nextLine();
		scanner.close();
	}
	
	public void readEmail() {
		System.out.println("Digite o email");
		Scanner scanner = new Scanner(System.in) ;
		this.email = scanner.nextLine();
		scanner.close();
	}
	
	public void readEndereco() {
		System.out.println("Digite o endereco");
		Scanner scanner = new Scanner(System.in) ;
		this.endereco = scanner.nextLine();
		scanner.close();
	}
	
	public void showContatos(List<ContatosModel> contatos) {
		for(ContatosModel contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Nascimento" + contato.getDataNascimento().getTime());
			System.out.println();
		}
	}
	
}
