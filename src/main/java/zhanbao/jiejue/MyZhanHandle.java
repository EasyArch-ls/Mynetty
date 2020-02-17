package zhanbao.jiejue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-17
 */
public class MyZhanHandle extends SimpleChannelInboundHandler<Person> {
    private int count=1;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Person person) throws Exception {
        int length=person.getLength();
        byte[] bytes=person.getBytes();
        String message=new String(bytes, Charset.forName("utf-8"));
        System.out.println("服务端收到： "+message);
        System.out.println("服务端收到的长度： "+length);
        System.out.println("服务端收到的消息条数  "+this.count++);
        String respon=UUID.randomUUID().toString();
        int responlength=respon.getBytes("utf-8").length;
        byte[] responbyte=respon.getBytes("utf-8");
        Person person1=new Person();
        person1.setLength(responlength);
        person1.setBytes(responbyte);
        System.out.println(person1);
        ctx.channel().writeAndFlush(person1);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
        ctx.close();
    }

}
