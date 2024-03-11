package JavaHw;

public class RandomNumber {
	public static void main(String[] args) {
// Random 物件
		for (int i = 0; i < 20; i++) {
			int score = (int) (Math.random() * 100) + 1;
			System.out.println("分數 " + (i + 1) + ": " + score + " - " + classify(score));
		}
	}

	public static String classify(int score) {
		int grade = score / 10; 

		switch (grade) {
		case 10:
			return "甲";
		case 9:
			return "甲";
		case 8:
			return "乙";
		case 7:
			return "丙";
		case 6:
			return "丁";
		default:
			return "其他";
		}
	}

}
