package ch.bfh.btx8081.w2019.green.alzman.model;

import java.util.HashMap;
import java.util.Map;


/**
 * This enum is used to represent the 3 different statuslevels we have defined
 * <br><br>1 = "Independent"<br> 2 = "With help"<br> 3 = "Dependent"
 * 
 * @author Adrian
 *
 */
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
	
	/**
	 * This method is used to find the level corresponding to the int
	 * 
	 * @param level int (between 1-3)
	 * @return {@link StatusLevel} corresponding to the param
	 */
	public static StatusLevel valueOf(int level) {
		return (StatusLevel) map.get(level);
	}
	
	public int getLevel() {
		return level;
	}

}
