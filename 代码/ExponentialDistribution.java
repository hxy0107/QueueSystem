package com.Course.Queue;

import java.util.*;
/**
 *  ָ���ֲ��ĸ����ܶȺ�����y=lamda*exp(-lamda*x)    x>=0 
 *	�ɴ˿��Լ�����ʷֲ�������y=1-exp(-lamda*x)    x>=0   
 *	y��   X
 *	���ȣ���y�������ڣ�0��1������ľ��ȷֲ������������   
 *  Ȼ����y=1-exp(-lamda*x)���溯����x����(1/lamda)*ln��1��y)   
 *	��z��1��y����ȻzҲ�ǣ�0��1������ľ��ȷֲ���������������Ǿ���x����(1/lamda)*ln��z����   
 *	z����ͨ��(double)   rand()   /   RAND_MAX���㡣ԭ����rand()   ������ֲ�������       
 *	��������ָ���ֲ��ı���x���Ϳ���ͨ��x����(1/lamda)*ln��z�����㡣
 */
public class ExponentialDistribution
{
	private double lamda ; //ָ���ֲ��Ĳ���lamda
	
	public ExponentialDistribution(double lamda) 
	{
		this.lamda = lamda;
	}
	
	public double getLamda() 
	{
		return lamda;
	}
	
	public void setLamda(double lamda) 
	{
		this.lamda = lamda;
	}

	/**
	 * �õ�ָ���ֲ���Ӧ�Ĳ���ֵ
	 */
	public double getX()
	{
		double z = Math.random();//�������һ��[0,1)�����ڵ�����
		double x = - lamda * Math.log(z);//��������һ��
		return x;
	}
	
	
	public static void main(String[] args) 
	{
		ExponentialDistribution edServe = new ExponentialDistribution(2);
		int i=1;
		while(i < 50)
		{
			System.out.println(edServe.getX());
			i++;
		}
	}
}
