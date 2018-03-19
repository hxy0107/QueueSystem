package com.Course.Queue;

public class QueueCustomer
{
	private int id;
	private double arriveTime;//�˿͵���ʱ�䣨��K��ָ���ֲ����ӵ�����
	private double serveTime;//�˿�Ҫ�����ʱ�䣨��ָ���ֲ����������Է���Ϊ��λ
	
	public QueueCustomer(int id, double arriveTime, double serveTime) 
	{
		this.id = id;
		this.arriveTime = arriveTime;
		this.serveTime = serveTime;
	}

	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public double getArriveTime() 
	{
		return arriveTime;
	}
	
	public void setArriveTime(double arriveTime) 
	{
		this.arriveTime = arriveTime;
	}
	
	public double getServeTime()
	{
		return serveTime;
	}
	
	public void setServeTime(double serveTime) 
	{
		this.serveTime = serveTime;
	}

	@Override
	public String toString() 
	{
		return "Customer [id=" + id + ", arriveTime=" + arriveTime + ", serveTime=" + serveTime + "]";
	}
	
	
}
