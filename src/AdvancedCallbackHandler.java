import com.ibm.mqtt.MqttAdvancedCallback;


public class AdvancedCallbackHandler implements MqttAdvancedCallback{

	@Override
	public void connectionLost() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publishArrived(String topicName, byte[] payload, int Qos,  
            boolean retained) throws Exception {  
           System.out.println("订阅主题: " + topicName);  
           System.out.println("消息数据: " + new String(payload));  
           System.out.println("消息级别(0,1,2): " + Qos);  
           System.out.println("是否是实时发送的消息(false=实时，true=服务器上保留的最后消息): " + retained);  
    }  

	@Override
	public void published(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	 public void subscribed(int Qos, byte[] payload) {  
        System.out.println("消息数据: " + new String(payload));  
        System.out.println("消息级别(0,1,2): " + Qos);  
 } 

	@Override
	public void unsubscribed(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
