package controller.product;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.MemberDao;
import dao.ProductDao;
import dto.Member;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Productview implements Initializable{
	

	 @FXML
	    private Button btndelete;

	    @FXML
	    private Button btnupdate;

	    @FXML
	    private Button btnback;

	    @FXML
	    private ImageView img;

	    @FXML
	    private TextField txtpname;

	    @FXML
	    private TextField txtpcontent;

	    @FXML
	    private Label txtpprice;

	    @FXML
	    private Label txtpactivation;

	    @FXML
	    private Label txtpdate;

	    @FXML
	    private Label txtmid;

	    @FXML
	    void back(ActionEvent event) {
	    	Home.home.loadpage("/view/product/product.fxml");
	    }

	    @FXML
	    void delete(ActionEvent event) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    		alert.setHeaderText("�ش� ��ǰ�� �����ұ��?");
	    	Optional<ButtonType> optional = alert.showAndWait();
	    	
	    	if(optional.get() == ButtonType.OK) {
	    		ProductDao.productDao.delete(Productcontrol.select.getPnum());
	    		Home.home.loadpage("/view/product/product.fxml");
	    	}
	    }

	    @FXML
	    void update(ActionEvent event) {
	    	Home.home.loadpage("/view/product/productupdate.fxml");
	    }
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 1. ��Ͽ��� ���õ� ��ǰ�� ��ü�� ȣ��
		Product product = Productcontrol.select;
		// 2. �� ��Ʈ�ѿ� �� �ֱ�
		img.setImage(new Image(product.getPimg() ) );
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
			// * õ���� ��ǥ
			DecimalFormat decimalFormat = new DecimalFormat("���� : #,##0��");
		txtpprice.setText(decimalFormat.format(product.getPprice()));
		if(product.getPactivation() == 1) {txtpactivation.setText("���� : �Ǹ���");}
		if(product.getPactivation() == 2) {txtpactivation.setText("���� : �ŷ���");}
		if(product.getPactivation() == 3) {txtpactivation.setText("���� : �ǸſϷ�");}
		txtpdate.setText("��ǰ ����� : " + product.getPdate());
		// * ȸ����ȣ�� �̿��� ȸ��id ã��[DAO���� �޼ҵ� �̿�]
		txtmid.setText("��ǰ ���ȸ�� : " + MemberDao.memberDao.getmid(product.getMnum() ) );
		
		txtpname.setEditable(false);
		txtpcontent.setEditable(false);
		
		// * ��ǰ���ȸ�� ��ȣ�� �α��ε�ȸ�� ��ȣ�� �������� ������
		if(product.getMnum() != Login.member.getMnum()) {
			btndelete.setVisible(false);
			btnupdate.setVisible(false);
		}
		
	}
	
}