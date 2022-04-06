package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Findidpane implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("���̵�ã�⿡�� �ڷΰ����ư Ŭ��");
    	Login.get���ΰ�ü().loadpage("/view/login/loginpane.fxml");

    }

    @FXML
    void findid(ActionEvent event) {
    	// 1. ��Ʈ�ѿ� �Էµ� �̸��� ��������
    	String email = txtemail.getText();
    	// 2. DB ���� ��ü���� ���̵�ã�� �޼ҵ� ����
    	String id = MemberDao.memberDao.findid(email);
    	// 3. Ȯ��
    	if(id != null) { // id�� �����ϸ� db���� ���̵�ã�� ����
    		// 1. �޽��� [�˶�]
    		Alert alert = new Alert(AlertType.INFORMATION); // �޽��� ��ü ����
    			alert.setHeaderText("ȸ������ ���̵�� : "+id);
    		alert.showAndWait(); // ����
    	}else { // null �̸� db���� Ȥ�� ���̵� ����
    		lblconfirm.setText("�ش� �̸����� ���̵� ������ �����ϴ�.");
    	} // else e
    }
	
}