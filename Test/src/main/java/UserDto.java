
public class UserDto {
	
	// �ʵ�
	private int ȸ����ȣ;
	private String ȸ�����̵�;
	private String ȸ����й�ȣ;
	private String ȸ���̸�;
	private String ȸ���̸���;
	
	// ������
	public UserDto() {}

	public UserDto(int ȸ����ȣ, String ȸ�����̵�, String ȸ����й�ȣ, String ȸ���̸�, String ȸ���̸���) {
		super();
		this.ȸ����ȣ = ȸ����ȣ;
		this.ȸ�����̵� = ȸ�����̵�;
		this.ȸ����й�ȣ = ȸ����й�ȣ;
		this.ȸ���̸� = ȸ���̸�;
		this.ȸ���̸��� = ȸ���̸���;
	}

	// �޼ҵ�
	public int getȸ����ȣ() {
		return ȸ����ȣ;
	}

	public void setȸ����ȣ(int ȸ����ȣ) {
		this.ȸ����ȣ = ȸ����ȣ;
	}

	public String getȸ�����̵�() {
		return ȸ�����̵�;
	}

	public void setȸ�����̵�(String ȸ�����̵�) {
		this.ȸ�����̵� = ȸ�����̵�;
	}

	public String getȸ����й�ȣ() {
		return ȸ����й�ȣ;
	}

	public void setȸ����й�ȣ(String ȸ����й�ȣ) {
		this.ȸ����й�ȣ = ȸ����й�ȣ;
	}

	public String getȸ���̸�() {
		return ȸ���̸�;
	}

	public void setȸ���̸�(String ȸ���̸�) {
		this.ȸ���̸� = ȸ���̸�;
	}

	public String getȸ���̸���() {
		return ȸ���̸���;
	}

	public void setȸ���̸���(String ȸ���̸���) {
		this.ȸ���̸��� = ȸ���̸���;
	}
	

	
	

}