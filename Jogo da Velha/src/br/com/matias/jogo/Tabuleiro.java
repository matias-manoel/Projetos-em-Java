package br.com.matias.jogo;

/**
 *
 * @author Matias
 */
public class Tabuleiro
{
    private int tabuleiro[][] = new int[3][3];
    
    public Tabuleiro()
    {
        zerarTabuleiro();
    }
    
    public void zerarTabuleiro()
    {
        for(int l = 0; l < 3; l++)
            for(int c = 0; c < 3; c++)
                tabuleiro[l][c] = 0;
    }
    
    public void exibeTabuleiro()
    {
        System.out.println();
        for(int l = 0; l < 3; l++)
        {
            for(int c = 0; c < 3; c++)
            {
                if(tabuleiro[l][c] == -1)
                    System.out.print(" X ");
                if(tabuleiro[l][c] == 1)
                    System.out.print(" O ");
                if(tabuleiro[l][c] == 0)
                    System.out.print("   ");
                if(c == 0 || c == 1)
                    System.out.print("|");
            }
            System.out.println();
        }
    }
    
    public int getPosicao(int tentativa[])
    {
        return tabuleiro[tentativa[0]][tentativa[1]];
    }
    
    public void setPosicao(int tentativa[], int jogador)
    {
        if(jogador == 1)
            tabuleiro[tentativa[0]][tentativa[1]] = -1;
        else
            tabuleiro[tentativa[0]][tentativa[1]] = 1;
        exibeTabuleiro();
    }
    
    public int checaLinhas()
    {
        for(int l = 0; l < 3; l++)
        {
            if((tabuleiro[l][0] + tabuleiro[l][1] + tabuleiro[l][2]) == -3)
                return -1;
            if((tabuleiro[l][0] + tabuleiro[l][1] + tabuleiro[l][2]) == 3)
                return 1;
        }
        return 0;
    }
    
    public int checaColunas()
    {
        for(int c = 0; c < 3; c++)
        {
            if((tabuleiro[0][c] + tabuleiro[1][c] + tabuleiro[2][c]) == -3)
                return -1;
            if((tabuleiro[0][c] + tabuleiro[1][c] + tabuleiro[2][c]) == 3)
                return 1;
        }
        return 0;
    }
    
    public int checaDiagonais()
    {
        if((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
            return -1;
        if((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
            return 1;
        if((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
            return -1;
        if((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
            return 1;
        return 0;
    }
    
    public boolean tabuleiroCompleto()
    {
        for(int l = 0; l < 3; l++)
            for(int c = 0; c < 3; c++)
                if(tabuleiro[l][c] == 0)
                    return false;
        return true;
    }
}