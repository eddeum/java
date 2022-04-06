package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;
import dto.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDao {
	
	// �ʵ�
	private Connection conn; 		// 1. DB ���� Ŭ����
	private PreparedStatement ps; 	// 2. ����� DB�� SQL ���� �������̽�
	private ResultSet rs;			// 3. SQL ��� ���ڵ带 �������� �������̽�
	
	public static BoardDao boardDao = new BoardDao(); // DB ���� ��ü�� �̸� �����ϴ����� -> �ݺ������� ���, �ش�Ŭ������ �޼ҵ带 �ҷ������ϱ� ����
	
	// ������
	public BoardDao() { // �����ڿ��� �����ϴ� ���� : ��ü ������ �ٷ� db�����ϱ�
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ����̺� Ŭ���� ȣ�� 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234"); // DB �ּҿ���

		}catch(Exception e) {}
	}
	
	// �޼ҵ�
		// 1. �۾��� �޼ҵ�
	public boolean write(Board board) {
		try {
		// 1. SQL �ۼ�
			String sql = "insert into board(btitle, bcontent, bwrite) values(?,?,?)";
		// 2. SQL ����
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwrite());
		// 3. SQL ����
			ps.executeUpdate(); // insert, update, delete <------> ps.executeQuery() : select
		// 4. SQL ���
			return true;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false;
	}
		// 2. ��� �� ȣ�� �޼ҵ�[��ȯŸ�� :ObservableList 
	public ObservableList<Board> list() {
		// * ����Ʈ ����
		ObservableList<Board> boardlist = FXCollections.observableArrayList();
		try {
		// 1. SQL �ۼ�
			// ���� : order by �ʵ�� asc[�ش� �ʵ�� �������� ��������]
			// 	   : order by �ʵ�� desc[�ش� �ʵ�� �������� ��������]
			String sql = "select * from board order by bnum desc";
		// 2. SQL ����
			ps = conn.prepareStatement(sql);
		// 3. SQL ����
			rs = ps.executeQuery(); // select
		// 4. SQL ���
			// rs : �˻� ����� ���ڵ带 �ϳ��� ��ȸ[��������=next()]
				// rs.next() : �˻������ ���� ���ڵ�
				// rs.get�ڷ���(�ش��ʵ������ȣ) : �� ���ڵ忡�� �ش� �ʵ��� ������ ��������
			while(rs.next()) { // ���� ���ڵ尡 ���������� �ݺ�
				// 1. ��üȭ
				Board board = new Board(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5),
						rs.getInt(6) );
				// 2. �ش� ��ü�� ����Ʈ�� ���
				boardlist.add(board);
			} // while e
			// ������ ����Ʈ ��ȯ
			return boardlist;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		// ���н� null
		return null;
	}
		// 3. �� ���� �޼ҵ�
	public boolean delete(int bnum) {
		try {
		// 1. SQL �ۼ�
			String sql = "delete from board where bnum=?";
		// 2. SQL ����
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bnum);
		// 3. SQL ����
			ps.executeUpdate();
		// 4. SQL ���
			return true;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false;
	}
		// 4. �� ���� �޼ҵ�
	public boolean update(int bnum, String title, String content) {
		try {
		// 1. SQL �ۼ�
			String sql = "update board set btitle=?, bcontent=? where bnum=?";
		// 2. SQL ����
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bnum);
		// 3. SQL ����
			ps.executeUpdate();
		// 4. SQL ���
			return true;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false;
	}
	
		// 5. ��� �ۼ� �޼ҵ�[���� �Խù� ��ȣ]
	public boolean rwrite(Reply reply) {
		try {
			String sql = "insert into reply(rcontent, rwrite, bnum) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setString(2, reply.getRwrite());
			ps.setInt(3, reply.getBnum());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return false;
	}
		// 6. �ش� �Խù��� ��� ȣ�� �޼ҵ�
	public ObservableList<Reply> replylist(int bnum){
		ObservableList<Reply> replylist = FXCollections.observableArrayList();
		
		try {
			String sql = "select * from reply where bnum =? order by bnum desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5) );
				replylist.add(reply);		
			} // while e
			return replylist;
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		return null;
	}
	
	public boolean viewcount(int bnum) {
		try {
			String sql = "select * from board where bnum=?";
			
		}catch(Exception e) {System.out.println("[SQL ����]"+e);}
		
		return false;
	}
	
} // ce