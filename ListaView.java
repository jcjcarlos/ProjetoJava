import java.util.Scanner;

public class ListaView {
	public String nome;
	public String telefone;
	public String endereco;
	
	public void readNome() {
		System.out.println("Digite o nome do objeto]");
		Scanner scanner = new Scanner(System.in) ;
		this.nome = scanner.nextLine();
		scanner.close();
	}
	
	public void readTelefone() {
		System.out.println("Digite o telefone do objeto");
		Scanner scanner = new Scanner(System.in) ;
		this.telefone = scanner.nextLine();
		scanner.close();
	}
	
	public void readEndereco() {
		System.out.println("Digite o endereco do objeto");
		Scanner scanner = new Scanner(System.in) ;
		this.endereco = scanner.nextLine();
		scanner.close();
	}
}
