package zhanbao.jiejue;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-17
 */
public class MypersonDecode extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println("myPersonDecoder");
        int length=byteBuf.readInt();
        byte[] bytes=new byte[length];
        byteBuf.readBytes(bytes);
        Person person=new Person();
        person.setBytes(bytes);
        person.setLength(length);
        list.add(person);

    }
}
