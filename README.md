# java-calculator-precourse
# 문자열 덧셈 계산기 ( java-calculator)

## 구현 목표

입력된 문자열에서 숫자를 추출하여 합계를 계산하는 프로그램을 작성한다.

쉼표(,) 또는 콜론(:)으로 구분된 숫자뿐 아니라, 사용자가 지정한 커스텀 구분자(//;\n 형태)를 처리할 수 있어야 한다.

## 기능 목록

1. 입력 처리
2. 구분자 처리
3. 숫자 변환 및 검증
4. 계산 로직
5. 출력

## 예외 처리

빈 문자열 : 0 반환

음수 포함 : IllegalArguementException 발생

숫자 외 입력 : IllegalArguementException 발생

## 커밋 전략

| **Type** | **설명** | **예시** |
| --- | --- | --- |
| **feat** | 새로운 기능 추가 | feat: 기본 구분자(, :) 처리 기능 추가 |
| **fix** | 버그 수정 | fix: 빈 문자열 입력 시 0 반환 오류 수정 |
| **refactor** | 코드 리팩토링 | refactor: parseNumbers 메서드 구조 단순화 |
| **test** | 테스트 코드 추가 | test: 커스텀 구분자 입력 테스트 추가 |
| **docs** | 문서 수정 | docs: README 기능 목록 업데이트 |

## 실행 가이드

```
./gradlew clean test
```

## 개발 환경

- JDK 21
- Gradle Wrapper
- camp.nextstep.edu.missionutils.Console

## 프로그램 실행 예시

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```