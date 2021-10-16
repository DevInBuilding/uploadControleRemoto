package pacote.controle.remoto;

public class ControleRemoto implements Controlador{
    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    private int canal;

    //Métodos especiais - construtor e getters and setters in private mode
    public ControleRemoto() {
            this.volume = 50;
            this.ligado = false;
            this.tocando = false;
            this.canal = 30;
    }

    //Volume
    private int getVolume() {
            return volume;
    }
    private void setVolume(int volume) {
            this.volume = volume;
    }
    //Ligado
    private boolean isLigado() {
            return ligado;
    }
    private void setLigado(boolean ligado) {
            this.ligado = ligado;
    }
    //Tocando
    private boolean isTocando() {
            return tocando;
    }
    private void setTocando(boolean tocando) {
            this.tocando = tocando;
    }
    //Canal
    private int getCanal() {
            return canal;
    }
    private void setCanal(int canal) {
            this.canal = canal;
    }

    /*Métodos Abstratos*/

    //Ligar\Desligar
    @Override
    public void ligar() {
            this.setLigado(true);
    }

    @Override
    public void desligar() {
            this.setLigado(false);
    }

    //Volume
    @Override
    public void maisVolume() {
            if(this.isLigado() && this.getVolume() < 100) {
                    this.setVolume(this.getVolume() + 5);
                    System.out.println("\n\tVolume " + volume + "\n");
            } else if(this.isLigado() && this.getVolume() == 100) {
                    this.setVolume(100);
                    System.out.println("\n\tVolume máximo\n");
            }
    }

    @Override
    public void menosVolume() {
            if(this.isLigado() && this.getVolume() > 0) {
                    this.setVolume(this.getVolume() - 5);
                    System.out.println("\n\tVolume " + volume + "\n");
            } else if(this.isLigado() && this.getVolume() == 0) {
                    this.setVolume(0);
                    System.out.println("\n\tSem som\n");
            }
    }

    //Ativar\Desativar som -- Rever métodos
    @Override
    public void ligarMudo() {
            if(this.isLigado() && this.getVolume() > 0) {
                    this.setVolume(0);
                    System.out.println("\n\tSem som\n");
            } else {
                    System.out.println("\n\tSem som\n");
            }
    }

    @Override
    public void desligarMudo() {
            if(this.isLigado() && this.getVolume() == 0) {
                    this.setVolume(30);
                    System.out.println("\n\tVolume " + volume + "\n");
            } else {
                    System.out.println("\n\tVolume " + volume + "\n");
            }
    }

    //Canal
    @Override
    public void selecionarCanal(int canal) {
            if(this.isLigado()) {
                    this.setCanal(canal);
                    System.out.println("\n\tCanal " + canal + " selecionado.\n");
            }
    }


    //Play\Pause
    @Override
    public void play() {
            if(this.isLigado() && !(this.isTocando())) {
                    this.setTocando(true);
                    System.out.println("\n\tEm reprodução...\n");
            } else {
                    System.out.println("\n\tJá está em reprodução.\n");
            }
    }

    @Override
    public void pause() {
            if(this.isLigado() && this.isTocando()) {
                    this.setTocando(false);
                    System.out.println("\n\tPausado\n");
            } else {
                    System.out.println("\n\tJá está pausado!\n");
            }
    }

    //Menu
    @Override
    public void abrirMenu() {
            System.out.println("----- MENU -----");
            System.out.println("Está tocando? " + this.isTocando());
            System.out.println("Canal: " + this.getCanal());
            System.out.print("Volume: " + this.getVolume());
            for(int i = 0; i < this.getVolume(); i+=10) {
                    System.out.print(" | ");
            }
            System.out.println("");
    }

    //"Limpar tela"
    public void limparTela() {
            for(int i = 0; i < 20; i++) { System.out.println(); }
    }
}
