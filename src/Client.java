import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable{

  public static ArrayList<Client> clients = new ArrayList<>();
  private Socket socket;
  private BufferedReader bufferedReader;
  private BufferedWriter bufferedWriter;
  private String clientUsername;

  public Client(Socket socket){
    try{
      this.socket = socket;
      //byte stream ends with stream and word stream ends with writer
      this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      this.clientUsername = bufferedReader.readLine();
      clients.add(this);
      broadcastMessage("SERVER " + clientUsername + " has entered our chat");
    }
    catch (IOException e){
  closeEverything(socket, bufferedReader,bufferedWriter);
    }
  }

  @Override
  public void run() {

  }
}
