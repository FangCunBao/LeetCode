package easy;

public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {

		int len = nums.length;
		int index = 0;
		for(int i=index; i<len-1; i = index)
		{
			if(nums[i] == nums[i+1])
			{
				for(int j=index; j<len-1; j++)
				{
					nums[j] = nums[j+1];
				}
				len--;
			}
			if(nums[i] == nums[i+1])
			{
				continue;
			}else
			{
				index++;
			}
		}
		
		for(int i=0;i<len;i++)
		{
			System.out.println(nums[i]);
		}
		
		return len;
	}
	
	
	/**
	 * 双指针法：类似插入排序，就是在数组中寻找不重复的元素，将其放在最后一个不重复的元素的后面
	 * 		      第一个元素可以认为是最后一个不重复的元素
	 * @param args
	 * [1,2,3]
	 * [1,1,2,2,2,3]
	 */
	
	public int removeDuplicates2(int[] nums) {
		if(nums.length == 0)
			return 0;
		int i = 0;
		for(int j = 1; j < nums.length; j++)
		{
			if(nums[i] != nums[j])
			{
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
		
	}
	
	public static void main(String[] args) {
		RemoveDuplicates rp = new RemoveDuplicates();
		int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
		rp.removeDuplicates(nums);
	}
}
