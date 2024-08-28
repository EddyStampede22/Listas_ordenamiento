import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Correlacion {
    public static double media(int posicion) throws IOException {
        FileReader archivoFisico = new FileReader("out/production/Desarrollo3/hola.csv");
        BufferedReader archivoLogico = new BufferedReader(archivoFisico);
        String registro = null;
        double suma = 0.0;
        int contador = 0;
        archivoLogico.readLine(); // leer encabezado con nombres de columna
        String campos[];

        while ( (registro = archivoLogico.readLine()) != null ) {
            campos = registro.split(",");
            suma += Double.parseDouble(campos[posicion]);
            contador++;
        }
        archivoLogico.close();
        archivoFisico.close();
        return suma/contador;
    }
    public static double desviacion(int posicion) throws IOException {
        FileReader archivoFisico = new FileReader("out/production/Desarrollo3/hola.csv");
        BufferedReader archivoLogico = new BufferedReader(archivoFisico);
        String registro = null;
        double suma = 0.0;
        int contador = 0;
        double numero=0.0;
        double desviacionfinal=0.0;
        archivoLogico.readLine(); // leer encabezado con nombres de columna
        String campos[];

        while ( (registro = archivoLogico.readLine()) != null ) {
            campos = registro.split(",");
            numero=Double.parseDouble(campos[posicion])-media(posicion);
            suma += Math.pow(numero,2);
            contador++;
        }
        desviacionfinal=Math.sqrt(suma/(contador-1));
        archivoLogico.close();
        archivoFisico.close();
        return desviacionfinal;
    }
    public static double PearsonCoefficient(int posicion1,int posicion2) throws IOException {
        FileReader archivoFisico = new FileReader("out/production/Desarrollo3/hola.csv");
        BufferedReader archivoLogico = new BufferedReader(archivoFisico);
        String registro = null;
        double suma = 0.0;
        int contador = 0;
        double normalizacion1=0.0;
        double normalizacion2=0.0;
        archivoLogico.readLine(); // leer encabezado con nombres de columna
        String campos[];

        while ( (registro = archivoLogico.readLine()) != null ) {
            campos = registro.split(",");
            normalizacion1=(Double.parseDouble(campos[posicion1])-media(posicion1))/(desviacion(posicion1));
            normalizacion2=(Double.parseDouble(campos[posicion2])-media(posicion2))/(desviacion(posicion2));
            suma += normalizacion1*normalizacion2;
            contador++;
        }
        archivoLogico.close();
        archivoFisico.close();
        return suma/(contador-1);

    }
    public static String haycorrelacion(double pearson) {
        if (pearson == 0) {
            return "Es correlación NULA";
        } else if (pearson == 1) {
            return "Es correlación positiva PERFECTA";
        } else if (pearson > 0 & pearson < 1) {
            return "Es correlacion postiva";
        } else if (pearson < 0 & pearson > -1) {
            return "Es correlacion negativa";
        } else if (pearson == -1) {
            return "Es correlacion negativa PERFECTA";
        }
        return "no hay un numero";
    }
    public static void main(String[] args) throws IOException {
        // CORRELACION ENTRE PROFIT Y R&D SPEND
        System.out.println("EL VALOR DE CORRELACION ENTRE PROFIT Y R&D SPEND = "+PearsonCoefficient(4,0));
        System.out.println("LA CORRELACION ENTRE PROFIT Y R&D SPEND = "+haycorrelacion(PearsonCoefficient(4,0)));

        // CORRELACION ENTRE PROFIT Y MARKETING
        System.out.println("EL VALOR DE CORRELACION ENTRE PROFIT Y MARKETING = "+PearsonCoefficient(4,2));
        System.out.println("LA CORRELACION ENTRE PROFIT Y MARKETING = "+haycorrelacion(PearsonCoefficient(4,2)));


    }
}
