import com.ibm.mqtt.MqttSimpleCallback;


public class SimpleCallbackHandler implements MqttSimpleCallback {

	@Override
	public void connectionLost() throws Exception {
		System.out.println("�ͻ�����broker�Ѿ��Ͽ�"); 
		
	}

	@Override
	public void publishArrived(String topicName, byte[] payload, int Qos, boolean retained) throws Exception {  
        System.out.println("��������: " + topicName);  
        System.out.println("��Ϣ����: " + new String(payload));  
        System.out.println("��Ϣ����(0,1,2): " + Qos);  
        System.out.println("�Ƿ���ʵʱ���͵���Ϣ(false=ʵʱ��true=�������ϱ����������Ϣ): " + retained);  
   }  
 
}  
