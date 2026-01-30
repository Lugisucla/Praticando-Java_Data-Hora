import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class DataHora {
    Scanner leitura = new Scanner(System.in);

    public void dataHoraAtual() {
        LocalDate dataAtual = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();
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
}
