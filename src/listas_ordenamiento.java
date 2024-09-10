import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listas_ordenamiento {
    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Combinar las dos listas mientras haya elementos en ambas
        while (i < list1.size() && j < list2.size()) {
                result.add(list1.get(i));
                i++;
                result.add(list2.get(j));
                j++;
        }
        Collections.sort(result); // ordena de orden ascendente la nueva lista combinada
        return result;
    }

    public static void main(String[] args) {
        if (args.length <2) {
            System.out.println("Usa dos listas de números en la linea de comandos:");
            System.out.println("Ejemplo 1,3,4,6  7,8,23,56");
            return;
        }
        List<Integer> list1 = parseList(args[0]);
        List<Integer> list2 = parseList(args[1]);
        List<Integer> mergedList = merge(list1, list2);

        System.out.println("Lista combinada: " + mergedList);
    }
    private static List<Integer> parseList(String listString) {
        // metodo para convertir en lista los numeros ingresados en la linea de comandos
        List<Integer> finallist = new ArrayList<>();
        String[] values = listString.split(",");

        for (String value : values) {
            try {
                finallist.add(Integer.parseInt(value.trim()));
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato de número inválido en la lista: " + value);
                System.exit(1);
            }
        }

        return finallist;
    }
}
