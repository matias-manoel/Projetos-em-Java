package br.com.matias.jogo;

import java.util.Random;

/**
 *
 * @author Matias
 */
public class Computador extends Jogador
{
    private Random aleatorio = new Random();

    public Computador(int jogador)
    {
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Computador' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro)
    {
        tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void tentativa(Tabuleiro tabuleiro)
    {
        do
        {
            do
            {
                System.out.print("Linha: ");
                tentativa[0] = aleatorio.nextInt(3) + 1;
                System.out.println(tentativa[0]);

                if((tentativa[0] < 1) || (tentativa[0] > 3))
                    System.out.println("Linha inválida. É 1, 2 ou 3!");
            }
            while((tentativa[0] < 1) || (tentativa[0] > 3));

            do
            {
                System.out.print("Coluna: ");
                tentativa[1] = aleatorio.nextInt(3) + 1;
                System.out.println(tentativa[1]);

                if((tentativa[1] < 1) || (tentativa[1] > 3))
                    System.out.println("Coluna inválida. É 1, 2 ou 3!");
            }
            while((tentativa[1] < 1) || (tentativa[1] > 3));

            tentativa[0]--;
            tentativa[1]--;

            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local já foi marcado. Tente outro!");
        }
        while(!checaTentativa(tentativa, tabuleiro));
    }
}