package tutorial_000.languageNewFeatures;

import java.util.List;
import java.util.stream.Collectors;

public class _004_Stream {

	public static void main(String[] args) {
		// Java 16 enhances Stream API with toList() and mapMulti() methods. Allow developers to write new code when converting 
		// a stream to a list.
		List<String> numbersList = List.of("element_1", "second_element", "the_third");
		
		// "Old" way with collector.
		List<String> collectorList = numbersList.stream()
											.filter(name -> name.contains("d"))
											.collect(Collectors.toList());
		
		System.out.println(collectorList);
		
		// We will note that this list is mutable :
		collectorList.add("fourth");
		System.out.println(collectorList);
		
		System.out.println("------------------------------");
		
		// Now same example with "toList()" method. We will note that this method return an immutable list.
		
		List<String> immutableList = numbersList.stream()
												.filter(name -> name.contains("d"))
												.toList();
		
		System.out.println(immutableList);
		
		// We will note that this list is mutable :
		try {
			immutableList.add("fourth");
		} catch(Exception e) {
			System.out.println("Cannot add element to immutable list !");
		}
		
		System.out.println("------------------------------");
		
		// Finally, the mapMulti() method allow us to easily map elements then retrieve a list (that is also immutable) :
		List<Object> mapMultiList = numbersList.stream()
												.mapMulti((name, downstream) -> downstream.accept(name.replace("d", "-123456-")))
												.toList();
		
		System.out.println(mapMultiList);
		System.out.println(mapMultiList.get(0).getClass());
		
		try {
			mapMultiList.add("another_element");
		} catch(Exception e) {
			System.out.println("This list also is immutable.");
		}
	}
}
