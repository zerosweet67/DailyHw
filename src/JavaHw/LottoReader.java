package JavaHw;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LottoReader {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入想查詢的大樂透期數: ");
		 try {
	            int userInputLineNumber = scanner.nextInt(); // 使用者輸入的筆數

	            queryAndOutput(userInputLineNumber);
	            System.out.println("查詢結果已縱向輸出至 Lotto_new.txt");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	
	 public static void queryAndOutput(int lineNumber) throws IOException {
	        String inputFile = "C:\\Java\\WorkSpace\\DailyHW\\Lotto.txt";
	        String outputFile = "C:\\Java\\WorkSpace\\DailyHW\\Lotto_new.txt";

	        List<String> lines = Files.readAllLines(Paths.get(inputFile));

	        if (lineNumber <= 0 || lineNumber > lines.size()) {
	            System.out.println("查詢的樂透筆數超出範圍。");
	            return;
	        }

	        String outputLine = lines.get(lineNumber - 1);
	        String[] numbers = outputLine.split(" ");

	        try {
	            Files.write(Paths.get(outputFile), List.of("第" + lineNumber + "筆樂透:"), java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);
	            Files.write(Paths.get(outputFile), List.of(numbers), java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

}
