package sockets;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Leocassio
 */
public class Servidor2 {

    public static void main(String[] args) {

        try {
            System.out.println("Aguardando conexão");
            ServerSocket servidor = new ServerSocket(1234);
            Socket conexao = servidor.accept();
            
            Scanner leitura = new Scanner(conexao.getInputStream());
            
            PrintStream escrita = new PrintStream(conexao.getOutputStream());
            String mensagem; 
            while((mensagem = leitura.nextLine()) != null) {                
                String mensagemTratada = mensagem + " IFRN";
                escrita.println(mensagemTratada);
            }
        } catch (Exception e) {
        }

    }
}
