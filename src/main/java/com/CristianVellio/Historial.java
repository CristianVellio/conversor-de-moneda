package com.CristianVellio;

import java.io.FileWriter;
import java.util.List;

public class Historial {
    public void almacenarJson(List<String> lista) {
        try {
            FileWriter fileWriter = new FileWriter("historial.txt");
            for (String elemento : lista) {
                fileWriter.write(elemento + "\n");
            }
            fileWriter.close();
            System.out.println("Historial almacenado con éxito");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un Error: ");
            throw new RuntimeException("Error" + e.getMessage());
        }
    }
}
