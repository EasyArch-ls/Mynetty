package zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-15
 */
public class Clinet {
    public static void main(String[] args)throws Exception {
        SocketChannel socketChannel=SocketChannel.open();
        InetSocketAddress socketAddress=new InetSocketAddress("localhost",8999);
        socketChannel.configureBlocking(true);
        socketChannel.connect(socketAddress);
        String file="/home/ls/下载/ls.zip";
        FileChannel fileChannel=new FileInputStream(file).getChannel();
        long start=System.currentTimeMillis();
        long transferTo=fileChannel.transferTo(0,fileChannel.size(),socketChannel);
        System.out.println("发送的字节数：   "+transferTo+"  耗时："+(System.currentTimeMillis()-start));
        fileChannel.close();


    }
}
