import java.util.Scanner;

class AnalizadorTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Analizador de Texto - Herramienta Linguistica v2.0");
        System.out.println("Introduce un texto (mínimo 10 caracteres):");
        String textoUsuario = scanner.nextLine();

        if (textoUsuario.length() < 10) {
            System.out.println("El texto es demasiado corto");
            return;
        }

        int vocales = 0;
        int consonantes = 0;
        int numeros = 0;
        int espacios = 0;
        int otros = 0;

        for (int i = 0; i < textoUsuario.length(); i++) {
            char caracter = textoUsuario.charAt(i);
            if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z')) {
                if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u' ||
                    caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U') {
                    vocales++;
                } else {
                    consonantes++;
                }
            } else if (caracter >= '0' && caracter <= '9') {
                numeros++;
            } else if (caracter == ' ') {
                espacios++;
            } else {
                otros++;
            }
        }

        CaracteristicasYEstadisticas(textoUsuario, consonantes, vocales, numeros, espacios, otros);
        
        ComplejidadLectura(textoUsuario, vocales, consonantes, espacios, otros, numeros);
       
        OracionFormato(textoUsuario, espacios);
        
    }

    static void CaracteristicasYEstadisticas (String textoUsuario, int vocales, int consonantes, int numeros, int espacios, int otros) {
        System.out.println("ESTADÍSTICAS BÁSICAS");
        System.out.println("Longitud: " + textoUsuario.length());
        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);
        System.out.println("Números: " + numeros);
        System.out.println("Espacios: " + espacios);
        System.out.println("Otros: " + otros);

        if (vocales > consonantes && consonantes > 0 && textoUsuario.length() > 20 && espacios >= 2 && numeros == 0) {
            System.out.println("Categoría: Texto literario con alta densidad vocálica");
        } else if (consonantes > vocales && vocales > 0 && textoUsuario.length() > 15 && (otros >= 3 || numeros >= 2) && espacios >= 1) {
            System.out.println("Categoría: Texto técnico o científico");
        } else if (numeros > 5 && (vocales + consonantes) < textoUsuario.length() / 2 && espacios < textoUsuario.length() / 10 && otros >= 2) {
            System.out.println("Categoría: Código o expresión matemática");
        } else if (espacios > textoUsuario.length() / 5 && vocales > 0 && consonantes > 0 && numeros < 3 && otros < vocales / 2) {
            System.out.println("Categoría: Texto informal o conversacional");
        } else {
            System.out.println("Categoría: Texto genérico");
        }

        int palabras = 1;
        for (int i = 0; i < textoUsuario.length(); i++) {
            if (textoUsuario.charAt(i) == ' ' && i < textoUsuario.length() - 1 && textoUsuario.charAt(i + 1) != ' ') {
                palabras++;
            }
        }
        System.out.println("Palabras estimadas: " + palabras);
    }

    static void ComplejidadLectura(String textoUsuario, int vocales, int consonantes, int espacios, int otros, int numeros) {
         double densidadVocales = (vocales * 100.0) / textoUsuario.length();
        if (densidadVocales > 45 && vocales > 10 && consonantes > 5 && espacios > 2) {
            System.out.println("¡Texto muy fluido!");
        } else if (densidadVocales < 25 && consonantes > 10 && (otros > 5 || numeros > 3)) {
            System.out.println("Texto complejo de leer");
        }
    }

    static void OracionFormato(String textoUsuario, int espacios) {
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        for (int i = 0; i < textoUsuario.length(); i++) {
            char caracter = textoUsuario.charAt(i);
            if (caracter >= 'A' && caracter <= 'Z') {
                tieneMayuscula = true;
            }
            if (caracter >= 'a' && caracter <= 'z') {
                tieneMinuscula = true;
            }
        }

        if (tieneMayuscula && tieneMinuscula && textoUsuario.charAt(0) >= 'A' && textoUsuario.charAt(0) <= 'Z' && (textoUsuario.charAt(textoUsuario.length() - 1) == '.' || textoUsuario.charAt(texto.length() - 1) == '!' || textoUsuario.charAt(textoUsuario.length() - 1) == '?') && espacios > 0) {
            System.out.println("Formato: Oración bien formada");
        } else if (tieneMayuscula && !tieneMinuscula && numeros >= 2 && espacios < textoUsuario.length() / 10) {
            System.out.println("Formato: Código o identificador");
        } else {
            System.out.println("Formato: Variado");
        }
    }

}








