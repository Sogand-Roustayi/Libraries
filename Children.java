package Library;

import java.util.Scanner;
/**
 * This class represents a children book of library. This is a subclass of book class 
 * @author Sogand Rostaee
 * @see Library.Book
 */
public class Children extends Book {
	
	private char ageCategories;	//rade seny
	/**
	 * Setter
	 */
	public void setAgeCategories(char ageCategories) {
		this.ageCategories = ageCategories;
	}
	/**
	 * Getter
	 */
	public char getAgeCategories() {
		return ageCategories;
	}
	/**
	 * The only constructor of the class
	 * @param name of children book
	 * @param author of children book
	 * @param translator of children book
	 * @param publisher of children book
	 * @param year of children book
	 * @param ageCategories of children book
	 */
	public Children (String name, String author, String translator, String publisher, int year, char ageCategories) {
		super(name, author, translator, publisher, year, "Children");	//genre be sorate pish farz Children ast
		this.setAgeCategories(ageCategories);
	}
	
	@Override
	public void Showinfo() {	//metod namayesh etelaate ketab//override
		super.Showinfo();
		System.out.println("Age Categories Of Book: " + this.getAgeCategories());
	}
	
	@Override
	public void Edit(Book [] B, int i, Scanner input) { //methode virayesh etelaat ketab//override
		super.Edit(B, i, input);
		if(B[i].getGenre().equalsIgnoreCase("Children")) {	//agar karbar genre ra taghir nadahad va bekhahad rade seny ketab ra taghir dahad
			System.out.println("You can edit age categories of Children book: ");
			String A = input.nextLine();
			if(A.isEmpty() == false) {
				char C[] = A.toCharArray();	//baraye tabdil string be char
				char AC = C[0];
				while(AC!='A' && AC!='B' && AC!='C' && AC!='D' && AC!='E' && AC!='a' && AC!='b' && AC!='c' && AC!='d' && AC!='e') {
					System.out.println("INVALID!!!"
							+ "\nEnter A or B or C or D or E: ");
					AC = input.next().charAt(0);
				}
				((Children)B[i]).setAgeCategories(AC);
			}
		}
	}
}
