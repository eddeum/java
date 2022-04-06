package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.exceptions.ExceptionInterceptorChain;

import dto.Member;

public class MemberDao { // DB ���ٰ�ü
	
	private Connection con; // DB������ ���Ǵ� Ŭ���� : DB����Ŭ����
	private PreparedStatement ps; // ����� DB�� SQL ���� �Ҷ� ���Ǵ� �������̽� : DB�����������̽�
	private ResultSet rs; // ������� �����ϴ� �������̽�
	
	public static MemberDao memberDao = new MemberDao(); // DB ���� ��ü;
	
	public MemberDao() {
		try {
		// DB ����
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB ����̹� ��������
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234"); // 2. DB �ּ� ����
		

			
		}catch(Exception e) {System.out.println("[DB ���� ����]"+e);}
	}
	
	// �޼ҵ�
		// * ���̵� �ߺ�üũ �޼ҵ�(�μ� : ���̵� �μ��� �޾� db�� �����ϴ��� üũ)
	public boolean idcheck(String id) {
		try {
			// 1. SQL �ۼ�
				// �˻� : select * from ���̺��� where ����(�ʵ��=��)
			String sql = "select * from member where mid=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			// 3. SQL ����
			rs = ps.executeQuery(); // select ���� -> �˻��� ����� ���� -> resultset O
			// resultset ó�� �⺻ ���� : null -->next()--> ��� ���ڵ�
			// 4. SQL ���
			if(rs.next()) { // ���࿡ ���� ������� �����ϸ� => �ش� ���̵� ���� -> �ߺ� O
				return true; // �ش���̵�� �ߺ��� ����
			}
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false; // �ش� ���̵�� �ߺ��� ����
	}
		// 1. ȸ������ �޼ҵ�(�μ� : db�� ���� ���̵�, ��й�ȣ, �̸���, �ּ�)
	public boolean signup(Member member) {
		try {
			// 1. SQL �ۼ�[ȸ����ȣ(�ڵ���ȣ=auto) ������ ��� �ʵ� ����
			String sql = "insert into member(mid, mpassword, memail, maddress, mpoint, msince)values(?,?,?,?,?,?)";
			// 2. SQL ����
			ps = con.prepareStatement(sql); // prepareStatement �������̽��� ����� db�� sql �ֱ�
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMemail());
			ps.setString(4, member.getMaddress());
			ps.setInt(5, member.getMpoint());
			ps.setString(6, member.getMsince());
			// 3. SQL ����
			ps.executeUpdate(); // insert ���� -> ���� ����� x -> resultset X
			return true;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false; // ���н�
		}
		// 2. �α��� �޼ҵ�(�μ� : �α��ν� �ʿ��� ���̵�, ��й�ȣ)
	public boolean login(String id, String password) {
		try {
			// 1. SQL �ۼ�
				// and : ����1 and ����2	�̸鼭
				// or : ����1 or ����2		�̰ų�
			String sql = "select * from member where mid=? and mpassword=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);	// ù��° ?�� id ���� �ֱ�
			ps.setString(2, password); // �ι�° ?�� password ���� �ֱ�
			// 3. SQL ����
			rs = ps.executeQuery(); // select ���� -> resultset
			// 4. SQL ���
			if(rs.next()) { // select �� ������� ������
				return true; // ���̵�� ��й�ȣ�� ���� -> �α��� ����
			} // if e
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false;
	}	
		// 3. ���̵�ã�� �޼ҵ�(�μ� : ���̵�ã�� �� �ʿ��� �̸���)
	public String findid(String email) {
		try {
			// 1. SQL �ۼ�
			String sql = "select * from member where memail=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			// 3. SQL ����
			rs = ps.executeQuery(); // select ���๮ -> rs
			// 4. SQL ���
			if(rs.next()) { // ���� ����� ������ �����ϸ�
				return rs.getString(2); // rs.getString(�����ͺ��̽������������ʵ������ȣ); 
			} // if e
		} catch(Exception e) {System.out.println("[SQL ����]"+e);}
		
		return null;
	}
	
		// 4. ��й�ȣã�� �޼ҵ�(�μ� : ��й�ȣã�� �� �ʿ��� ���̵�, �̸���)
	public String findpassword(String id, String email) {
		try {
			// 1. SQL �ۼ�
			String sql = "select * from member where mid=? and memail=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			// 3. SQL ����
			rs = ps.executeQuery();
			// 4. SQL ���
			if(rs.next()) {
				return rs.getString(3);
			} // if e
		} catch(Exception e) {System.out.println("[SQL ����]"+e);}
		
		return null;
	}
	
		// 5. ���̵� �μ��� ȸ������ ȣ��
	public Member getmember(String id) {
		try {
		// 1. SQL �ۼ�
			String sql = "select * from member where mid=?";
		// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
		// 3. SQL ����
			rs = ps.executeQuery();
		// 4. SQL ���
			if(rs.next()) {
				// 1. ��ü ����
				Member member = new Member(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getString(7) );
				// rs.next() : ����� ���� ���ڵ�(��, ����)
				// rs.getInt(�ʵ������ȣ) : �ش� �ʵ��� �ڷ����� ���������� ��������
				// rs.getString(�ʵ������ȣ) : �ش� �ʵ��� �ڷ����� ���ڿ��� ��������
				
				// 2. ��ȯ
				return member;
				
			} // if e
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return null;
	}
		// 6. ȸ��Ż��[ȸ����ȣ�� �μ��� �޾� �ش� ȸ����ȣ�� ���ڵ� ����]
	public boolean delete(int mnum) {
		try {
			// 1. SQL �ۼ�
				// ���ڵ���� : delete from ���̺��� where ����
			String sql = "delete from member where mnum = ?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			// 3. SQL ����
			ps.executeUpdate(); // insert, update, delete ����
			// 4. SQL ���
			return true;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false;
	}
		// 7. ȸ������[ȸ����ȣ(���), �̸���(����), �ּ�(����) �μ��� �޾Ƽ� ȸ������ ó��]
	public boolean update(int mnum, String email, String address) {
		try {
		// 1. SQL �ۼ�
				// ���ڵ���� : update ���̺��� set �ʵ��1=������1, �ʵ��2=������2 where ����
			String sql = "update member set memail=?, maddress=? where mnum=?";
		// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, address);
			ps.setInt(3, mnum);
		// 3. SQL ����
			ps.executeUpdate();
		// 4. SQL ���
			return true;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false;
	}
	
		// 8. �ش� ȸ����ȣ�� �ش� id ã��
	public String getmid(int mnum) {
		try {
			String sql = "select mid from member where mnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return null;
	}

}