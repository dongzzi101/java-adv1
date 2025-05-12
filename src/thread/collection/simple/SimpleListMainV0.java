package thread.collection.simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleListMainV0 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // thread1, thread2 동시에 실행 가정
        list.add("a"); // 쓰레드 1 실행 가정
        list.add("b"); // 쓰레드 2 실행 가정
        System.out.println(list);
    }
}
