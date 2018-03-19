package com.Course.Queue;

public class Run
{
	private static QueueSystem queueSystem = new QueueSystem(1, 400, 0, 0, 0, 0);
	
	public static void main(String[] args)
	{
		for(int i=1; i<=20; i++)
			RunSystem();
	}
	
	public static void RunSystem()
	{
		//QueueSystem queueSystem = new QueueSystem(1, 100, 0, 0, 0, 0);
		
		//��P���趨��ָ���ֲ�lamda
		ExponentialDistribution edServe = new ExponentialDistribution(12);
		
		//�����˿͵�������Erlang�ֲ�
		ErlangDistribution erlang = new ErlangDistribution(8, 3);
		
		//ϵͳָ���ķ�����ʱ��
		double totalServeTime = queueSystem.getTotalServeTime();
		//ϵͳ��ǰ�Ѿ�����˿͵���ʱ��
		double currentServeTime = 0;
		//��¼��һ���˿͵ĵ���ʱ��
		double lastArriveTime = 0 ;
		//��¼��ǰ�˿͵ĵ���ʱ��
		double currentArriveTime = 0 ;
		//��¼����Ĺ˿�����
		int count = 0;
		
		//��Ϊ�˿͵ı�ʶ��
		int id = 1;
		//�˿͵ĵ���ʱ��
		double arriveTime = 0;
		//Ϊÿ���˿��ṩ�ķ���ʱ��
		double serveTime = 2.0;
		//��¼�˿͵��Ŷ�ʱ��
		double waitTime = 0;
		
		//����ϵͳ��ʼʱ���Ѿ�����һ���˿ͣ���˵�һ���˿͵��Ŷ�ʱ��Ϊ0������ʱ��Ҳ��Ϊ0
		if(id == 1)
		{
			arriveTime = 0;
			//serveTime = edServe.getX();
		}
		
		QueueCustomer customer = new QueueCustomer(id,arriveTime,serveTime);
		currentServeTime += serveTime;
		currentArriveTime = lastArriveTime = customer.getArriveTime();
		
		while(currentServeTime <= totalServeTime && lastArriveTime <= totalServeTime)
		{
			
			count++;
			id++;
			lastArriveTime = currentArriveTime;
			
			//��һ���˿͵ĵ���ʱ��Ϊ��һ���˿͵ĵ���ʱ�����ʱ����
			arriveTime = lastArriveTime + erlang.getErlangArriveTime();
			//serveTime = edServe.getX();
			
			customer = new QueueCustomer(id,arriveTime,serveTime);
			
			currentServeTime += serveTime;
			currentArriveTime = customer.getArriveTime();
			
			//��ǰ�˿͵��Ŷ�ʱ������ϸ��˿͵ĵ���ʱ�������Ҫ������ʱ���ȥ��ǰ�˿͵ĵ���ʱ��
			if(lastArriveTime + customer.getServeTime() > currentArriveTime)
				waitTime += lastArriveTime + customer.getServeTime() - currentArriveTime;
		
		}
		
		queueSystem.setQueueTime(waitTime);
		queueSystem.setTotalCount(count);
		queueSystem.setU( (double)1/edServe.getLamda() );//����ϵͳ��������
		queueSystem.setArriveLamda((double)1/(erlang.getK() * erlang.getLamda()));//���õ���ǿ��
		
		System.out.println("(" + "k" + "," + "��"
				+ ")" + "====>" + "(" + erlang.getK() + "," + queueSystem.getResult(1) + ")");
		System.out.println("=====================================================");
		System.out.println();
	}
}
