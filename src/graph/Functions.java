package graph;

public class Functions {
	
	public static double f(double x) {
		return Driver.function(x);
	}
	//f' and f'' both use the limit definition of a derivative
	public static double fp(double x) {
		double primed = (f(x+0.0001) - f(x))/0.0001;
		return primed;
	}
	public static double fpp(double x) {
		double primed = (fp(x+0.0001)-fp(x))/0.0001;
		return primed;
	}
	
	//integration
	public static double integral(double a, double b) {
		double sum = 0;
		
		//Riemann's Sum Demonstration (Although slow, gets the task done)
//		double inc = 0.001;
//		for(double i = a; i < b; i+=inc) {
//			sum += inc * f(i);
//		}
		
		//Simpson's Rule (Faster integration)
		sum = (b - a) / 8 * (f(a) + 3 * f((2 * a + b) / 3) + 3 * f((a + 2 * b) / 3) + f(b));
		sum = Math.floor(sum*1000)/1000;
		return sum;
		
	}
	//integral(from a to b) of f(x) dx = F(b) - F(a)
	public static double FTC(double a, double b) {
		return Math.floor((integral(0,b) - integral(0,a))*1000)/1000;
	}
}
