package airbnb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            sc.nextLine();
            List<List<Integer>> magic = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                String[] lines = line.split(" ");
                List<Integer> arr = new ArrayList<>();
                for (int j = 0; j < lines.length; j++) {
                    arr.add(Integer.parseInt(lines[j]));
                }
                magic.add(arr);
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            count(magic, res, 0, path);
            int cost = Integer.MAX_VALUE;
            List<Integer> win = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                int start = 0;
                int temp = 0;
                for (Integer item : res.get(i)) {
                    temp += (item - start) * (item - start);
                    start = item;
                }
                if (temp < cost) {
                    win = res.get(i);
                    cost = temp;
                }
            }
            win.add(0, 0);
            for (int i = 0; i < win.size(); i++) {
                System.out.println(win.get(i));
            }
        }
    }

    static void count(List<List<Integer>> nums, List<List<Integer>> res, int start, List<Integer> path) {
        if (start == 9) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.get(start).size(); i++) {
            if (path.contains(nums.get(start).get(i)))
                continue;
            path.add(nums.get(start).get(i));
            count(nums, res, nums.get(start).get(i), path);
            path.remove(path.size()-1);
        }
    }
}
