package Library;

import java.util.Scanner;
/**
 * This class represents a exquisite book of library. This is a subclass of book class 
 * @author Sogand Rostaee
 * @see Library.Book
 */
public class Exquisite  extends Book {	//nafis

	private String type;	//noe ketabe nafis

	/**
	 * Setter
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Getter
	 */
	public String getType() {
		return type;
	}
	/**
	 * The only constructor of the class
	 * @param name
	 * @param author
	 * @param translator
	 * @param publisher
	 * @param year
	 * @param type
	 */
	public Exquisite(String name, String author, String translator, String publisher, int year, String type) {
		super(name, author, translator, publisher, year, "Exquisite");	//genre be sorate pish farz Exquisite ast
		this.setType(type);
	}
	
	@Override
	public void Showinfo() {	//metod namayesh etelaate ketab//override
		super.Showinfo();
		System.out.println("Type of Exquisite Book: " + this.getType());
	}
	
	@Override
	public void Edit(Book [] B, int i, Scanner input) {
		super.Edit(B, i, input);
		if(B[i].getGenre().equalsIgnoreCase("Exquisite")) { //agar karbar genre ra taghir nadahad va bekhahad type ketab ra taghir dahad
			System.out.println("You can edit type of Exquisite book: ");
			String ty = input.nextLine();
			while(ty.equalsIgnoreCase("Leathery") == false && ty.equalsIgnoreCase("Aromatic") == false && ty.equalsIgnoreCase("Manuscript") == false) {
				System.out.println("INVALID!!!"
						+ "\nEnter Aromatic or Manuscript or Leathery:");
				ty = input.nextLine();
			}
			if(ty.isEmpty() == false) {
				((Exquisite) B[i]).setType(ty);
			}
		}
	}
}
