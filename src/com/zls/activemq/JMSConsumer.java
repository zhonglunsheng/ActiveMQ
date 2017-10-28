package com.zls.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {

	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKURL=ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory; //���ӹ���
		Connection connection = null;//����
		Session session; //�Ự ���ܻ��߷�����Ϣ���߳�
		Destination destination;//��Ϣ��Ŀ�ĵ�
		MessageConsumer messageConsumer;//��Ϣ��������
		//ʵ�������ӹ���
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKURL);
		try {
			connection=connectionFactory.createConnection();//ͨ�����ӹ�����ȡ����
			connection.start(); //��������
			session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//����session
			destination=session.createQueue("FirstQueue1");//������Ϣ����
			messageConsumer=session.createConsumer(destination);//������Ϣ������
			messageConsumer.setMessageListener(new Listener());//ע����Ϣ����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
