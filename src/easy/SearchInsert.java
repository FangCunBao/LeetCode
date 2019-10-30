package easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5 输出: 2 示例 2:
 * 
 * 输入: [1,3,5,6], 2 输出: 1 示例 3:
 * 
 * 输入: [1,3,5,6], 7 输出: 4 示例 4:
 * 
 * 输入: [1,3,5,6], 0 输出: 0
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author fy
 *
 */
public class SearchInsert {

	public int searchInsert(int[] nums, int target) {

		int index = -1;
		index = search(nums,0,nums.length-1,target);
		if(index < 0)
		{
			for(int i=0;i<nums.length;i++)
			{
				if(nums[i] > target)
				{
					index = i;
					break;
				}
			}
		}
		if(index < 0){
			return nums.length;
		}
		return index;
	}
	//二分法查找，返回索引
	private int search(int[] arr, int lo, int hi, int num)
	{
		int i = lo;
		int j = hi;
		int index = -1;
		while(i <= j)
		{
			int mid = (i+j)/2;
			if(num < arr[mid])
				j = mid-1;
			if(num > arr[mid])
				i = mid + 1;
			if(num == arr[mid])
			{
				index = mid; 
				break;
			}
				
		}
		return index;
	}
	
	public static void main(String[] args) {
		SearchInsert si = new SearchInsert();
		int [] arr1 = new int[]{1,3,5,6};
		System.out.println(si.searchInsert(arr1, 5));
	}
}
