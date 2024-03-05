package JavaHw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LottoProducer {
	
	private static final String Lotto_PATH = "C:/Java/WorkSpace/DailyHW/"; // window - C:/qrcodes	
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
        System.out.println("Lotto_PATH "+dir.toAbsolutePath().toString());
	}

	public static void main(String[] args) throws IOException {
		 int numberOfDraws = 20;
	        List<String> filesToZip = new ArrayList<>();

	        for (int i = 1; i <= numberOfDraws; i++) {
	            String fileName = Lotto_PATH + "/Lotto_" + i + ".txt";
	            filesToZip.add(fileName);

	            generateAndWriteLottoToFile(fileName);
	            System.out.println("已生成第 " + i + " 筆大樂透結果，並輸出至 " + fileName);
	        }

	        zipFiles(Lotto_PATH, "LottoResults.zip", filesToZip);
	        System.out.println("已將 " + numberOfDraws + " 個 txt 檔案壓縮成 LottoResults.zip");
	   

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
    public static void generateAndWriteLottoToFile(String fileName) throws IOException {
        HashMap<Integer, TreeSet<String>> lottoResults = playLottoMap(100);
        writeResultsToFile(lottoResults, fileName);
    }
    
    public static void zipFiles(String sourceFolderPath, String zipFileName, List<String> filesToZip) throws IOException {
        Path sourcePath = Paths.get(sourceFolderPath);
        Path zipFilePath = sourcePath.resolve(zipFileName);

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFilePath))) {
            for (String fileToZip : filesToZip) {
                Path filePath = sourcePath.resolve(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip);
                zipOutputStream.putNextEntry(zipEntry);
                Files.copy(filePath, zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }

}}
