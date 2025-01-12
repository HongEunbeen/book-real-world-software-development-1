# 입출금 내역 분석기 요구 사항

- [ ] 은행 입출금 내역의 총 수입과 총 지출은 각각 얼마인가? 결과가 양수인가 음수인가?
- [ ] 특정 달엔 몇 건의 입출금 내역이 발생했는가?
- [ ] 지출이 가장 높은 상위 10건은 무엇인가?
- [ ] 돈을 가장 많이 소비하는 항목은 무엇인가?

# final 변수
final 변수 사용의 장점
- 어떤 객체의 상태가 바뀔 수 있고, 어떤 객체의 상태가 바뀔 수 없는지 명확하게 구분할 수 있다.

final 키워드 적용해도 객체가 바뀌지 못하도록 강요 불가

- final 필드로 가리키는 객체라도 가변상태를 포함하기 때문

추상 메서드에서는 final 키워드의 의미가 무력화 된다.

# 코드 유지보수성과 안티 패턴

- 특정 기능을 담당하는 코드를 쉽게 찾을 수 있어야 한다.
- 코드가 어떤 일을 수행하는지 쉽게 이해할 수 있어야 한다.
- 새로운 기능을 쉽게 추가하거나 기존 기능을 쉽게 제거할 수 있어야 한다.
- 캡슐화가 잘 되어 있어야 한다. 즉, 코드 사용자에게는 세부 구현 내용잉 감춰져 있으므로 사용자가 쉽게 코드를 이해하고, 기능을 바꿀 수 있어야 한다.

## 코드 복사, 붙여넣기 안티패턴의 문제점
- 한 개의 거대한 갓 클래스 때문에 코드를 이해하기 어렵다.
- 코드 중복 때문에 불안정하고 변화에 쉽게 망가진다.

### 갓 클래스 안티패턴
- 한 클래스로 모든 것을 해결하는 패턴
- 한 개의 파일에 모든 코드를 구현하는 방식으로 목적 무엇인지 이해 어려움

### 코드 중복 안티패턴 
- 코드가 중복되어있어 기존의 기능 변경 어려움
    - 중복 배체 원칙으로 반복을 제거하면 로직을 바꿔도 여러 곳의 코드 바궈야 할 필요성 없음

결론적으로 코드 간결 유지하는것도 중요하지만, KISS 원칙 남용하지 않는것도 중요
- 한 문제를 작은 개별 문제로 분리해 더 쉽게 관리할 수 있는지 파악하기

# 단일 책임 원칙(SRP)
쉽게 관리하고 유지보수하는 코드를 구현하는데 도움을 주는 포괄적인 소프트웨어 개발 지침
- 한 클래스는 한 기능만 책임진다.
- 클래스가 바뀌어야 하는 이유는 오직 하나여야 한다.
    - 코드가 바뀌는 이유가 한 가지가 아니라면, 여러 장소에서 변경이 발생해 유지보수 어려워짐

### SRP 적용 대상
- 클래스
- 메서드
SRP는 한 가지 특정 동작, 개념, 카테고리와 관련된다!
  
### SRP 적용 방법
Main 클래스의 여러 책임을 개별로 분리
1. 입력 읽기
2. 주어진 형식의 입력 파싱 
3. 결과 처리
4. 결과 요약 리포트

- BankStatementCSVParser
  - 파싱 기능을 위임 받았고, 이 기능을 독립적으로 구현
  - 새로운 요구 사항 발생 시, 캡슐화된 기능을 재사용해 구현 가능
- BankTransaction
  - 다른 코드가 특정 데이터 형식에 의존하지 않는다.
- BankStatementAnalyzer(Main)
  - 파싱 알로기즘 동작 방식 변경 발생 시 한 곳의 코드만 변경 가능

# 놀람 최소화 원칙(principle of least surprise)
누군가가 놀라지 않도록 일관성을 유지하는 범위에서 코드를 구현할 것을 강조하는 원칙으로 원칙

- 메서드가 수행하는 일을 바로 이해할 수 있도록 자체 문서화를 제공하는 메서드명을 사용한다.
- 코드의 다른 부분이 파라미터의 상태에 의존할 수 있으므로 파라미터의 상태를 바꾸지 않는다.

하지만 주관적인 개념으로 확신이 서지 않는다면 동료와 함께 의논 필요

# 응집도
- KISS
- DRY
- SRP

코드 품질과 관련한 특성으로 서로 어떻게 관련되어 있는지를 가르킨다. 응집도는 클래스나 메서드의 책임이 서로 얼마나 강하게 연결되어 있는지 측정한다.
즉, 어떤 것이 여기저기에 모두 속해 있는지를 말한다.
- 소프트웨어의 복잡성을 유추하는데 도움
- 코드 유지보수성을 결정하는 중요한 개념
- 누구나 쉽게 코드를 찾고, 이해하고, 사용할 수 있도록 만든다.

## 응집도 개념 적용
- 클래스(클래스 수준 응집도)
- 메서드(메서드 수준 응집도)

`BankStatementAnalyzer`

다양한 부분을 연결하는 클래스이지만 계산 로직 정적 메서드로 선언되어 있음
- 계산 관련 작업은 파싱이나 결과 전송과 직접적인 관련 없음 -> 응집도 떨어짐

### 클래스 수준 응집도

일반적으로 여섯 가지 방법으로 그룹화
- 기능
- 정보
- 유틸리티
- 논리
- 순차
- 시간

그룹화하는 메서드의 관련성이 약하면 응집도는 낮아진다.

#### 기능
기능이 비슷한 메서드를 그룹화하는 방법 
- 장점 : 함께 사용하는 메서드를 그룹화하면 찾기도 쉽고 이해하기 쉬워 응집도를 높인다.
- 단점 : 한 개의 메서드르 갖는 클래스를 과도하게 만들려는 경향으로 코드가 장황해지고 복잡해진다.

#### 정보
같은 데이터나 도메인 객체를 처리하는 메서드를 그룹화하는 방법
- 예시 : 특정 객체 CURD를 제공하는 클래스 안에서 관련 정보 응집하는 클래스(DAO)
- 장점 : 유지보수하기 쉽다.
- 단점 : 필요한 일부 기능을 포함하는 클래스 전체를 디펜던시로 추가한다.(불필요한 디펜던시까지도!)

#### 유틸리티
관련성이 없는 메서드, 특히 메서드가 어디에 속해야 할지 결정 어려울 때는 유틸리티 클래스에 추가하는 방법
- 장점 : 간단히 추가 가능
- 단점 : 메서드가 서로 연관성이 없기에 클래스 전체의 기능 추론 어렵고, 특징을 찾기 어려워 클래스의 책임을 파악하기 어렵다.

-> 관련성이 없는 여러 메서드를 명확하지 않는 기준으로 그룹화하므로 이 원칙을 거스른다?

#### 논리
특정 논리로 그룹화하는 방법
- 예시 : JSON, CSV, XML 자료를 '파싱'하는 메서드를 한 클래스로 그룹화
- 장점 : 높은 수준의 카테고리화 제공
- 단점 : 본직적으로 다르므로 메서드는 서로 관련이 없어 클래스는 여러개의 책임을 가지게 되며 SRP를 위배한다.

#### 순차
입출력이 순차적으로 흐르는 것을 순차 응집
- 예시 : 파일을 읽고, 파싱하고, 처리하고, 정보를 저장하는 메서드들을 한 클래스로 그룹화
- 장점 : 여러 동작이 어떻게 함께 수행되는지 쉽게 이해할 수 있고 관련 동작을 찾기 쉽다.
- 단점 : 한 클래스를 바꿔야 할 여러 이유가 존재하므로 SRP를 위배하고 클래스를 순식간에 복잡하게 만든다.
-> 개별적으로 응집된 클래스로 분리하는 것이 더 좋은 방법!

#### 시간
여러 연산 중 시간과 관련된 연산을 그룹화하는 방법
- 예시 : 처리 작업을 시작하기 전 초기화, 후 뒤정리 작업 담당 메서드 포함 클래스
- 장점 : 판단 불가
- 단점 : 각 동작을 이해하고 사용하기 어렵다(초기화 작업은 다른 작업보다 먼저 실행해야 한다는 점)

### 메서드 수준 응집도
메서드가 다양한 기능을 수행할수록 메서드가 어떤 동작을 하느지 이해하기 어려워짐
-> 메서드가 연관 없는 일 처리 = 응집도 낮아짐

#### 메서드가 응집도가 낮으면
- 여러 책임을 포함하기에 각 책임을 테스트하기 어려움
- 메서드의 책임도 테스트 어려움

# 결합도(coupling)
- 응집도 : 클래스, 패키지, 메서드 등의 동작이 얼마나 관련되어 있는가
- 결합도 : 어떤 클래스를 구현하는데 얼마나 많은 지식(다른 클래스)을 참조했는가

한 기능이 다른 클래스에 얼마나 의존하고 있는지를 가늠하 결합도는 코드가 서로 어떻게 의존하는지와 관련이 있는 척도이다.

코드 구현시에는 결합도를 낮춰야 한다. = 코드의 다양한 컴포넌트가 내부와 세부 구현에 의존하지 않아야 함을 의미한다.

더 많은 클래스를 참조했다면 기능 변경시 유연성 떨어짐 -> 의존하는 모든 클래스가 영향 받기 때문!

### 결합도 예시
시계 어떻게 동작하는지 몰라도 시간 알아내는데 문제 없음

-> 사람은 시계 내부 구조에 의존하지 않기 때문

인터페이스와 구현이 서로 결합되지 않았기 때문이데 시계 내부 구조를 바꾸더라도 사람이 시계 읽는데 영향 받지 않는다.

### 인터페이스와 구현
인터페이스를 이용하면 요구 사항이 바뀌더라도 유연성을 유지할 수 있다. 즉, 결합도를 제거할 수 있다.

# 테스트
고객의 요구 사항을 충족했음을 보장할 수 있는 테스트

-> 자바 테스트 프레임워크에서 인기 있고 많이 사용하는 제이유닛 이용

## 테스트 자동화
수동 테스트에만 의존하면 안 된다. 자동화된 테스트에서 사람의 조작 없이 여러 테스트가 포함된 스위트가 자동으로 실행된다.

코드를 변경했을 때, 지정된 테스트가 빠르게 실행되므로 소프트웨어가 예상하지 못한 문제를 일으키지 않고 제대로 동작할 거라는 확신 가질 수 있다.!

### 테스트 자동화 장점
#### 확신
고객의 요구 사항을 충족하고 있다는 사실을 더욱 확신할 수 있다. 테스트 구격 사양 결과를 고객에게 증거 제공 가능할 수 있다. 즉, 테스트가 고객의 사양이 된다.
#### 변화에도 튼튼함 유지
바꾼 코드로 인해 새로운 버그가 발생하지 않았음을 확인하는 데 큰 도움이 된다.
#### 프로그램 이해도
소스코드의 프로젝트에서 다양한 컴포넌트가 어떻게 동작하는지 이해하는데 도움을 준다.다양한 컴포넌트의 디펜던시와 이들이 어떻게 상호작용하는지 명확히 드러내기에 소프트웨어의 전체 개요를 빠르게 파악가능하다.

## 제이유닛
유닛 테스트 : 메서드나 작은 클래스처럼 작고 고립된 단위(유닛)를 테스트하는 방법

###테스트 메서드 저장
- `src/main/java` : 코드 저장
- `src/test/java` : 테스트 클래스 저장

-> 메이븐과 그레이들 빌드 도구에서의 기본 규칙

###Junit Assert 구문
제이유닛은 특정 조건을 테스트하는 다양한 Assert 구문(정적 메서드)을 제공한다. 이 Assert 구문으로 어떤 연산의 결과와 사용자가 예상한 결과를 비교할 수 있다.

###Given-When-Then
1. 테스트의 콘텍스트를 설정한다.
2. 동작을 실행한다.
3. 예상된 결과를 어서션으로 지정한다.

테스트가 무엇을 수행하는지 쉽게 이해하기 위해 테스트를 세 부분으로 분리하는 것이 좋다.

### 코드 커버리지
테스트 집합이 소프트웨어의 소스코드를 얼마나 테스트했는가를 가리키는 척도

#### 커버리지 목표
커버리지가 높을수록 예상치 못한 버그 발생할 확률 낮아짐

70 ~ 90 퍼센트 목표 -> 100 퍼센트까지는 무모한 일(테스트 필요 없는 메서드 존재)

하지만! 테스트하지 않은 부분이 남아 있음을 알려주는 역할로 테스트 품질과는 관련 없음!
-> 소프트웨어 잘 테스트 하고 있음을 의미하는거 X

자코코, 에마, 코베르투라 같은 코드 커버리지 도구 많이 사용

#### 분기, 구문 커버리지
구문 커버리지는 얼마나 많은 구문의 코드를 커버했는지 의미 -> 분기문을 한 구문으로 취급하는 단점 존재

분기문에는 가능한 여러 개의 경로 존재로 구문 커버리지보다 각 분기문 확인하는 분기 커버리지 사용 추

# 정리
- 갓 클래스와 코드 중복은 코드를 추론하고 유지보수하기 어렵게 만드는 요인이다.
- 단일 책임 원칙은 관리하고 유지보수하기 쉬운 코드를 구현하는데 도움을 준다.
- 응집도는 클래스나 메서드의 책임이 마나 강하게 연관되어 있는지를 가리킨다.
- 결합도는 클래스가 다른 코드 부분에 얼마나 의존하고 있느지를 가리킨다.
- 높은 응집도와 낮은 결합도는 유지보수가 가능한 코드가 가져야 할 특징이다.
- 자동화된 테스트 스위트는 소프트웨어가 올바로 동작하며, 코드를 수정해도 잘 동작할 것임을 확신할 수 있고, 프로그램을 쉽게 이해할 수 있도록 도움을 준다.
- 자바 테스트 프레임워크로 제이유닛을 활용해 메서드와 클래스의 동작을 테스트하는 유닛 테스트를 만든다.
- 테스트를 쉽게 이해할 수 있도록 Given-When-Then 패턴으로 유닛 테스트를 세 부분으로 분리하는 것이 좋다.