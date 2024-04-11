
package diccionariodecontrasenas;

public class Main {
    
    final static String[] CHARLIST = {"A","B","C","D","E","F","G","H","I","J",
                                      "K","L","M","N","Ñ","O","P","Q","R","S",
                                      "T","U","V","W","X","Y","Z","0","1","2",
                                      "3","4","5","6","7","8","9"};
    static int contador = 1;
    
    public static void main(String[] args) {
        int longitudDeContraseña = 4; // Longitud de la combinación
        generarDiccionario(longitudDeContraseña, "");
    }
    
    public static void generarDiccionario(int length, String prefix) {
        if (length == 0) {
            System.out.println("["+contador+"]"+prefix);
            contador++;
            return;
        }
        
        for (int i = 0; i < CHARLIST.length; i++) {
            String newPrefix = prefix + CHARLIST[i];
            generarDiccionario(length - 1, newPrefix);
        }
    }
}

