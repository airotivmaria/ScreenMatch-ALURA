package alura.screenmatch.calculos;

import alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    public void inclui(Titulo titulo){
        System.out.println("Adicionando duração em minutos de " + titulo.getNome());
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
