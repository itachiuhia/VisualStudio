package Java;

import java.util.*;

public class DistintStting {

    public static long dist(String s, int k){

        if(s == null || s.length() == 0 || k >s.length() || k > 26){
            return 0;
        }

        int res = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();

	    for (int i = 0; i < s.length() - k + 1; i++) {
		while (j < s.length() && map.size() < k) {
			int count = 1;
			if (map.containsKey(s.charAt(j))) {
				count = map.get(s.charAt(j));
				count++;
			}
			map.put(s.charAt(j), count);
			j++;
		}

		if (map.size() == k) {
			res += s.length() - j + 1;
		}

		int count = map.get(s.charAt(i));
		if (count == 1) {
			map.remove(s.charAt(i));
		} else {
			map.put(s.charAt(i), count - 1);
		}
	}
	return res;


    }
    public static void main(String[] args) {

        String s = "abccca";
        System.out.println(dist(s, 1));
        System.out.println(dist(s, 2));
        System.out.println(dist(s, 3));
        System.out.println(dist(s, 4));

        
    }
}
