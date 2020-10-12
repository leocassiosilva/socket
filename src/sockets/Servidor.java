package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Leocassio
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(999);
            System.out.println("Aguardando conexão");
            Socket conexao = servidor.accept();
            System.out.println("Conexão efetuada " + conexao.getInetAddress().getHostAddress());
            Scanner leitura = new Scanner(conexao.getInputStream()); 
            
            String mensagem; 
            
            while((mensagem = leitura.nextLine()) != null){
                System.out.println(mensagem);
            }
            
            servidor.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
