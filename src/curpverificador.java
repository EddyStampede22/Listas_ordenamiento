import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class curpverificador {
    public static void main(String[] args) throws IOException {
        FileReader archivo = new FileReader("ruta donde se encuentra el archivo .txt");
        BufferedReader archivo2 = new BufferedReader(archivo);
        String linea="";
        int contador=1;
        Pattern pat= Pattern.compile("^[A-Z]{4}[0-9]{2}[^2-9][^3-9][^4-9][1-9]([MF])(SA|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[A-Z]{3}[0-9]{2}");


        while ((linea=archivo2.readLine())!=null) {
            Matcher matcher=pat.matcher(linea);
            if (!(matcher.matches())) {
                System.out.println("Curp no valida: "+linea + " se encontro en la posicion  "+contador);
            }
            contador++;
        }
        archivo2.close();
        archivo.close();
    }
}
