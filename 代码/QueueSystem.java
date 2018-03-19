package com.Course.Queue;

/**
 * �Ŷ�ϵͳ��ϵͳ���Ŷ�λ��Ϊ����࣬����Ա��ĿΪ1
 */
public class QueueSystem 
{
	private int startCount;//ϵͳ�г�ʼ�Ĺ˿���
	private double totalServeTime;//ϵͳ���ܵĿ���ʱ��,�Է���Ϊ��λ
	private int totalCount;//ϵͳ������ܹ˿���
	private double queueTime;//ϵͳ�����й˿͵����Ŷ�ʱ��
	private double U;//����Ա����
	private double arriveLamda;//����ǿ��
	
	
	public QueueSystem(int startCount, double totalServeTime, int totalCount, double queueTime, double U, double arriveLamda)
	{
		this.startCount = startCount;
		this.totalServeTime = totalServeTime;
		this.totalCount = totalCount;
		this.queueTime = queueTime;
		this.U = U;
		this.arriveLamda = arriveLamda;
	}

	public int getStartCount()
	{
		return startCount;
	}
	
	public void setStartCount(int startCount) 
	{
		this.startCount = startCount;
	}
	
	public double getTotalServeTime() 
	{
		return totalServeTime;
	}
	
	public void setTotalServeTime(double totalServeTime) 
	{
		this.totalServeTime = totalServeTime;
	}
	
	public int getTotalCount() 
	{
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) 
	{
		this.totalCount = totalCount;
	}
	
	public double getQueueTime() 
	{
		return queueTime;
	}
	
	public void setQueueTime(double queueTime) 
	{
		this.queueTime = queueTime;
	}
	
	public double getU() 
	{
		return U;
	}
	
	public void setU(double U) 
	{
		this.U = U;
	}
	
	public double getArriveLamda()
	{
		return arriveLamda;
	}
	
	public void setArriveLamda(double arriveLamda) 
	{
		this.arriveLamda = arriveLamda;
	}

	public double getEwq() 
	{
		double Ewq = 0;
		if(totalCount > 0)
			Ewq = (double)queueTime / (double)totalCount;
		return Ewq;
	}
	
	public double getResult(int count)
	{
		double P = arriveLamda/U;
		double Ewq = getEwq();
		if(count == 1)
			System.out.println("ϵͳ����ʱ�䣺" + totalServeTime + "  ϵͳ����Ա������" + U + "  ϵͳ����˿�����" + totalCount + "  �˿����Ŷ�ʱ�䣺" + queueTime);
		return ((Math.log(2 * U * Ewq) - Math.log(1 + 2 * U * Ewq))/(Math.log(P)));
	}
	
}
