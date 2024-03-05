package JavaHw;

import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PlayLottoSet {

	public static void main(String[] args) {

		TreeSet<String> playlottoSet = PlayLottoSet.playLottoSet();
		System.out.println("TreeSet大樂透開獎結果 :" + playlottoSet);

		Map<Integer, Integer> lottoMap = playLottoHashMap(playlottoSet);

	}

	public static Map<Integer, Integer> playLottoHashMap(TreeSet<String> playLottoSet) {
		  HashMap<Integer, Integer> map = new HashMap<>();
	        int[] order = {1}; // 使用陣列以便在 lambda 運算式中修改

	        playLottoSet.forEach(lottoResult -> {
	            map.put(order[0], Integer.parseInt(lottoResult));
	            order[0]++;
	        });

	        // 若要按照順序輸出，可以透過 forEach 遍歷
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
