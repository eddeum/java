package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Findpassword implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtid;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("��й�ȣã�⿡�� �ڷΰ����ư Ŭ��");
    	Login.get���ΰ�ü().loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void findpassword(ActionEvent event) {
    	System.out.println("��й�ȣã�� �õ�");

    }
	
}