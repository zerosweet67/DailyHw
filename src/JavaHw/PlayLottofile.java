package JavaHw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public class PlayLottofile {

	public static void main(String[] args) throws IOException {

		int numberOfDraws = 100;
		String fileName = "Lotto.txt";

		HashMap<Integer, TreeSet<String>> lottoResults = playLottoMap(numberOfDraws);
		writeResultsToFile(lottoResults, fileName);
		System.out.println("大樂透組別: " + lottoResults);
		System.out.println("已生成" + numberOfDraws + "筆大樂透結果，並輸出至 " + fileName);
		renameAndMoveFile();
		System.out.println("檔名已修改完成已生成");
		/**
		 * int numberOfLottoSets = 100; HashMap<Integer, TreeSet<String>> lottoMap =
		 * playLottoMap(numberOfLottoSets);
		 * 
		 * // 遍歷 HashMap 並輸出結果 for (int key : lottoMap.keySet()) {
		 * System.out.println("大樂透組別: " + key + ", Lotto Set: " + lottoMap.get(key)); }
		 **/

	}

	public static TreeSet<String> playLottoSet() {
		TreeSet<String> lottoSet = new TreeSet<>();

		while (lottoSet.size() < 7) {
			String num = String.format("%02d", (int) (49 * Math.random() + 1));
			lottoSet.add(num);
		}

		return lottoSet;
	}

	public static HashMap<Integer, TreeSet<String>> playLottoMap(int numberOfLottoSets) {
		HashMap<Integer, TreeSet<String>> lottoMap = new HashMap<>();

		for (int i = 1; i <= numberOfLottoSets; i++) {
			TreeSet<String> lottoSet = playLottoSet();
			lottoMap.put(i, lottoSet);
		}

		return lottoMap;
	}

	public static void writeResultsToFile(HashMap<Integer, TreeSet<String>> lottoResults, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (Integer drawNumber : lottoResults.keySet()) {
				writer.write("大樂透組別: " + drawNumber + ", Lotto Set: " + lottoResults.get(drawNumber) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static final String Lotto_PATH = "C:/Java/WorkSpace/DailyHW/Lotto"; // window - C:/qrcodes
	static {
		Path dir = Paths.get(Lotto_PATH);
		if (!Files.exists(dir)) {
			try {
				Files.createDirectories(dir);
			} catch (IOException e) {
				// Handle the exception according to your requirements
				e.printStackTrace();
			}
		}
		System.out.println("Lotto_PATH " + dir.toAbsolutePath().toString());
	}

	public static void renameAndMoveFile() throws IOException {
		Path fromFile = Paths.get("C:\\Java\\WorkSpace\\DailyHW\\Lotto.txt");
		Path toDirectory = Paths.get(Lotto_PATH);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Path toFile = toDirectory.resolve("Lotto_"+sdf.format(date)+".txt");
		Files.copy(fromFile, toFile);

	}
}
