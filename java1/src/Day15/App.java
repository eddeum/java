package Day15;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			// 1. ��� ���� ǥ ���
				//
						// �迭�̳� ����Ʈ�� ��� ��ü ȣ�� �ݺ���
				//
			System.out.print("\t\t\t 1.���� \t 2.���� : ");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				// 1. ������ȣ�� �Է¹޴´�.
					// �Է�
				// 2. �Է¹��� ������ȣ�� ��Ʈ�ѳ� �޼ҵ忡�� �ѱ��.
				// 3. �޼ҵ� ����� ���� ���
				boolean ��� = Controller.����(null);
			} // if e
			else if(ch==2) {
				// 1. ������ȣ�� �Է¹޴´�.
					// �Է�
				// 2. �Է¹��� ������ȣ�� ��Ʈ�ѳ� �޼ҵ忡�� �ѱ��.
				// 3. �޼ҵ� ����� ���� ���
				boolean ��� = Controller.����(null);
			} // else if e
			
			
			
			
			
			
			
		} // while e
		

	} // me

} // ce