package l00Doubts;

public class MethodOverriding extends Parent {

//Note: cannot override static	method without using static
//	public void g() {
//		System.out.println("child g");
//	}
	
	public static void gg() {
		System.out.println("child gg");
	}
	
	public void ggx() {
		System.out.println("child ggx");
	}
	
	
	
	
	public static void main(String[] args) {
		
		Parent p = new MethodOverriding();
		p.gg();
		p.ggx();
		
		
	}

}


class Parent {
	
//	public static void g() {
//		System.out.println("parent g");
//	}
	
	public static void gg() {
		System.out.println("parent gg");
	}
	
	public void ggx() {
		System.out.println("parent ggx");
	}
}