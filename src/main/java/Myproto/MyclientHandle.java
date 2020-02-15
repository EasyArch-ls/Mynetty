package Myproto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-15
 */
public class MyclientHandle extends SimpleChannelInboundHandler<Mypersion.Mymessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Mypersion.Mymessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int i = new Random().nextInt(2);
        Mypersion.Mymessage mymessage=null;
        if (i == 0) {
             mymessage = Mypersion.Mymessage.newBuilder()
                    .setDataType(Mypersion.Mymessage.DataType.PersonType)
                    .setPerson(Mypersion.Person.newBuilder().setEmail("1123").setId(11).setName("person")
                            .build())
                    .build();
        } else if (i == 1) {
             mymessage = Mypersion.Mymessage.newBuilder()
                    .setDataType(Mypersion.Mymessage.DataType.StudentType)
                    .setStudent(Mypersion.Student.newBuilder().setGrade("1123").setId(11).setName("student")
                            .build())
                    .build();
        }


        ctx.channel().writeAndFlush(mymessage);
    }
}
