import com.ibm.mqtt.MqttClient;
import com.ibm.mqtt.MqttException;

public class MQTTPubSub {
	private final static String CONNECTION_STRING = "tcp://121.40.187.96:143";
	private final static boolean CLEAN_START = true;
	private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s
	private final static String CLIENT_ID = "client1";
	public String PUBLISH_TOPICS = "tokudu/china";
	private MqttClient mqttClient = null;
	private final static int[] QOS_VALUES = { 0, 0, 2, 0 };
	private final static String[] TOPICS = { "Test/TestTopics/Topic1",
			"Test/TestTopics/Topic2", "Test/TestTopics/Topic3", "tokudu/china" };

	public MQTTPubSub() {
		try {
			// 创建MqttClient对象
			mqttClient = new MqttClient(CONNECTION_STRING);
			// 创建回调处理器
			SimpleCallbackHandler simpleCallbackHandler = new SimpleCallbackHandler();
			// mqttClient.registerSimpleHandler(simpleCallbackHandler);//注册接收消息方法
			mqttClient.registerAdvancedHandler(new AdvancedCallbackHandler());// 注册接收消息方法
			// 创建连接
			mqttClient.connect(CLIENT_ID, CLEAN_START, KEEP_ALIVE);
			// 订阅接主题
			mqttClient.subscribe(TOPICS, QOS_VALUES);
			/**
			 * 完成订阅后，可以增加心跳，保持网络通畅，也可以发布自己的消息
			 */
			mqttClient.publish(PUBLISH_TOPICS, "keepalive".getBytes(),
					QOS_VALUES[0], false);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MQTTPubSub();
	}
}
