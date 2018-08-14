package com.rick.algorithm.chapter_1;

import com.rick.algorithm.base.StdIn;
import com.rick.algorithm.base.StdOut;
import com.rick.algorithm.base.StdRandom;

import java.util.HashMap;

public class Practice_1 {


    public static void main(String[] args) {
//        _1_1_1();
//        _1_1_2();
//        _1_1_5();
//        _1_1_6();
//        _1_1_7();
//        _1_1_8();
//        _1_1_9();
//        _1_1_11();
//        _1_1_12();
//        _1_1_13();
//        _1_1_14_lg(65);
//        _1_1_16();
//        _1_1_18();
//        _1_1_19();
        _1_1_21();
    }

    public static void _1_1_21() {
        String[] arrs = StdIn.readAllStrings();
        StdOut.println("姓名     分数     最高成绩     比例");
        for (int i = 0; i < arrs.length; i += 3) {
            StdOut.printf("%-7s%-9d%d%7.3f\n", arrs[i],
                    Integer.parseInt(arrs[i + 1]),
                    Integer.parseInt(arrs[i + 2]),
                    Double.parseDouble(arrs[i + 1])
                            / Double.parseDouble(arrs[i + 2]));
        }
    }


    private static HashMap<Integer, Long> FCaches = new HashMap<Integer, Long>();

    public static void _1_1_19() {
        //计算机用这段程序在一个小时之内能够得到F(N) 结果的最大N 值是多少？
        // 49 7778742049
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + F(N));
    }


    /**
     * 计算  斐波那契数
     * <p>
     * F函数是一个树形递归计算模式,
     * 但是对其进行了优化，使用的优化技术应该是记忆技术。
     * <p>
     * 开发F(N) 的一 个更好的实现，用数组保存已经计算过的值。
     * 使用了HashMap，用来缓存数据
     *
     * @param N
     * @return
     */
    public static long F2(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (FCaches.containsKey(N)) {
            return FCaches.get(N);
        }
        long result = F2(N - 1) + F2(N - 2);
        if (!FCaches.containsKey(N)) {
            FCaches.put(N, result);
        }
        return result;
    }

    /**
     * F函数是一个树形递归计算模式
     * <p>
     * F函数是计算  斐波那契数
     *
     * @param N
     * @return
     */
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }


    public static void _1_1_18() {
        //50
//        StdOut.println(mystery(2, 25));

        // 33
//        StdOut.println(mystery(3, 11));

        // 给定正整数a 和b，mystery(a,b)计算的结果是什么?
        // 结果为 a * b


        //将代码中的+ 替换为* 并将return 0 改为return 1，然后回答相同的问题。
        // 33554432
//        StdOut.println(mystery(2, 25));

        // 177147
//        StdOut.println(mystery(3, 11));

        // 给定正整数a 和b，mystery(a,b)计算的结果是什么?
        // a的b次方

        StdOut.println(mystery(3, 3));
    }

    /**
     * 看着像  线性递归计算过程
     * 也像    线性迭代计算过程
     *
     * @param a
     * @param b
     * @return
     */
    public static int mystery(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a * a, b / 2);
        return mystery(a * a, b / 2) * a;
    }


    public static void _1_1_16() {
        StdOut.println(exR1(6));
    }

    /**
     * 树形递归计算模式
     * <p>
     * 斐波那契数
     **/
    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }


    public static void _1_1_14_lg(int N) {
        int sum = 2;
        int log = 1;
        while (sum <= N) {
            sum *= 2;
            log++;
        }
        StdOut.println(log - 1);
    }

    public static void _1_1_13() {
        int[][] intArr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                intArr[i][j] = StdRandom.uniform(2);
            }
        }
        StdOut.println("---变换前---");
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                StdOut.print(intArr[x][y]);
            }
            StdOut.println();
        }
        StdOut.println("---变换后---");
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                StdOut.print(intArr[y][x]);
            }
            StdOut.println();
        }
    }

    public static void _1_1_12() {
        // 元素颠倒顺序, 感觉像是小把戏，但是挺好玩
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.print(i);
    }


    public static void _1_1_11() {
        String[] arrInit = new String[]{"*", " "};
        String[][] booleanArr = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                booleanArr[i][j] = arrInit[StdRandom.uniform(2)];
            }
        }
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                StdOut.print(booleanArr[x][y]);
            }
            StdOut.println();
        }
    }

    public static void _1_1_9() {
        int N = 100;
        //通过求余数的方式，算出N的二进制数据
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        StdOut.println(s);

        // int 类型是4个字节，共32位
        // 通过位运算符中的, 右位移运算符 >> ,位与 & 运算符
        // 判断得出N的二进制数据
        byte[] arr = new byte[32];
        //顺着从N中取值，倒着往arr中存
        for (int i = 31; i >= 0; i--) {
            arr[i] = (byte) (N & 1);
            N >>= 1;
        }
        for (byte b : arr)
            StdOut.print(b);
        StdOut.println();
    }

    /**
     * 参考 ASCII码对照表
     */
    public static void _1_1_8() {
        System.out.println('b');
        System.out.println('b'/*98*/ + 'c'/*99*/);/*197*/
        System.out.println((char) ('a' + 4));
    }

    public static void _1_1_7() {
        /**
         * 这是一个求平方根的算法
         */
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
        //3.00009


        //i循环999次，j循环i+（i+1）...999次
        //总共循环次数大概为999*1000/2=499500次
        //公式：N的平方/2
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
        //499500

        // i = 2的i次方
        //从2的0次方等于1，到2的9次方等于512（2的10次方是1024，比1000大），
        // 总共循环10次；
        //j 每次循环1000次
        //双层嵌套循环总共循环次数，10000次；
        int sum2 = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum2++;
        StdOut.println(sum2);
        //10000
    }


    /**
     * 0
     * 1
     * 1
     * 2
     * 3
     * 5
     * 8
     * 13
     * 21
     * 34
     * 55
     * 89
     * 144
     * 233
     * 377
     * 610
     */
    public static void _1_1_6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void _1_1_5() {
        double x = 0.0, y = 0.0;
        if (0 <= x && x < 1) {
            StdOut.println(true);
        }
    }

    public static void _1_1_3() {
        int[] ints = StdIn.readAllInts();
        if (ints[0] == ints[1] || ints[1] == ints[2]) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }

    public static void _1_1_2() {
        //(1 + 2.236)/2 = 1.618
        StdOut.println((1 + 2.236) / 2);
        //1 + 2 + 3 + 4.0 = 10.0
        StdOut.println(1 + 2 + 3 + 4.0);
        //4.1 >= 4  = true
        StdOut.println(4.1 >= 4);
        //1 + 2 + "3"
        StdOut.println(1 + 2 + "3");
    }


    public static void _1_1_1() {
        // ( 0 + 15 ) / 2 = 7
        int result = (0 + 15) / 2;
        StdOut.println(result);

        //2.0e-6 * 100000000.1 = 200.0000002
        /**
         2.0e-6  是个什么意思咧。。。。
         这个表示方法叫做科学计数法，
         首先这是一个高精度数，
         2.0e-6 = 0.000002
         2.0 表示是一个double类型的数字
         e-6 表示小数点往前走6位
         加起来说的就是：2.0e-6 2.0的小数点往前走6位
         */
        StdOut.println(2.0e-6 * 100000000.1);

        //true && false || true && true
        // 从左往右运行，结果是 true
        //1.true && false 结果是 false
        //2.false || true 结果是 true
        //3.true && true 结果是 true
        StdOut.println(true && false || true && true);
    }


}
