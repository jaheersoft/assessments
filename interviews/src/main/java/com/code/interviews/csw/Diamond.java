package com.code.interviews.csw;

public class Diamond {
	
	public static void main(String args[]) {
		createDiamond(9);
	}
	
	//reduced the inner for loop iterations 
	public static void createDiamond(int oddNumber) {
		String arr[][] = new String[oddNumber][oddNumber];
		int fillFrom = oddNumber/2;
		int fillTo = oddNumber/2;
		int meanvalue =oddNumber/2;
		for(int i = 0;i < oddNumber;i++) {
			if(fillFrom == fillTo) {
				for(int k = 0;k<fillFrom;k++) {
					arr[i][k] = " ";
					System.out.print(arr[i][k]);
				}
				arr[i][fillTo] = "*";
				System.out.print(arr[i][fillTo]);
				for(int l = oddNumber-1;l>fillTo;l--) {
					arr[i][l] = " ";
					System.out.print(arr[i][l]);
				}
				if(i == (oddNumber-1)) {
					break;
				} else {
					fillFrom--;
					fillTo++;
				}
			} else {
				if(i > meanvalue) {
					if(fillFrom < meanvalue) {
						fillFrom++;
						fillTo--;
					}
					for(int k = 0;k<fillFrom;k++) {
						arr[i][k] = " ";
						System.out.print(arr[i][k]);
					}
					for(int j = fillFrom;j <= fillTo;j++) {
						arr[i][j] = "*";
						System.out.print(arr[i][j]);
					}
					for(int l = oddNumber-1;l>fillTo;l--) {
						arr[i][l] = " ";
						System.out.print(arr[i][l]);
					}
				} else {
					for(int k = 0;k<fillFrom;k++) {
						arr[i][k] = " ";
						System.out.print(arr[i][k]);
					}
					for(int j = fillFrom;j <= fillTo;j++) {
						arr[i][j] = "*";
						System.out.print(arr[i][j]);
					}
					for(int l = oddNumber-1;l>fillTo;l--) {
						arr[i][l] = " ";
						System.out.print(arr[i][l]);
					}
					if(fillFrom > 0) {
						fillFrom--;
						fillTo++;
					}
				}
			}
			/*for(int j = 0;j<oddNumber;j++) {
				if(arr[i][j] == null || "".equals(arr[i][j])) {
					arr[i][j] = " ";
				}
				System.out.print(arr[i][j]);
			}*/
			System.out.println();
		}
	}
	
	
}
