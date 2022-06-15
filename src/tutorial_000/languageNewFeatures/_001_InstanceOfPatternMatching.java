package tutorial_000.languageNewFeatures;

public class _001_InstanceOfPatternMatching {
	
	public static void main(String[] args) {
		/*
		 * Preview feature since java 14, pattern matching for instance of is released in Java 16.
		 * 
		 * Let assume we have an object, and want to do some actions only if this object is of a specific type.
		 * Previously to Java 14, we would have done something like this :
		 */
		
		String message = "A String.";
		Object object = message;
		if(object instanceof String){
			String value = (String)object;
			System.out.println(value.length());
		}
		
		System.out.println("---------------------------------------------");
		
		/*
		 * With Java 16, we may write the following :
		 */
		
		// "value" is assigned only if "object" is of String type.
		// The scope of the "value" variable is the "if" block.
		if(object instanceof String value){
			System.out.println(value.length());
		}
		
		System.out.println("---------------------------------------------");
		
		/*
		 * Another example with custom classes :
		 */
		
		Animal dog = new Dog();
		Animal cat = new Cat();
		
		useInstanceOfPatternMatching(dog);
		System.out.println("-----");
		useInstanceOfPatternMatching(cat);
	}
	
	/**
	 * Call specific method depending of the type of the animal. 
	 */
	private static void useInstanceOfPatternMatching(Animal animal) {
		if(animal instanceof Dog dog) {
			dog.dogPresentation();
		} else if(animal instanceof Cat cat) {
			cat.catPresentation();
		}
	}
	
}

interface Animal {
	void yell();
}

class Dog implements Animal {
	@Override
	public void yell() {
		System.out.println("Wuf wuf !");
	}
	
	public void dogPresentation() {
		System.out.println("I'm a dog !");
		this.yell();
	}
}

class Cat implements Animal {
	@Override
	public void yell() {
		System.out.println("Meow meow !!");
	}
	
	public void catPresentation() {
		System.out.println("I'm a cat !");
		this.yell();
	}
}