package day3;

public class Overloading_sum {

	
	 public int sum(int a, int b) {
	        return a + b;
	    }

	    // sum of two doubles
	    public double sum(double a, double b) {
	        return a + b;
	    }

	    public static void main(String[] args) {
	        Overloading_sum obj = new Overloading_sum();

	        int intSum = obj.sum(10, 20);
	        double doubleSum = obj.sum(15.5, 24.5);

	        System.out.println("Sum of integers: " + intSum);
	        System.out.println("Sum of doubles : " + doubleSum);
	    }
}
