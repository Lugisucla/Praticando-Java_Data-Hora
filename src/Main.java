
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataHora dataHora = new DataHora();
        Scanner scanner = new Scanner(System.in);

        String menu = "Digite o número da funcionalidade que deseja testar:\n" +
                "1 - Data e hora atual\n" +
                "2 - Formatando data e hora para relatórios\n" +
                "3 - Diferença entre horas\n" +
                "4 - Calculando a data de entrega\n" +
                "5 - Ajustando a data de vencimento\n" +
                "6 - Verificando a data de um evento\n" +
                "7 - Lembrete de pagamento\n" +
                "8 - Fuso horário\n" +
                "9 - Convertendo horário para outro fuso\n" +
                "10 - Controle de expediente\n" +
                "0 - Sair";

        System.out.println(menu);

        int escolha = -1;

        while (escolha != 0) {

            System.out.println(menu);
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    dataHora.dataHoraAtual();
                    break;
                case 2:
                    dataHora.formataDataHoraAtual();
                    break;
                case 3:
                    dataHora.diferencaHorasMinutos();
                    break;
                case 4:
                    dataHora.dataEntrega();
                    break;
                case 5:
                    dataHora.ajustaVencimento();
                    break;
                case 6:
                    dataHora.verificaEvento();
                    break;
                case 7:
                    dataHora.lembretePagamento();
                    break;
                case 8:
                    System.out.println("Funcionalidade temporariamente indisponível!");
                    break;
                case 9:
                    System.out.println("Funcionalidade temporariamente indisponível!");
                    break;
                case 10:
                    System.out.println("Funcionalidade temporariamente indisponível!");
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Não existe nenhuma funcionalidade com esse número!");
            }
        }

        scanner.close();
    }
}