# 📑 Algorithm Study Curriculum

알고리즘 스터디 문제 풀이 및 코드 리뷰를 위한 저장소입니다.

---

### 📅 주차별 학습 로드맵

| 주차      | 주제                         |    상태    |
| :-------- | :--------------------------- | :--------: |
| **1주차** | 문자열, 누적합, 구현         |  ✅ 완료   |
| **2주차** | 그래프이론, DFS, BFS         | 🏃 진행 중 |
| **3주차** | 완전탐색, 백트래킹           |  📅 예정   |
| **4주차** | 비트마스킹                   |  📅 예정   |
| **5주차** | 그리디, 라인스위핑, 투포인터 |  📅 예정   |
| **6주차** | 이분탐색과 LIS               |  📅 예정   |
| **7주차** | DP                           |  📅 예정   |
| **8주차** | 펜윅트리, 최단거리           |  📅 예정   |

---

### 🛠 스터디 규칙 (Workflow)

#### 1. 레포지토리 운영

- 본 저장소를 각자 **Fork** 하여 개인 저장소로 가져옵니다.
- 개인 저장소에서 작업 후, 원본 저장소의 `main` 브랜치로 **Pull Request(PR)**를 보냅니다.

#### 2. 브랜치 명명 규칙

- **형식:** `[주차]_week-[이름 약자]` (정렬을 위해 주차는 2자리 숫자로 표기)
- **예시:** 1주차 홍길동일 경우 → `01_week-gd`

#### 3. 폴더 구조 및 파일명

- **구조:** `./[주차]_week/[이름 약자]/[문제파일]`
- **예시:** `./01_week/gd/01_example.java`
- 각 주차 폴더 안에 본인의 약자 폴더를 만들고 소스코드를 관리합니다.

#### 4. PR 및 알림

- **PR 제목:** `[n주차] 이름 문제 풀이 제출`
- **슬랙 확인:** `#algo-pr-check` 채널 알림을 통해 팀원들의 PR 제출 여부를 확인하고 리뷰를 진행합니다.

---

### ✍️ 상세 문제 리스트

#### [1주차] 문자열, 누적합, 구현

| 문제 번호 | 문제 이름                        |                       링크                        |
| :-------: | :------------------------------- | :-----------------------------------------------: |
|   2309    | 일곱 난쟁이                      | [바로가기](https://www.acmicpc.net/problem/2309)  |
|   10808   | 알파벳 개수                      | [바로가기](https://www.acmicpc.net/problem/10808) |
|   2979    | 트럭 주차                        | [바로가기](https://www.acmicpc.net/problem/2979)  |
|   10988   | 팰린드롬인지 확인하기            | [바로가기](https://www.acmicpc.net/problem/10988) |
|   1159    | 농구 경기                        | [바로가기](https://www.acmicpc.net/problem/1159)  |
|   11655   | ROT13                            | [바로가기](https://www.acmicpc.net/problem/11655) |
|   9996    | 한국이 그리울 땐 서버에 접속하지 | [바로가기](https://www.acmicpc.net/problem/9996)  |
|   2559    | 수열                             | [바로가기](https://www.acmicpc.net/problem/2559)  |
|   1620    | 나는야 포켓몬 마스터 이다솜      | [바로가기](https://www.acmicpc.net/problem/1620)  |
|   9375    | 패션왕 신해빈                    | [바로가기](https://www.acmicpc.net/problem/9375)  |
|   1213    | 팰린드롬 만들기                  | [바로가기](https://www.acmicpc.net/problem/1213)  |
|   1940    | 주몽                             | [바로가기](https://www.acmicpc.net/problem/1940)  |
|   3986    | 좋은 단어                        | [바로가기](https://www.acmicpc.net/problem/3986)  |
|   1629    | 곱셈                             | [바로가기](https://www.acmicpc.net/problem/1629)  |
|   4375    | 1                                | [바로가기](https://www.acmicpc.net/problem/4375)  |

#### [2주차] 그래프이론, DFS, BFS

| 문제 번호 | 문제 이름         |                       링크                        |
| :-------: | :---------------- | :-----------------------------------------------: |
|   2178    | 미로 탐색         | [바로가기](https://www.acmicpc.net/problem/2178)  |
|   1012    | 유기농 배추       | [바로가기](https://www.acmicpc.net/problem/1012)  |
|   2468    | 안전 영역         | [바로가기](https://www.acmicpc.net/problem/2468)  |
|   2583    | 영역 구하기       | [바로가기](https://www.acmicpc.net/problem/2583)  |
|   1992    | 쿼드트리          | [바로가기](https://www.acmicpc.net/problem/1992)  |
|   2828    | 사과 담기 게임    | [바로가기](https://www.acmicpc.net/problem/2828)  |
|   2910    | 빈도 정렬         | [바로가기](https://www.acmicpc.net/problem/2910)  |
|   4659    | 비밀번호 발음하기 | [바로가기](https://www.acmicpc.net/problem/4659)  |
|   2870    | 수강신청          | [바로가기](https://www.acmicpc.net/problem/2870)  |
|   10709   | 기상캐스터        | [바로가기](https://www.acmicpc.net/problem/10709) |
|   3474    | 거듭제곱          | [바로가기](https://www.acmicpc.net/problem/3474)  |
|   2852    | 경기 기록         | [바로가기](https://www.acmicpc.net/problem/2852)  |
|   1436    | 영화감독 숌       | [바로가기](https://www.acmicpc.net/problem/1436)  |
|   9012    | 괄호              | [바로가기](https://www.acmicpc.net/problem/9012)  |
|   4949    | 균형잡힌 세상     | [바로가기](hhttps://www.acmicpc.net/problem/4949) |
|   14502   | 연구소            | [바로가기](https://www.acmicpc.net/problem/14502) |
|   2636    | 치즈              | [바로가기](https://www.acmicpc.net/problem/2636)  |
|   1068    | 트리              | [바로가기](https://www.acmicpc.net/problem/1068)  |
|   1325    | 효율적인 해킹     | [바로가기](https://www.acmicpc.net/problem/1325)  |
|   17298   | 오큰수            | [바로가기](https://www.acmicpc.net/problem/17298) |
|   13460   | 구슬 탈출 2       | [바로가기](https://www.acmicpc.net/problem/13460) |
