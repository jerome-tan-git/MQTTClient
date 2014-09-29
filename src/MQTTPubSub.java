import com.ibm.mqtt.MqttClient;
import com.ibm.mqtt.MqttException;

public class MQTTPubSub {
	private final static String CONNECTION_STRING = "tcp://121.40.187.96:143";
	private final static boolean CLEAN_START = true;
	private final static short KEEP_ALIVE = 30;// �ͺ����磬��������Ҫ��ʱ��ȡ���ݣ�����30s
	private final static String CLIENT_ID = "client1";
	public String PUBLISH_TOPICS = "tokudu/china";
	private MqttClient mqttClient = null;
	private final static int[] QOS_VALUES = { 0, 0, 2, 0 };
	private final static String[] TOPICS = { "Test/TestTopics/Topic1",
			"Test/TestTopics/Topic2", "Test/TestTopics/Topic3", "tokudu/china" };

	public MQTTPubSub() {
		try {
			// ����MqttClient����
			mqttClient = new MqttClient(CONNECTION_STRING);
			// �����ص�������
			SimpleCallbackHandler simpleCallbackHandler = new SimpleCallbackHandler();
			// mqttClient.registerSimpleHandler(simpleCallbackHandler);//ע�������Ϣ����
			mqttClient.registerAdvancedHandler(new AdvancedCallbackHandler());// ע�������Ϣ����
			// ��������
			mqttClient.connect(CLIENT_ID, CLEAN_START, KEEP_ALIVE);
			// ���Ľ�����
			mqttClient.subscribe(TOPICS, QOS_VALUES);
			/**
			 * ��ɶ��ĺ󣬿���������������������ͨ����Ҳ���Է����Լ�����Ϣ
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
