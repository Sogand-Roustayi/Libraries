package Library;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class does not represent any object. This is a test for the library.
 * @author Sogand Rostaee
 * @see Library Library.Member
 * <br>Library.Book
 * <br>Library.Exquisite
 * <br>Library.Children
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	//gereftan vorody
		boolean again = true;	//meghdar boolean baraye tekar halghe ta ghabl az exit
		Member[] M = new Member [1000000];	//array e ke member ha ra zakhire mikone
		Book [] B = new Book [1000] ;
		//admin(bararye nemone)
		M[0] = new Member("Sarah_Rajaby", (short) 18,'f', "22546531", "admin", "Sara2003");
		M[0].setID();
		Member.setCounter();
		M[1] = new Member("Zahra_Molaee", (short) 26,'f', "88246532", "admin", "z2626");
		M[1].setID();
		Member.setCounter();
		M[2] = new Member("Mohammad_Sadeghi", (short) 24, 'm', "22577531", "admin", "747424");
		M[2].setID();
		Member.setCounter();
		int i = Login(input, M);
		while( again ) {	//halghe while ta vaghty ke karbar Exit ra entekhab nakarde meno chap mikonad va az karbar dastor migirad
			System.out.println("****************************************************");
			System.out.println( "What do you want to do?"
					+ "\n 0) Exit"
					+ "\n 1) Register a new user"
					+ "\n 2) Show user's information"
					+ "\n 3) Edit user's profile"
					+ "\n 4) Delete a user"
					+ "\n 5) Add a new book to the library"
					+ "\n 6) Show book's information"
					+ "\n 7) Edit book's information"
					+ "\n 8) Delete a book"
					+ "\n 9) Search for book's code"
					+ "\n10) Borrow a nwe book"
					+ "\n11) Return the borrowed book"
					+ "\n12) Borrow a children's book"
					+ "\n13) Print a list of members who have already borrowed this book"
					+ "\n    Choose one of them:");
			//print menu
			int k = 0;
			//Input Mismatch Exception
			while(true) {
				try {
					k = input.nextInt();	//entekhab karbar az menu
					break;
				}catch(InputMismatchException e){
					System.out.println("INVALID!!!"
							+ "\nChoose one of the numbers in the menu:");
					input.nextLine();
				}
			}
			
			switch(k) {	
			case 0: //baraye khoroj
				System.out.println("Have a great day ^-^"
						+ "\n**************************************************************************** ");
				i = Login(input,M);
				break;
				
			case 1:	//sabtenam karbar jadid
				if(M[i].getType().equalsIgnoreCase("Admin")) {
					if (Member.Length(M) != -1) {	//baraye zamany ke array por shode bashad
						Create (M,input);	//in metod ba gereftan vijegy ha az karbar ozve jadid misazad va dar array jakhire mikonad
					}
					else {	
						System.out.println("Member's array is full");
					}
				}
				else {
					System.out.println("Only an admin can register new user!!!");
				}
				break;
				
			case 2:	//namayesh etelaate karbar ba gereftan id
				M[i].Showinfo();
				break;
				
			case 3:	//virayesh etelaat karbar ba gereftan id
					M[i].Edit(input);	//virayesh etelaat karbar
				break;
				
			case 4:	//baraye hazf karbar
					M[i].Delete(i, M);	//member ba estefade az metode delete hazf mishavad
				break;
			
			case 5:	//sabte ketabe jadid
				if(M[i].getType().equalsIgnoreCase("Admin")) {
					if (Book.BLength(B) != -1) {	//baraye zamany ke array por shode bashad
						CreateB(B,input);	//in metod ba gereftan vijegy haye ketab az karbar on ra dar array zakhire mikonad
					}
					else {	
						System.out.println("Book's array is full");
					}
				}
				else {
					System.out.println("You can not add a new book to the library!!!");
				}
				break;
				
			case 6:	//namayesh etelaate ketab ba gereftan code on
				int i1 = Book.Search(B,input);
				if(i1 == -1) {	//ketabi ba in code dar arrye vojod nadarad
					System.out.println("No book with this code was found !!");
				}
				else {	//chap etelaate ketab
					B[i1].Showinfo();
				}
				break;
				
			case 7:	//virayesh etelaat ketab ba gereftan code
				if(M[i].getType().equalsIgnoreCase("Admin")) {
					int i4 = Book.Search(B, input);
					if(i4 == -1) {	//ketabi ba in code dar arrye vojod nadarad
						System.out.println("No book with this code was found !!");
					}
					else {
						B[i4].Edit(B ,i4 , input);	//virayesh etelaat ketab
					}
				}
				else {
					System.out.println("You can not edit information of a book!!!");
				}
				break;
				
			case 8:	//baraye hazf ketab
				if(M[i].getType().equalsIgnoreCase("Admin")) {
					int i5 = Book.Search(B, input);
					if(i5 == -1) {
						System.out.println("No book with this code was found !!");
					}
					else {
						B[i5].DeleteB( i5, B );	//ketab yaft shode va ba estefade az metode delete hazf mishavad
					}
				}
				else {
					System.out.println("You can not edit information of a book!!!");
				}
				break;
				
			case 9:	//baraye yaftan code ketab ba estefade az nam on
				Book.Search_Code(B, input);
				break;
				
			case 10:	//baraye amanat gereftan ketab
				Borrow(input, B, M, i);
				break;
				
			case 11:	//baraye bargardandan ketab
				Return(input, B, M, i);
				break;
				
			case 12:	//baraye amanat gereftan ketab kodak va nojavan
				Children_Borrow(input, B, M, i);
				break;
				
			case 13:
				int i6 = Book.Search(B, input);
				B[i6].Print_Members();
				break;
				
			default :
				System.out.println("ERROR: Enter Correct Number!!!");
			}
		}
		input.close();
	}
	/**
	 * If there is a member with this id and password, this method lets member to enter.
	 * @param input is an object of the Scanner class to get input.
	 * @param M is an array of members that they are saved in itþ.
	 * @return the index of the entered member
	 */
	public static int Login(Scanner input, Member [] M) {
		int i = -1;
		while(true) {
			System.out.println("Please enter your rigester ID:");
			long ID = 0;
			//Input Mismatch Exception
			while(true) {
				try {
					ID = input.nextLong();	//gereftan id az karbar
					break;
				}catch(InputMismatchException e){
					System.out.println("INVALID!!!"
							+ "\nEnter a number as your ID:");
					input.nextLine();
				}
			}
			System.out.println("Please enter your password:");
			String password = input.next();
			i = Member.Search(M,ID);	
			if(i == -1 ) {
				System.out.println("No user with this ID was found!!!");
			}
			else if(!M[i].getPassword().equals(password)) {
				System.out.println("The password is not correct!!!");
			}
			else {
				System.out.println("Hello and welcome to the library ^-^");
				break;
			}
		}
		return i;
	}
	/**
	 * This method creates a new member by getting the properties from the user.
	 * @param M is an array of members which we want to save the members of library in itþ.
	 * @param input is an object of the Scanner class to get input.
	 */
	public static void Create (Member [] M ,Scanner input) {
		System.out.println("Please enter your name:");
		String n = input.next();	//gereftan esm az karbar
		System.out.println("Please enter your age:");
		short a = 0  ;
		//Input Mismatch Exception
		while(true) {
			try {
				input.nextLine();
				a = input.nextShort();	//gereftan sen az karbar
				break;
			}catch(InputMismatchException e){
				System.out.println("INVALID!!!"
						+ "\nEnter a number as your age:");
			}
		}
		System.out.println("Please enter your gender:");
		char g = input.next().charAt(0);	//gereftan jensiat az karbar
		while (g!='m' && g!='M' && g!='f' && g!='F') {	//chare jensiyat faghat maghadir f va m ra mipazirad va maghadir digar ra ghabol nemikonad 
			System.out.println("INVALID!!!"
					+ "\nEnter F or M: ");
			g = input.next().charAt(0);	
		}
		System.out.println("Please enter your phonenumber:");
		String p = input.next();	//gereftan shomare telephone az karbar
		System.out.println("What type of member are you? ");
		String t = input.next();
		while (!t.equalsIgnoreCase("Admin") && !t.equalsIgnoreCase("Normal")) {
			System.out.println("INVALID!!!"
					+ "\nEnter Admin or Normal: ");
			t = input.next();	
		}
		System.out.println("Please choose your password:");
		String pa = input.next();
		Member m = new Member(n, a, g, p, t, pa);	//sakhtan ozve jadid
		int i = Member.Length(M);	//akharin index por shode
		M[i] = m;	//zakhire member sakhte shode dar array
		m.setID();	//set kardan id
		Member.setCounter();	//meghdar id 1 vahed azafe mishavad
		System.out.println("Your rigester ID is:"+ m.getID());	//print id
	}
	
	/**
	 * This method creates a new book by getting the properties from the user.
	 * @param B is an array of books which we want to save books of library in itþ.
	 * @param input is an object of the Scanner class to get input.
	 */
	public static void CreateB (Book [] B ,Scanner input) {	//in metod ba gereftan vijegy ha az karbar ketab jadid misazad
		input.nextLine();
		System.out.println("Please enter name of book:");
		String n = input.nextLine();	//gereftan esm ketab az karbar
		System.out.println("Please enter name of author:");
		String a = input.nextLine();	//gereftan esm nevisandeh az karbar
		System.out.println("Please enter name of translator:");
		String t = input.nextLine();	//gereftan esm motarjem az karbar
		System.out.println("Please enter name of publisher:");
		String p = input.nextLine();	//gereftan esm nasher az karbar
		System.out.println("Please enter year of publication:");
		int y = 0;
		//Input Mismatch Exception
		while(true) {
			try {
				y = input.nextInt();	//gereftan sal chap az karbar
				break;
			}catch(InputMismatchException e){
				System.out.println("INVALID!!!"
						+ "\nEnter a number as year of publication: ");
				input.nextLine();
			}
		}
		
		System.out.println("Please enter genre of book:");
		input.nextLine();
		String g = input.nextLine();	//gereftane genre az karbar
		if(g.equalsIgnoreCase("Exquisite")) {	//agar genre Exquisite bod
			System.out.println("Please enter type of exquisite book:");
			String ty = input.nextLine();	//gereftane type az karbar
			while(!ty.equalsIgnoreCase("Leathery") && !ty.equalsIgnoreCase("Aromatic") && !ty.equalsIgnoreCase("Manuscript")) {
				System.out.println("INVALID!!!"
						+ "\nEnter Aromatic or Manuscript or Leathery:");
				ty = input.nextLine();
			}
			Exquisite b = new Exquisite(n, a, t, p, y,ty);
			int i = Book.BLength(B);	//avalin index khali az array ketab ha
			B[i] = b;	//zakhire Ketabe sakhte shode dar array
			Book.setCounter();	//meghdar adadye code 1 vahed azafe mishavad
			b.setCode(b.Generate_Code(a, y, Book.getCounter()));	//sakhtan va set kardan code
			b.setAvailability(true);
			System.out.println("The code of book is: "+ b.getCode());	//print code ketab
		}

		else if(g.equalsIgnoreCase("Children")) {
			System.out.println("please enter age categories of children book:");
			char AC = input.next().charAt(0);
			while(AC!='A' && AC!='B' && AC!='C' && AC!='D' && AC!='E' && AC!='a' && AC!='b' && AC!='c' && AC!='d' && AC!='e') {
				System.out.println("invalid !!! Enter A or B or C or D or E: ");
				AC = input.next().charAt(0);
			}
			Children b = new Children(n, a, t, p, y, AC);
			int i = Book.BLength(B);	//akharin index por shode
			B[i] = b;	//zakhire Ketabe sakhte shode dar array
			Book.setCounter();	//meghdar adadye code 1 vahed azafe mishavad
			b.setCode(b.Generate_Code(a, y, Book.getCounter()));	//sakhtan va set kardan code
			b.setAvailability(true);
			System.out.println("The Book Code is: "+ b.getCode());	//print code ketab
		}
		else {
			Book b = new Book ( n, a, t, p, y, g);	//sakhtan ozve jadid
			int i = Book.BLength(B);	//akharin index por shode
			B[i] = b;	//zakhire Ketabe sakhte shode dar array
			Book.setCounter();	//meghdar adadye code 1 vahed azafe mishavad
			b.setCode(b.Generate_Code(a, y, Book.getCounter()));	//sakhtan va set kardan code
			b.setAvailability(true);
			System.out.println("The Book Code is: "+ b.getCode());	//print code ketab
		}
	}
	/**
	 * This method lends a book. If the member wants to borrow a book the main method will use this method.
	 * @param input is an object of the Scanner class to get input.
	 * @param B is an array of books that they are saved in itþ.
	 * @param M is an array of members that they are saved in itþ.
	 * @param i is an index of array of members that the user save in. 
	 */
	public static void Borrow(Scanner input, Book[] B, Member[] M, int i ) {	//amanat gereftan ketab
		int x = Book.Search(B, input);	//search book
		if(x == -1) {	//ketaby ba in code nabode 
			System.out.println("No book with this code was found !!");
		}
		else if(B[x].getGenre().equalsIgnoreCase("Exquisite")) {
			System.out.println("You can not borrow this book because It is a exquisite book  !!!");
		}
		else if(B[x].getGenre().equalsIgnoreCase("Children")) {
			System.out.println("It is a children's book\nYou can not borrow this book here please choose 13 of the menu ");
		}
		else {
			if(B[x].isAvailability()) {	//agar ketabe mored nazar mojod bashad
				if(M[i].Add_Book(B[x])) {	//agar ba movafaghiyat ezafe shavad be arraye amanat
					B[x].setAvailability(false);	//mojodiat ketab false mishavad
					int e = Member.Length(B[x].getMember());	//akharin khane array member e book
					B[x].getMember() [e] = M[i];	//rikhtan member dar array e book 
					System.out.println("You have successfully borrowed this book ");	
				}
			}
			else {
				System.out.println("This book has been borrowed !!");
			}
		}	
	}
	/**
	 * This method lends a children book. If the member wants to borrow a children book the main method will use this method.
	 * @param input is an object of the Scanner class to get input.
	 * @param B is an array of books that they are saved in itþ.
	 * @param M is an array of members that they are saved in itþ.
	 * @param x is an index of array of members that the user save in.
	 */
	public static void Children_Borrow( Scanner input, Book[] B, Member[] M, int x) {	//amanat gereftan ketab kodak va no javan
		int a = M[x].getAge();	//sen karbar
		if(a > 15) {	//bayad zire 15 bashad
			System.out.println("You can not borrow children's books !!!");
		}
		else {
			int sum = 0;
			char AC = M[x].AgeCategories();	//rade seny karbar
			for(int i = 0 ; i < Book.BLength(B);i++ ) {	//baraye peyda kardan ketab haye kodak va nojavan motabegh ba rade seny karbar
				if(B[i].getGenre().equalsIgnoreCase("Children") && AC == ((Children) B[i]).getAgeCategories()) {
					sum++; //tedad ketab ha
				}
			}
			if(sum == 0) { //ketaby ba in rade seny nabode
				System.out.println("Sorry!!!\nWe do not have book for your age ");
			}
			else {
				for(int i = 0; i < Book.BLength(B); i++ ) {
					if(B[i].getGenre().equalsIgnoreCase("Children") && AC == ((Children) B[i]).getAgeCategories()) {
						System.out.println('('+ i + ')');
						B[i].Showinfo(); //chap ketab ha
					}
				}
				System.out.println("Please chose one of them:");
				int v = input.nextInt();
				if(B[v].isAvailability()) {	//agar ketabe mored nazar mojod bashad
					if(M[x].Add_Book(B[v])) {	//agar ba movafaghiyat ezafe shavad be arraye amanat
						B[v].setAvailability(false);	//mojodiat ketab false mishavad
						int e = Member.Length(B[v].getMember());	//akharin khane array member e book
						B[v].getMember() [e] = M[x];	//rikhtan member dar array e book 
						System.out.println("You have successfully borrowed this book ");	
					}
				}
				else {
					System.out.println("This book has been borrowed !!");
				}
			}
		}
	}
	/**
	 * This method returns the borrowed book to the library.
	 * @param input is an object of the Scanner class to get input.
	 * @param B is an array of books that they are saved in itþ.
	 * @param M is an array of members that they are saved in itþ.
	 * @param i is an index of array of members that the user save in.
	 */
	public static void Return(Scanner input, Book[] B, Member[] M, int i ){	//bargardandan
		int x = Book.Search(B, input);	//search book
		if(x == -1) {	//ketaby ba in code nabode
			System.out.println("No book with this code was found !!");
		}
		else {
			if(M[i].Remove_Book(B[x])) {	//agar ba movafaghiyat hazf shavad az arraye amanat
				B[x].setAvailability(true);	//mojodiat ketab true mishavad
				System.out.println("You have successfully returned this book");
			}
		}
	}
	
}
