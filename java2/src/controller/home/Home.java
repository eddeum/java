package controller.home;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable {
				// fxml ����� �ʱⰪ ���� �������̽�
	
	public static Home home; // ��ü����(�ٸ������� ȣ���ϱ� ����)
	
	public Home() {home = this;}  // * this : ���� Ŭ������ �޸� ȣ��
	
	
	@FXML
	private Label lblloginid;
	@FXML
	private Label lblpoint;
	@FXML
	private Label lbllogout;
	@FXML
	private Label lbldelete;
	@FXML
	private Label lblinfo;
	@FXML
	private Label lblupdate;
	@FXML
	private Label lblboard;
	@FXML
	private Label lblproduct;
	
	@FXML
	private BorderPane borderpane;
	
	@FXML // ȸ������ ���̺��� Ŭ�������� �̺�Ʈ
	public void accinfo(MouseEvent e) {loadpage("/view/home/info.fxml");}
	
	@FXML // ȸ������ ���̺��� Ŭ�������� �̺�Ʈ
	public void accupdate(MouseEvent e) {loadpage("/view/home/update.fxml");}
	
	@FXML // �����Խ� ���̺��� Ŭ�������� �̺�Ʈ
	public void accboard(MouseEvent e) {loadpage("/view/board/board.fxml");}
	
	@FXML // �����Ƿ� ���̺��� Ŭ�������� �̺�Ʈ
	public void accproduct(MouseEvent e) {loadpage("/view/product/product.fxml");}
	
	
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
		}catch(Exception e) { System.out.println( e );}
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Login.member.getMid()+"��");
		lblpoint.setText("����Ʈ : " + Login.member.getMpoint()+"��");
	}
	
	@FXML // �α׾ƿ� ���̺��� Ŭ�������� �̺�Ʈ
	public void logout(MouseEvent e) {
		// 1. Login ���� �����
		Login.member = null;
		// 2. ������ ��ȯ
		Main.instance.loadpage("/view/login/login.fxml");
	}
	@FXML //ȸ��Ż�� ���̺��� Ŭ�������� �̺�Ʈ
	public void delete(MouseEvent e) {
		
		// 1. �޽���
		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��,��� ��ư Ÿ��
			alert.setHeaderText("ȸ�� Ż�� �Ͻðڽ��ϱ�?");
		// 2. ��ư Ȯ��[Optional] : Ŭ���� 
		Optional<ButtonType> optional = alert.showAndWait(); // ����
		if(optional.get()==ButtonType.OK) { // Ȯ�� ��ư�� ��������
			// ȸ��Ż�� ����
			boolean result = MemberDao.memberDao.delete(Login.member.getMnum());
								// ���� �α������� ȸ���� ��ȣ ȣ��
			if(result) { // Ż�𼺰�
				// �α׾ƿ�[Login Ŭ������ Member ��ü null���� ����
				Login.member = null;
				// ��������ȯ
				Main.instance.loadpage("/view/login/login.fxml");
			}else { // Ż�����
				
			} // else e
		}
		// �ƴϸ�

	}
	
	
}