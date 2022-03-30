package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Login implements Initializable {
	
	// * �ش� Ŭ������ �޸𸮸� ��ȯ���ִ� �޼ҵ�
		// 1. ���� Ŭ������ ��ü����
	public static Login ���ΰ�ü;
		// 2. �����ڿ��� ��ü�� this �־��ֱ�
			// this : ����Ŭ������ �޸�[���ο� �޸��Ҵ� x]
	public Login() {
		���ΰ�ü = this; // super : ����Ŭ����(���) this : �� Ŭ����
		// this : ����Ŭ���� ��ü �޸� ȣ��
	}
		// 3. �ܺο��� ȣ���� �� �ִ� �޼ҵ� ����(�޼ҵ� �ȸ�����)
	public static Login get���ΰ�ü() {
		return ���ΰ�ü;
	}
	
	// line 17~26 : Loginpane controller���� ȸ�������������� �̵��ϱ�����..

    @FXML
    private MediaView mediaview;
    
    @FXML
    private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 1. ������ �����ϱ�
			// 1. ���������� ��üȭ
		Media media = new Media(getClass().getResource("/img/login.mp4").toString());
			// 2. �̵���÷��̾� ��ü�� ������ �ֱ�
		MediaPlayer mediaPlayer = new MediaPlayer(media);
			// 3. �̵��信 �̵���÷��̾� �ֱ�
		mediaview.setMediaPlayer(mediaPlayer);
			// 4. �̵���÷��̾� ����
		mediaPlayer.play();
		
		loadpage("/view/login/loginpane.fxml");
	}
	
	public void loadpage(String page) {
		try {
		Parent parent = FXMLLoader.load(getClass().getResource(page));
		borderpane.setCenter(parent);
		}catch(Exception e) {System.out.println("�ش� ������ �����ϴ�."+e);}
	}
	
	
	
}