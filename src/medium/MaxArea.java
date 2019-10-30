package medium;

/**
 * 盛水最多的容器:题目描述看原题
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 
 * @author fy
 *
 */
public class MaxArea {

	public int maxArea(int[] height) {
		if(height.length < 2)
			return 0;
		int max = 0;
		for(int i=1;i<=height.length-1;i++)
		{
			for(int j=0;(j+i)<=(height.length-1);j++)
			{
				int t = i*Math.min(height[i+j], height[j]);
				max = Math.max(max, t);
				//if(i == 7)
					System.out.println(max);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaxArea ma = new MaxArea();
		int height[] = new int[]{1,8,6,2,5,4,8,3,7};
		int height2[] = new int[]{1,1};
		ma.maxArea(height2);
	}
}
