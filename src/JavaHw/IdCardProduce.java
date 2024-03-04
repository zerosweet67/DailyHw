package JavaHw;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
 * 台北市 Ａ 10　　新竹市 Ｏ 35
　台中市 Ｂ 11　　彰化縣 Ｎ 22
　基隆市 Ｃ 12　　雲林縣 Ｐ 23
　台南市 Ｄ 13　　嘉義縣 Ｑ 24
　高雄市 Ｅ 14　　台南縣 Ｒ 25
　台北縣 Ｆ 15　　高雄縣 Ｓ 26
　宜蘭縣 Ｇ 16　　屏東縣 Ｔ 27
　桃園縣 Ｈ 17　　花蓮縣 Ｕ 28
　新竹縣 Ｊ 18　　台東縣 Ｖ 29
　苗栗縣 Ｋ 19　　澎湖縣 Ｘ 30
　台中縣 Ｌ 20　　陽明山 Ｙ 31
　南投縣 Ｍ 21　　嘉義市 Ｉ 34
 * 
 * S=戶籍碼十位數×1+戶籍碼個位數×9+性別碼×8+N1×7+N2×6+N3×5+N4×4+N5×3+N6×2+N7×1
 * 若S除以10的餘數是R，則檢查碼=10-R
 * */
public class IdCardProduce {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"請輸入欲產生之縣市之代碼, " + "如 台北市 Ａ 10　　新竹市 Ｏ 35\r\n" + "　台中市 Ｂ 11　　彰化縣 Ｎ 22\r\n" + "　基隆市 Ｃ 12　　雲林縣 Ｐ 23\r\n"
						+ "　台南市 Ｄ 13　　嘉義縣 Ｑ 24\r\n" + "　高雄市 Ｅ 14　　台南縣 Ｒ 25\r\n" + "　台北縣 Ｆ 15　　高雄縣 Ｓ 26\r\n"
						+ "　宜蘭縣 Ｇ 16　　屏東縣 Ｔ 27\r\n" + "　桃園縣 Ｈ 17　　花蓮縣 Ｕ 28\r\n" + "　新竹縣 Ｊ 18　　台東縣 Ｖ 29\r\n"
						+ "　苗栗縣 Ｋ 19　　澎湖縣 Ｘ 30\r\n" + "　台中縣 Ｌ 20　　陽明山 Ｙ 31\r\n" + "　南投縣 Ｍ 21　　嘉義市 Ｉ 34 : ");

		Integer placeId = sc.nextInt();
		System.out.println("請輸入性別, 如 男 = 1 , 女 = 2 :");
		Integer sex = sc.nextInt();
		    // 取出 map 的值
		Map<Integer, Character> placeCode = IdCardProduce.createPrintMap();
		boolean isValid = false;
		 System.out.println("生成中請稍後...");
		while (!isValid) {
		    String num = IdProduce();
		    char placeChar = placeCode.get(placeId);
		    String idcardString = placeChar + sex.toString() + num;
		    isValid = idVerify(placeId, idcardString);
		    if (isValid) {
		        System.out.println("產生之身分證字號為: " +  idcardString);
		    }
		}

	}
		   
	

	public static String IdProduce() {
		// F2 28844455
		Random r = new Random();
        StringBuilder idBuilder = new StringBuilder();
		for (int i=1; i<9; i++){
			int num = r.nextInt(9)+1;
            idBuilder.append(num);
		}
		 return idBuilder.toString();

	}
	
	public static boolean idVerify(Integer placeId,String idcardString) {
		int val = placeId;
		int p = (val/10)+ (9*(val%10));
		int j = 1;
		for (int i = 8; i>= 1&& j < idcardString.length(); i--) {
			p += i * Integer.parseInt(idcardString.substring(j,j+1));
			j++;
		}
		p += Integer.parseInt(idcardString.substring(9,10));
		 if (p % 10 == 0) { 
		        return true;
		    }

		    return false;

	}
	
	public static  Map<Integer, Character> createPrintMap(){
		Map<Integer, Character> printPlace = new HashMap<>();
		printPlace.put(10,'A');
		 printPlace.put(11, 'B');
	        printPlace.put(12, 'C');
	        printPlace.put(13, 'D');
	        printPlace.put(14, 'E');
	        printPlace.put(15, 'F');
	        printPlace.put(16, 'G');
	        printPlace.put(17, 'H');
	        printPlace.put(34, 'I');
	        printPlace.put(18, 'J');
	        printPlace.put(19, 'K');
	        printPlace.put(20, 'L');
	        printPlace.put(21, 'M');
	        printPlace.put(22, 'N');
	        printPlace.put(35, 'O');
	        printPlace.put(23, 'P');
	        printPlace.put(24, 'Q');
	        printPlace.put(25, 'R');
	        printPlace.put(26, 'S');
	        printPlace.put(27, 'T');
	        printPlace.put(28, 'U');
	        printPlace.put(29, 'V');
	        printPlace.put(32, 'W');
	        printPlace.put(30, 'X');
	        printPlace.put(31, 'Y');
		return printPlace;
	}

}
