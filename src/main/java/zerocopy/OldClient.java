package zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-15
 */
public class OldClient {
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("localhost",8899);
        String file="/home/ls/下载/ls.zip";
        InputStream inputStream=new FileInputStream(file);
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        byte[] bytes=new byte[4096];
        long readcount;
        long total=0;
        long start=System.currentTimeMillis();
        while((readcount=inputStream.read(bytes))>=0){
            total+=readcount;
            dataOutputStream.write(bytes);
        }
        System.out.println("发送的字节数：   "+total+"  耗时："+(System.currentTimeMillis()-start));
        dataOutputStream.close();
        socket.close();
        inputStream.close();

    }

}
