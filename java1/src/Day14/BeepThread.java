package Day14;

import java.awt.Toolkit;

public class BeepThread extends Thread {
						// ��� Thread[��Ƽ������ Ŭ����]
	// *run�޼ҵ� �������̵�(ctrl+�����̽���)
	@Override
	public void run() { // Thread�� �ִ� run�޼ҵ� ������[�������̵�]
	
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
	
	
	

}