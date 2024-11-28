import java.io.*;
import java.math.*;
class ArmstrongTwoIntervals {
	static void findArmstrong(int low, int high)
	{
		for (int i = low + 1; i < high; ++i) {
			int x = i;
			int n = 0;
			while (x != 0) {
				x /= 10;
				++n;
			}
			int pow_sum = 0; 
			x = i;
			while (x != 0) {
				int digit = x % 10;
				pow_sum += Math.pow(digit, n);
				x /= 10;
			}
			if (pow_sum == i) 
				System.out.print(i + " ");	 
		}
	}
	public static void main(String args[])
	{
		int num1 = 100;
		int num2 = 400;
		findArmstrong(num1, num2);
		System.out.println();
	}
}