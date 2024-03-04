package JavaHw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 計算出使用者輸入日期加上天數，並印出原本日期 和 加上天數日期
 * Date使用者輸入的日期,dateNum 使用者輸入的天數
 * 
 * */
public class ComputationDate {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入日期, 格式為 2024-03-04 : ");
		String date = sc.nextLine();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false); 
		Date getDate;
		try {
			getDate = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(getDate);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			if (day <= 0 || day>31) {
				System.out.println("請輸入正確的日期! ");
				 return;
			}
			
			System.out.println("請輸入欲加的天數: ");
			int dateNum = sc.nextInt();
			System.out.println(dateNum + "天後的日期為 : " + sdf.format(getDate.getTime()+ dateNum *24 * 60 * 60 * 1000));
			
			
		} catch (ParseException e) {
			System.out.println("請輸入正確的日期! ");
		}
		
	}}
