package arithmetic;

public class Title1 {

	
	
	
	public static void main(String[] args) {
		
		
		
	/*	title1：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
		也不知道每个数字重复几次。
		请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
		*/
		int [] numbers={2,3,1,0,2,5,3};
		int lenght=7;
		int [] duplication=new int[1];
		
		boolean isSuplication= isSuplication(numbers,lenght,duplication);
		
		
		
	}

	private static boolean isSuplication(int[] numbers, int lenght, int[] duplication) {

		if(numbers==null||numbers.length<=0){
			return false;
		}
		for(int j=0;j<lenght;j++ ){
			if(numbers[j]<0||  numbers[j]>=lenght){
				return false;
			}
		}
		
		
		
		
		
		return false;
	}
	
	
	
	
}