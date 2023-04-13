package Utilidades;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static Utilidades.Leitura.ler;

public class ValidacaoData {
    public LocalDate LerData2() {
        try {
            LocalDate data;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(ler.nextLine(), formatter);
            return data;
        } catch (Exception ex) {
            System.out.println("Data invalida, insira uma data com o formato (dd/MM/aaaa):");
            return LerData2();
        }
    }
}

