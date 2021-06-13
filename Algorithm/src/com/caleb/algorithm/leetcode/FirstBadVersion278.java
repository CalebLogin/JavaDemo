package com.caleb.algorithm.leetcode;

/**
 * 第一个错误的版本 你是产品经理，目前正在带领一个团队开发新的产品。 不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。 假设你有 n 个版本 [1, 2, ...,
 * n]，你想找出导致之后所有版本出错的第一个错误的版本。 你可以通过调用 bool isBadVersion(version) 接口来判断版本号
 * version 是否在单元测试中出错。 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 
 * @author:Caleb
 * @Date :2021-06-13 18:38:28
 */
public class FirstBadVersion278 extends VersionControl {

	/**
	 * 二分法
	 * 
	 * @param n
	 * @return
	 */
	public int firstBadVersion(int n) {
		int l = 1, r = n;
		while (l < r) {
			// 防止溢出
			int mid = l + ((r-l) / 2);
			if(!isBadVersion(mid)){
				l = mid+1;
			}else{
				r = mid;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		FirstBadVersion278 firstBadVersion278 = new FirstBadVersion278();
		System.out.println(firstBadVersion278.firstBadVersion(2126753390));
		
	}

}

class VersionControl {
	boolean isBadVersion(int version) {
		if(version >= 1702766719){
			return true;
		}
		return false;
	}
}