package JavaHw;

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
public class IdCardVerification {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入身分證字號(須包含英文字母) : ");
		String idArray = sc.nextLine().toUpperCase();

		boolean isValid = idVerify(idArray);

		if (isValid) {
			System.out.println("有效的身分證號碼");

		}else {
		System.out.println("無效的身分證號碼");}

	}
/*
 *  S=戶籍碼十位數×1+戶籍碼個位數×9+性別碼×8+N1×7+N2×6+N3×5+N4×4+N5×3+N6×2+N7×1
 * 若S除以10的餘數是R，則檢查碼=10-R*/
	public static boolean idVerify(String idArray) {

	    int[] placeNumber = { 10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29,
	            32, 30, 31, 32 };
	    int val = placeNumber[idArray.charAt(0) - 'A'];
	    int p = (val / 10) + (9 * (val % 10));
	    int j = 1;
	    for (int i = 8; i >= 1; i--) {
	        p += i * Integer.parseInt(idArray.substring(j, j + 1));
	        j++;
	    }

	    p += Integer.parseInt(idArray.substring(9, 10));
	    if (p % 10 == 0) {
	       
	        return true;
	    }

	   
	    return false;
	}

}
