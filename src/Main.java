import alura.screenmatch.calculos.CalculadoraDeTempo;
import alura.screenmatch.calculos.Classificavel;
import alura.screenmatch.calculos.FiltroRecomendacao;
import alura.screenmatch.modelos.Episodio;
import alura.screenmatch.modelos.Filme;
import alura.screenmatch.modelos.Serie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Filme filme = new Filme();
        Serie serie = new Serie();
        Episodio episodio = new Episodio();
        FiltroRecomendacao filtro = new FiltroRecomendacao();
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();

        while(true){
            System.out.println(Menu());
            String opcao = scanner.nextLine();

            switch (opcao){
                case "1":
                    CadastrarFilme(scanner, filme);
                    System.out.println(Menu2());
                    String opcao2 = scanner.nextLine();
                    switch (opcao2) {
                        case "1":
                            calculadora.inclui(filme);
                            System.out.println("O tempo para assistir " + filme.getNome() + " é de " + calculadora.getTempoTotal() + " min");
                            break;
                        case "2":
                            filme.avalia(7);
                            filme.avalia(9);
                            filme.avalia(6);
                            System.out.println("Total de avaliações: " + filme.getTotalDeAvaliacoes());
                            System.out.println("A média das avaliações do filme " + filme.getNome() + " é de " + filme.pegaMedia());
                            break;
                        case "3":
                            filtro.filtra(filme);
                        default:
                            System.out.println("Opção inválida.");
                            return;
                    }
                    break;
                case "2":
                    CadastrarSerie(scanner, serie);
                    System.out.println(Menu2());
                    String opcao3 = scanner.nextLine();
                    switch (opcao3) {
                        case "1":
                            calculadora.inclui(serie);
                            System.out.println("O tempo para assistir " + serie.getNome() + " é de " + calculadora.getTempoTotal() + " min");
                            break;
                        case "2":
                            serie.avalia(8);
                            serie.avalia(9);
                            serie.avalia(6);
                            System.out.println("Total de avaliações: " + serie.getTotalDeAvaliacoes());
                            System.out.println("A média das avaliações da serie " + serie.getNome() + " é de " + serie.pegaMedia());
                            break;
                        case "3":
                            System.out.print("É necessário cadastrar ao menos um episodio dessa série: ");
                            System.out.print("Numéro do episódio: ");
                            episodio.setNumero(scanner.nextInt());
                            episodio.setSerie(serie);
                            episodio.setTotalVisualizacoes(400);
                            filtro.filtra(episodio);

                        default:
                            System.out.println("Opção inválida.");
                            return;
                    }
                    break;
                case "3":
                    System.out.println("Até a próxima!");
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    public static void CadastrarFilme(Scanner scanner, Filme filme){
        System.out.print("Nome do filme: ");
        String nomeFilme = scanner.nextLine();
        filme.setNome(nomeFilme);

        System.out.print("Ano de lançamento: ");
        int ano = scanner.nextInt();
        filme.setAnoDelancamento(ano);
        scanner.nextLine();

        System.out.print("Diretor do filme: ");
        String diretor = scanner.nextLine();
        filme.setDiretor(diretor);

        System.out.print("Duração do filme em minutos: ");
        int duracao = scanner.nextInt();
        filme.setDuracaoEmMinutos(duracao);
        scanner.nextLine();

        System.out.println("Filme cadastrado com sucesso!");
        filme.exibeFichaTecnica();
    }

    public static void CadastrarSerie(Scanner scanner, Serie serie){
        System.out.print("Nome da serie: ");
        String nomeSerie = scanner.nextLine();
        serie.setNome(nomeSerie);

        System.out.print("Ano de lançamento: ");
        int ano = scanner.nextInt();
        serie.setAnoDelancamento(ano);

        System.out.print("Quantas temporadas: ");
        int temporadas = scanner.nextInt();
        serie.setTemporadas(temporadas);

        System.out.print("Episódios por temporada: ");
        int episodios = scanner.nextInt();
        serie.setEpisodiosPorTemporada(episodios);

        System.out.print("Duração da serie em minutos: ");
        int duracao = scanner.nextInt();
        serie.setDuracaoEmMinutos(duracao);
        scanner.nextLine();

        System.out.println("Serie cadastrada com sucesso!");
        serie.exibeFichaTecnica();
        scanner.nextLine();

    }
    public static String Menu(){
        return ("""
                [1] - Cadastrar Filme
                [2] - Cadastrar Série
                [3] - Sair
                """);
    }

    public static String Menu2(){
        return ("""
                [1] - Calcular tempo de tela
                [2] - Avaliações
                [3] - Recomendação
                """);
    }
}