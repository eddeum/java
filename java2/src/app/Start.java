package app;

import controller.Chatting;
import controller.login.Login;
import dao.RoomDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		// 5. 컨테이너 불러오기
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
																// 패키지명(폴더)/파일명.확장자
		// 6. 씬 객체 -> 컨테이너
		Scene scene = new Scene(parent);
		// 7. 씬 -> 스테이지
		stage.setScene(scene);
		// 3. 스테이지 로고 설정
			Image image = new Image("/img/stagelogo.jpeg"); // 1. 이미지 불러오기[이미지 객체화]
				// 절대경로 vs 상대경로
				// 절대경로 : 모든 경로
					// C:\Users\504\git\java\java2\src\img
				// 상대경로 : 현 위치[프로젝트 src] 기준 경로
					// 생략[src폴더부터] /img/파일명.확장자 
			
		stage.getIcons().add(image); // 3. 스테이지 아이콘 설정 
		
		// * 외부폰트 설정
			// 1. 폰트 로드
			Font.loadFont(getClass().getResourceAsStream("SANGJU Gotgam.ttf"), 14); // 해당 폰트의 컴퓨터 이름이 정확하지 않아 안되는것 같아요... 다른 폰트는 되니까... 해보시고 저도 저 폰트의 컴퓨터이름을 확인해봃게요~~넹
			// 2. 현재 scene에 외부 스타일시트 적용
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
		// * stage(윈도우창)에 X버튼을 눌렀을때 이벤트
			stage.setOnCloseRequest(e -> {
				// 만약에 로그인이 되어있으면
				if(Login.member != null) {
					// 2. 방 삭제
					if(Chatting.selectroom != null) { // 만약에 방에 접속되어 있는 상태이면
					// 1. 방 접속명단 삭제
						RoomDao.roomDao.roomlivedelete(Login.member.getMid() );
						RoomDao.roomDao.roomdelete(Chatting.selectroom.getRonum() );
					} // if e
					// 3. 선택 방 초기화
					Chatting.selectroom = null;
				} // if e
			});
			
			
			
			
		stage.setResizable(false);	// 4. 스테이지 크기 변경 불가
		stage.setTitle("이젠마켓"); // 2. 스테이지 창 이름
		stage.show(); // 1. 스테이지 열기
	}
	public static void main(String[] args) {
		launch(args);
	}
}
