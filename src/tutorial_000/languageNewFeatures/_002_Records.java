package tutorial_000.languageNewFeatures;

public class _002_Records {

	public static void main(String[] args) {
		
		/*
		 * Preview feature since java 14, Records are released in Java 16. This feature is aimed to allow developers to easily create POJO 
		 * classes. In other words, defining a record is a concise way of defining an immutable data holding object.
		 * 
		 * For creating a record, we have to write :
		 */

		record SimpleRecord(){}
		record BookRecord (String name, String topic) {}
		
		/* 
		 * Take a look at the definition of "BookRecord". With a single line, we defined a POJO. Java compiler will :
		 * - generate a constructor (that take two parameters for "name" and "topic")
		 * - private fields for "name" and "topic" ("private final String name;" and "private final String topic;")
		 * - accessors for this two fields. Getters take the name of the field. For example : "topic()".
		 * - equals, hashCode and toString  methods
		 * 
		 */
		
		SimpleRecord simpleRecord = new SimpleRecord();
		System.out.println(simpleRecord.hashCode());
		System.out.println(simpleRecord.toString());
		
		System.out.println("----");
		
		BookRecord book = new BookRecord("Les Misérables", "Victor Hugo's novel");
		
		System.out.println(book.name());
		System.out.println(book.topic());
		System.out.println(book.hashCode());
		System.out.println(book.toString());
		System.out.println(book.equals(simpleRecord));
		
		System.out.println("---------------------------------------------");
		
		/* 
		 * Records also allows developpers to add customs fields, methods and constructor :
		 */ 
	 	
		record CustomizedBook (int id, String name, String topic) {
			private static String field = "World !";
		 
			public CustomizedBook(String name, String topic) {
				this(123, name, topic);
			}
			
			public static void callField() {
					System.out.println("Hello " + field);
			}
		}
		 	
		CustomizedBook specialBook = new CustomizedBook("Iliad", "Famous Greek epic poem");	
		
		System.out.println(specialBook.name());
		System.out.println(specialBook.topic());
		System.out.println(specialBook.id());
		
		CustomizedBook.callField();
		 	
		System.out.println("---------------------------------------------");
		
		/*
		 * The additional constructor defined inside the record is called a Compact constructor. It doesn’t consist of any parameters and is just 
		 * an extension of the canonical constructor. A compact constructor wouldn’t be generated as a separate constructor by the compiler. Instead, 
		 * it is used for validation cases and would be invoked at the start of the main constructor.
		 * 
		 * Important things to note about Records :
		 * - A record can neither extend a class nor it can be extended by another class. It’s a final class.
		 * - Records cannot be abstract
		 * - Records cannot extend any other class and cannot define instance fields inside the body. Instance fields must be defined in the 
		 * 		state description only
		 * - Declared fields are private and final
		 * - The body of a record allows static fields and methods (CustomizedBook)
		 * - Records can implement interfaces
		 * - Records support multiple constructors (example below in "CustomizedBook")
		 * - Records allow modifying accessor methods : Though records do generate public accessor methods for the fields defined in the state 
		 * 		description, they also allow the developer to redefine the accessor methods in the body :
		 */
		
		record AnotherRecord(String name, int id) {
			public String name() {
				System.out.println("Modified accessor will return the name :");
				return name;
			}
		}
		
		AnotherRecord anotherRecord = new AnotherRecord("Empty record.", 4);
		System.out.print(anotherRecord.name());
	}
}
