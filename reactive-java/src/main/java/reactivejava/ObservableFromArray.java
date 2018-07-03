package reactivejava;

import io.reactivex.Observable;

import java.util.stream.IntStream;

public class ObservableFromArray {

    private static Integer[] toIntegerArray(int[] inArray) {
        return IntStream.of(inArray).boxed().toArray(Integer[]::new);
    }

    public void fromArray() {
        System.out.println("ObservableFromArray.fromArray");

        /*
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
        */

        // RxJava 에서 int[] 를 사용하기 위해서는 Integer[] 로 변환 해야한다.
        int[] intArray = {400, 500, 600};
        Observable<Integer> source = Observable.fromArray(toIntegerArray(intArray));
        source.subscribe(System.out::println);
    }
}
