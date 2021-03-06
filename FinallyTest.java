package com.baron.exception;

public class FinallyTest {

	//	output:
	//	try print finally 2
	static int testReturn(){
		try {
			System.out.println("try");
			return print();
		} finally{
			System.out.println("finally");
			return 2;
		}
	}
	// output:
	// java.lang.Exception: finally
	static void testException() throws Exception{
		try {
			throw new Exception("try");
		} finally{
			throw new Exception("finally");
		}
	}
	
	static int print(){
		System.out.println("print");
		return 1;
	}
	// output:
	// try print finally 1
	static int test2(){
		try {
			System.out.println("try");
			return print();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			System.out.println("finally");
		}
		return 0;
	}
	
}
