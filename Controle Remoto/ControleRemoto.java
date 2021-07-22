package encapsulamento;

public class ControleRemoto implements Controlador{
	//Atributos
	private int volume;
	private boolean ligado;
	private boolean tocando;
	//M�todos especiais - construtor e getters and setters in private mode
	public ControleRemoto() {
		this.volume = 50;
		this.ligado = false;
		this.tocando = false;
	}
	
	//Volume
	private int getVolume() {
		return volume;
	}
	private void setVolume(int volume) {
		this.volume = volume;
	}
	//Ligado
	private boolean getLigado() {
		return ligado;
	}
	private void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	//Tocando
	private boolean getTocando() {
		return tocando;
	}
	private void setTocando(boolean tocando) {
		this.tocando = tocando;
	}

	//M�todos abstratos - atrav�s do implemento 'Controlador' - eles permitem que os m�todos getters and setters estejam no 'private mode' para serem acessados somente dentro da classe
	
	//Ligar\Desligar
	@Override
	public void ligar() {
		this.setLigado(true);
	}

	@Override
	public void desligar() {
		this.setLigado(false);
	}

	//Menu
	@Override
	public void abrirMenu() {
		System.out.println("----- MENU -----");
		System.out.println("Est� ligado? " + this.getLigado());
		System.out.println("Est� tocando? " + this.getTocando());
		System.out.print("Volume: " + this.getVolume());
		for(int i = 0; i < this.getVolume(); i+=10) {
			System.out.print(" | ");
		}
		System.out.println("");
	}

	@Override
	public void fecharMenu() {
		System.out.println("Fechando Menu...");
	}

	//Volume
	@Override
	public void maisVolume() {
		if(this.getLigado()==true) {
			this.setVolume(this.getVolume() + 5);
		} else {
			System.out.println("Imposs�vel ligar");
		}
	}

	@Override
	public void menosVolume() {
		if(this.getLigado()==true) {
			this.setVolume(this.getVolume() - 5);
		} else {
			System.out.println("Imposs�vel ligar");
		}
	}

	//Ativar\Desativar som
	@Override
	public void ligarMudo() {
		if(this.getLigado()==true && this.getVolume() > 0) {
			this.setVolume(0);
		}
	}

	@Override
	public void desligarMudo() {
		if(this.getLigado()==true && this.getVolume() == 0) {
			this.setVolume(50);
		}
	}

	//Play\Pause
	@Override
	public void play() {
		if(this.getLigado() && !(this.getTocando())) {
			this.setTocando(true);
		} else {
			System.out.println("Reprodu��o n�o realizada");
		}
	}

	@Override
	public void pause() {
		if(this.getLigado() && this.getTocando()) {
			this.setTocando(false);
		} else {
			System.out.println("Pausa n�o realizada");
		}
	}
	
	
}
