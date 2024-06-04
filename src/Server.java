import java.io.IOException;
import java.net.ServerSocket;

public class Server {

  private ServerSocket serverSocket;

  public Server(ServerSocket serverSocket){
    this.serverSocket = serverSocket;
  }

  public void startServer(){
    try{
      while(!serverSocket.isClosed()) {
        //held until client connects
        Socket socket = serverSocket.accept();
        System.out.println("A new client has connected");
        Client clientHandler = new Client(socket);

        Thread thread = new Thread(Client);
        thread.start();
      }
    }
    catch(IOException e){

    }
  }

  public void closeServerSocket(){
    try{
      if(serverSocket != null){
        serverSocket.close();
      }
    }
    catch(IOException e){

    }
  }

  public static void main(String[] args) throws IOException{
    ServerSocket serverSocket  = new ServerSocket(1234);
    Server server = new Server(serverSocket);
    server.startServer();
  }
}
