/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primosocket;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gorin
 */
public class ServerConnessione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ServerSocket sSocket = null;
        int porta=3500;
        
        while(true){
            try {
                sSocket = new ServerSocket(porta);
                Socket connessione;
                System.out.println("In attesa di connessione...");
            
                connessione=sSocket.accept();   //-----connessione effettuata------
                System.out.println("Connessione Avvenuta");
                
                sSocket.setSoTimeout(10000);
                
            } catch (IOException ex) {
                System.out.println("Errore");
            }  finally {//---------------------Chiusura della connessione----------------------
                try {
                    sSocket.close();
                    System.out.println("Sessione terminata correttamente");//messaggio di avvenuta chiusura
                } catch (IOException ex) {
                    System.out.println("Problema nella chiusura");
                }
            }//-------------------------------------------------------------------------------
        }
    }
    
}
/*Errori che si possono generare
--ServerSocket(int porta)
    IOException - se si verifica un errore I / O all'apertura del socket.
    SecurityException - se esiste un gestore della sicurezza e il suo checkListen metodo non consente l'operazione.
    IllegalArgumentException - se il parametro PORTA è al di fuori dell'intervallo specificato di valori di porta validi, compreso tra 0 e 65535, inclusi.

--accept()
    -------------------
    Ascolta una connessione da effettuare a questo socket e l'accetta. Il metodo rimane in attesa fino a quando non viene stabilita una connessione.
    Viene screato un nuovo socket e, se esiste un gestore della sicurezza, checkAcceptviene chiamato il metodo del gestore della sicurezza s.getInetAddress().
    getHostAddress()e s.getPort() come argomento per garantire che l'operazione sia consentita. Ciò potrebbe comportare una SecurityException.    
    -------------------

    IOException - se si verifica un errore I / O durante l'attesa di una connessione.
    SecurityException- se esiste un gestore della sicurezza e il suo checkAcceptmetodo non consente l'operazione.
    SocketTimeoutException - se è stato precedentemente impostato un timeout con setSoTimeout e il timeout è stato raggiunto.
    IllegalBlockingModeException - se questo socket ha un canale associato, il canale è in modalità non bloccante e non c'è nessuna connessione pronta per essere accettata

--close()
    IOException - se si verifica un errore I / O quando si chiude questo socket.

--setSoTimeout(int timeout)
    produce l'eccezione SocketException, se c'è un errore nella comunicazione TCP
*/