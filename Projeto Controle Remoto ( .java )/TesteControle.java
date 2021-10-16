package pacote.controle.remoto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteControle {
    public static void main (String[] args) {
        String escolha, selecao, volume, tocar, silenciar;
        int canal;
        ControleRemoto c = new ControleRemoto();
        Scanner ler = new Scanner(System.in);

        try {
            do {
                System.out.println("Deseja ligar o aparelho (s/n)? ");
                escolha = ler.next();
                if(escolha.equalsIgnoreCase("s")) {
                    System.out.println("INICIALIZANDO...\n");
                    c.ligar();
                    c.abrirMenu();

                    do {
                        System.out.println("\nQual operação deseja executar? \n[M - abrir Menu | C - selecionar Canal | V - alterar volume | S - ativar mudo | P - tocar | D - desligar]");
                        selecao = ler.next();
                        if(selecao.equalsIgnoreCase("D")){
                                System.out.println("ENCERRANDO A APLICAÇÃO...");
                                c.desligar();
                                break;

                        } else {
                                switch(selecao) {
                                    case "M": c.abrirMenu();
                                                            break;

                                    case "C": do{ //Valores negativos não serão aceitos na seleção de canais
                                                                    System.out.println("\nDigite o canal desejado: ");
                                                                    canal = ler.nextInt();
                                                                    if(canal < 0) { System.out.println("\n\tEntrada inválida!\n"); }
                                                      }while(canal < 0);
                                                      c.selecionarCanal(canal);
                                                            break;

                                    case "V": System.out.println("Quer aumentar ou diminuir o volume (+/-)? ");
                                                      volume = ler.next();
                                                      if(volume.equals("+")) { c.maisVolume(); }
                                                      else if(volume.equals("-")) { c.menosVolume(); }
                                                      else { System.out.println("\n\tEntrada Inválida\n"); }
                                                            break;

                                    case "S": System.out.println("Escolha o modo desejado (m - mudo / u - não mudo): ");
                                                      silenciar = ler.next();
                                                      if(silenciar.equalsIgnoreCase("m")) { c.ligarMudo(); }
                                                      else if(silenciar.equalsIgnoreCase("u")) { c.desligarMudo(); }
                                                      else { System.out.println("\n\tEntrada Inválida\n"); }
                                                            break;

                                    case "P": System.out.println("Escolha o modo desejado (play/pause): ");
                                                      tocar = ler.next();
                                                      if(tocar.equalsIgnoreCase("play")) { c.play(); }
                                                      else if(tocar.equalsIgnoreCase("pause")) { c.pause(); }
                                                      else { System.out.println("\n\tEntrada Inválida\n"); }
                                                            break;

                                    default: System.out.println("\n\tSeleção Inválida!\n");
                                                     c.limparTela();
                                }
                            }
                                
                    }while(selecao!="D");

                    break;

                    } else if(escolha.equalsIgnoreCase("n")) {
                            System.out.println("\n\tAté a próxima!\n");
                            break;
                    } else {
                            System.out.println("\n\t***Opção Inválida!\n");
                    }
                    ler.close();

            }while(escolha != "s" || escolha != "n");

        } catch(InputMismatchException erro) {
                System.err.println("\n\tERRO: " + erro);
        }
    }
}
