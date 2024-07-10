/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication52;

/**
 *
 * @author semoz
 */
import java.util.*; //be-import kol el classes
public class JavaApplication52 {
public static void main(String[] args) {
      	// Create an empty array board n7ot feha el array el 3*3 eli fe el function ta7t
		String [][] board = getBoard();
                
		// bn3mel array shayel el "X" W el "O"
		String[] symbol = {" X "," O "};

		int result; // bn3rf integer 3shan n3rf el final results (0=player kaza keseb....1= players et3dlo)

		
                //loop to keep the game as long as no one WON
		do {
			// call el board
			shaklElBoard(board);

			// Get available cell to mark
			int[] cell = getCell(board, symbol[0]);
			
			// Mark available cell with player's symbol
			placeSymbol(board, cell, symbol[0]);
	
			// Determine game status
			result = gameStatus(board, symbol[0]);

			// If status is continue(@result=2) bn5ali el next player yel3ab
			if (result == 2) {
				swap(symbol);
			}

		} while(result == 2); // lesa el l3ba sha8ala

		//  call el board
		shaklElBoard(board);

		// results (0=player kaza keseb....1= players et3dlo.....2=lesa el l3ba sha8ala)
		if (result == 0)
			System.out.println(symbol[0] + "player WON YAYAYA!");
		else
			System.out.println("Players TIE!");

	}

        // win walla tie walla continue 
	public static int gameStatus(String[][] arr, String e) {
		if (win(arr, e))
			return 0; // Win
		else if (tie(arr))
			return 1; // tie
		else
			return 2; // Continue
	}

	 
	    // low el player keseb horizontally awo vertically awo diagonally 
	public static boolean win(String[][] arr, String s) { 
		return kesebHorizontally(arr, s) || kesebVertically(arr, s) || kesebDiagonally(arr, s);
	}

	// low keseb horizontally returns true 
	public static boolean kesebHorizontally(String[][] arr, String s) {
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == s)
					count++;
			}
			if (count == 3)
				return true;
		}
		return false;
	}

	//low kesebVertically returns true
	public static boolean kesebVertically(String[][] arr, String s) {
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[j][i] == s)
					count++;
			}
			if (count == 3)
				return true;
		}
		return false;
	}
        
        //low keseb diagonaly returns true
	public static boolean kesebDiagonally(String[][] arr, String s) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) { // low kamel 3 mn el shemal le el yemen
			if (arr[i][i] == s)
				count++;
			if (count == 3)
				return true;
		}

		count = 0;
		for (int i = 0, j = arr[i].length - 1; j >= 0 ; j--, i++) { // low kamel 3 mn el yemen le el shemal
			if (arr[i][j] == s)
				count++;
			if (count == 3)
				return true;
		}
		return false;
	}

        //function low kolo etmala and no one keseb then it's a tie
	public static boolean tie(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == "   ")
					return false;
			}
		}
		return true;
	}

	/** swap swaps the elements in an array */
	public static void swap(String[] t) {
		String temp = t[0];
		t[0] = t[1];
		t[1] = temp;
	}
        
        // define each player symbol(0 for player "X" && 1 for player "O")
	public static void placeSymbol(String[][] arr, int[] e, String s) {
		arr[e[0]][e[1]] = s;
	}

	/** getCell returns a valid cell input by user */
	public static int[] getCell(String[][] arr, String s) { 
		Scanner input = new Scanner(System.in);
		int[] cell = new int[2]; // Cell row and column

		//bn-ask player too enter a symbol
		do {
			System.out.print("player " + s + " choose your row(0,1,2): ");
			cell[0] = input.nextInt();
			System.out.print("player " + s + " choose your coloumn(0,1,2): ");
			cell[1] = input.nextInt();

		} while (!validOrNot(arr, cell));
		return cell;
	}
        
        //function bn-check low e5tar mn (0,1,2) && low el cell fadya walla laa
	public static boolean validOrNot(String[][] arr, int[] cell) {
		for (int i = 0; i < cell.length; i++) {
			if (cell[i] < 0 || cell[i] >= 3) {
				System.out.println("Invalid cell");
				return false;
			}
		}
		if (arr[cell[0]][cell[1]] != "   ") {
			System.out.println(
				"\nRow " + cell[0] + " column " + cell[1] + " is taken");
			return false;
		}
		return true;		
	}

        //function bn3mel feha array 3*3 fadya
	public static String[][] getBoard() {
		String[][] arr = new String[3][3]; 
		for (int i = 0; i < 3; i++) {  // for row 
			for (int j = 0; j < 3; j++) {  //for coloums
				arr[i][j] = "   "; //empty spaces
			}
		}
		return arr; //return an empty board
	}

        //bn3ml shakl el borders bta3t el board
	public static void shaklElBoard(String[][] arr) {
		System.out.println("\n-------------");
		for (int i = 0; i < arr.length; i++) {               //rows
			for (int j = 0; j < arr[i].length; j++) {   //coloums
				System.out.print("|" + arr[i][j]);
			}
			System.out.println("|\n-------------");
		}
	}
}
    
