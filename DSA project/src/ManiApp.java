import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ManiApp {
	

	public static void main(String[] args) {
		String title;
		String autFname;
		String autLname;
		
		
		controller cnt=new controller();
		ManiApp main=new ManiApp();
		cnt.inputBook("Effective Java Programming Language Guide ", "Joshua ", "Bloch", 120);	//Initializing some books before present
		cnt.inputBook("PHP and MySQL Web Development", "Luke", "Welling", 123);	
		cnt.inputBook("Not Just Java", "Peter", "van", 1528);
		cnt.inputBook("PHP 4 BibleTim", "Tim", "Converse", 1320);
		cnt.inputBook("Head First Java", "Kathy", "Sierra", 1523);	
		cnt.inputBook("Programming PHP", "Kevin", "Tatroey", 1255);
		cnt.inputBook("Head First PHP & MySQL", "Lynn", " Beighley", 1206);
		cnt.inputBook("Java Concurrency in Practice", "Brian", "Goetz", 1205);
		cnt.inputBook("OCA Java SE 7 Programmer", " Mala", "Gupta", 1295);//9
		cnt.inputBook("Java in a Box", "Bruce", "Eckel", 1863);
		cnt.inputBook("Java for Dummies ", "Barry", "Burd ", 1741);
		
	do{																// iterate operations until exit
		System.out.println("\t\t ~! Bookshop database !~");		
		System.out.println("\t -<|| Mani Operations ||>-");		
		System.out.println("   1-Insert record");
		System.out.println("   2-Print all records");
		System.out.println("   3-Search record by name");
		System.out.println("   4-Search record by ISBN");
		System.out.println("   5-Search record by Related names");
		System.out.println("   6-Delete record by name");
		System.out.println("   7-Delete record by ISBN");
		System.out.println("   8-About Developers");
		System.out.println("   9-Exit");
		int op=0;
		try {
			op = Integer.parseInt(main.getInput("Please Enter operation"));		//take the input and convert int to integer
		} catch (NumberFormatException e) {
			System.out.println("=!! Wrong input please re enter !!=");
		}
		switch (op) {															
		case 1:			
			System.out.println("  Insert record");
			title=main.getInput("Enter the book title");
			if(cnt.checkBookCntnt(title, "java")||cnt.checkBookCntnt(title, "php")){	// check book is java or php		
					autFname=main.getInput("Enter author name");
					autLname=main.getInput("Enter authorsurname");
					String temp=main.getInput("Enter the isbn");
					int tmpIsbn=-5;
					try {
						tmpIsbn = Integer.parseInt(temp);		//take as strig and convert it to integer
					} catch (NumberFormatException e) {
						System.out.println("Wrong input ISBN must integer");
					}
					if(tmpIsbn>=0){
						boolean ins=cnt.inputBook(title, autFname, autLname, tmpIsbn);	//add to tree
						if(ins){
							System.out.println("Book inserted");
							main.getInput("\nplease enter any key to continue");			
						}
					}else{
						System.out.println("Isbn number is negative can't accept");
						main.getInput("\nplease enter any key to continue");
					}
			}else{
				System.out.println("Book isn't related to php or java cant insert record");		// hold until user input to go to main menu
				main.getInput("\nplease enter any key to continue");
			}	
			break;
		case 2:
			cnt.printAll();
			main.getInput("\nplease enter any key to continue");
			break;
		case 3:
			cnt.searchName(main.getInput("Please enter the books name to search"));
			main.getInput("\nplease enter any key to continue");
			break;
		case 4:
			int tmpIsbn=-5;
			String temp=main.getInput("Enter the isbn");
				try {
					tmpIsbn = Integer.parseInt(temp);
					} catch (NumberFormatException e) {
						System.out.println("Wrong input ISBN must integer");
					}
				if(tmpIsbn>=0){
					cnt.searchISBN(tmpIsbn);
				}else{
					System.out.println("Isbn number is negative can't accept");
					main.getInput("\nplease enter any key to continue");
				}
			
			main.getInput("\nplease enter any key to continue");
			break;
		case 5:
			cnt.printRelTag(main.getInput("Enter the name or names' part to search related books"));
			
			main.getInput("\nplease enter any key to continue");
			break;
		case 6:
			if(cnt.isEmpty()){													//before delete check if the tree is empty
			cnt.delByName(main.getInput("enter the book name to delete"));
			}
			else
				System.out.println("Theres no book to delete plese insert some books");
			main.getInput("\nplease enter any key to continue");
			break;
		case 7:
			if(cnt.isEmpty()){													//before delete check if the tree is empty
				tmpIsbn=-5;
				temp=main.getInput("Enter the isbn");
					try {
						tmpIsbn = Integer.parseInt(temp);
						} catch (NumberFormatException e) {
							System.out.println("Wrong input ISBN must integer");
						}
					if(tmpIsbn>=0){
						cnt.delByIsbn(tmpIsbn);
					}else{
						System.out.println("Isbn number is negative can't accept");
						main.getInput("\nplease enter any key to continue");
					}
			}else
				System.out.println("Theres no book to delete plese insert some books");
			
			main.getInput("\nplease enter any key to continue");
			break;
		case 8:
			System.out.println("\t\t=@ About the developers @=");
			System.out.println("W A D Inesh Dhanushka Gunasekara  ");
			System.out.println("NSBM No :BSC-UCD-CSS-B03-161");
			System.out.println("Index No :13208383");
			System.out.println("Github name:ineshkcwa");
			System.out.println("------------------------------------");
			System.out.println("A I Madhushan Silva  ");
			System.out.println("NSBM No :BSC-UCD-CSS-B03-008");
			System.out.println("Index No :13208384");
			System.out.println("Github name:madushankcwa");
			System.out.println("------------------------------------");
			System.out.println("K C Samarasinghe");
			System.out.println("NSBM No :BSC-UCD-CSS-B03-073");
			System.out.println("Index No :13208358");
			System.out.println("Github name:chanukakcwa");
			System.out.println("------------------------------------");
			System.out.println("I R C N BANDARA ILANGASINGHE");
			System.out.println("NSBM No :BSC-UCD-CSS-B03-061");
			System.out.println("Index No :13208383");
			System.out.println("Github name:chanakakcwa");
			main.getInput("\nplease enter any key to continue");
			break;
		case 9:
			String ex=main.getInput("To confirm enter Y or Yes To cancel enter N or No");
			ex=ex.toLowerCase();
			int cntr=ex.indexOf("y");
			if(cntr>=0){
				System.exit(0);
			}			
			break;
		default:
			System.out.println("  ");
			break;
		}
	}while(true);
		
	}
	public String getInput(String prompt){
			BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));	//create input stream
			System.out.println(prompt);
			System.out.flush();
			try {
				return stdin.readLine();				//take user input from console
			} catch (IOException e) {
				return "error";
			}
		
	}
}
