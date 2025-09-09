package l00Doubts;

public class SuperThisCheck extends MySuper  {

    public SuperThisCheck(String str) {		
    	/*giving compilation error as super() is implictly calling MySuper() - which is the default constructor 
    	 * but it is not created by the system as already there is another constructor created.*/
        System.out.println("Hi");
    }

    public static void main(String args[]) {
        new SuperThisCheck("Bye");
    }
}


class MySuper {
	
	public MySuper() {
		
	}
	
    public MySuper(String str) {
        System.out.println("Hello");
    }
}