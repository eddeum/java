package Test;

public class Student {
	
	// 1. �ʵ�
	private int ��ȣ;
	private String �̸�;
	private int ����;
	private int ����;
	private int ����;
	private int ���� = ����+����+����;
	private double ��� = ����/3;

	
	// 2. ������
	public Student() {}

	public Student(int ��ȣ, String �̸�, int ����, int ����, int ����, int ����, double ���) {
		super();
		this.��ȣ = ��ȣ;
		this.�̸� = �̸�;
		this.���� = ����;
		this.���� = ����;
		this.���� = ����;
		this.���� = ����;
		this.��� = ���;
	}

	// 3. �޼ҵ�
	public int get��ȣ() {
		return ��ȣ;
	}

	public void set��ȣ(int ��ȣ) {
		this.��ȣ = ��ȣ;
	}

	public String get�̸�() {
		return �̸�;
	}

	public void set�̸�(String �̸�) {
		this.�̸� = �̸�;
	}

	public int get����() {
		return ����;
	}

	public void set����(int ����) {
		this.���� = ����;
	}

	public int get����() {
		return ����;
	}

	public void set����(int ����) {
		this.���� = ����;
	}

	public int get����() {
		return ����;
	}

	public void set����(int ����) {
		this.���� = ����;
	}

	public int get����() {
		return ����;
	}

	public void set����(int ����) {
		this.���� = ����;
	}

	public double get���() {
		return ���;
	}

	public void set���(double ���) {
		this.��� = ���;
	}
	
	


}