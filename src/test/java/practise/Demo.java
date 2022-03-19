package practise;

import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Demo {

	public static void main(String[] args) {
		String s="welcome to qspiders";
		String[] s1 = s.split(" ");
		for (int i = 0; i < s1.length; i++) {
			for (int j =s1[i].length()-1 ; j>=0 ; j--) {
				System.out.print(s1[i].charAt(j));
			}
			System.out.print(" ");
			
		}
		
		
			
		
	}
}
		
		

	