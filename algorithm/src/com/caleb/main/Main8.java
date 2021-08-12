package com.caleb.main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main8 {
    private static class Ticket{
        int sla, x;

        public Ticket( int sla, int x) {
            this.sla = sla;
            this.x = x;
        }
    }

    private static class Ufs{
        int[] p;
        Ufs(int n){
            p = new int[n];
            for(int i = 0; i < n; ++i) p[i] = i;
        }
        int getP(int a){
            return p[a] = a == p[a] ? a : getP(p[a]);
        }
        void set1(int a, int b){
            p[a] = getP(b);
        }
    }

    private static List<Ticket> foo(List<Ticket> tickets){
        List<Ticket> ans = new ArrayList<>();
        tickets.sort(Comparator.comparing(a->-a.x));
        Ufs ufs = new Ufs(tickets.size() + 1);
        for(Ticket t : tickets){
            int s = t.sla;
            int p = ufs.getP(s);
            if(p > 0){
                ans.add(t);
                ufs.set1(p, p - 1);
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            int s = sc.nextInt();
            int x = sc.nextInt();
            tickets.add(new Ticket(s, Math.min(x, n)));
        }
		sc.close();
        List<Ticket> ans = foo(tickets);
        System.out.println(
                ans.stream().mapToLong(a->a.x).sum()
        );
    }

}