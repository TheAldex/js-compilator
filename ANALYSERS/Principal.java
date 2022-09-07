package analizadores;

import java.io.File;

public class Principal {
    public static void main(String[] args) {
        String filePath = new File("hola.txt").getAbsolutePath();
        TablaS tabla = new TablaS();
        ALexico aLex = new ALexico(filePath, tabla);
        ASinSem aSin = new ASinSem(aLex, tabla);
        aSin.aSintactico();
        aLex.imprimirTokens();
    }
}
