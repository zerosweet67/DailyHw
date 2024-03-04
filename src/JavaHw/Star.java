package JavaHw;

public class Star {
	public static void main(String[] args) {

		for (int i = 1; i <= 6; i++) {

			System.out.println("星星圖: " + i + " ;");
			star(i);
		}

	}

	public static void star(int i) {
		int maxlevel = 5;
		switch (i) {
		case 1:
			
			for (int j = 1; j <= maxlevel; j++) {
				for (int k = 1; k <= j; k++) {
					System.out.print("*");
				}
				System.out.println("\n\n");
			}
			break;
		case 2:
			
			for (int j = 1; j <= maxlevel; j++) {
				for (int k = 1 ; k <= maxlevel-j; k++) {
					System.out.print(" ");
				}
				for(int m = 1; m<= j ;m++) {
					System.out.print("*");
				}
				System.out.println("\n\n");
			}
			break;
		case 3:
			for (int a = 1; a <= maxlevel; a++) {
			    for (int b = 1; b <= maxlevel - a +1; b++) {
			        System.out.print("*");
			    }
			    System.out.println("\n");
			}
			break;
		case 4:
			for (int c = 1; c <= maxlevel; c++) {
				for(int d = 0; d< c-1; d++) {
					System.out.print(" ");
				}
				for(int e = 1; e<= maxlevel - c +1; e++) {
					System.out.print("*");
				}
				System.out.println("\n");
			}
			
			break;
		case 5:
			for(int f = 1; f<= maxlevel; f++) {
				for(int g = 0; g<= maxlevel-f;g ++) {
					System.out.print(" ");
				}
				for (int h = 1; h<= f; h++) {
					System.out.print("*" + " ");
				}System.out.println("\n");
			}
			
			
			break;
		case 6:
			for(int f = 1; f<= maxlevel; f++) {
				for(int g = 0; g<= maxlevel-f;g ++) {
					System.out.print(" ");
				}
				for (int h = 1; h<= f; h++) {
					System.out.print("*" + " ");
				}System.out.println("\n");
			}
			
			for (int q = maxlevel; q> 0; q --) {
				for (int r = 0 ; r<= maxlevel - q+1; r++) {
					System.out.print(" ");
				}
				for (int s = 0; s < q-1; s ++) {
					System.out.print("*" + " ");
				}
				System.out.println("\n");
				
			}
			break;

		default:
			System.out.println("未定義的星星圖");
		}

	}
}
