package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by andilyliao on 16-6-4.
 */
public class TestSocket {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("localhost",6666);
        OutputStream os=s.getOutputStream();
        os.write("bbb".getBytes());
        os.flush();
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(bufferedReader.readLine());

       // s.close();
    }
}
