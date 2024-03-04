package JavaHw;

import java.util.Scanner;

public class GuessNumberGame {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = (int) (Math.random() * 10000);
		
		//避免生成重複的數字
		
		int flag = 0;
		while (flag == 0) {
			int[] check = new int[10];
			for (int i = 0; i < 10; i++)
				check[i] = 0;
			check[num / 1000] += 1;
			check[(num / 100) % 10] += 1;
			check[(num / 10) % 10] += 1;
			check[num % 10] += 1;
			
		//檢查 check 數組中是否有任何數字出現超過一次 , 若有 , 重新生成數字
			for (int i = 0; i < 10; i++) {
				if (check[i] >= 2) {
					num = (int) (Math.random() * 10000);
					flag = 0;
					break;

				} else
					flag = 1;
			}
		}
		// System.out.println("答案為 : " + num);

		int input = -1;
		int idx = 0;
		int times = 0;
		while (input != num) {
			System.out.print("請輸入4位數字 : ");
			input = sc.nextInt();
			int inputcopy = input;

			if (input < 0) {
				System.out.println("請輸入4 位數字");
				times++;
				continue;

			}
			int t = 0;
			// 檢查輸入的4位數字

			while (inputcopy != 0) {
				inputcopy /= 10;
				t++;
			}
			if (t != 4) {
				System.out.println("請輸入4 位數字");
				times++;
				continue;
			}
			int n = 0, m = 0; // nAmB

			if (input == num)
				break;
			// 輸入的各個位數

			int[] a = new int[4];
			a[0] = input / 1000;
			a[1] = (input / 100) % 10;
			a[2] = (input / 10) % 10;
			a[3] = (input) % 10;
			// 答案的各個位數
			int[] ans = new int[4];
			ans[0] = num / 1000;
			ans[1] = (num / 100) % 10;
			ans[2] = (num / 10) % 10;
			ans[3] = (num) % 10;
			for (int i = 0; i < 4; i++) {
				if (ans[i] == a[i])
					n += 1; // A的數量
				for (int j = 0; j < 4; j++) {// B的數量
					if (ans[j] == a[i] && j != i)
						m += 1;
				}
			}
			System.out.print((++idx) + ": " + n + "A" + m + "B");
			System.out.println();
			times++;
		}
		if (input == num) {
			times++;
			System.out.println("4A0B");
			System.out.println("猜對囉");
			System.out.println("猜測次數: " + times);
		}

	}

}
