package Day06;

public class Korean {
	// * Korean Ŭ���� ����
	
	// 1. �ʵ�
	String nation = "���ѹα�"; 	// ���� ������ �̸� ���ѹα� ����
	String name;				// �̸� �������� �ʱ�ȭx[Null]
	String ssn;					// �ֹε�Ϲ�ȣ �������� �ʱ�ȭ x[Null]
	
	// 2. ������
		// ����1 : �������̸� == Ŭ�����̸�
		// ����2 : �ܺηκ��� ������ �Ű���[�μ�] ���� -> �ص��ǰ����ص���
		// ����3 : ������ ������ �̸� ������ ����.
			// �����ε� : ������ �̸��� ��� �ڵ带 ������
	
	// 1. �������
	Korean(){
		// ���빰�� ����.
	}
	
	// 2. �ʵ� 1���� ���� ������
	Korean(String n){
		name = n;
	}
	
	// 3. �ʵ� 2���� ���� ������
	Korean(String n, String s){
		name = n;
		ssn = s;
	}
	
	// 4. �ʵ� 4���� ���� ������
	Korean(String nation, String name, String ssn){
		this.nation = nation;
		this.name = name;
		this.ssn = ssn;
		// ���κ���(���� Ŭ���� �� ����)
		// �Ű�����(�ܺηκ��� ���� ����)
		// ���κ��� == �Ű����� -> �̸��� �����ϸ� �浹
		// ���κ��� ǥ�� ���
			// this.�ʵ�� : ����Ŭ���� �� �ʵ�ȣ��
	}
	
	// 3. �޼ҵ�
	
}