import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-07-07 18:50:44
 * 
 *       工单调度
 * 
 */
public class Main6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int orderCount = sc.nextInt();
		Map<Integer, List<Integer>> map = new HashMap<>();
		int res = 0;
		int maxSla = 0;
		for (int i = 0; i < orderCount; i++) {
			int sla = sc.nextInt();
			maxSla = Math.max(maxSla, sla);
			int score = sc.nextInt();
			List<Integer> temp = map.getOrDefault(sla, new ArrayList<>());
			temp.add(score);
			map.put(sla, temp);
		}
		sc.close();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(0);
		for (int i = 0; i <= maxSla; i++) {
			if (map.containsKey(i)) {
				List<Integer> temp = map.get(i);
				for (Integer sla : temp) {
					int maxCount = i;
					if (q.size() >= maxCount) {
						if (q.peek() >= sla) {
							continue;
						} else {
							res -= q.poll();
							res += sla;
							q.add(sla);
						}
					} else {
						res += sla;
						q.add(sla);
					}
				}
			}
		}
		System.out.println(res);
	}

}