
package diccionariodecontrasenas;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    final static String[] CHARLIST = {"A","B","C","D","E","F","G","H","I","J",
                                      "K","L","M","N","Ñ","O","P","Q","R","S",
                                      "T","U","V","W","X","Y","Z","0","1","2",
                                      "3","4","5","6","7","8","9"};
    static FileWriter writer;
    static int counter = 1; // Contador para el formato [n]
    
    public static void main(String[] args) {
        int combinationLength = 5; // Longitud de la combinación
        try {
            writer = new FileWriter("combinations.txt");
            generateCombinations(combinationLength, "");
            writer.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public static void generateCombinations(int length, String prefix) {
        if (length == 0) {
            try {
                writer.write("[" + counter + "]" + prefix + "\n");
                counter++;
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
            return;
        }
        
        for (int i = 0; i < CHARLIST.length; i++) {
            String newPrefix = prefix + CHARLIST[i];
            generateCombinations(length - 1, newPrefix);
        }
    }
}
