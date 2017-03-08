import java.util.Scanner;

/**
 * @author alber_000
 */
public class Tasca4 {

    String entrarCadena(String missatgeExplicatiu) {
        System.out.print(missatgeExplicatiu);
        Scanner lector = new Scanner(System.in);
        String text1 = lector.nextLine();
        lector.nextLine();

        return text1;
    }

    String entrarDataAmbDef(String missatgeExplicatiu, String defaultValue) {
        String defecte; // defecte es igual a defaultValue - No cal que el posis de nou
        boolean dataOk;
        dataOk = esData( ?????????);
        Scanner data = new Scanner(System.in);
        // No tinc molt clar com funciona el Scanner pero quan l'usuari t'envia un 'Enter' has de guardar les dades
        // Un cop tens les dades guardades comproves si es igual a "" (es a dir, length == 0). Si ho es, tornes defaultValue
        // Si no es == a "" has de mirar si es data... boolean b = esData(data) -> Si no es data error! I el que toqui
        do {
            System.out.print(missatgeExplicatiu);
            if (!dataOk) { // Si ho fas aixi, dataOK ha de ser true si l'usuari ha posat una data o has assignat el default
                data.next();
                System.out.println("Data no vàlida! Torna-hi.");
            }
            defecte = data.next();
        } while (!dataOk);
        data.nextLine();

        return defecte;
    }

    boolean esData(String data) {

        if (!caractersCorrectes(data)) {
            return false;
        }
        String[] components = data.split("/");
        if (components.length != 3) {
            // Format ha de ser dd/mm/yyyy
            return false;
        }

        // La data nomes té digits i / i com a minim té 3 components
        String dia = components[0];
        String mes = components[1];
        String any = components[2];

        if (!anyCorrecte(any)) {
            return false;
        }

        if (!mesCorrecte(mes)) {
            return false;
        }

        return diaCorrecte(dia, mes);
    }

    private boolean diaCorrecte(String diaStr, String mesStr) {
        Integer dia = Integer.valueOf(diaStr);
        Integer mes = Integer.valueOf(mesStr);

        int[] diesMesos = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int maxDies = diesMesos[mes - 1];

        return (1 <= dia && dia <= maxDies);
    }

    private boolean mesCorrecte(String mes) {
        Integer mesNumeric = Integer.valueOf(mes);
        boolean llargadaMes = mes.length() == 2;

        return (mesNumeric >= 1 && mesNumeric <= 12) && llargadaMes;
    }

    private boolean anyCorrecte(String any) {
        return (any.length() == 4);
    }

    char[] particionaCadena(String text) {
        char[] chars = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }

        return chars;
    }

    boolean esNumero(char c) {
        char[] numeros = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for (char n : numeros) {
            if (n == c)
                return true;
        }

        return false;
    }

    /**
     * true si només té numeros o '/'
     *
     * @param text a comprovar
     * @return true si te nomes números o '/' i fals si no
     */
    boolean caractersCorrectes(String text) {
        char[] caracters = particionaCadena(text);

        for (int i = 0; i < caracters.length; i++) {
            char c = caracters[i];
            if (!(c == '/' || esNumero(c)))
                return false;
        }

        return true;
    }

    // boolean confirmarAmbDef(String missatgeExplicatiu, char defaultValue){
    //PENDENT!
    // }

    /*******************/
    /*                Activitat A404 Tasca 7               */
    /*                   Codi per provar                   */
    /*******************/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tasca4 prg = new Tasca4();
        prg.prova();
    }

    void prova() {

        boolean confirmacio;
        String valor;

        //Prova la funció entrarText
        valor = entrarCadena("Entra un text qualsevol. Pot ser buit:\n");
        System.out.print("El texte entrat per teclat és: ");
        System.out.println(valor);

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        valor = entrarDataAmbDef(
                "Entra una data qualsevol. No deixa entrar dates no valides.\nSi entres una cadena buita, retornarà \"24/03/2000\":\n",
                "24/03/2000");

        System.out.print("El texte entrat per teclat és: ");
        System.out.println(valor);

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        valor = entrarDataAmbDef("Entra una data qualsevol. No deixa entrar dates no valides:\n", "");
        System.out.print("El texte entrat per teclat és: ");
        System.out.println(valor);

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        //confirmacio = confirmarAmbDef("Confirmació 1: afirmatiu per defecte. Vols confirmar? (S/n) ", 's');
        System.out.print("La resposta a la confirmació ha estat: ");
        //System.out.println(confirmacio?"Si":"No");

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        //confirmacio = confirmarAmbDef("Confirmació 2: negatiu per defecte. Vols confirmar? (s/N) ", 'n');
        System.out.print("La resposta a la confirmació ha estat: ");
        //System.out.println(confirmacio?"Si":"No");

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        //confirmacio = confirmarAmbDef("Confirmació 3: cal contestar. Vols confirmar? (s/n) ", '\0');
        System.out.print("La resposta a la confirmació ha estat: ");
        //System.out.println(confirmacio?"Si":"No");

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        //confirmacio = confirmarAmbDef("Confirmació 4: cal contestar. Vols confirmar? (s/n) ", '\0');
        System.out.print("La resposta a la confirmació ha estat: ");
        //System.out.println(confirmacio?"Si":"No");
    }

}
