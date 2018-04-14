package com.jvm;

public class FinalizeEscapGC {

	public static FinalizeEscapGC SAVE_HooK = null;
	
	public void isAlive(){
		System.out.println("yes,i am still alive :");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		FinalizeEscapGC.SAVE_HooK = this;
		
	}
	
	public static void main(String[] args) throws Exception{
		SAVE_HooK = new FinalizeEscapGC();
		
		SAVE_HooK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HooK != null){
			SAVE_HooK.isAlive();
		}
		else{
			System.out.println("no, i am dead !");
		}
		
		SAVE_HooK = null;
		System.gc();
		Thread.sleep(500);
		
		if(SAVE_HooK != null){
			SAVE_HooK.isAlive();
		}
		else{
			System.out.println("no, i am dead !");
		}
	}
}
