import java.util.*;
class BinaryToDecimal{
	public static void binaryToDecimal(int num)
	{
		int r, temp, ans = 0, p = 0;
		temp = num;
		while (num != 0) {
			r = num % 10;
			ans += r * (1 << p);
			p++;
			num /= 10;
		}
		System.out.println("Decimal Equivalent of " + temp
						+ " is " + ans);
	}
	public static void main(String[] args)
	{
		int num = 1100;
		binaryToDecimal(num);
	}
}



import java.util.*;
class GFG {
	public static void main(String args[])
	{
		int num, ans;
		String temp;
		num = 1010;
		temp = String.valueOf(num);
		ans = Integer.parseInt(temp, 2);
		System.out.println("Decimal Equivalent of " + num +" is " + ans);
	}
}
