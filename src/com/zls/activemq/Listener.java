package com.zls.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * ��Ϣ������
 * @author zhonglunsheng
 *
 */
public class Listener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		// TODO �Զ����ɵķ������
		try {
			System.out.println("�յ�����Ϣ��"+((TextMessage)message).getText());
		} catch (JMSException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	
}
