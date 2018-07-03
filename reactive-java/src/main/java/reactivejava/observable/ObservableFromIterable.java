package reactivejava.observable;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import reactivejava.common.Order;

public class ObservableFromIterable {
    public void fromIterable() {
        System.out.println("ObservableFromIterable::fromIterable()");

        fromList();
        fromSet();
        fromBlockingQueue();
    }

    // fromIterable from List
    public void fromList() {
        System.out.println("fromList()");

        List<String> names = new ArrayList<>();
        names.add("Jerry");
        names.add("William");
        names.add("Bob");

        Observable<String> source = Observable.fromIterable(names);
        source.subscribe(System.out::println);
    }

    // Iterable from Set
    public void fromSet() {
        System.out.println("fromSet()");

        Set<String> cities = new HashSet<>();
        cities.add("Seoul");
        cities.add("London");
        cities.add("Paris");

        Observable<String> source = Observable.fromIterable(cities);
        source.subscribe(System.out::println);
    }

    // Iterable from BlockingQueue
    public void fromBlockingQueue() {
        System.out.println("fromBlockingQueue()");

        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
        orderQueue.add(new Order("ORD-1"));
        orderQueue.add(new Order("ORD-2"));
        orderQueue.add(new Order("ORD-3"));

        Observable<Order> source = Observable.fromIterable(orderQueue);
        source.subscribe(order -> System.out.println(order.getId()));
    }

}
