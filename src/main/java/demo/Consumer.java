package demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author CuiShujun
 * @Date 2019/5/31
 */
public class Consumer {

    private final static String QUEUE_NAME = "nice";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("developer");
        factory.setPassword("123456");
        try {
            // 创建一个连接
            Connection connection = factory.newConnection();
            // 创建一个通道
            Channel channel = connection.createChannel();
            // 指定一个永久队列
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            // 创建队列消费者
            com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Received Message '" + message + "'");
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
