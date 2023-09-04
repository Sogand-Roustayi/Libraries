package Library;

import java.util.Scanner;
/** 
 * This class represents a member of library. You can create an object from this class and use setters and getters to set the properties of the object. Two objects are considered equal if they have identical IDs.
 * @author Sogand Rostaee
 *
 */
public class Member {

	private static int counter = 1 ;	//moteghayery ke id ra mishemarad
	private String name;
	private short age;
	private String phoneno;
	private char gender;
	private long ID;
	private Book [] book = new Book[5] ;
	private String type;
	private String password;

	/**
	 * Setters
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(short age) {
		this.age = age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public void setID() {
		ID = 1000000 + counter;
	}
	public static void setCounter() {
		counter++;
	}
	public void setBook(Book[] book) {
		this.book = book;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Getters
	 */
	public String getName() {
		return name;
	}
	public short getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public long getID() {
		return ID;
	}
	public static int getCounter() {
		return counter;
	}
	public Book[] getBook() {
		return book;
	}
	public String getType() {
		return type;
	}
	public String getPassword() {
		return password;
	}
	/**
	 * The only constructor of the class.
	 * @param name of member
	 * @param age of member
	 * @param gender of member(f or m or F or M)
	 * @param phone_number of member
	 */
	public Member (String name, short age, char gender, String phoneno, String type, String password) {
		this.setName(name);
		this.setAge(age);
		this.setGender(gender);
		this.setPhoneno(phoneno);
		this.setType(type);
		this.setPassword(password);
		
	}
	/**
	 * This method searches the array of members to find a member with the same ID as the input ID.
	 * @param M is an array of members that they are saved in itþ.
	 * @param ID is a unique number for each member.
	 * @return The index of member with this ID in the array of members
	 */
	public static int Search(Member[] M , long ID) {
		int x = -1;
		int j = Length(M);	//akharin index por shode
		if(j == -1) {
			j = M.length;
		}
		for(int i = 0; i < j; i++) {	//peymayesh array ta jaei ke por shode ast
			if(ID == M[i].getID()) {	//agar id dade shode ba id yeki az karbaran yeki bashd x az -1 be index on karbar dar array taghir mikonad
				x = i;
			}
		}
		return x;
	}
	/**
	 * This method shows member's information.
	 */
	public void Showinfo() {
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Phonenumber: " + this.getPhoneno());
		System.out.println("Rigester ID: "+ this.getID());

	}
	/**
	 * This method edits member's information.
	 * @param input is an object of the Scanner class to get input.
	 */
	public void Edit(Scanner input) {
		input.nextLine();
		System.out.println("You can edit your name:");
		String name = input.nextLine();	//gerftan esm
		if(!name.isEmpty()) {	//agar karbar esm ra taghir bedahad esm vared shode zakhire mishavad
			this.setName(name);	//set kardan esm
		}
		
		System.out.println("You can edit your age:");		
		String a ;	//sen ra ba string migirim ta betavanim az metod isEmpty estefade konim 
		//Number Format Exception
		while(true) {
			try {
				a = input.nextLine();
				if(!a.isEmpty()) {	//agar karbar sen ra taghir bedahad sen vared shode be shekle short zakhire mishavad
					short A = Short.parseShort(a);	//baraye tabdil String be short
					this.setAge(A);	//set kardan esm
				}
				break;
			}catch(NumberFormatException e){
				System.out.println("INVALID!!!"
						+ "\nEnter a number as your age:");
			}
		}

		System.out.println("You can edit your gender:");
		String ge = input.nextLine();
		if(!ge.isEmpty()) {	//agar karbar jensiat ra taghir bedahad jensiat vared shode zakhire mishavad
			char ch[] = ge.toCharArray();	//baraye tabdil string be char
			char g = ch[0];	//baraye tabdil string be char
			while (g!='m' && g!='M' && g!='f' && g!='F') {	//chare jensiyat faghat maghadir f va m ra mipazirad va maghadir digar ra ghabol nemikonad 
				System.out.println("INVALID!!!"
						+ "\nEnter F or M: ");
				g = input.next().charAt(0);	
				input.nextLine();
			}
			this.setGender(g);	//set kardan jensiat
		}
		System.out.println("You can edit your phonenumber:");
		String nu = input.nextLine();	//gerftan shomare telephone
		if(!nu.isEmpty()) {	//agar karbar shomare telephone ra taghir bedahad shomare vared shode zakhire mishavad
			this.setPhoneno(nu);	//set kardan shomare telephone
		}
		System.out.println("You can edit your password:");
		String p = input.nextLine();	
		if(!p.isEmpty()) {	
			this.setPassword(p);
		}
		System.out.println("Changes saved successfully!!");
	}
	/**
	 * This method deletes a member from array of members.
	 * @param i is the index of the member to be deleted. 
	 * @param M is an array of members that they are saved in itþ.
	 */
	public void Delete(int i, Member[] M ) {
		int j = Length(M);	//akharin index por shode
		if(j == -1) {
			j = M.length-1;
		}
		M [i] = null;	//member mored nazar ba khaly kardan va mosavy null gharar dadan on index array hazf mishavad//member yaft shode va  ba estefade az metode delete hazf mishavad
		if( i != j) {	//agar member hazf shode akharin member nabashad bayad hame araye haye baad az on yek khone dar array aghab berevand
			for( ;i <= j ;i++) {	//baraye aghab keshidan arayeha
				M[i] = M[ i+1 ];
			}
		}
		System.out.println("User deleted successfully!!");
	}
	/**
	 * This method adds the book that the member borrows to the array of borrowed books of this member.
	 * @param b is the book that the member is going to borrow.
	 * @return true if the method can do its job and the array of borrowed books isn't full or returns false if not
	 */
	public boolean Add_Book(Book b){	//ezafe kardan ketab amanat gerefte shode be arraye ketab haye amanat gerefte shode
		if( this.book[4]!=null) {	//agar akharin index khali nabashad yany kole array por ast
			System.out.println("You have borrowed five books.You can not borrow a new book !!");
			return false;
		}
		else {
			this.book[ Book.BLength(this.book)] = b ;	//agar array por nabashad akharin khane ra peyda kare va ketab ra dar an gharar midahad
			return true;
		}
	}
	/**
	 * This method removes the book that the member borrowed from the array of borrowed books of this member.
	 * @param b is the book that the member borrowed.
	 * @return true if the method can do its job and the book exists in the array of borrowed books or return false if not
	 */
	public boolean Remove_Book(Book b) {
		int i = -1;
		int j = Book.BLength(this.book);
		if(j == -1) {
			j = this.book.length -1;
		}
		for(int k = 0; k < j; j++) {
			if(b.getCode().equalsIgnoreCase( this.book[i].getCode()) ) {
				i = k;
			}
		}
		if(i == -1) {	//agar ketab dar array ketab haye amanat gerefte shode nabashad
			System.out.println("You have not borrowed such a book !!!");
			return false;
		}
		else {
			this.book[i].DeleteB(i, this.book);
			return true;
		}
	}
	/**
	 * This method finds the first null index of an array of members.
	 * @param M is an array of members that they are saved in itþ.þ
	 * @return The first null index of an array of members
	 */
	public static int Length(Member [] M) {	//baraye fahmidan inke array ma ta kodam khane(index) por shode va az koja be baad null ast va bayad por shavad
		int a = 0;
		while(M[a]!= null) {	//peymayesh roye array ta residan be khane haye khaly on
			a++;
			if(a == M.length) {	//agar array por bashad -1 bar migardanad
				a =-1;
				break;
			}
		}
		return a;
	}
	/**
	 * This method specifies the age category of member.
	 * @return A character (a letter) that shows age categories of member
	 */
	public char AgeCategories() {
		char AC = 0;
		int age = this.getAge();
		if(age < 6) {
			AC = 'A';
		}
		if(age == 6 || age == 7) {
			AC = 'B';
		}
		if(age == 8 || age == 9) {
			AC = 'C';
		}
		if(age == 10 || age == 11) {
			AC = 'D';
		}
		if(12 <= age && age <= 15) {
			AC = 'E';
		}
		return AC;
	}
}
