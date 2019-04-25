package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * Created by wangmingming on 2019/4/24.
 */
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {

        ByteBuf buf = packet.content();
        String msg = buf.toString(CharsetUtil.UTF_8);

        System.out.println("收到来自客户端的消息:" + msg);

        String newMsg = "我是udp_server,我收到来你的消息:" + msg;
        DatagramPacket toClientPacket =
                new DatagramPacket(Unpooled.copiedBuffer(newMsg, CharsetUtil.UTF_8), packet.sender());
        ctx.writeAndFlush(toClientPacket);

    }
}
