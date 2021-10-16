package pacote.controle.remoto;

public interface Controlador {
    public abstract void ligar();
    public abstract void desligar();
    public abstract void abrirMenu();
    public abstract void maisVolume();
    public abstract void menosVolume();
    public abstract void selecionarCanal(int canal);
    public abstract void ligarMudo();
    public abstract void desligarMudo();
    public abstract void play();
    public abstract void pause();
}
