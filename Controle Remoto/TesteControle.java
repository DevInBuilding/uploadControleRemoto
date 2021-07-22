package encapsulamento;

public class TesteControle {
	public static void main (String[] args) {
		ControleRemoto c = new ControleRemoto(); //Constructor usada para que o acesso aos comandos do controle sejam permitidos.
		c.ligar();
		c.maisVolume();
		c.play();
		c.abrirMenu();
		c.fecharMenu();
	}
}
