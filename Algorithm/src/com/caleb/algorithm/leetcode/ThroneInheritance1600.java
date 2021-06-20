package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:Caleb
 * @Date  :2021-06-20 18:08:40
 */
public class ThroneInheritance1600{

	public static void main(String[] args) {
		ThroneInheritance throneInheritance = new ThroneInheritance("king");
		throneInheritance.birth("king","andy");	
		throneInheritance.birth("king","bob");	
		throneInheritance.birth("king","catherine");	
		throneInheritance.birth("andy","matthew");	
		throneInheritance.birth("bob","alex");	
		throneInheritance.birth("bob","asha");	
		List<String> intheritanceList1 = throneInheritance.getInheritanceOrder();
		for(String str:intheritanceList1){
			System.out.print(str+" ");
		}
		System.out.println();
		throneInheritance.death("bob");
		List<String> intheritanceList2 = throneInheritance.getInheritanceOrder();
		for(String str:intheritanceList2){
			System.out.print(str+" ");
		}
		System.out.println();
	}

}

class ThroneInheritance {

	Map<String,List<String>>  inheritanceMap;
	Map<String,Integer> stillAlive;
	String kingName;
    public ThroneInheritance(String kingName) {
		this.kingName = kingName;
		inheritanceMap = new HashMap<>();
		stillAlive = new HashMap<>();
		stillAlive.put(kingName, 1);
		inheritanceMap.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
		inheritanceMap.get(parentName).add(childName);
		inheritanceMap.put(childName, new ArrayList<>());
		stillAlive.put(childName, 1);
    }
    
    public void death(String name) {
		stillAlive.put(name,0);
    }
    
    public List<String> getInheritanceOrder() {
		return getInheritanceOrderList(kingName);
    }

	private List<String> getInheritanceOrderList(String kingName){
		List<String> inheritanceList = new ArrayList<>();
		List<String> childList = inheritanceMap.get(kingName);
		if(stillAlive.get(kingName) == 1){
			inheritanceList.add(kingName);
		}
		for(String childName : childList){
			inheritanceList.addAll(getInheritanceOrderList(childName));
		}
		return inheritanceList;
	}
}