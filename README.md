# 🎁 포장의 민족

<p align="center">
  <img src= "https://github.com/Team-SNS/Pojang-BE/assets/78871184/ef7c6f3e-446d-47e8-a4e3-e19b9cd8d6b2" width="100%" height="100%">
</p> 

<br/>

# 📈아키텍처 설계서

## 📍백엔드 아키텍처
![pojang 아키텍처-백엔드 배포 drawio](https://github.com/SimJH99/readme-templete/assets/78871184/2cd5cdce-469e-42f1-8583-29dff81f7510)

## 📍프론트엔드 아키텍처
![pojang 아키텍처-프론트 배포 drawio](https://github.com/SimJH99/readme-templete/assets/78871184/61924dd3-c0e5-450c-ad87-267f43d01bad)

<br/>

# 📝구성스크립트

## Frontend
![image](https://github.com/SimJH99/readme-templete/assets/78871184/c8f53284-351d-45ad-91d6-683c54d8f9e9)

## Docker-compose Backend githubaction yml
![image (1)](https://github.com/SimJH99/readme-templete/assets/78871184/b99df443-11bc-461a-9275-26c8e7a5e547)

## k8s gitaction.yml
![image (2)](https://github.com/SimJH99/readme-templete/assets/78871184/aea71fe4-eb3c-421e-8f20-422c8f47eeee)

## docker-compose.yml
![image (3)](https://github.com/SimJH99/readme-templete/assets/78871184/eae05fd7-581f-4e88-84f3-33691ff58456)


<br/>

# 📈아키텍처 상세문서

## 프론트엔드

### 1. 개요
이 아키텍처는 프론트엔드 정적 웹 애플리케이션의 CI/CD 파이프라인 구축과 높은 가용성, 보안을 위한 구성을 목표로 합니다. 
GitHub 저장소에 코드 변경이 발생할 때마다 자동으로 빌드 및 배포 프로세스가 실행되어 Amazon S3에 정적 웹사이트를 호스팅합니다.
Amazon CloudFront를 통해 전 세계에 콘텐츠를 빠르게 제공하며, AWS Certificate Manager(ACM)에서 발급받은 SSL 인증서를 적용하여 HTTPS를 통한 안전한 접근을 보장합니다.
Amazon Route 53은 도메인 이름 시스템(DNS) 서비스를 제공하여 사용자가 웹 애플리케이션에 쉽게 접근할 수 있도록 합니다.
    
### 2. 주요 컴포넌트
- **GitHub Actions**: GitHub 저장소에 코드 변경이 감지되면 자동으로 빌드 및 배포 프로세스를 실행
- **Amazon S3 버킷**: 빌드된 정적 파일을 호스팅
- **AWS Certificate Manager**: SSL 인증서를 관리합니다. 인증서는 CloudFront 배포에 연결하여 HTTPS 통신을 가능하게 함
- **Amazon CloudFront**: S3 버킷에 호스팅된 정적 웹사이트 앞에 위치하는 CDN 서비스로, 캐싱을 통해 전 세계적으로 빠른 콘텐츠 제공을 가능하게 하며, ACM에서 발급받은 SSL 인증서를 사용하여 안전한 HTTPS 연결을 제공
- **Amazon Route 53**: 웹 애플리케이션의 도메인 이름을 관리하고, CloudFront 배포와 매핑하여 사용자가 웹 애플리케이션에 쉽게 접근할 수 있도록 함
  
<br/>

## 백엔드
### 1. 시스템 개요
본 시스템은 고성능 및 확장 가능한 백엔드 서비스를 제공하기 위해 AWS 클라우드 서비스를 기반으로 구축되었습니다. 주요 서비스 구성 요소로는 Amazon RDS, DockerHub, Amazon EC2, Amazon Route 53, ALB 및 Docker Compose를 포함하며, Spring Boot 기반의 애플리케이션과 Redis를 활용합니다. 그리고 GitHub Actions를 이용한 CI/CD 자동화 프로세스를 포함합니다.

### 2. 구조적 설계

#### 2.1 인프라 구성

- **Amazon RDS**: 데이터의 영속성 관리 및 안정적인 데이터베이스 서비스 제공
- **DockerHub**: 컨테이너 이미지 저장 및 관리
- **Amazon EC2**: 애플리케이션 서버 호스팅
- **Amazon Route 53 및 ALB**: 도메인 관리 및 SSL을 통한 안전한 트래픽 분산
- **Docker Compose**: 애플리케이션과 Redis 서비스의 컨테이너화 및 관리
- **GitHub Actions**: 코드 변경에 따른 자동화된 CI/CD 파이프라인 구현

#### 2.2 애플리케이션 구성

Spring Boot 애플리케이션: 비즈니스 로직 처리 및 RESTful API 제공

#### 2.3 보안 구성

**SSL**: Route 53과 ALB를 통한 암호화된 데이터 전송.

### 3. 기술 스택

- **프로그래밍 언어 및 프레임워크**: Java, Spring Boot
- **데이터베이스**: Amazon RDS, Redis(인메모리)
- **컨테이너**: Docker
- **이미지 저장소**: DockerHub
- **서버**: Amazon EC2
- **로드 밸런서 및 도메인 관리**: Amazon Route 53, ALB
- **보안**: SSL(https)

### 4. 데이터 모델 및 스토리지
- **Amazon RDS**: 관계형 데이터베이스를 사용하여 사용자 정보, 트랜잭션 데이터 등을 저장
- **Redis**: 이메일 인증을 위한 인증코드 저장 및 관리(검증완료 또는 유효시간 만료 시 인증코드 삭제)

### 5. 인터페이스
- **RESTful API**: 클라이언트와 서버 간의 통신을 위한 API
- **Docker Compose**: 서비스 간의 의존성 관리 및 배포 자동화

### 6. 배포
Docker Compose 파일을 사용한 배포: EC2 인스턴스에서 Spring Boot 애플리케이션과 Redis 컨테이너를 동시에 배포 및 관리

### 7. 유지보수 및 확장성
- **컨테이너화**: 애플리케이션 및 서비스의 컨테이너화를 통해 배포, 확장 및 유지보수의 용이성 보장
- **로드 밸런싱**: ALB를 통한 자동 로드 밸런싱과 트래픽 관리를 통해 시스템의 확장성 및 가용성 향상

## k8s
### 1. 개요

본 문서는 백엔드 시스템을 위한 아키텍처 설계에 대한 상세 설명을 제공합니다. 시스템은 Amazon EKS (Elastic Kubernetes Service)를 기반으로, EC2 인스턴스에서 실행되는 워커 노드, AWS Elastic Load Balancer를 통한 Route 53 연결, Amazon ElastiCache (Redis), DockerHub, 그리고 GitHub Actions를 이용한 CI/CD 자동화 프로세스를 포함합니다.

### 2. 인프라 구성

### 2.1 Amazon EKS (Elastic Kubernetes Service)
- 사용 목적
  - 컨테이너화된 애플리케이션의 배포, 관리, 확장을 위한 관리형 Kubernetes 서비스 사용
- 세부 구성
  - 마스터 노드: EKS가 관리하는 Kubernetes 컨트롤 플레인
  - 워커 노드: EC2 인스턴스에 배포된 애플리케이션을 실행하는 노드

### 2.2 AWS Elastic Load Balancer & Route 53

- 사용 목적
  - 애플리케이션에 대한 트래픽 분산 및 도메인 이름을 통한 접근 관리
  
- 세부 구성:
   - Elastic Load Balancer (ELB): 인바운드 트래픽을 EKS 클러스터의 워커 노드에 자동으로 분산
   - Route 53: 사용자 정의 도메인 이름을 ELB와 연결하여 외부 접근성 향상**

### 2.3 Amazon ElastiCache (Redis)
- 사용 목적: 이메일 인증을 위한 인증코드 저장 및 관리(검증완료 또는 유효시간 만료 시 인증코드 삭제)

### 2.4 DockerHub

- 사용 목적: 애플리케이션 컨테이너 이미지의 저장 및 버전 관리
- 세부 구성: 공개 또는 비공개 리포지토리 설정, 이미지 푸시 및 풀 관리

### 2.5 GitHub Actions

- 사용 목적: 코드 변경에 따른 자동화된 CI/CD 파이프라인 구현
  
- 세부 구성
    - CI (Continuous Integration): 코드 커밋 및 푸시 시 자동 빌드 및 테스트 실행
    - CD (Continuous Deployment): 테스트 성공 시 DockerHub로 컨테이너 이미지를 자동 배포 및 EKS 클러스터에 롤아웃

<br/>

## 3. 보안 및 네트워크 설계

### 3.1 네트워크 보안

- 목적
  - 시스템의 보안 강화 및 민감한 데이터 보호
  
- 구현
    - IAM (Identity and Access Management): EKS, EC2, ElastiCache 및 기타 AWS 서비스에 대한 접근 권한 관리
    - 보안 그룹 및 네트워크 ACLs: EC2 인스턴스 및 ElastiCache 클러스터에 대한 인바운드 및 아웃바운드 트래픽 제어
 
<br/>
<br/>
 
