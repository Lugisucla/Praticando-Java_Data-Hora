import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    public void verificaEvento() {
        System.out.print("Digite a data do evento (dd-MM-yyyy): ");
        String dataEvento = leitura.nextLine();

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataEventoFormatada = LocalDate.parse(dataEvento, dataFormatada);

        if (dataEventoFormatada.isBefore(LocalDate.now())) {
            System.out.println("O evento já ocorreu.");
        } else if (dataEventoFormatada.isEqual(LocalDate.now())) {
            System.out.println("O evento é hoje!");
        } else {
            System.out.println("O evento já ocorreu.");
        }
    }

    public void lembretePagamento() {
        System.out.println("Digite a data do vencimento (dd-MM-yyyy): ");
        String dataVencimento = leitura.nextLine();

        System.out.println("Digite a quantidade de dias restantes para começar a receber o lembrete: ");
        int diasFaltando = leitura.nextInt();

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataVencimentoFormatada = LocalDate.parse(dataVencimento, dataFormatada);
        LocalDate inicioLembrete = dataVencimentoFormatada.minusDays(diasFaltando);

        if (!dataAtual.isBefore(inicioLembrete) &&
                !dataAtual.isAfter(dataVencimentoFormatada)) {
            System.out.println("Data do lembrete: " + inicioLembrete.format(dataFormatada));
        } else {
            System.out.println("Nenhum vencimento recente.");
        }
    }

    public void fusoHorario() {
        DateTimeFormatter horaFormatada = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZonedDateTime horaAtualBrasil = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime horaAtualToquio = horaAtualBrasil.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));

        System.out.println("Horário atual em São Paulo: " + horaAtualBrasil.format(horaFormatada));
        System.out.println("Horário atual em Tóquio: " + horaAtualToquio.format(horaFormatada));
    }

    public void converteFuso() {
        DateTimeFormatter horaFormatada = DateTimeFormatter.ofPattern("HH:mm");
        ZonedDateTime horaAtualBrasil = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime horaAtualSydney = horaAtualBrasil.withZoneSameInstant(ZoneId.of("Australia/Sydney"));


        System.out.println("Horário atual em São Paulo: " + horaAtualBrasil.format(horaFormatada));
        System.out.println("Horário atual em Sydney: " + horaAtualSydney.format(horaFormatada));
    }

    public void controlaExpediente() {
        DateTimeFormatter horaMinuto = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Digite o horário de entrada (HH:mm): ");
        LocalTime horarioEntrada = LocalTime.parse(leitura.next(), horaMinuto);

        System.out.println("Digite a carga horária diária (em horas):");
        int cargaHoraria = leitura.nextInt();

        System.out.println("Digite o horário real de saída (HH:mm):");
        LocalTime horarioRealSaida = LocalTime.parse(leitura.next(), horaMinuto);

        LocalTime horarioPrevistoSaida = horarioEntrada.plusHours(cargaHoraria);

        System.out.println("Horário de entrada: " + horarioEntrada);
        System.out.println("Horário de saída previsto: " + horarioPrevistoSaida);
        System.out.println("Horário real de saída: " + horarioRealSaida);

        int minutosPrevisto = horarioPrevistoSaida.getHour() * 60 + horarioPrevistoSaida.getMinute();
        int minutosReal = horarioRealSaida.getHour() * 60 + horarioRealSaida.getMinute();
        int minutosSaldo = minutosReal - minutosPrevisto;

        if (minutosSaldo > 0) {
            System.out.println("Saldo de horas: +" + (minutosSaldo / 60) + "h " + (minutosSaldo % 60) + "min");
        } else if (minutosSaldo < 0) {
            minutosSaldo = Math.abs(minutosSaldo);
            System.out.println("Saldo de horas: -" + (minutosSaldo / 60) + "h " + (minutosSaldo % 60) + "min");
        } else {
            System.out.println("Saldo de horas: 0h");
        }
    }
}
