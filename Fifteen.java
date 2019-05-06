import java.util.Arrays;
import java.util.Scanner;
public class Fifteen {
	//Method gets intricateMatrix and return position of number's place
	static int[] findNumber(int[][] m, int num) {
		int[] result = new int[2];
		for(int i = 0; i < m.length; i++) {
			for(int n = 0; n < m[i].length; n++) {
				if (m[i][n] == num) {
				result[1] = n;
				result[0] = i;
				}
			}
		}
		return result;
	}
	//Method gets intricateMatrix and return possible steps in order top, right, bottom, left. -1 is impossible direction
	static int[] possibleSteps(int[][] intrMatrix, int[] zeroPosition) {
		int result[] = new int[4];
		if (zeroPosition[0] == 0) {
			result[0] = -1;
		} else {
			result[0] = intrMatrix[zeroPosition[0] - 1][zeroPosition[1]];
		}
		if (zeroPosition[1] == 3) {
			result[1] = -1;
		} else {
			result[1] = intrMatrix[zeroPosition[0]][zeroPosition[1] + 1];
		}
		if (zeroPosition[0] == 3) {
			result[2] = -1;
		} else {
			result[2] = intrMatrix[zeroPosition[0] + 1][zeroPosition[1]];
		}
		if (zeroPosition[1] == 0) {
			result[3] = -1;
		} else {
			result[3] = intrMatrix[zeroPosition[0]][zeroPosition[1] - 1];
		}
		return result;
	}

	static void game(int[] pos)
	throws java.io.IOException {
		int number;
		boolean include = false;
		Scanner in = new Scanner(System.in);
		do {
			do {
				System.out.print("Enter number you'd like to move ");
				while(!in.hasNextInt()) {
					System.out.print("it's not a number, enter ");
					for(int i = 0; i < pos.length; i++) {
						if (pos[i] >= 0)
							System.out.print(pos[i] + " ");
					}
					in.next();
				}
				System.out.println();
			} while(!in.hasNextInt()); //here I'll should add numbers from possible steps
			number = in.nextInt();
			for(int i = 0; i < pos.length; i++) {
				if (number == pos[i] && number > 0) {
					include = true;
					break;
				}
			}
		} while(!include);


		System.out.println("Number is " + number);
		in.close();
	}

	public static void main(String arg[])
	throws java.io.IOException {
		int matrix[][] = { //Matrix where all squares on their places
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 0}
		};
		int intricateMatrix[][] = { //Matrix where almost all squares on wrong places
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 0},
			{13, 14, 15, 12}
		};
		int zero[] = findNumber(intricateMatrix, 0); //Position of empty square (1/16)
		int positions[] = possibleSteps(intricateMatrix, zero);


		game(positions);

		System.out.println("Zero point at " + (zero[0] + 1) + " line and " + (zero[1] + 1) + " column");
		for(int i = 0; i < intricateMatrix.length; i++) {
			for(int n = 0; n < intricateMatrix[i].length; n++) {
				System.out.print(((intricateMatrix[i][n] < 10) ? "0" : "") + intricateMatrix[i][n] + " ");
			}
			System.out.println();
		}
		System.out.println("Is pazzle solved? " + Arrays.deepEquals(matrix, intricateMatrix));
		System.out.println("Possible step is " + positions[0] + " " + positions[1] + " " + positions[2] + " " + positions[3]);
	}
}
