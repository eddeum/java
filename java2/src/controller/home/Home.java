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
				// fxml 실행시 초기값 설정 인터페이스
	
	public static Home home; // 객체생성(다른곳에서 호출하기 위함)
	
	public Home() {home = this;}  // * this : 현재 클래스의 메모리 호출
	
	
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
	private Label lblproduct1;
	@FXML
	private Label lblproduct2;
	@FXML
	private Label lblproduct3;
	@FXML
	private Label lblproduct4;
	@FXML
	private Label lblrecord;	
	
	
	@FXML
	private BorderPane borderpane;
	
	public static String category;
	
	@FXML // 회원정보 레이블을 클릭했을때 이벤트
	public void accinfo(MouseEvent e) {loadpage("/view/home/info.fxml");}
	
	@FXML // 회원수정 레이블을 클릭했을때 이벤트
	public void accupdate(MouseEvent e) {loadpage("/view/home/update.fxml");}
	
	@FXML // 자유게시 레이블을 클릭했을때 이벤트
	public void accboard(MouseEvent e) {loadpage("/view/board/board.fxml");}
	
	@FXML // 남성의류 레이블을 클릭했을때 이벤트
	public void accproduct1(MouseEvent e) {
		loadpage("/view/product/product.fxml"); category = "남성의류";
	}
	
	@FXML // 여성의류 레이블을 클릭했을때 이벤트
	public void accproduct2(MouseEvent e) {
		loadpage("/view/product/product.fxml");  category = "여성의류";
	}
	
	@FXML // 게임기기 레이블을 클릭했을때 이벤트
	public void accproduct3(MouseEvent e) {
		loadpage("/view/product/product.fxml");  category = "게임기기";
	}
	
	@FXML // 생활용품 레이블을 클릭했을때 이벤트
	public void accproduct4(MouseEvent e) {
		loadpage("/view/product/product.fxml");  category = "생활용품";
	}
	
	@FXML // 통계 레이블을 클릭했을때 이벤트
	public void accrecord(MouseEvent e) {loadpage("/view/record.fxml");}
	
	
	
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
		}catch(Exception e) { System.out.println( e );}
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/chatting.fxml");
		lblloginid.setText(Login.member.getMid()+"님");
		lblpoint.setText("포인트 : " + Login.member.getMpoint()+"점");
	}
	
	@FXML // 로그아웃 레이블을 클릭했을때 이벤트
	public void logout(MouseEvent e) {
		// 1. Login 정보 지우기
		Login.member = null;
		// 2. 페이지 전환
		Main.instance.loadpage("/view/login/login.fxml");
	}
	@FXML //회원탈퇴 테이블을 클리했을때 이벤트
	public void delete(MouseEvent e) {
		
		// 1. 메시지
		Alert alert = new Alert(AlertType.CONFIRMATION); // 확인,취소 버튼 타입
			alert.setHeaderText("회원 탈퇴 하시겠습니까?");
		// 2. 버튼 확인[Optional] : 클래스 
		Optional<ButtonType> optional = alert.showAndWait(); // 실행
		if(optional.get()==ButtonType.OK) { // 확인 버튼을 눌렀을때
			// 회원탈퇴 진행
			boolean result = MemberDao.memberDao.delete(Login.member.getMnum());
								// 현재 로그인중인 회원의 번호 호출
			if(result) { // 탈퇴성공
				// 로그아웃[Login 클래스내 Member 객체 null으로 수정
				Login.member = null;
				// 페이지전환
				Main.instance.loadpage("/view/login/login.fxml");
			}else { // 탈퇴실패
				
			} // else e
		}
		// 아니면

	}
	
	
}
