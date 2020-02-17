package zhanbao.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import zhanbao.jiejue.MyPersonEncoder;
import zhanbao.jiejue.MyZhanHandle;
import zhanbao.jiejue.MypersonDecode;
import zhanbao.jiejue.MyzhanCientHandle;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-15
 */
public class MyzhanClientInityializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline=socketChannel.pipeline();
       /* pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(Mypersion.Mymessage.getDefaultInstance() ));
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());*/
        pipeline.addLast(new MypersonDecode());
        pipeline.addLast(new MyPersonEncoder());
        pipeline.addLast(new MyzhanCientHandle());

    }
}
