package sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leocassio
 */
public class Cliente {
    public static void main(String[] args) {
        try {
            Socket conexao = new Socket("localhost", 999);
            System.out.println("Conexao efetuada");
            
            PrintStream saida = new PrintStream(conexao.getOutputStream());            
            
            
            Scanner teclado = new Scanner(System.in);

            String mensagem; 
            while((mensagem = teclado.nextLine()) != null){
                saida.println(mensagem);  
            }
            
            teclado.close();
            saida.close();
            conexao.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
