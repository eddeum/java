package Day14;

public class Day14_5 {

	public static void main(String[] args) {
		
		// ���� : �������Ҹ�, �����̼Ҹ�, ȣ���̼Ҹ� ���ÿ� 5�����
		// 1. Tread Ŭ�����κ��� extends
			// �������̵� -> ������
		// 2. Runnable �������̽��κ��� implements
			// �������̵� -> ����
		
		// * main �����尡 ���� ������ ������ ȣ���Ѵ�
		// Thread Ŭ�����κ��� ��ӹ��� �ڽ�Ŭ������ ��ü ����
		�������Ҹ� ������ = new �������Ҹ�(); 
		// �ڽ�Ŭ������ ��ü�� �θ�Ŭ������ �޼ҵ� ����
		������.start(); // ---> run �޼ҵ� ȣ��[��Ƽ������ ����]
		
		�����̼Ҹ� ������ = new �����̼Ҹ�();
		������.start();
		
		ȣ���̼Ҹ� ȣ���� = new ȣ���̼Ҹ�();
		ȣ����.start();
		
		
	} // me
} // ce