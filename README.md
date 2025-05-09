# 🏖️ Gahyun Resort Homepage 🏖️  
Spring Framework 기반 리조트 홈페이지 구축 프로젝트  

---

## 📖 목차  
1. [소개](#소개)  
2. [프로젝트 목표](#프로젝트-목표)  
3. [기술 스택](#기술-스택)  
4. [구현 기능](#구현-기능)  
5. [ERD](#erd)  
6. [폴더 구조](#폴더-구조)  
7. [상세 페이지](#상세-페이지)  
8. [프로젝트 팀 및 역할](#프로젝트-팀-및-역할)  
9. [참고 자료](#참고-자료)  

---

## 👀 소개  

### 프로젝트 개요  
- **프로젝트명**: 가현 리조트 홈페이지  
- **목적**: 사용자가 편리하게 리조트를 예약하고 정보를 확인할 수 있는 **직관적이고 반응형인 리조트 홈페이지 구축**  
- **타겟 고객**: 3~4인 가정을 둔 중장년층 부모  
- **기간**: 2024년 8월 21일 ~ 11월 13일  

### 학습 및 프로젝트 목적  
- 이 프로젝트는 **이젠아카데미**에서 진행한 **첫 번째 팀 프로젝트**로, Spring Framework를 활용한 **Spring MVC 아키텍처 학습**에 중점을 두었습니다.  
- **Spring MVC**의 전반적인 흐름과 구조를 이해하고 실습하기 위해 리조트 홈페이지 프로젝트를 주제로 설정하였습니다.  

---

## 📌 프로젝트 목표  

### 주요 목적  
1. 로그인 및 고객 회원가입 기능  
2. 객실 예약 및 조회 시스템 구현  
3. PG사 연동 결제 시스템 구현  
4. 다양한 디바이스에서 최적화된 반응형 디자인 제공  

---

## 🛠️ 기술 스택  

### 💻 Backend  
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white)  
![Spring Framework](https://img.shields.io/badge/Spring_Framework-6DB33F?style=flat&logo=spring&logoColor=white)  

### 🎨 Frontend  
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=html5&logoColor=white)  
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=css3&logoColor=white)  
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=black)  

### 🗃️ Database  
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)  

---

## 🔍 구현 기능  



#### 유저 기능  
- 회원가입 및 로그인  
  - 이메일 인증을 통한 비밀번호 찾기
- 객실 예약  
  - 날짜, 인원, 객실 타입 선택  
  - 잔여 객실 확인 및 예약 기능  
- 객실 결제
  - PG사 연동 결제 시스템

---


## 📂 폴더 구조  
---
```plaintext
Gahyun-Project/
│
├── dev/                    # 주요 소스 코드 폴더
│   ├── config/             # 설정 파일 
│   ├── controller/         # 컨트롤러 
│   ├── dao/                # 데이터 접근 객체 
│   ├── mapper/             # MyBatis 매퍼 파일
│   ├── model/              # DTO 및 모델 파일 
│   └── service/            # 서비스 레이어
│
├── resources/              # 리소스 파일
│   ├── mapper/             # MyBatis XML 매퍼 파일
│   ├── tiles/              # Tiles 설정 파일
│   └── views/              # JSP 뷰 파일
│       ├── layout/         # 레이아웃 JSP
│       ├── inc/            # 공통 헤더/푸터
│       └── pages/          # 개별 페이지 JSP
│
├── webapp/                 # 웹 애플리케이션 폴더
│   ├── css/                # CSS 파일
│   ├── images/             # 이미지 파일
│   ├── js/                 # JavaScript 파일
│   └── remocon/            # 리모콘 UI 리소스
│
└── pom.xml                 # Maven 의존성 파일
```
---

## 📚 참고 자료  
- **[모두투어](https://www.modetour.com)**: 예약 및 결제 시스템 참고  
- **[롯데리조트](https://www.lotteresort.com)**: 객실 관리 UI/UX 참고  

---
## 👨‍💻 Developer
- 오승안 [OurOh](https://github.com/OurOh)
- 오수석 [zoilee](https://github.com/zoilee)
- 이민형 [Minh137](https://github.com/Minh137)
- 제규진 [Ginie-J](https://github.com/Ginie-J)
- 박민정 [vMinJungPark](https://github.com/vMinJungPark)
