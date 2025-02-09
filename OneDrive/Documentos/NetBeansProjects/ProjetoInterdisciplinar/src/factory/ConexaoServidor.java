package factory;

import java.io.*;
import java.net.*;

public class ConexaoServidor {

    private static final String servidorIP = "192.168.2.166";  // IP do Raspberry Pi
    private static final int porta = 5555;  // Porta configurada no servidor

    public static String solicitarLeitura() {
        try (Socket socket = new Socket(servidorIP, porta); 
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Envia uma solicitação de leitura para o servidor
            out.println("GET_DATA");

            // Aguarda a resposta do servidor
            StringBuilder resposta = new StringBuilder();
            String linha;
            int contador = 0;
            while ((linha = in.readLine()) != null && contador < 2) { // Lê apenas duas linhas
                resposta.append(linha).append("\n");
                contador++;
            }

            return resposta.toString().trim();

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao conectar ao servidor." + e.getMessage();
        }
    }
}
