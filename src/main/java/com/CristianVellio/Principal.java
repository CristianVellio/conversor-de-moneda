package com.CristianVellio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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

                switch (opcion) {
                    case 1:
                        conversion.valores("MXN", "USD");
                        respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                    case 2:
                        conversion.valores("MXN", "EUR");
                        respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                    case 3:
                        conversion.valores("MXN", "GBP");
                        respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                    case 4:
                        conversion.valores("USD", "MXN");
                        respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                    case 5:
                        conversion.valores("EUR", "MXN");
                        respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                    case 6:
                        conversion.valores("GBP", "MXN");
                        respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                    case 7:
                        conversion.valoresEstandarizados();
                        respuestas.add(formattedDate + " - " + conversion.mensajeRespuesta());
                        break;
                    case 8:
                        System.out.println("Gracias por usar el Conversor de Monedas");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Ingrese solo códigos de moneda válidos.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor numérico válido.");
            }

            historial.almacenarJson(respuestas);

            System.out.println("Programa terminado");
            lectura.close();
        }
    }
}
