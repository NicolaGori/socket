/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primosocket;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gorin
 */
public class ClientConnessione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
            Socket connessione = null;        
            int connected = 0;
        while (connected==0){
            try {
                //─────────────Apertura della connessione───────────────
                String server = "localhost";
                int porta = 3500;
                
                connessione = new Socket(server, porta);
                System.out.println("Connessione Aperta");
                //────────────────────────────────────────────
            } catch (IOException ex) {
                    System.out.println("Errore");
            } finally {
                try {
                //─────────────Chiusura della connessione───────────────
                connessione.close();
                connected=1;
                System.out.println("Sessione Terminata");//messaggio di avvenuta chiusura
                } catch (IOException ex) {
                    System.out.println("Problema nella chiusura");
                //────────────────────────────────────────────
                }
            }
        }
    }
}
//─────────────────────────────────────────────────────────
//                                    alcuni errori generati
//─────────────────────────────────────────────────────────
/*Errori che si possono generare
--Socket()
    IOException - se si verifica un errore I / O durante la creazione del socket.
    SecurityException - se esiste un gestore della sicurezza e il suo checkConnectmetodo non consente l'operazione.
    IllegalArgumentException - se il parametro port è al di fuori dell'intervallo specificato di valori di porta validi, compreso tra 0 e 65535, inclusi.
    NullPointerException - se l'indirizzo è null.
--close()
    IOException - se si verifica un errore I / O quando si chiude questo socket.
*/