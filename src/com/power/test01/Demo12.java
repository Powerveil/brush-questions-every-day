package com.power.test01;

import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo12 {
    private static int N = 30;
    private static int M = 60;
    private static int MAX;

    public static void main(String[] args) {
//        System.out.println(N);

        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
//174094882455171152761423221685761892795431233411387427793198
//650286024865090061389344606618496378829135984076361542097372
//601657541200146071777733599818266038012509478351201640618984
//143988087783837107349651099683484992553337438088068198972282
//890781586124258626539246182119762952003918195325258677229419
//698255491250839396799769357665825441616335532825361862146291
//503649293440596342887581257444442930778730382520372975343211
//325351222640703400531067500454956482168314849207060705673849
//265774579830223671554026061117300483012903885770893074783710
//083450145620356667677191627276513995926532444279237315785832
//411595106453089134746365281031552217482363035280722591085079
//053410485925413958279617719034175332412908745680774313630190
//429314820559328748143552689295945058801322270313370955837837
//939182801848609300876356583948397645861551964542532682663945
//625356614462682551015176002433628234343684739800880514363921
//982340231989891351425389287014819359798014755509282450440511
//590838726938103384801541373585690893606978941566666714061214
//952341523168827712604946036245881214982452998386986623826275
//782780208928205527678781609589000725521486468983551558405472
//149903035076783644195574734088152324666290493119955560594634
//905391288186024902215444250421277955403412298227858394469856
//607272647132163832860126054679347881638761723785858733108109
//249157334220127702410373959720286708183036202841837581704881
//367895556630088230650972282944827258473951902831431040790814
//079538232104075905120989173307660289899942087873076421916033
//622143260549608274076012938515668898707915863945382394851328
//164677964192631597026176253407553188801750590935427267220117
//591817866992665840378311257621611574856498432538327068011953
//631534031790352912617015229051836886166704989498756486878095
//690013558017746707412183571476823027885971347137127534455141

        System.out.println("=================================");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("=================================");
        ww(0,0,arr,arr[0][0]);
        System.out.println(MAX);

    }

    private static void ww(int i, int j, int[][] arr, int number) {
        if (i >= N || j >= M) return;
        number += arr[i][j];
        if (i == N - 1 && j == M - 1) {
            if (number > MAX) {
                MAX = number;
            }
            return;
        }
        ww(i + 1, j, arr, number);
        ww(i, j + 1, arr, number);
    }

}
