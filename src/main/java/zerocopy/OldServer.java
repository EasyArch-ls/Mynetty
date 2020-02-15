package zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-15
 */
public class OldServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(8899);
        while (true){
            Socket socket=serverSocket.accept();
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            try {
               byte[] bytes=new byte[4096];
               while (true){
                  int readline=dataInputStream.read(bytes,0,bytes.length);
                   System.out.println(readline);
                  if(readline<0){
                      break;
                  }
               }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
