package factory;

import java.io.*;
import java.net.*;

public class ConexaoServidor {

    public static final String servidorIP = "192.168.101.19";  // Substitua pelo IP da sua Raspberry Pi
    public static final int porta = 5555;  // A mesma porta configurada no servidor

    public static void main(String[] args) {

        try {
            // Cria um socket e conecta-se ao servidor
            Socket socket = new Socket(servidorIP, porta);

            // Cria streams para comunicação com o servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Recebe a mensagem de boas-vindas do servidor
            /*int line;
            while ((line = in.read()) != -1) {
                System.out.print((char) line);
                if ((char) line == '!') {
                    break;
                }
            }*/
            
             while (true) {
                String response = in.readLine(); // Aguarda uma mensagem do servidor
                if (response == null) {
                    System.out.println("Conexão com o servidor encerrada.");
                    break; // Sai do loop caso a conexão seja encerrada
                }
                System.out.println("Recebido do servidor: " + response);
            }
            
            System.out.println("");

            // Envia uma mensagem para o servidor
            out.write("Oi servidor\n");

            // Recebe a confirmação de dados recebidos
            String respostaConfirmacao = in.readLine();
            System.out.println("Recebido do servidor: " + respostaConfirmacao);

            // Fecha os streams e o socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
