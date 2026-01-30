import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataHora {
    Scanner leitura = new Scanner(System.in);
    LocalDate dataAtual = LocalDate.now();
    LocalTime horaAtual = LocalTime.now();

    public void dataHoraAtual() {
        String relatorio;

        System.out.println("Enviar relatório semanal? (S/N)");
        relatorio = leitura.nextLine();

        while (!relatorio.equalsIgnoreCase("S") && !relatorio.equalsIgnoreCase("N")) {
            System.out.println("Resposta inválida.\nEnviar relatório semanal? (S/N)");
            relatorio = leitura.nextLine();
        }

        if (relatorio.equalsIgnoreCase("S")) {
            System.out.println("Relatório criado! \nData atual: " + dataAtual + "\nHoraAtual: " + horaAtual);
        } else if (relatorio.equalsIgnoreCase("N")) {
            System.out.println("Nenhum relatório será criado.");
        }
    }

    public void formataDataHoraAtual() {
        DateTimeFormatter dataAtualformatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter horaAtualformatada = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Data atual formatada: " +  dataAtual.format(dataAtualformatada) + "\nHora atual formatada: " + horaAtual.format(horaAtualformatada));
    }

    public void diferencaHorasMinutos() {
        int horaInicio;
        int minutoInicio;
        int horaTermino;
        int minutoTermino;

        System.out.println("Digite a hora de início da atividade:");
        horaInicio = leitura.nextInt();
        System.out.println("Digite os minutos do início da atividade:");
        minutoInicio = leitura.nextInt();

        System.out.println("Digite a hora do término da atividade:");
        horaTermino = leitura.nextInt();
        System.out.println("Digite os minutos do término da atividade:");
        minutoTermino = leitura.nextInt();

        LocalTime inicio = LocalTime.of(horaInicio, minutoInicio);
        LocalTime termino = LocalTime.of(horaTermino, minutoTermino);
        Duration duracao = Duration.between(inicio, termino);

        System.out.println("Diferença de tempo:" + duracao.toHours() + " horas e " + duracao.toMinutesPart() + " minutos");
    }

    public void dataEntrega() {
        System.out.print("Digite a data (dd-MM-yyyy): ");
        String dataTexto = leitura.nextLine();
        System.out.println("Digite o prazo em dias: ");
        int diasPrazo = leitura.nextInt();

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataInicioFormatada = LocalDate.parse(dataTexto, dataFormatada);
        LocalDate dataEntrega = dataInicioFormatada.plusDays(diasPrazo);

        System.out.println("Data de entrega: " + dataEntrega.format(dataFormatada));
    }

    public void ajustaVencimento() {
        System.out.print("Digite a data (dd-MM-yyyy): ");
        String dataTexto = leitura.nextLine();
        System.out.println("Digite o número de meses para o vencimento: ");
        int mesesVencimento = leitura.nextInt();

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataInicioFormatada = LocalDate.parse(dataTexto, dataFormatada);
        LocalDate dataVencimento = dataInicioFormatada.plusMonths(mesesVencimento);

        System.out.println("Data de entrega: " + dataVencimento.format(dataFormatada));
    }
}
