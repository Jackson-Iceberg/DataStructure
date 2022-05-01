package search;

// 使用二分查找的前提是 该数组是有序的
public class BinarySearch {
	public static void main(String[] args) {
		int [] array = {1,8,10,89,1000,1234};
		int index = binarySearch(array,0,array.length-1,88);
		if(index == -1) System.out.println("Index不存在");
		else System.out.println("Index="+index);
	}
	// 二分查找算法
	public static int binarySearch(int[] array,int left,int right,int finalVal) {
		if(left>right) return -1;
		
		int mid = (left+right)/2;
		int midVal = array[mid];
		
		if(finalVal>midVal) { // 向右递归
			return binarySearch(array,mid+1,right,finalVal);
		}
		else if(finalVal<midVal) {
			return binarySearch(array,left,mid-1,finalVal);
		}
		else {
			return mid;
		}
	}
}
