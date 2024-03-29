# Team Intro.

---

안녕하세요. 팀 리더 1명, 백엔드 2명으로 이루어진 Team.Cupid 입니다. Java를 이용하여 다양한 기술 활용과 코드 디자인, 코드 리뷰를 통한 서비스 최적화 과정을 통해 실무 프로젝트 수준의 개발을 목표로 하고 있습니다.

- 리더 : GOLF
- 백엔드
    - 장태현
    - 홍성민
    

# Tech Stack

---

- Back-end : Spring boot 2.7.6 + Java 11 + MarianaDB + JPA + Security + JWT


# Git Flow

---

## GitFlow란?

GitFlow 전략을 사용하여 브랜치를 관리합니다.코드리뷰 : PR을 통해 Merge전 코드리뷰를 진행하여 사전에 발생할 수 있는 문제를 방지함과 동시에 함께 고민하고 개발을 진행합니다.

- Master : 제품으로 출시될 소스를 저장하는 브랜치입니다.
- Develop : 개발이 완료된 부분만 Merge합니다.
- Feature : 기능을 개발하는 브랜치 입니다.
- Hotfixs : Master 브랜치에서 발생한 버그를 수정하는 브랜치입니다.
    
    ![https://user-images.githubusercontent.com/59078557/211580433-6fd943c3-405e-4bb8-b95e-f522fe631278.png](https://user-images.githubusercontent.com/59078557/211580433-6fd943c3-405e-4bb8-b95e-f522fe631278.png)
    

## 작업방식

1. 메인 저장소를 fork 해온다.
2. fork 한 Repository를 clone 한다.
3. git remote add upstream <메인 저장소 주소>를 통해 upstream 설정을 한다.
4. git fetch를 통해 최신 코드를 받아온다
5. upstream/develop 브랜치에서 feature 브랜치를 생성한다.
6. 작업 완료된 fearure 브랜치를 origin 브랜치로 push 한다.
7. 해당 브랜치를 upstream으로 PR을 올린다.
8. 코드 리뷰 진행 후 Merge를 진행한다.
