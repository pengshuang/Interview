//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class ThoughtWorks {
//    private HashMap<String, String> user2scene = new HashMap<>();
//    private HashMap<String, Integer> userCheck = new HashMap<>();
//    private HashMap<String, Integer > sceneStart = new HashMap<>();
//    private HashMap<String, Integer > sceneEnd = new HashMap<>();
//    private Map<String, Integer> incomeMap = new TreeMap<>(new Comparator<String>() {
//        public int compare(String o1, String o2) {
//            return o1.compareTo(o2);
//        }
//    });
//
//    int dayForWeek(String pTime) throws Exception {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        c.setTime(format.parse(pTime));
//        int dayOfWeek;
//        if(c.get(Calendar.DAY_OF_WEEK) == 1){
//            dayOfWeek = 7;
//        }else{
//            dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
//        }
//        return dayOfWeek;
//    }
//    void summary(String input){
//        double income = 0;
//        int[][] charge = new int[8][24];
//        for(int i = 1; i <= 5; i++){
//            charge[i][9] = 30;
//            charge[i][10] = 30;
//            charge[i][11] = 30;
//            charge[i][12] = 50;
//            charge[i][13] = 50;
//            charge[i][14] = 50;
//            charge[i][15] = 50;
//            charge[i][16] = 50;
//            charge[i][17] = 50;
//            charge[i][18] = 80;
//            charge[i][19] = 80;
//            charge[i][20] = 60;
//            charge[i][21] = 60;
//        }
//        for(int i = 6; i <= 7; i++){
//            charge[i][9] = 40;
//            charge[i][10] = 40;
//            charge[i][11] = 40;
//            charge[i][12] = 50;
//            charge[i][13] = 50;
//            charge[i][14] = 50;
//            charge[i][15] = 50;
//            charge[i][16] = 50;
//            charge[i][17] = 50;
//            charge[i][18] = 60;
//            charge[i][19] = 60;
//            charge[i][20] = 60;
//            charge[i][21] = 60;
//        }
//        String[] arr = input.split(" ");
//        if (arr.length == 4) {
//            String user = arr[0];
//            String date = arr[1];
//            String time = arr[2];
//            String scene = arr[3];
//            String sceneInfo = date + " " + time + " " + scene;
//            String sceneInfo2 = date + " " + scene;
//            String userInfo = date + " " + time + " " + scene + " " + user;
//            String[] tempSplit = time.split("~");
//            int[] timezone = new int[2];
//            timezone[0] = Integer.parseInt(tempSplit[0].split(":")[0]);
//            timezone[1] = Integer.parseInt(tempSplit[1].split(":")[0]);
//
//            if (user2scene.containsKey(sceneInfo)) {
//                System.out.println("Error: the booking conflicts with existing bookings!");
//            } else if ((sceneStart.containsKey(sceneInfo2) && sceneStart.get(sceneInfo2) <= timezone[0] && sceneEnd.get(sceneInfo2) >= timezone[0])
//                    || (sceneEnd.containsKey(sceneInfo2) && sceneStart.get(sceneInfo2) <= timezone[1] && sceneEnd.get(sceneInfo2) >= timezone[1])) {
//                System.out.println("Error: the booking conflicts with existing bookings!");
//            } else if (timezone[0] < 9 || timezone[0] > 22 || timezone[1] < 9 || timezone[1] > 22 || timezone[0] == timezone[1]) {
//                System.out.println("Error: the booking is invalid!");
//            }
//            else {
//                user2scene.put(sceneInfo, user);
//                sceneStart.put(sceneInfo2, timezone[0]);
//                sceneEnd.put(sceneInfo2, timezone[1]);
//                int weekday = -1;
//                try {
//                    weekday = dayForWeek(date);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                income = 0;
//                for(int i = timezone[0]; i < timezone[1]; i++) {
//                    income += charge[weekday][i];
//                }
//                userCheck.put(userInfo, (int)income);
//                incomeMap.put(sceneInfo, (int)income);
//                System.out.println("Success: the booking is accepted!");
//            }
//        } else if (arr.length == 5) {
//            String user = arr[0];
//            String date = arr[1];
//            String time = arr[2];
//            String scene = arr[3];
//            String flag = arr[4];
//            String sceneInfo = date + " " + time + " " + scene;
//            String sceneInfo2 = date + " " + scene;
//            String userInfo = date + " " + time + " " + scene + " " + user;
//            if (!flag.equals("C"))
//                System.out.println("Error: the booking is invalid!");
//            else if (!user2scene.containsKey(sceneInfo)) {
//                System.out.println("Error: the booking being cancelled does not exist!");
//            }
//            else {
//                  int weekday = -1;
//                  try {
//                      weekday = dayForWeek(date);
//                  } catch (Exception e) {
//                      e.printStackTrace();
//                  }
//                  if (weekday < 6) {
//                      income = 0.5 * userCheck.get(userInfo);
//                  } else {
//                      income = 0.25 * userCheck.get(userInfo);
//                  }
//                  userCheck.put(userInfo, (int) income);
//                  incomeMap.remove(sceneInfo);
//                  incomeMap.put(sceneInfo + " 违约金", (int)income);
//                  user2scene.remove(sceneInfo);
//                  sceneStart.remove(sceneInfo2);
//                  sceneEnd.remove(sceneInfo2);
//                  System.out.println("Success: the booking is accepted!");
//            }
//        } else if (input.startsWith("check")) {
//            check();
//        }
//        else {
//            System.out.println("Error: the booking is invalid!");
//        }
//
//    }
//
//    void check() {
//        System.out.println("收入汇总");
//        System.out.println("---");
//        Iterator<Map.Entry<String, Integer>> entries = incomeMap.entrySet().iterator();
//        Map<String, Integer> sceneA = new TreeMap<>();
//        Map<String, Integer> sceneB = new TreeMap<>();
//        Map<String, Integer> sceneC = new TreeMap<>();
//        Map<String, Integer> sceneD = new TreeMap<>();
//        while (entries.hasNext()) {
//            Map.Entry<String, Integer> entry = entries.next();
//            String[] entryArr = entry.getKey().split(" ");
//            String date = entryArr[0];
//            String time = entryArr[1];
//            String sceneId = entryArr[2];
//            String info = date + " " + time + " ";
//            if (entryArr.length == 4)
//                info += "违约金";
//            switch (sceneId)
//            {
//                case "A":
//                    sceneA.put(info, entry.getValue());
//                    break;
//                case "B":
//                    sceneB.put(info, entry.getValue());
//                    break;
//                case "C":
//                    sceneC.put(info, entry.getValue());
//                    break;
//                case "D":
//                    sceneD.put(info, entry.getValue());
//                    break;
//                default:
//                    break;
//            }
//        }
//        System.out.println("场地:A");
//        Iterator<Map.Entry<String, Integer>> incomeA = sceneA.entrySet().iterator();
//        int totalA = 0;
//        while (incomeA.hasNext()) {
//            Map.Entry<String, Integer> entry = incomeA.next();
//            totalA += entry.getValue();
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        System.out.println("小计: " + totalA);
//
//        System.out.println();
//        System.out.println("场地:B");
//        Iterator<Map.Entry<String, Integer>> incomeB = sceneB.entrySet().iterator();
//        int totalB = 0;
//        while (incomeB.hasNext()) {
//            Map.Entry<String, Integer> entry = incomeB.next();
//            totalB += entry.getValue();
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        System.out.println("小计: " + totalB);
//
//        System.out.println();
//        System.out.println("场地:C");
//        Iterator<Map.Entry<String, Integer>> incomeC = sceneC.entrySet().iterator();
//        int totalC = 0;
//        while (incomeC.hasNext()) {
//            Map.Entry<String, Integer> entry = incomeC.next();
//            totalC += entry.getValue();
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        System.out.println("小计: " + totalC);
//
//        System.out.println();
//        System.out.println("场地:D");
//        Iterator<Map.Entry<String, Integer>> incomeD = sceneD.entrySet().iterator();
//        int totalD = 0;
//        while (incomeD.hasNext()) {
//            Map.Entry<String, Integer> entry = incomeD.next();
//            totalD += entry.getValue();
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        System.out.println("小计: " + totalD);
//
//        System.out.println("---");
//        int sum = totalA + totalB + totalC + totalD;
//        System.out.println("总计: " + sum);
//
//    }
//
//    public static void main(String[] args) {
//        ThoughtWorks t = new ThoughtWorks();
//
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            t.summary(sc.nextLine());
//        }
//    }
//
//}