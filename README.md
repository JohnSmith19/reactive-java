<img src="http://reactivex.io/assets/Rx_Logo_S.png" align="right"/>

# Reactive Java - RxJava Programming

[RxJava: Reactive Extensions for the JVM](https://github.com/ReactiveX/RxJava)

## [Observable](http://reactivex.io/documentation/ko/observable.html)

<img src="http://reactivex.io/assets/operators/legend.png" width="600"/>

### [just()](http://reactivex.io/documentation/operators/just.html)

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

just() 와는 달리 데이터를 발행하려면 onNext()를 직접 호출해야 하며 모든
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

[Example](https://github.com/JohnSmith19/reactive-java/blob/f82763afe8623b760698ee926d6c31a67193ca43/reactive-java/src/main/java/reactivejava/subjects/AsyncSubjectExample.java)

## Testing

### Unit Test

[ObservableTest](https://github.com/JohnSmith19/reactive-java/blob/01b1c6d8cf62c74f612b843926f579e8ef8871e1/reactive-java/src/main/java/reactivejava/observable/ObservableTest.java)

[SingleTest](https://github.com/JohnSmith19/reactive-java/blob/20dea2ee4da04107a779db3c65f4abf603471a79/reactive-java/src/main/java/reactivejava/single/SingleTest.java)

### Integration Test

[MainApplication](https://github.com/JohnSmith19/reactive-java/blob/01b1c6d8cf62c74f612b843926f579e8ef8871e1/reactive-java/src/main/java/MainApplication.java)
