package zhanbao.jiejue;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-17
 */
public class MyPersonEncoder extends MessageToByteEncoder<Person> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Person person, ByteBuf byteBuf) throws Exception {
        System.out.println("MyPersonEncoder");
        byteBuf.writeInt(person.getLength());
        byteBuf.writeBytes(person.getBytes());
    }
}
