<img src="http://reactivex.io/assets/Rx_Logo_S.png" align="right"/>

# Reactive Java - RxJava Programming

[RxJava: Reactive Extensions for the JVM](https://github.com/ReactiveX/RxJava)

## [Observable](http://reactivex.io/documentation/ko/observable.html)

<img src="http://reactivex.io/assets/operators/legend.png" width="600"/>

### [just()](http://reactivex.io/documentation/operators/just.html)

create an Observable that emits a particular item

<img src="http://reactivex.io/documentation/operators/images/just.c.png" width="600"/>

인자로 넣은 데이터를 차례로 발행하기 위해 Observable 을 생성한다.

실제 데이터 발행은 subscribe() 를 호출 후 시작한다.

1 - 10 개의 값을 넣을 수 있다. 단 타입은 모두 동일해야 한다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/b1e5b63ff31ffce7dad37027d9b730001576bb14/reactive-java/src/main/java/reactivejava/FirstExample.java)

### [subscribe()](http://reactivex.io/documentation/operators/subscribe.html) 와 Disposable

```java
Disposable subscribe(onNext)
Disposable subscribe(onNext, onError)
Disposable subscribe(onNext, onError, onComplete)
```

onComplete 알림이 왔을때 자동으로 dispose()가 호출되어 Observable
과의 관계를 끊는다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/ee221c9109462c3093d036149eac87bb82d84b05/reactive-java/src/main/java/reactivejava/ObservableNotifications.java)

### [create()](http://reactivex.io/documentation/operators/create.html)

create an Observable from scratch by means of a function

<img src="http://reactivex.io/documentation/operators/images/create.c.png" width="600"/>

just() 와는 달리 데이터를 발행 하려면 onNext()를 직접 호출해야 하며 모든
데이터를 발행 후 반드시 onComplete() 함수를 호출해야 한다.

```java
Observable<T> create(ObservableOnSubscribe<T> source>

public interface ObservableOnSubscribe<T> {
    void subscribe(ObservableEmitter<T> e) throws Exception;
}
```

[Example](https://github.com/JohnSmith19/reactive-java/blob/acbc56cbb27cb4dc4c7e0f50fe0720c6f78e08cc/reactive-java/src/main/java/reactivejava/ObservableCreateExample.java)

### Lambda 표현식

[식별자 없이 실행 가능한 함수 표현식](http://multifrontgarden.tistory.com/124)

[Java 8 Method Reference](https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx)

```java
// Java 8 Method Reference
source.subscribe(System.out::println);

// Lambda Expression
source.subscribe(data -> System.out.println("Result: " + data));

// Anonymous Object
source.subscribe(new Consumer<Integer>() {
    @override
    public void accept(Integer data) throws Exception {
        System.out.println("Result: " + data);
    }
});
```

### [From](http://reactivex.io/documentation/operators/from.html)

convert various other objects and data types into Observables

<img src="http://reactivex.io/documentation/operators/images/from.c.png" width="600"/>

#### fromArray()

배열에 들어있는 데이터를 처리할때는 Observable fromArray 를 사용한다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/1d9e187d1542a4cc4d6d5f21cfb477037950a4ae/reactive-java/src/main/java/reactivejava/ObservableFromArray.java)

#### fromIterable()

Iterator 의 데이터를 처리한다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/c433c441d4bec15606ab80e6a9021913edc17983/reactive-java/src/main/java/reactivejava/ObservableFromIterable.java)

#### fromCallable()

[Callable](http://developer88.tistory.com/87) 데이터를 처리한다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/e11c3f1e22cf82c37dc4ba2a097712638363eed8/reactive-java/src/main/java/reactivejava/observable/ObservableFromCallable.java)

#### fromFuture()

[Future](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Future.html) 데이터를 처리한다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/78545d5d5991a4c2fe859bbd2e82c6d5fc96a8fb/reactive-java/src/main/java/reactivejava/observable/ObservableFromFuture.java)

#### fromPublisher()

[Flow.Publisher<T>](https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/Flow.Publisher.html)

[Example](https://github.com/JohnSmith19/reactive-java/blob/688f3554de934cdad17aae1ff19bdcb2712c5c45/reactive-java/src/main/java/reactivejava/observable/ObservableFromPublisher.java)

## [Single](http://reactivex.io/documentation/ko/single.html)

Single class 는 오직 1 개의 데이터만 발행 하도록 한정한다.

결과가 유일한 서버 API 를 호출할 때 사용할 수 있다.

<img src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/Single.legend.png" width="600"/>

데이터 하나가 발행과 동시에 종료 (onSuccess) 된다. 라이프사이클 함수는 onSuccess(T value) 함수와 onError()

함수로 구성된다.

#### just()

Single 클래스는 Observable 과 거의 같은 방법으로 사용가능 하다

```java
Single<String> source = Single.just("Hello Single");
source.subscribe(System.out::println);
```

[Example](https://github.com/JohnSmith19/reactive-java/blob/20dea2ee4da04107a779db3c65f4abf603471a79/reactive-java/src/main/java/reactivejava/single/SingleExample.java)

## "Hot", "Cold" Observable

### Cold Observable

차가운 Observable 은 Observable 선언 후 just(), from 등을 호출해도 Observer 가 subscribe() 함수를 호출하여 구독하지 않으면 데이터를 발행하지 않는다.

### Hot Observable

뜨거운 Observable 은 구독자의 존재 여부와 관계없이 데이터를 발행하는 Observable 이다. 따라서 여러 구독자를 고려할 수 있다. 구독자는 Observable 에서 발행하는 데이터를 처음부터 모두 수신할 것으로 보장할 수 없다.

차가운 Observable 은 구독자가 구독을 시작하면 준비된 데이터를 처음부터 발행하며 뜨거운 Observable 은 구독한 시점부터 Observable 에서 발행한 값을 받는다.

## [Subject](http://reactivex.io/documentation/ko/subject.html)

차가운 Observable 을 뜨거운 Observable 로 바꿔준다. Subject 의 특성은 Observable 속성과 구독자의 속성이 모두 모여있다. Observable 처럼 데이터를 발행할 수 있고 구독자처럼 발행된 데이터를 바로 처리할 수도 있다.
RxJava 에서는 AsyncSubject, BehaviorSubject, PublishSubject, ReplaySubject 등을 제공한다.

### AsyncSubject

AsyncSubject 는 Observable 에서 발행한 마지막 데이터를 얻어올 수 있는 Subject 이다. 완료되기 전 마지막 데이터에만 관심이 있으며 이전 데이터는 무시한다.

<img src="http://reactivex.io/documentation/operators/images/S.AsyncSubject.e.png" width="600"/>

1.  처음 구독자가 subscribe() 함수를 호출한다.
2.  이후에 red, green 이 발행된 후 두번째 구독자가 subscribe() 함수를 호출한다.
3.  마지막으로 blue 가 발행되고 데이터 발행을 완료(onComplete event) 한다.

완료되기 전까지는 구독자에게 데이터를 전달하지 않다가 완료와 동시에 첫번째와 두번째 구독자에게 마지막 blue 를 발행하고 종료한다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/f7d090e458b00d1cf502dd1fb198747f6f4fb77e/reactive-java/src/main/java/reactivejava/subjects/AsyncSubjectExample.java)

### BehaviorSubject

BehaviorSubject 는 (구독자가) 구독을 하면 가장 최근 값 혹은 기본 값을 넘겨주는 클래스다.

<img src="http://reactivex.io/documentation/operators/images/S.BehaviorSubject.png" width="600"/>

pink 는 BehaviorSubject 를 생성할 때 넘긴 초기값이다. 첫 번째 구독자는 초기값을 받고 다음에 red 부터 수신한다. 두 번째 구독자는 green 이 발행된 이후에 구독 했으므로 green 을 처음 전달 받는다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/e94020ad17fe26f576b6f2d2beac5d3afd2b5c6b/reactive-java/src/main/java/reactivejava/subjects/BehaviorSubjectExample.java)

### PublishSubject

가장 평범한 Subject class. 구독자가 subscribe() 함수를 호출하면 값을 발행하기 시작한다. AsyncSubject 처럼 마지막 값만 발행하거나 BehaviorSubject 처럼 발행한 값이 없을때 기본값을 대신 발행하지도 않는다.
오직 해당 시간에 발생한 데이터를 그대로 구독자에게 전달받는다.

<img src="http://reactivex.io/documentation/operators/images/S.PublishSubject.png" width="600"/>

첫 번째 구독자가 subscribe() 함수를 호출하면 red, green 데이터를 발행한다. 두번째 구독자가 subscribe() 함수를 호출하면 blue 를 발행하고
onComplete 를 호출해 데이터 발행을 완료한다.

첫번째 구독자는 red, green, blue 를 모두 전달 받았으며, 두번째 구독자는 구독한 이후에 발행된 blue 만 전달 받는다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/2812d8c0640e5caecac5c9a1839d712e04ea6723/reactive-java/src/main/java/reactivejava/subjects/PublishSubjectExample.java)

### ReplaySubject

ReplaySubject 는 구독자가 새로 생기면 항상 데이터의 처음부터 끝까지 발행해 주는 것을 보장해준다.
모든 데이터 내용을 저장해두는 과정 중 메모리 누수가 발생할 가능성을 염두에 두고 사용할 때 주의해야 한다.

<img src="http://reactivex.io/documentation/operators/images/S.ReplaySubject.png" width="600"/>

첫번째 구독자가 subscribe() 를 호출하면 red, green 데이터를 발행한다. 두번째 구독자가 subscribe() 를 호출하면 마지막 데이터인 blue 를 발행하고 onComplete() 를 호출해 
데이터 발행을 완료한다. 

첫번째 구독자는 Observable 을 구독한 이후에 발행한 red, green 을 전달받는다. 두번째 구독자가 subscribe() 를 호출하면 지금까지 발행된 red, green 을 바로 전달 받는다.
마지막으로 Subject Class 가  blue 를 발행하면 두 구독자 모두 해당 값을 전달 받는다. 

[Example](https://github.com/JohnSmith19/reactive-java/blob/5b8e97bb2c4f64edacfa20dffc3a5c7edaddb6f9/reactive-java/src/main/java/reactivejava/subjects/ReplaySubjectExample.java)

## ConnectableObservable

ConnectableObservable 은 Subject 클래스처럼 차가운 Observable 을 뜨거운 Observable 로 변환한다. 
Observable 을 여러 구독자에게 공유할 수 있으므로 원 데이터 하나를 여러 구독자에게 동시에 전달할 때 사용한다.
subscribe() 을 호출해도 아무 동작이 일어나지 않으며 connect() 를 호출한 시점부터 subscribe() 를 호출한 구독자에게 데이터를 발행한다.

<img src="http://reactivex.io/documentation/operators/images/publishConnect.c.png" width="600"/>

첫번째와 두번째 구독자가 추가되면 connect() 를 호출에 데이터 발생을 시작한다.
세번째 구독자를 추가한다 이전에 connect() 를 호출 했으므로 세번째 구독자는 다음에 발생하는 데이터를 바로 수신할 수 있다.

[Example](https://github.com/JohnSmith19/reactive-java/blob/12c0cfa2bfd3299dd89016cc4843a172c27269c0/reactive-java/src/main/java/reactivejava/connectable/ConnectableObservableExample.java)

## Testing

### Unit Test

[ObservableTest](https://github.com/JohnSmith19/reactive-java/blob/master/reactive-java/src/main/java/reactivejava/observable/ObservableTest.java)

[SingleTest](https://github.com/JohnSmith19/reactive-java/blob/master/reactive-java/src/main/java/reactivejava/single/SingleTest.java)

[SubjectTest](https://github.com/JohnSmith19/reactive-java/blob/master/reactive-java/src/main/java/reactivejava/subjects/SubjectTest.java)

[ConnectableObservableTest](https://github.com/JohnSmith19/reactive-java/blob/master/reactive-java/src/main/java/reactivejava/connectable/ConnectableObservableTest.java)

### Integration Test

[MainApplication](https://github.com/JohnSmith19/reactive-java/blob/master/reactive-java/src/main/java/MainApplication.java)
