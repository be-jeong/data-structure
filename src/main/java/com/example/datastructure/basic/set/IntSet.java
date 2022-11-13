package com.example.datastructure.basic.set;

public class IntSet {

    private int max; //집합 최대 개수
    private int num; //집합 요소 개수
    private int[] set; // 집합 본체

    public IntSet(int capacity) {
        num = 0;
        max = capacity;

        try {
            set = new int[max]; // 집합 배열 생성
        } catch (OutOfMemoryError e) { // 배열 생성 실패
            max = 0;
        }
    }

    public int capacity() { //집합 최대 개수
        return max;
    }

    public int size() { //집합 요소개수
        return num;
    }

    public int indexOf(int n) { //배열 인덱스 찾는 메서드
        for(int i=0; i<n; i++) {
            if(set[i] == n) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(int n) { // 해당 집합에 해당 요소가 있는지 없는지 메서드
        return indexOf(n) != -1;
    }

    public boolean add(int n) {
        if(num >= max || contains(n)) { // 가득 찼거든 이미 안에있으면 추가 불가
            return false;
        } else {
            set[num++] = n; // 가장 마지막자리에 추가한다
            return true;
        }
    }

    public boolean remove(int n) { // 집합에서 해당 요소 삭제하기 메서드
        int idx; // n이 저장된 요소의 인덱스

        if(num <= 0 || (idx = indexOf(n)) == -1) { // 이미 집합이 비어있거나 n이 존재하지 않습니다.
            return false;
        } else { // 마지막 요소를 삭제한 곳으로 옮김
            set[idx] = set[--num];
            return true;
        }
    }

    public void copyTo(IntSet s) {
        int n = Math.min(s.max, num); // 복사할 요소의 개수

        for(int i=0; i<n; i++) {
            s.set[i] = set[i];
        }

        s.num = n;
    }

    public void copyFrom(IntSet s) {
        int n = Math.min(max, s.num);

        for(int i=0; i<n; i++) {
            set[i] = s.set[i];
        }

        num = n;
    }

    public boolean equalTo(IntSet s) {
        if(num != s.num) {
            return false;
        }

        for(int i=0; i<num; i++) {
            int j = 0;
            for(; j<s.num; j++) {
                if(set[i] == s.set[i]) {
                    break;
                }
            }
            if(j == s.num) {
                return false;
            }
        }

        return true;
    }

    public void unionOf(IntSet s1, IntSet s2) { // 집합 s1과 s2의 합집합을 복사
        copyFrom(s1);

        for(int i=0; i<s2.num; i++) {
            add(s2.set[i]);
        }

    }

    public String toString() {
        StringBuffer sb = new StringBuffer("{ ");

        for(int i=0; i<num; i++) {
            sb.append(set[i] + " ");
        }

        sb.append("}");

        return sb.toString();
    }
}
