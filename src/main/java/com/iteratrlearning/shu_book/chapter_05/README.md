# 5장 비즈니스 규칙 엔진

## 도전 과제
- 모든 비즈니스 기능이 어떤 조건에 따라 액션을 유발하는 규칙을 정의할 수 있어야 한다는 사실을 알게되어 비즈니스 팀과 기술팀이 비즈니스 규칙 엔진을 직접 구현하기로 했다.

## 비즈니스 규칙 엔진 요구 사항
비즈니스 규칙 엔진은 간단한 맞춤 언어를 사용해 한 개 이상의 비즈니스 규칙을 실행하는 소프트웨어로 다양한 컴포넌트로 동시에 지원한다.
- 팩트 : 규칙이 활인할 수 있는 정보
- 액션 : 수행하려는 동작
- 조건 : 액션을 언제 발생시킬지 지정
- 규칙 : 실행하려는 비즈니스 규칙을 저정, 보통 팩트, 액션, 조건을 한 그룹으로 묶어 규칙으로 만듬

## 테스트 주도 개발
- 액션 추가
- 액션 실행
- 기본 보고

기본 기능을 기본 API로 변경한 후 실행할 수 있는 코드로 액션을 만든다.

이때, Runnable 인터페이스를 사용하는 방법도 있지만 도메인을 반영해 Action이라는 인터페이스를 만들어 비즈니스 규칙 엔진과 구체적 액션의 결합을 제거하는게 좋다.

Action 인터페이스는 한 개의 추상 메서드만 선언하므로 함수형 인터페이스 애너테이션을 추가할 수 있다.

### TDD를 사용하는 이유
- 테스트를 따로 구현하므로 테스트에 대응하는 요구 사항을 한 개씩 구현할 때마다 필요한 요구사항에 집중하고 개선 가능
- 코드를 올바르게 조직할 수 있다.(테스트를 구현하며 코드에 어떤 공개 인터페이스를 만들어야 하는지 검토 가능)
- TDD 주기에 따라 요구 사항 구현을 반복하며 종합적인 테스트 스위트 완성으로 요구사항 만족 및 버그 발생 범위 줄어듬
- 테스트 통과 위한 코드 구현으로 필요 없는 테스트 구현을 줄일 수 있음

### TDD 주기
1. 실패하는 테스트 구현
2. 모든 테스트 실행
3. 기능이 동작하도록 코드 구현
4. 모든 테스트 실행

-> 리팩터링이 추가되면 모든 테스트 실행 후 리팩터링을 한다.

## 모킹
모킹은 비즈니스 규칙에 액션을 추가할 때마다 실행되었는지 확인한다.

자바의 유명한 모킹 라이브러리인 모키토를 이용해 모킹을 사용한다.
1. 목 생성
2. 메서드가 호출되었는지 확인

정적 메서드 `mock()`으로 필요한 목 객체를 만드록 특정 동작이 실행되었는지 확인합니다.

```Java
final Action mockAction = mock(Action.class);
```
mock()메서드에 Action 객체를 인수로 전달해 유닛 테스트로 Action의 목 객체를 만듬

- 모키토를 이용해 메서드가 몇 번 호출되었는지, 어떤 인수가 제공되었는지 등 조금 더 복잡한 검증 로직도 실행할 수 있다.
