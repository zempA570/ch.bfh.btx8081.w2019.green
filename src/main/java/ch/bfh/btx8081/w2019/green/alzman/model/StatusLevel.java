package ch.bfh.btx8081.w2019.green.alzman.model;

import java.util.HashMap;
import java.util.Map;

public enum StatusLevel {
	
	INDEPENDENT(1),
	WITHHELP(2),
	DEPENDENT(3);
	
	private int level;
	private static Map<Integer, StatusLevel> map = new HashMap<>();
	
	private StatusLevel(int level) {
		this.level = level;
	}
	
	static {
		for (StatusLevel statusLevel : StatusLevel.values()) {
			map.put(statusLevel.getLevel(), statusLevel);
		}
	}
	
	public static StatusLevel valueOf(int level) {
		return (StatusLevel) map.get(level);
	}
	
	public int getLevel() {
		return level;
	}

}
