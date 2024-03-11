package JavaHw;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PlayLottoSet {

	public static void main(String[] args) {

		TreeSet<String> playlottoSet = PlayLottoSet.playLottoSet();
		System.out.println("TreeSet大樂透開獎結果 :" + playlottoSet);

		Map<Integer, Integer> lottoMap = playLottoHashMap(playlottoSet);

	}

	public static Map<Integer, Integer> playLottoHashMap(TreeSet<String> playLottoSet) {
		
		//Hashmap 
		  HashMap<Integer, Integer> map = new HashMap<>();
	        int[] order = {1}; 

	        playLottoSet.forEach(lottoResult -> {
	            map.put(order[0], Integer.parseInt(lottoResult));
	            order[0]++;
	        });

	        map.forEach((key, value) -> System.out.println("第" + key + "個大樂透: " + value));

	        return map;
	}

	public static TreeSet<String> playLottoSet() {

		TreeSet<String> lottoSet = new TreeSet<>();

		while (lottoSet.size() < 7) {
			String num = String.format("%02d", (int) (49 * Math.random() + 1));
			lottoSet.add(num);
		}

		return lottoSet;
	}
}
