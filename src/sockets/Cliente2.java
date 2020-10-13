package sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente2 {

    public static void main(String[] args) {

        try {
            Socket conexao = new Socket("localhost", 1234);
            System.out.println("Conexao efetuada");
            PrintStream saida = new PrintStream(conexao.getOutputStream());
            Scanner entrada = new Scanner(conexao.getInputStream());
            Scanner teclado = new Scanner(System.in);
            
            String mensagem;
            while ((mensagem = teclado.nextLine()) != null) {                
                saida.println(mensagem);
                System.out.println(entrada.nextLine());
            }
            saida.close();
            conexao.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
