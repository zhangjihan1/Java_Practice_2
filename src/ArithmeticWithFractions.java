/*
下代码属于Deep Knowledge Education，其用途仅为教学展示，任何人不可复制，使用，或用于任何其他用途，违者必追究法律责任。
The code below belongs to Deep Knowledge Education. 
It is only for demonstration as part of education process.
You cannot copy, use the code, nor can you use it for any other purpose.
Offenders must be held accountable.
Date: 20 Sep 2020
*/

/*
 * Java 练习：写一个用于计算分数的小程序
 * 要求：(1) 从命令行读取用户输入
 * 		(2) 使用OOP编程计算分数加减乘除
 * 		(3) 按格式显示结果
 */

//(0) 定义所有需要用的类
//负责接受用户输入和程序运行的主类: ArithmeticWithFractions
public class ArithmeticWithFractions {

	public static void main(String[] args) {
		//(1) 从命令行读取用户输入
		if (args.length != 2) terminate();
		String frac1Str = args[0];
		String frac2Str = args[1];
		
		//(2) 检查用户输入是否正确
		if (frac1Str.contains("-") || frac2Str.contains("-")) terminate(); 
		
		String[] frac1Arr = frac1Str.split("/");
		String[] frac2Arr = frac2Str.split("/");
		if (frac1Arr[1].equals("0") || frac2Arr[1].equals("0")) terminate();
		
		//(3) 创建 Fraction 对象
		Fraction fr1 = new Fraction(Integer.valueOf(frac1Arr[0]), Integer.valueOf(frac1Arr[1]));
		Fraction fr2 = new Fraction(Integer.valueOf(frac2Arr[0]), Integer.valueOf(frac2Arr[1]));
		
		//(4) 计算以及显示分数加减乘除结果
		displayResults(fr1, fr2);
		
	}
	
	//输出错误，结束程序 
	public static void terminate() {
		System.out.println("Illegal Argument. Exit...");
		System.exit(1);
	}
	
	//计算以及显示分数加减乘除结果
	public static void displayResults(Fraction fr1, Fraction fr2) {
		Calculator calc = new Calculator(fr1, fr2);
		System.out.println("--- Basic operations with fractions ---");
		System.out.printf("%-15s %s + %s = %s %n", "The sum:", fr1, fr2, calc.addFractions());
		System.out.printf("%-15s %s - %s = %s %n", "The difference:", fr1, fr2, calc.subFractions());
		System.out.printf("%-15s %s X %s = %s %n", "The product:", fr1, fr2, calc.multFractions());
		System.out.printf("%-15s %s \u00F7 %s = %s %n", "The product:", fr1, fr2, calc.divFractions());
	}

}

//提供主要分数计算逻辑的服务类: Calculator
class Calculator {
	private Fraction fr1;
	private Fraction fr2;
	
	public Calculator(Fraction fr1, Fraction fr2) {
		this.fr1 = fr1;
		this.fr2 = fr2;
	}
	
	//计算分数加
	public Fraction addFractions() {
		int newNumerator = fr1.numerator * fr2.denominator + fr2.numerator * fr1.denominator;
		int newDenominator = fr1.denominator * fr2.denominator;
		return new Fraction(newNumerator, newDenominator);
	}
	
	//计算分数减
	public Fraction subFractions() {
		int newNumerator = fr1.numerator * fr2.denominator - fr2.numerator * fr1.denominator;
		int newDenominator = fr1.denominator * fr2.denominator;
		return new Fraction(newNumerator, newDenominator);
	}
	
	//计算分数乘
	public Fraction multFractions() {
		int newNumerator = fr1.numerator * fr2.numerator;
		int newDenominator = fr1.denominator * fr2.denominator;
		return new Fraction(newNumerator, newDenominator);
	}
	
	//计算分数除
	public Fraction divFractions() {
		int newNumerator = fr1.numerator * fr2.denominator;
		int newDenominator = fr1.denominator * fr2.numerator;
		return new Fraction(newNumerator, newDenominator);
	}
}

//提供分数数据的数据类: Fraction
class Fraction {
	public int numerator;
	public int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
}