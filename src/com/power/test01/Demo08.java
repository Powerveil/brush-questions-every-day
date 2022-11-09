package com.power.test01;

import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pageSize = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        System.out.println(pageSize);
        System.out.println(operation);
        int[] page = new int[4];
//        int pos = 1;
        for (int i = 0; i < 4; i++) {
            page[i] = i + 1;
        }
        if (pageSize <= 4) {
            ww(pageSize, operation, page);
        } else {
            qq(pageSize, operation, page);
        }
//        for (int i = 0; i < pageSize; i++) {
//            System.out.print(page[i]);
//            if (i != pageSize - 1) {
//                System.out.print(" ");
//            } else {
//                System.out.println();
//            }
//        }
    }

    private static void ww(int pageSize, String operation, int[] page) {
        int cursorPos = 1;
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == 'U') {
                if (cursorPos == 1) {
                    cursorPos = pageSize;
                } else {
                    cursorPos -= 1;
                }
            } else if (operation.charAt(i) == 'D') {
                if (cursorPos == pageSize) {
                    cursorPos = 1;
                } else {
                    cursorPos += 1;
                }
            }
        }

        for (int i = 0; i < pageSize; i++) {
            System.out.print(page[i]);
            if (i != pageSize - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        System.out.println(cursorPos);
//        return cursorPos;
    }

    private static void qq(int pageSize, String operation, int[] page) {
        int cursorPos = 1;
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == 'U') {
                if (cursorPos == 1) {
                    cursorPos = pageSize;
                    for (int j = 0; j < 4; j++) {
                        page[j] = cursorPos - 3 + j;
                    }
                } else {
                    if (cursorPos == page[0]) {
                        for (int j = 0; j < 4; j++) {
                            page[j]--;
                        }
                    }
                    cursorPos -= 1;
                }
            } else if (operation.charAt(i) == 'D') {
                if (cursorPos == pageSize) {
                    cursorPos = 1;
                    for (int j = 0; j < 4; j++) {
                        page[j] = j + 1;
                    }
                } else {
                    if (cursorPos == page[3]) {
                        for (int j = 0; j < 4; j++) {
                            page[j]++;
                        }
                    }
                    cursorPos += 1;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(page[i]);
            if (i != 3) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        System.out.println(cursorPos);
//        return cursorPos;
    }
}
