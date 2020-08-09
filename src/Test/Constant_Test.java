package Test;

import java.io.IOException;

import System.Data.Constant;
/**
 * Test the methods related to constant.
 * @author Jing Hu
 * @version 1.0
 */
public class Constant_Test {
	public static void main(String[] args) throws IOException {
		System.out.println(Constant.getAutoEmailTime());
		System.out.println(Constant.getManagerEmail());
		Constant.setAutoEmailTime("0 2 12 ? * TUE");
		Constant.setManagerEmail("aaa@qq.com");
		String head[]=Constant.getRequiredHead();
	}
}
