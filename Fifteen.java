public class Fifteen {
	public static void main(String arg[])
	throws java.io.IOException {
		int matrix[][] = {
			{11, 12, 13, 14},
				{15, 16, 17, 18},
					{19, 20, 21, 0},
						{23, 24, 25, 22}
		};
		int zero[] = {0, 0};
		
		for(int i = 0; i < matrix.length; i++) {
			for(int n = 0; n < matrix[i].length; n++) {
				if (matrix[i][n] == 0) {
				zero[0] = i;
				zero[1] = n;
				}
			}
		}
		
		System.out.println("Zero point at " + (zero[0] + 1) + " line and " + (zero[1] + 1) + " column");
		for(int i = 0; i < matrix.length; i++) {
			for(int n = 0; n < matrix[i].length; n++) {
				System.out.print(matrix[i][n] + " ");
			}
			System.out.println();
		}
	}
}