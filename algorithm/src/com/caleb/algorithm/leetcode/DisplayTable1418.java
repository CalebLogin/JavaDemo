package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author:Caleb
 * @Date :2021-07-06 16:57:27
 * 
 *       点菜展示表
 * 
 *       给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说，
 *       orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei
 *       是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 
 *       请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table”
 *       ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * 
 *       注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * 
 * 
 */
public class DisplayTable1418 {

	public List<List<String>> displayTable(List<List<String>> orders) {
		List<List<String>> res = new ArrayList<>();
		Map<String, Map<String, Integer>> ordered = new TreeMap<String, Map<String, Integer>>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1).compareTo(Integer.parseInt(o2));
			}

		});
		Set<String> dashes = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});
		for (List<String> order : orders) {
			Map<String, Integer> tableOrdered = ordered.getOrDefault(order.get(1), new HashMap<>());
			tableOrdered.put(order.get(2), tableOrdered.getOrDefault(order.get(2), 0) + 1);
			ordered.put(order.get(1), tableOrdered);
			dashes.add(order.get(2));
		}
		List<String> dash = new ArrayList<>();
		dash.add("Table");
		for (String dashName : dashes) {
			dash.add(dashName);
		}
		res.add(dash);
		for (Map.Entry<String, Map<String, Integer>> map : ordered.entrySet()) {
			List<String> list = new ArrayList<>();
			list.add(map.getKey());
			for (int i = 1;i<dash.size();i++) {
				list.add(String.valueOf(map.getValue().getOrDefault(dash.get(i), 0)));
			}
			res.add(list);
		}
		return res;
	}

	public static void main(String[] args) {

	}

}