package test;

import java.util.*;

public class test3 {

        public static void main(String[] args) {
            Set<String> set = caculate(new int[] {12, 12, 1, 1}, 24);
            if(set != null){
                System.out.println("True");
            }else {
                System.out.println("False");
            }
        }


        private static void printlnResultSet(Collection<String> resultSet) {
            for (String str : resultSet) {
                System.out.println(str);
            }
        }


        private static int[][] arrangeAllNumbers(int[] numbers) {
            List<int[]> list = new ArrayList<int[]>();
            allSort(numbers, 0, numbers.length - 1, list);
            int[][] resultSet = new int[list.size()][list.get(0).length];
            resultSet = list.toArray(resultSet);
            return resultSet;
        }

        private static char[][] arrangeAllOperators(char[] operators, int number) {
            int setSize = (int) Math.pow(operators.length, number);
            int index = 0;
            char[][] resultSet = new char[setSize][number];
            for (int i = 0; i < operators.length; i++) {
                for (int j = 0; j < operators.length; j++) {
                    for (int k = 0; k < operators.length; k++) {
                        resultSet[index][0] = operators[i];
                        resultSet[index][1] = operators[j];
                        resultSet[index][2] = operators[k];
                        index++;
                    }
                }
            }
            return resultSet;
        }


        public static Set<String> caculate(int[] numbers, int targetNumber){
            Set<String> resultSet = new HashSet<String>();// 这里用Set而不是用List，主要是因为当给定的一组数字中如果有重复数字的话，同一结果会被出现多次，如果用List存放的话，会将重复的结果都存放起来，而Set会自动消除重复值
            char[][] operatorsArrangement = arrangeAllOperators(new char[] { '+',
                    '-', '*', '/' }, 3);
            int[][] numbersArrangement = arrangeAllNumbers(numbers);
            for (int[] nums : numbersArrangement)
                for (char[] operators : operatorsArrangement) {
                    int result = 0;
                    try {
                        result = caculate(nums, operators);
                    } catch (Exception e) {// 出现非精确计算
                        continue;
                    }
                    if (result == targetNumber)
                        resultSet.add(buildString(nums, operators, targetNumber));// 如果计算后的结果等于想要的结果，就存放到集合中
                }
            if (resultSet.isEmpty())
                return null;
            return resultSet;
        }

        /**
         * 将一组整型数字以给定的操作符按顺序拼接为一个完整的表达式字符串
         *
         * @param nums
         *            一组整型数字
         * @param operators
         *            一组操作符
         * @param target
         *            目标值
         * @return 拼接好的表达式字符串
         */
        private static String buildString(int[] nums, char[] operators, int target) {
            String str = String.valueOf(nums[0]);
            for (int i = 0; i < operators.length; i++) {
                str = str + ' ' + operators[i] + ' ' + nums[i + 1];
            }
            str = str + " = " + target;
            return str;
        }

        /**
         * 将给定的一组数字以给定的操作符按顺序进行运算，如：int result = caculate(new int[]{3,4,5,8}, new
         * char[]{'+','-','*'});
         *
         * @param nums
         *            一组数字
         * @param operators
         *            一组运算符，数量为数字的个数减1
         * @return 最后的计算结果
         * @throws Exception
         *             当计算结果不精确时，抛出该异常，主要是针对除法运算，例如18 / 8 = 2，诸如这样不精确计算将抛出该异常
         */
        private static int caculate(int[] nums, char[] operators) throws Exception {
            int result = 0;
            for (int i = 0; i < operators.length; i++) {
                if (i == 0) {
                    result = caculate(nums[i], nums[i + 1], operators[i]);
                } else {
                    result = caculate(result, nums[i + 1], operators[i]);
                }
            }
            return result;
        }

        /**
         * 根据指定操作符将两个给定的数字进行计算
         *
         * @param num1
         *            数字1
         * @param num2
         *            数字2
         * @param operator
         *            操作符，只能从“+、-、*、/”4个操作符中取值
         * @return 计算结果
         * @throws Exception
         *             当计算结果不精确时，抛出该异常，主要是针对除法运算，例如18 / 8 = 2，诸如这样不精确计算将抛出该异常
         */
        private static int caculate(int num1, int num2, char operator)
                throws Exception {
            double result = 0;
            switch (operator) {// 根据操作符做相应的计算操作
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = (double) num1 / (double) num2;
                    break;
            }
            if (!check(result))
                throw new Exception("不精确的计算数字");
            return (int) result;
        }

        /**
         * 检查指定的浮点数是否可以直接转换为整型数字而不损失精度
         *
         * @param result
         *            要检查的浮点数
         * @return 如果可以进行无损转换，返回true，否则返回false
         */
        private static boolean check(double result) {
            String str = String.valueOf(result);
            int pointIndex = str.indexOf(".");// 小数点的下标值
            String fraction = str.substring(pointIndex + 1);
            return fraction.equals("0") ? true : false;// 通过判断小数点后是否只有一个0来确定是否可以无损转换为整型数值
        }

        /**
         * 对传入的整型数组buf进行全排列
         *
         * @param buf
         *            要进行全排列的整型数组
         * @param start
         *            开始的下标值
         * @param end
         *            结束下标值
         * @param list
         *            保存最后全排列结果的集合
         */
        private static void allSort(int[] buf, int start, int end, List<int[]> list) {
            if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
                int[] a = new int[buf.length];
                System.arraycopy(buf, 0, a, 0, a.length);
                list.add(a);
            } else {// 多个字母全排列
                for (int i = start; i <= end; i++) {
                    int temp = buf[start];// 交换数组第一个元素与后续的元素
                    buf[start] = buf[i];
                    buf[i] = temp;
                    allSort(buf, start + 1, end, list);// 后续元素递归全排列
                    temp = buf[start];// 将交换后的数组还原
                    buf[start] = buf[i];
                    buf[i] = temp;
                }
            }
        }
}
