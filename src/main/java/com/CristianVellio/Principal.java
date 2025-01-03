package com.CristianVellio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonSyntaxException;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        Consulta consulta = new Consulta();

        Conversion conversion = new Conversion(consulta);

        Historial historial = new Historial();

        List<String> respuestas = new ArrayList<>();

        Map<Integer, String[]> conversiones = Map.of(
                1, new String[] { "MXN", "USD" },
                2, new String[] { "MXN", "EUR" },
                3, new String[] { "MXN", "GBP" },
                4, new String[] { "USD", "MXN" },
                5, new String[] { "EUR", "MXN" },
                6, new String[] { "GBP", "MXN" });

        String menu = """
                \n***************************************************
                *** Sea bienvenido al Conversor de Monedas ***

                1) Peso Mexicano ==>> Dólar Estadounidense
                2) Peso Mexicano ==>> Euro
                3) Peso Mexicano ==>> Libra Esterlina
                4) Dólar Estadounidense ==>> Peso Mexicano
                5) Euro ==>> Peso Mexicano
                6) Libra Esterlina ==>> Peso Mexicano

                7) Otra opción de conversión

                8) Salir
                ***************************************************
                """;

        while (opcion != 8) {
            try {
                System.out.println(menu);
                opcion = Integer.parseInt(lectura.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                if (opcion >= 1 && opcion <= 6) {
                    String[] divisas = conversiones.get(opcion);
                    conversion.valores(divisas[0], divisas[1]);
                    respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                } else if (opcion == 7) {
                    conversion.valoresEstandarizados();
                    respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                } else if (opcion == 8) {
                    System.out.println("Gracias por usar el Conversor de Monedas");
                } else {
                    System.out.println("Opción no válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Ingrese solo códigos de moneda válidos.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor numérico válido.");
            }

            historial.almacenarJson(respuestas);
        }

        System.out.println("Programa terminado");

        lectura.close();
    }
}