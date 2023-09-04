package Library;

import java.util.Scanner;

/**
 * This class represents a book of library. You can create an object from this class and use setters and getters to set the properties of the object. Two objects are considered equal if they have identical book's codes.
 * @author Sogand Rostaee
 * @see Library Library.Exquisite
 * <br>Library.Children
 */
public class Book {		//class book ra braye ketab haye ketabkhane tashkil midahim

	private static int counter = 0;	//moteghayery ke code ketab ra mishemarad
	private String name;
	private String author;
	private String translator;
	private String publisher;
	private int year;
	private String code;
	private boolean availability = true;
	private String genre;
	private Member [] member = new Member [1000000];

	/**
	 * Setters
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setMember(Member[] member) {
		this.member = member;
	}
	public static void setCounter() {
		counter++;
	}
	/**
	 * Getters
	 */
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public String getTranslator() {
		return translator;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getYear() {
		return year;
	}
	public String getCode() {
		return code;
	}
	public boolean isAvailability() {
		return availability;
	}
	public String getGenre() {
		return genre;
	}
	public Member[] getMember() {
		return member;
	}
	public static int getCounter() {
		return counter;
	}
	/**
	 * The only constructor of the class
	 * @param name of book
	 * @param author of book
	 * @param translator of book
	 * @param publisher of book
	 * @param year of book
	 * @param genre of book
	 */
	public Book(String name, String author, String translator, String publisher, int year, String genre) {
		this.setName(name);
		this.setAuthor(author);
		this.setTranslator(translator);
		this.setPublisher(publisher);
		this.setYear(year);
		this.setGenre(genre);
	}

	/**
	 * This method searches the array of books to find a book with the same code as the input code.
	 * @param B is an array of books that they are saved in itþ.
	 * @param input is an object of the Scanner class to get input.
	 * @return The index of book with this code in the array of books
	 */
	public static int Search(Book [] B, Scanner input) {
		System.out.println("Please enter the code of book:");
		String code = input.next();	//gereftan code az karbar
		int x = -1;
		int j = BLength(B);	//akharin index por shode
		if(j == -1) {
			j = B.length;
		}
		for(int i = 0; i < j; i++) {	//peymayesh array ta jaei ke por shode ast
			//agar code dade shode ba code yeki az ketabha yeki bashd x az -1 be index on karbar dar array taghir mikonad
			if(code.equalsIgnoreCase( B[i].getCode()) ) {
				//az metode equals dar halati ke kochak ya bozorg bodan ra dar nazar nemigirad estefade mishavad
				x = i;
			}
		}
		return x;
	}

	/**
	 * This method shows book's information
	 */
	public void Showinfo() {
		System.out.println("Name of Book: " + this.getName());
		System.out.println("Author of Book: " + this.getAuthor());
		System.out.println("Translator of Book: " + this.getTranslator());
		System.out.println("Publisher of Book: " + this.getPublisher());
		System.out.println("Year Of Publication: " + this.getYear());
		System.out.println("genre of Book: " + this.getGenre());
	}
	/**
	 * This method edits book's information.
	 * @param B is an array of books that they are saved in itþ.
	 * @param i is the index of the book.
	 * @param input is an object of the Scanner class to get input.
	 */
	public void Edit(Book [] B, int i, Scanner input) {
		input.nextLine();
		System.out.println("You can edit name of book:");
		String n = input.nextLine();	//gerftan esm ketab
		if(!n.isEmpty()) {	//agar karbar esm ketab ra taghir bedahad esm vared shode zakhire mishavad
			B[i].setName(n);	//set kardan esm
		}

		System.out.println("You can edit name of author:");		
		String a = input.nextLine();	//gereftan esm nevisandeh az karbar
		String a1;
		if(!a.isEmpty()) {	//agar karbar esm nevisandeh ra taghir bedahad esm vared shode zakhire mishavad
			a1 = a;
			B[i].setAuthor(a);	//set kardan esm nevisandeh
		}
		else {
			a1 = B[i].author;
		}

		System.out.println("You can edit name of translator:");
		String t = input.nextLine();	//gereftan esm motarjem az karbar
		if(!t.isEmpty()) {	//agar karbar esm motarjem ra taghir bedahad esm vared shode zakhire mishavad
			B[i].setTranslator(t);	//set kardan esm motarjem
		}

		System.out.println("You can edit name of publisher:");
		String p = input.nextLine();	//gereftan esm nasher az karbar
		if(!p.isEmpty()) {	//agar karbar esm nasher ra taghir bedahad esm vared shode zakhire mishavad
			B[i].setPublisher(p);	//set kardan esm nasher
		}

		System.out.println("You can edit year of publication: ");
		String y;
		int y1 ;
		//Number Format Exception
		while(true) {
			try {
				y = input.nextLine();	//gereftan sal chap az karbar
				if(!y.isEmpty()) {	//agar karbar sal chap ra taghir bedahad sal vared shode zakhire mishavad
					int ye = Integer.valueOf(y);
					y1 = ye;
					B[i].setYear(ye);	//set kardan sal chap
				}
				else {
					y1 = B[i].year;
				}
				break;
			}catch(NumberFormatException e){
				System.out.println("INVALID!!!"
						+ "\nEnter a number as year of publication: ");
			}
		}
		
		System.out.println("You can edit genre of book: ");
		String g = input.nextLine();	//gereftan genre
		if(g.isEmpty() == false) {	//agar karbar genre ra taghir bedahad genre vared shode zakhire mishavad
			B[i].setGenre(g);	//set kardan genre
			String z= B[i].code.substring(0,4);	//joda kardan adad aval code
			Integer counter = Integer.valueOf(z) - 1000 ;	//joda kardan counter code 
			B[i].setCode(Generate_Code(a1,y1,counter));	//sakht va set kardan code

			// agar bekhahim genre yek ketabe nafis ra taghir dahim
			if(B[i].getGenre().equalsIgnoreCase("Exquisite") && !g.equalsIgnoreCase("Exquisite")) {
				// agar genre vared shode Children bashad
				if(g.equalsIgnoreCase("Children")) {
					System.out.println("Please enter age categories of children book:");
					char AC = input.next().charAt(0);	//gereftan rade seny
					while(AC!='A' && AC!='B' && AC!='C' && AC!='D' && AC!='E' && AC!='a' && AC!='b' && AC!='c' && AC!='d' && AC!='e') {
						System.out.println("INVALID!!!"
								+ "\nEnter A or B or C or D or E: ");
						AC = input.next().charAt(0);
					}
					// sakht yek ketab jadid az jense Children va garar dadan an dar array
					Children C = new Children(B[i].getName(), B[i].getAuthor(), B[i].getTranslator(), B[i].getPublisher(), B[i].getYear(), AC);
					C.setCode(B[i].getCode());	//set kardan code ketab
					B[i] = C;
				}
				// agar genre vared shode mamoly bashad
				else {
					// sakht yek ketab jadid az jense Book va garar dadan an dar array
					Book K = new Book(B[i].getName(), B[i].getAuthor(), B[i].getTranslator(), B[i].getPublisher(), B[i].getYear(), B[i].getGenre());
					K.setCode(B[i].getCode());	//set kardan code ketab
					B[i] = K;
				}
			}

			// agar bekhahim genre yek ketabe kodak va nojavan ra taghir dahim
			else if(B[i].getGenre().equalsIgnoreCase("Children") && !g.equalsIgnoreCase("Children")) {	
				// agar genre vared shode Exquisite bashad
				if(g.equalsIgnoreCase("Exquisite")) {
					System.out.println("Please enter type of exquisite book: ");
					String ty = input.nextLine();	// gereftan type
					while(ty.equalsIgnoreCase("Leathery") == false && ty.equalsIgnoreCase("Aromatic") == false && ty.equalsIgnoreCase("Manuscript") == false) {
						System.out.println("INVALID!!!"
								+ "\nEnter Aromatic or Manuscript or Leathery:");
						ty = input.nextLine();
					}
					// sakht yek ketab jadid az jense Exquisite va garar dadan an dar array
					Exquisite E = new Exquisite(B[i].getName(), B[i].getAuthor(), B[i].getTranslator(), B[i].getPublisher(), B[i].getYear(), ty);
					E.setCode(B[i].getCode());	//set kardan code ketab
					B[i] = E;
				}
				// agar genre vared shode mamoly bashad
				else {
					// sakht yek ketab jadid az jense Book va garar dadan an dar array
					Book K = new Book(B[i].getName(), B[i].getAuthor(), B[i].getTranslator(), B[i].getPublisher(), B[i].getYear(), B[i].getGenre());
					K.setCode(B[i].getCode());	//set kardan code ketab
					B[i] = K;
				}
			}

			// agar bekhahim genre yek ketabe mamoly ra be nafis taghir dahim
			else if(g.equalsIgnoreCase("Exquisite")) {
				System.out.println("Please enter type of exquisite book: ");
				String ty = input.nextLine();	// gereftan type
				while(ty.equalsIgnoreCase("Leathery") == false && ty.equalsIgnoreCase("Aromatic") == false && ty.equalsIgnoreCase("Manuscript") == false) {
					System.out.println("INVALID!!!"
							+ "\nEnter Aromatic or Manuscript or Leathery:");
					ty = input.nextLine();
				}
				// sakht yek ketab jadid az jense Exquisite va garar dadan an dar array
				Exquisite E = new Exquisite(B[i].getName(), B[i].getAuthor(), B[i].getTranslator(), B[i].getPublisher(), B[i].getYear(), ty);
				E.setCode(B[i].getCode());	//set kardan code ketab
				B[i] = E;
			}

			// agar bekhahim genre yek ketabe mamoly ra be kodak va nojavan taghir dahim
			else if(g.equalsIgnoreCase("Children")) {
				System.out.println("Please enter age categories of children book:");
				char AC = input.next().charAt(0);
				while(AC!='A' && AC!='B' && AC!='C' && AC!='D' && AC!='E' && AC!='a' && AC!='b' && AC!='c' && AC!='d' && AC!='e') {
					System.out.println("INVALID!!!"
							+ "\nEnter A or B or C or D or E: ");
					AC = input.next().charAt(0);
				}
				// sakht yek ketab jadid az jense Children va garar dadan an dar array
				Children C = new Children(B[i].getName(), B[i].getAuthor(), B[i].getTranslator(), B[i].getPublisher(), B[i].getYear(), AC);
				C.setCode(B[i].getCode());	//set kardan code ketab
				B[i] = C;
			}
		}
		System.out.println("Changes saved successfully and the new  code of book is: "+ B[i].getCode());
	}
	/**
	 * This method prints a list of member's name who has borrowed this book before and the member who has borrowed that now. 
	 */
	public void Print_Members() {
		int j = Member.Length(this.member);
		if(j == 0) {
			System.out.println("No one has borrowed this book yet");
		}
		else {
			int i = 0;
			while( i < j ) {
				System.out.println(i+1+". ");
				System.out.println(this.member[i].getName());
				i++;
			}
			if(this.isAvailability()) {
				System.out.println("Currently, no one has borrowed this book");
			}
			else {
				System.out.println("Currently, " + this.member[i].getName() + " has borrowed this book" );
			}
		}
	}
	/**
	 * This method deletes a book from array of books.
	 * @param i is the index of the book to be deleted.
	 * @param B is an array of books that they are saved in itþ.
	 */
	public void DeleteB( int i ,Book [] B) {
		int j = BLength(B);	//akharin index por shode
		if(j == -1) {
			j = B.length -1;
		}
		B [i] = null;	//ketabe mored nazar ba khaly kardan va mosavy null gharar dadan on index array hazf mishavad
		if( i != j) {	//agar ketab hazf shode akharin ketab nabashad bayad hame araye haye baad az on yek khone dar array aghab berevand
			for( ;i <= j ;i++) {	//baraye aghab keshidan arayeha
				B[i] = B[ i+1 ];
			}
		}
		System.out.println("User deleted successfully!!");
	}
	/**
	 * This method searches the array of books to find books that have these letters in their name.
	 * @param B is an array of books that they are saved in itþ.
	 * @param input is an object of the Scanner class to get input.
	 */
	public static void Search_Code(Book [] B, Scanner input) {
		System.out.println("Please enter a part of name of book:");
		String n = input.next();	//gereftane esme ketab ya bakhshi az on
		int sum = 0;
		for(int i = 0; i < BLength(B); i++) {	//yaftan tedad ketab haye ham nam
			if(B[i].name.contains(n)) {
				sum++;
			}
		}
		if(sum != 0) {
			Book [] S = new Book[sum];	//sakhtan yek array az ketab haye ham nam
			int j = 0;	
			for(int i = 0; i < BLength(B); i++) {	//rikhtane ketab haye ham nam dar array
				if(B[i].name.contains(n)) {
					S[j] = B[i];
					j++;
				}
			}
			for(j = 0; j < sum ; j++) {	//chap eteleaate ketab haye ham nam
				int d = j+1;
				System.out.println("("+ d +")");
				S[j].Showinfo();
			}
			System.out.println("please choose one of them: ");
			int a = input.nextInt();	//karbar yeki az ketab ha ra entekhab mikonad
			System.out.println("that book code is: " + S[a-1].code);	//namayesh code ketabe entekhab shode
		}
		else {
			System.out.println("No book with this name was found !!");
		}
	}
	/**
	 * This method generates a code for the book by author's name and year of publication and counter number.
	 * @param a is author's name.
	 * @param y is the year of publication.
	 * @param counter
	 * @return Generated code
	 */
	public String Generate_Code (String a, int y, int counter) {	//metode sakhte code ketab
		int index=0;
		for(int i = 0; i < a.length(); i++) {
			if( Character.isWhitespace(a.charAt(i))  ) {	//esme nevisande ta jayee ke be spase beresad
				index=i;
			}
		}
		int j = y % 100;	//2 ragham akhare sale chap
		int k = 1000 + counter;	//adade avale code
		if(j%10==j) {	//baraye zamany ke dahgan nadarem
			String code = k + "/" + a.toUpperCase().charAt(0) + a.toUpperCase().charAt(index+1) + "/" + "0" + j;
			return code;
		}
		else {
			String code = k + "/" + a.toUpperCase().charAt(0) + a.toUpperCase().charAt(index+1) + "/" + j;
			return code;
		}
	}

	/**
	 * This method finds the first null index of an array of books.
	 * @param B is an array of books that they are saved in itþ.
	 * @return The first null index of an array of books
	 */
	public static int BLength (Book [] B) {
		int a = 0;
		while(B[a]!= null) {	//peymayesh roye array ta residan be khane haye khaly on
			a++;
			if(a == B.length) {	//agar array por bashad -1 bar migardanad
				a =-1;
				break;
			}
		}
		return a;
	}
}
