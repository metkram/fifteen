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

	static void printMatrix(int[][] matrix) {
		System.out.println("+-------------------+");
		for(int i = 0; i < matrix.length; i++) {
			System.out.print("| ");
			for(int n = 0; n < matrix[i].length; n++) {
				if(matrix[i][n] == 0) {
					System.out.print("   | ");
				} else {
					System.out.print(((matrix[i][n] < 10) ? "0" : "") + matrix[i][n] + " | ");
				}

			}
			System.out.println("");
			System.out.println("+-------------------+");
		}
	}

	static int[][] generateMatrix() { //This method generate 4x4 matrix and solve 15 pazzle probleb (only one half pazzles could be solved)
		int matrix[] = new int[15];
		int intrMatrix[][] = new int[4][4];
		int temp = 0, paritySum;
		boolean parity = false;
		for(int i = 0; i < matrix.length; i++) {
			matrix[i] = i + 1;
		}
		while(!parity) {
			paritySum = 0;
			parity = false;
			for(int i = 0; i < matrix.length; i++) {
				int random = (int) (Math.random() * 15);
				temp = matrix[i];
				matrix[i] = matrix[random];
				matrix[random] = temp;
			}

			for(int i = 0; i < matrix.length; i++) {
				temp = matrix[i];
				for(int n = temp + 1; n < matrix.length; n++) {
					if(matrix[n] < matrix[i]) {
						paritySum++;
					}
				}
			}
			parity = paritySum == 0 ? true : paritySum % 2 == 0;
		}
		temp = 0;
		for(int i = 0; i < intrMatrix.length; i++) {
			for(int n = 0; n < intrMatrix[i].length; n++) {
				intrMatrix[i][n] = matrix[temp];
				if(temp < 14) {
					temp++;
				}
			}
		}
		intrMatrix[3][3] = 0;
		return intrMatrix;
	}

	static void game(int[] pos, int[][] solvedmatrix, int[][] unsolvedmatrix)
	throws java.io.IOException {
		int number;
		boolean include = false;
		int[][] solved = solvedmatrix, unsolved = unsolvedmatrix;
		int[] zero, chosenNumber;
		Scanner in = new Scanner(System.in);
		while(!Arrays.deepEquals(solved, unsolved)) {
			do {
				do {
					printMatrix(unsolved);
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
			System.out.println("Chosen number is " + number);
			zero = findNumber(unsolved, 0);
			chosenNumber = findNumber(unsolved, number);
			unsolved[zero[0]][zero[1]] = number;
			unsolved[chosenNumber[0]][chosenNumber[1]] = 0;
		}
		in.close();
		System.out.println("Yo, yo, yo, you have won this game");
	}

	public static void main(String arg[])
	throws java.io.IOException {
		int matrix[][] = { //Matrix where all squares on their places
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 0}
		};
		int intricateMatrix[][] = generateMatrix();  //Matrix where almost all squares on wrong places
		int zero[] = findNumber(intricateMatrix, 0); //Position of empty square (1/16)
		int positions[] = possibleSteps(intricateMatrix, zero);

		game(positions, matrix, intricateMatrix);
	}
}
