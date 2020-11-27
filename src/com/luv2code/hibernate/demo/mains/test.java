package com.luv2code.hibernate.demo.mains;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] numbers = new int[] {9, 9, 4, 2, 8, 0, 2};
//		
//		for(int i=numbers.length/2;i<numbers.length;i++){
//			  if(numbers[i] == 0){
//				  break;
//			  }else {
//			    System.out.println(numbers[i]);
//			  }
//		}
		
		boolean krit=isWerewolf("rOtaTor");
		System.out.println("krit: " +krit);
	}
	
	public static boolean isWerewolf(String target) {
		  // write your code here
		  StringBuilder sbTarget=new StringBuilder(target);
		  System.out.println(sbTarget);
		  //System.out.println(sbTarget.reverse());
		  
		  if(target.equals(sbTarget.reverse().toString())){
		    return true;
		  }
		  return false;
		}

}
