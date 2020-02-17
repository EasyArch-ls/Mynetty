package zhanbao.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import zhanbao.jiejue.MyPersonEncoder;
import zhanbao.jiejue.MyZhanHandle;
import zhanbao.jiejue.MypersonDecode;


/**
 * Demo class
 *
 * @author ls
 * @date 20-2-17
 */
public class MyZhanInityializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline=socketChannel.pipeline();
       /* pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
        pipeline.addLast(new LengthFieldPrepender(4));*/
       /* pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));*/
        pipeline.addLast(new MypersonDecode());
        pipeline.addLast(new MyPersonEncoder());
        pipeline.addLast(new MyZhanHandle());
    }
}
