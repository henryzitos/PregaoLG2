package docs;

import entity.Investidor;
import entity.VendaAcao;

import java.io.*;

public class PersistenciaArquivo {
    public void main(String[] args) {
        leituraCustodiantes();
    }

    public void leituraCustodiantes() {
        String file = "src\\docs\\participantDownload.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String[] row = line.split(";");
                for(String index : row) {
                    System.out.printf("%-60s", index);
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
