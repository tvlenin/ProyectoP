package networkAccess;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SSocket extends Thread{
	
	int puerto;
	private ServerSocket server;
	private Socket socket;
	private boolean running = false;
	
	
	public SSocket(int pPuerto){
		puerto = pPuerto;
		running = true;
		initServer();
	}
	
	public void initServer(){
		try{
			
			server = new ServerSocket(puerto);
			System.out.println("$$ServerMsg$$ Esperando Conexión... $$ServerMsg$$");
			run();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run(){
		while(running){
			try{
				socket = server.accept();
				Thread t = new Thread(new Runnable() {
			         public void run()
			         {
			        	 clientHandler(socket);
			         }
				});
				t.start();
			}
			catch(Exception e){
				
			}
		}
	}
	
	public void clientHandler(Socket socket){
		BufferedReader entrada = null;
		DataOutputStream salida = null;
		try {
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while(running){
			try {
				salida.writeUTF("Message ");
				String msjRecibido = entrada.readLine();
				if(msjRecibido == null){
					System.out.println("$$ServerMsg$$ Client disconnected $$ServerMsg$$");
					entrada.close();
					salida.close();
					break;
				}
				else{
					System.out.println(msjRecibido);
				}
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
    	try {
			SSocket p = new SSocket(9090);

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	

}
