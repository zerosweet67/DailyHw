package JavaHw;

import java.text.DecimalFormat;
import java.util.TreeSet;

public class PlayLottoSet {

	public static void main(String[] args) {
		   int index = 1;
	        TreeSet<String> tset = new TreeSet<String>(); //TreeSet特性，資料不能重覆，用HashSet也可以
	        do{
	            String num = new DecimalFormat("00").format((int)(42*Math.random()+1));
	            tset.add(num);
	            while(index == tset.size()){ //判斷tset是否有出現重復號碼
	                if(tset.size() <= 6)
	                    System.out.println("第" + (index++) + "個號碼是：" + num);
	                else if(index == 7){
	                    System.out.println("特別號碼是：" + num);
	                    index++;
	                }
	            }
	        }while(index <= 7);
		
	}

}
