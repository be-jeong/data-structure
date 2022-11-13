package com.example.datastructure.basic.search;

import java.util.Scanner;

public class Match {

    static int bfMatch(String text, String path) { // 브루트-포스 법으로 문자열 검색하는 메섣,
        int pointerText = 0;
        int pointerPath = 0;

        while (pointerText != text.length() && pointerPath != path.length()) {
            if(text.charAt(pointerText) == path.charAt(pointerPath)) {
                pointerText++;
                pointerPath++;
            } else {
                pointerText = pointerText - pointerPath + 1;
                pointerPath = 0;
            }
        }

        if(pointerPath == path.length()) {
            return pointerText - pointerPath;
        }

        return -1;
    }

    static int kmpMatch(String text, String pattern) {
        int textPointer = 1; //텍스트 포인터
        int patternPointer = 0; //패턴 포인터
        int[] skip = new int[pattern.length() + 1]; //건너뛰기 표

        skip[textPointer] = 0;

        while (textPointer != pattern.length()) {
            if(pattern.charAt(textPointer) == pattern.charAt(patternPointer)) {
                skip[++textPointer] = ++patternPointer;
            } else if(patternPointer == 0) {
                skip[++textPointer] = patternPointer;
            } else {
                patternPointer = skip[patternPointer];
            }
        }

        textPointer = patternPointer = 0;

        while (textPointer != text.length() && patternPointer != pattern.length()) {
            if(text.charAt(textPointer) == pattern.charAt(patternPointer)) {
                textPointer++;
                patternPointer++;
            } else if (patternPointer == 0) {
                textPointer++;
            } else
                patternPointer = skip[patternPointer];
        }

        if(patternPointer == pattern.length()) {
            return textPointer - patternPointer;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("입력한 텍스트 : ");
        String text = scanner.next();

        System.out.println("패턴 : ");
        String path = scanner.next();

        int bfIdx = bfMatch(text, path);
        int kmpIdx = kmpMatch(text, path);

        if(bfIdx == -1)
            System.out.println("해당 텍스트에 패턴이 없습니다.");

        int length = 0;
        for(int i=0; i<bfIdx; i++) {
            length += text.substring(i, i+1).getBytes().length;
        }
        length += path.length();

        System.out.println((bfIdx + 1) + "번째 부터 일치합니다.");
        System.out.println("텍스트 : " + text);
        System.out.printf(String.format("패턴 : %%%ds\n", length), path);
    }

}
