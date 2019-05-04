package br.com.controleRemotoInterface;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class ControleRemoto implements Controlador {

    //Attributes
    private boolean menu;
    private int volume;
    private boolean ligado;
    private boolean tocando;

    //Methods


    public ControleRemoto() {
        this.volume = 0;
        this.ligado = false;
        this.tocando = false;
        this.menu = false;
    }

    private boolean getMenu() {
        return menu;
    }

    private void setMenu(boolean menu) {
        this.menu = menu;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }


    @Override
    public void ligar() {
        this.setLigado(true);
        this.setMenu(true);
        this.setVolume(50);
        System.out.println("APARELHO LIGADO!\n");
    }

    @Override
    public void desligar() {
        if (getLigado()) {
            this.setLigado(false);
            System.out.println("\nDESLIGANDO APARELHO...\n" +
                    "APARELHO DESLIGADO COM SUCESSO!");
        } else {
            System.out.print("SEU APARELHO ESTÁ DESLIGADO!\n");
            System.out.print("DESEJA LIGAR? 1)SIM 2)NÃO\n");
            Scanner sc = new Scanner(System.in);
            int escolha = sc.nextInt();

            if (escolha==1){
                ligar();
            }else{
                System.out.print("APARELHO PERMANECE DESLIGADO!");
            }


            /*int i = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um texto:");
        while(sc.hasNext()){
            i++;
            System.out.println("Token: "+sc.next());
        }
        sc.close(); //Encerra o programa*/

        }
        }

    @Override
    public void abrirMenu () {
        if (getLigado()) {
            System.out.println("------> MENU <-------");
            System.out.println("LIGADO? " + this.getLigado());
            System.out.println("TOCANDO? " + this.getTocando());
            System.out.print("VOLUME: " + this.getVolume());
            for (int i = 0; i <= this.getVolume(); i += 10) {
                System.out.print("|");
            } System.out.print("\n");
        } else {
            System.out.print("ERROR! MENU SÓ FUNCIONA COM APARELHO LIGADO!");
        }
    }


    @Override
    public void fecharMenu() {
        System.out.println("Fechando menu...");
    }

    @Override
    public void maisVolume() {
        if (getLigado()) {
            this.setVolume(this.getVolume() + 5);
            for (int i = 0; i <= this.getVolume(); i += 10) {
                System.out.print("|");
            }
            System.out.println(">>>   VOLUME.... <<" + getVolume() + ">>");
        } else {
            System.out.println("Impossivel aumentar volume... Aparelho desligado!");
        }

    }

    @Override
    public void menosVolume() {
        if (getLigado()) {
            this.setVolume(this.getVolume() - 5);
            System.out.println(">>>   VOLUME.... <<" + getVolume() + ">>");
        } else {
            System.out.println("Impossivel abaixar volume... Aparelho desligado!");
        }
    }

    @Override
    public void ligarMudo() {
        if (getLigado() && getVolume() > 0) {
            this.setVolume(0);
        }

    }

    @Override
    public void desligarMudo() {
        if (getLigado() && this.getVolume() == 0) {
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (getLigado() && !(this.getTocando())) {
            this.setTocando(true);
            System.out.println(">>>  PLAY <<<");
        } else {
            System.out.println("Não consegui reproduzir!");
        }
    }

    @Override
    public void pause() {
        if (getLigado() && getTocando()) {
            System.out.println(">>>  PAUSE <<<");
            this.setTocando(false);
        } else {
            System.out.println("Não consegui pausar!");
        }
    }
}


