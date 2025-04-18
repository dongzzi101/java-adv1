
## 섹션 3. 스레드 생성과 실행

### 자바 메모리 구조 복습

| 영역         | 설명 |
|--------------|------|
| 메서드 영역  | 프로그램 실행에 필요한 공통 데이터를 관리하는 영역. 모든 클래스에서 공유됨. 클래스 정보(실행 코드, 필드, 메서드, 생성자 등), static 변수, 런타임 상수 풀 등이 존재함 |
| 스택 영역    | 스레드마다 하나씩 생성되는 실행 스택. 지역 변수, 연산 결과, 메서드 호출 정보 등이 포함됨. 메서드 호출 시 스택 프레임이 쌓이고 종료되면 제거됨 |
| 힙 영역      | 객체와 배열이 생성되는 공간. 가비지 컬렉션 대상이 되는 주요 메모리 영역임 |

- 스택 영역은 스레드마다 별도로 생성됨
- 현재는 스레드 1개 사용 → 스택도 1개
- 스레드 수가 늘어나면 스택도 그 수만큼 늘어남

---

### 스레드 생성

- 스레드를 만드는 방법은 두 가지가 있음
    - Thread 클래스를 상속받는 방식
    - Runnable 인터페이스를 구현하는 방식

- 스레드는 실행 순서와 실행 기간이 보장되지 않음 → 이것이 멀티 스레드의 특징임

---

### start() 메서드

- `start()`는 스레드에 스택 공간을 할당하면서 스레드를 시작함
- 새로운 스레드에서 `run()` 메서드를 실행함
- `run()`만 호출하면 main 스레드에서 실행되기 때문에 반드시 `start()`를 사용해야 별도의 스레드에서 실행됨

---

### 데몬 스레드

| 구분           | 설명 |
|----------------|------|
| 사용자 스레드  | 주요 작업을 담당하는 스레드. 모든 사용자 스레드가 종료돼야 JVM이 종료됨 |
| 데몬 스레드    | 백그라운드에서 보조 작업을 수행함. 사용자 스레드가 모두 종료되면 자동으로 종료됨 |

- `setDaemon(true)`로 설정 가능
- `start()` 실행 전에만 설정 가능
- 기본값은 `false` (즉, 사용자 스레드임)

---

### Thread 상속 vs Runnable 구현

| 방식              | 장점 | 단점 |
|------------------|------|------|
| Thread 상속      | 구현이 간단함 (run 메서드만 재정의하면 됨) | 자바는 단일 상속만 허용 → 다른 클래스 상속 중이라면 사용 불가<br>유연성 떨어짐 |
| Runnable 구현    | 상속 제약 없음<br>실행 코드와 스레드 분리 가능 → 가독성 높음<br>여러 스레드가 동일 Runnable 객체 공유 가능 → 자원 관리 효율적 | Thread에 Runnable 객체를 전달하는 구조라 약간 복잡함 |

---