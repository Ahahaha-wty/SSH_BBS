package com.BBS.Utils;

public class levelUtil {
	public static Integer getLevel(Integer l) {
		if (l>=1050&&l<1450) {
			return 8;
		}
		else if (l>=750&&l<1050) {
			return 7;
		}
		else if (l>=500&&l<750) {
			return 6;
		}
		else if (l>=300&&l<500) {
			return 5;
		}
		else if (l>=150&&l<300) {
			return 4;
		}
		else if (l>=50&&l<150) {
			return 3;
		}
		else if (l>=10&&l<50) {
			return 2;
		}
		return 1;
		
		
		
				
	}
}
