package com.caleb.pdd;

public class Main3 {

	// public static void m1() {
	// Scanner sc = new Scanner(System.in);
	// int t = sc.nextInt();
	// String[][] strs = new String[t][];
	// for (int i = 0; i < t; i++) {
	// int c = sc.nextInt();
	// sc.nextLine();
	// strs[i] = new String[c];
	// for (int j = 0; j < c; j++) {
	// strs[i][j] = sc.nextLine();
	// }
	// }
	// sc.close();
	// StringBuilder stringBuilder = new StringBuilder();
	// for (int i = 0; i < t; i++) {
	// List<int[]> list = new ArrayList<>();
	// int maxSla = 0;
	// for (int j = 0; j < strs[i].length; j++) {
	// String[] ss = strs[i][j].split("");
	// list.add(new int[] { Integer.parseInt(ss[0]), Integer.parseInt(ss[1]) });
	// maxSla = Math.max(maxSla, Integer.parseInt(ss[1]));
	// }
	// Collections.sort(list, new Comparator<int[]>() {
	// @Override
	// public int compare(int[] o1, int[] o2) {
	// // TODO Auto-generated method stub
	// return o1[1] - o2[1];
	// }
	// });
	// PriorityQueue<Integer> q = new PriorityQueue<>();
	// q.add(0);
	// for (int[] ll : list) {
	// int maxCount = ll[1];
	// int sla = ll[0];
	// if (q.size() >= maxCount) {
	// if (q.peek() >= sla) {
	// continue;
	// } else {
	// q.poll();
	// q.add(sla);
	// }
	// } else {
	// q.add(sla);
	// }
	// }
	// int res = 0;
	// while (!q.isEmpty()) {
	// res += q.poll();
	// }
	// stringBuilder.append(res + "\n");
	// }
	// System.out.print(stringBuilder.toString());
	// }

	// public static int res;

	// public static void m2() {
	// Scanner sc = new Scanner(System.in);
	// int t = sc.nextInt();
	// for (int i = 0; i < t; i++) {
	// int P = sc.nextInt();
	// int Q = sc.nextInt();
	// res = Math.abs(P - Q);
	// trackBack(P, Q, 0, P);
	// System.out.println(res);
	// }

	// }

	// public static void trackBack(int nums, int target, int times, int p) {
	// if (res < times || nums < p) {
	// return;
	// }
	// if (nums == target) {
	// res = Math.min(res, times);
	// return;
	// }
	// trackBack(nums - 2, target, times + 1, p);

	// trackBack(nums - 1, target, times + 1, p);

	// trackBack(nums + 1, target, times + 1, p);

	// trackBack(nums * 2, target, times + 1, p);

	// }

	// public static void m3() {
	// Scanner sc = new Scanner(System.in);
	// int t = sc.nextInt();
	// sc.nextLine();
	// StringBuilder stringBuilder = new StringBuilder();
	// String[] strs = new String[t];
	// for (int i = 0; i < t; i++) {
	// strs[i] = sc.nextLine();
	// }
	// sc.close();
	// for (int i = 0; i < t; i++) {
	// String[] ss = strs[i].split(" ");
	// int n = Integer.parseInt(ss[0]);
	// long m = Long.parseLong(ss[1]);
	// if (ss[1].length() > n) {
	// stringBuilder.append("-1\n");
	// continue;
	// }
	// long k = (long) Math.pow(10, n - 1);
	// long r = k % m;
	// long ans = k + ((m - r) % m);
	// stringBuilder.append(ans + "\n");
	// }
	// System.out.print(stringBuilder.toString());

	// }

	// public static void m4() {
	// Scanner sc = new Scanner(System.in);
	// int groups = sc.nextInt();
	// StringBuilder stringBuilder = new StringBuilder();
	// for (int i = 0; i < groups; i++) {
	// int N = sc.nextInt();
	// int K = sc.nextInt();
	// int D = sc.nextInt();
	// int Q = sc.nextInt();
	// int[] res = new int[N];
	// int[] score = new int[N];
	// boolean flag = false;
	// for (int j = 0; j < K; j++) {
	// int l = sc.nextInt();
	// int p = sc.nextInt();
	// if (flag) {
	// continue;
	// }
	// score[p] = l;
	// int fenshu = cal(score, p, N, D);
	// res[p] = fenshu;
	// if (p - 1 >= 0 && score[p - 1] != 0) {
	// res[p - 1] = cal(score, p - 1, N, D);
	// }
	// if (p - 1 < N && score[p + 1] != 0) {
	// res[p + 1] = cal(score, p + 1, N, D);
	// }
	// for (int l1 = 0; l1 < res.length; l1++) {
	// if (res[l1] == Q) {
	// stringBuilder.append(j + "\n");
	// flag = true;
	// break;
	// }
	// }
	// }
	// if (flag) {
	// continue;
	// }
	// stringBuilder.append("-1\n");
	// }
	// System.out.print(stringBuilder.toString());
	// }

	// public static int cal(int[] score, int p, int N, int D) {
	// int left = p - 1, right = p + 1;
	// int temp = score[p];
	// while (left >= 0 && left >= p - D) {
	// temp += score[left];
	// left--;
	// }
	// while (right < N && right <= p + D) {
	// temp += score[right];
	// right++;
	// }
	// return temp;
	// }

	public static void main(String[] args) {
		
	}

}
