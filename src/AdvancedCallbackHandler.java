import com.ibm.mqtt.MqttAdvancedCallback;


public class AdvancedCallbackHandler implements MqttAdvancedCallback{

	@Override
	public void connectionLost() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publishArrived(String topicName, byte[] payload, int Qos,  
            boolean retained) throws Exception {  
           System.out.println("��������: " + topicName);  
           System.out.println("��Ϣ����: " + new String(payload));  
           System.out.println("��Ϣ����(0,1,2): " + Qos);  
           System.out.println("�Ƿ���ʵʱ���͵���Ϣ(false=ʵʱ��true=�������ϱ����������Ϣ): " + retained);  
    }  

	@Override
	public void published(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	 public void subscribed(int Qos, byte[] payload) {  
        System.out.println("��Ϣ����: " + new String(payload));  
        System.out.println("��Ϣ����(0,1,2): " + Qos);  
 } 

	@Override
	public void unsubscribed(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
