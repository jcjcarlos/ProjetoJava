import java.util.Calendar;

public class ListaModel {
	public String nome;
	public String telefone;
	public String endereco;
	public Calendar data;
	
	public ListaModel() {
		//Durante a persistencia, salvar o horário da que foi salvo o objeto.
		this.data = Calendar.getInstance();
	}
	
	public String toString() {
		return this.nome + " " + this.telefone + " " + this.endereco;
	}
}
