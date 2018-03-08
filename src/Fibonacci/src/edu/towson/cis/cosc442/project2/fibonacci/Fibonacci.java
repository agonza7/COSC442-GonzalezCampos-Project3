
package Fibonacci.src.edu.towson.cis.cosc442.project2.fibonacci;

/**
 * The Class Fibonacci to simply calculates the nth Fibonacci number given the input n.
 */
public class Fibonacci {
	
	/**
	 * Calculates and returns the nth Fibonacci number.
	 *
	 * @param n the index
	 * @return the nth Fibonacci number
	 */
	public int fibonacci(int n) {
		switch (n) {
		//This was the bug found on this file it had case 0: Return 1;
			case 0: return 0;
			case 1: return 1;
			default: return (fibonacci(n - 1) + fibonacci(n - 2));
		}
	}
}
