package skill;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 两个list(内部不重复)取交集、并集、差集
 */
public class TwoList {
	
	/**
	 * 使用JDK API取交集，缺点是会破坏原有list的结构
	 */
	public static List<String> intersection(List<String> aList, List<String> bList) {
		if (aList == null || bList == null)
			return null;
		aList.retainAll(bList);
		return aList;
	}
	
	/**
	 * 使用JDK API取并集
	 */
	public static List<String> union(List<String> aList, List<String> bList) {
		if (aList == null || bList == null)
			return null;
		
		bList.removeAll(aList);
		aList.addAll(bList);
		return aList;
	}
	
	/**
	 * 使用JDK API取差集，在aList中不在bList中的元素
	 */
	public static List<String> difference(List<String> aList, List<String> bList) {
		if (aList == null)
			return null;
		if (bList == null)
			return aList;
		aList.removeAll(bList);
		return aList;
	}
	
	/**
	 * 取交集，空间换时间
	 */
	public static List<String> intersection2(List<String> aList, List<String> bList) {
		if (aList == null || bList == null)
			return null;
		
		Map<String, Boolean> map = new LinkedHashMap<>();
		List<String> result = new ArrayList<>();
		
		for (String s : aList) {
			map.put(s, Boolean.FALSE);
		}
		
		for (String s : bList) {
			if (map.containsKey(s)) {
				map.put(s, Boolean.TRUE);
			}
		}
		
		for (Entry<String, Boolean> entry : map.entrySet()) {
			if (entry.getValue()) {
				result.add(entry.getKey());
			}
		}
		
		return result;
	}
	
	/**
	 * 取并集，直接用set
	 */
	public static List<String> union2(List<String> aList, List<String> bList) {
		if (aList == null || bList == null)
			return null;
		
		LinkedHashSet<String> set = new LinkedHashSet<>();
		List<String> result = new ArrayList<>();
		
		for (String s : aList) {
			set.add(s);
		}
		
		for (String s : bList) {
			set.add(s);
		}
		
		for (String s : set) {
			result.add(s);
		}
		
		return result;
	}
	
	/**
	 * 取差集，可以用交集的思路
	 */
	public static List<String> difference2(List<String> aList, List<String> bList) {
		if (aList == null || bList == null)
			return null;
		
		Map<String, Boolean> map = new LinkedHashMap<>();
		List<String> result = new ArrayList<>();
		
		for (String s : aList) {
			map.put(s, Boolean.TRUE);
		}
		
		for (String s : bList) {
			map.put(s, Boolean.FALSE);
		}
		
		for (Entry<String, Boolean> entry : map.entrySet()) {
			if (entry.getValue()) {
				result.add(entry.getKey());
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> aList = new ArrayList<>();
		List<String> bList = new ArrayList<>();
		
		aList.add("A");
		aList.add("B");
		
		bList.add("B");
		bList.add("C");
		bList.add("D");
		
//		System.out.println(intersection(aList, bList).toString()); // [B]
//		System.out.println(union(aList, bList).toString()); // [A,B,C,D]
//		System.out.println(difference(aList, bList).toString()); // [A]
		
		System.out.println(intersection2(aList, bList).toString()); // [B]
		System.out.println(union2(aList, bList).toString()); // [A,B,C,D]
		System.out.println(difference2(aList, bList).toString()); // [A]
	}
}
