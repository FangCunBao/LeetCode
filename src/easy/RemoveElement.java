package easy;

/**
 * 移除数组中值==val的元素，且空间复杂度为O(1)
 * @author fy
 *
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {

		int len = nums.length;
		int index = 0;
		for(int i=index; i<len; i = index)
		{
			if(nums[i] == val)
			{
				for(int j=index; j<len; j++)
				{
					nums[j] = nums[j+1];
				}
				len--;
			}
			if(nums[i] == val)
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
}
