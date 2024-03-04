package JavaHw;

public class PlayLotto {

	public static void main(String[] args) {
		String[] num = playLotto();
		System.out.println("大樂透開獎結果 : ");
		for(String lotto :num ) {
			System.out.print(lotto + "、");
		}

	}
	public static String[] playLotto() {
		
		String[] num = new String[6];
		for (int i = 0; i < 6; i++) {
			int randomnum = (int) (Math.random() * 49 + 1);
			num[i] = String.format("%02d", randomnum);
			for (int j = 0; j < i; j++) {// 檢查有無重覆{
				if (num[i] == num[j]) {// 有重覆重抽一次
					i--;
					break;
				}
			}

		}
		return num;
		
		
	}
	
}
