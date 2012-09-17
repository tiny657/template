Skill Set
---------
 - Spring : Java Framework
 - Spring Social : Social Login (facebook)
 - Spring Mobile : Spring Mobile MVC
 - Mybatis : SQL mapping Framework
 - Ehcache : cache Framework
 - Maven : Build & Dependency Management
 - Bootstrap : CSS Framework
 - Tiles2 : JSP Layout Framework
 - Selenium : Automatic Web Browser Test Framework
 - JUnit : Java Test Framework
 - Mockito : Mocking Framework
 - Lombok : Getter/Setter 등 불필요한 코드 생략 가능한 Library
 - MoreUnit : Code, Test Code 이동 툴
 - Emma : Code Coverage 검사 툴
 - Checkstyle : Coding Convention 검사 툴
 - FindBugs : 코드 정적 분석 툴
 
 
Getting Started
---------------
### JDK 설치 ###
```
$ yum install java-1.6.0-openjdk.x86_64 java-1.6.0-openjdk-devel.x86_64
```
참고 : http://www.oracle.com/technetwork/java/javaee/downloads/index.html

### MySQL 설치 ###
```
$ yum install mysql-server
```

MySQL 서버 시작
```
$ service mysqld start
```
참고 : http://dev.mysql.com/downloads/mysql

### Mysql 기본 template DB 생성 ###
	$ mysql -u root -e "CREATE DATABASE template"

### Tomcat 설치 ###
```
$ yum install tomcat6-webapps tomcat6-admin-webapps
```
Tomcat 시작
$ service tomcat6 start

### STS 설치 ###
http://www.springsource.org/downloads/sts
 
### Maven 설치 ###
http://maven.apache.org/download.html

### Lombok 설치 ###
http://projectlombok.org/mavenrepo/index.html

### Project clone ###
sts의 File > Import > Projects from Git > URI 선택 후 아래 설정값을 입력  

	URI : ssh://git@github.com:[ID]/template.git
	Host : github.com
	Repository path : [ID]/template.git
	Protocol : ssh
	Port : 없음
	User : git
	Password : 없음

Import existing projects 시 No projects found 라는 에러가 발생하면 아래 단계를 수행 후 다시 시도  
Package Explorer에서 template 우클릭 > Configure > Convert To Maven Project를 수행하여 maven project로 생성  

### Maven eclipse project 생성 ###
다운로드 받아진 template project에서 경로에서 아래와 같이 입력하여 eclipse project를 생성  

	$ mvn eclipse:eclipse

### Checkstyle 적용 ###
 	sts Package Explorer에서 template project 우클릭 > Checkstyle > Activate Checkstyle
 		
### 브라우저 설치 ###
	Internet Explorer, Chrome, Firefox : Selenium 테스트를 위하여 설치


STS Setting
-----------
### Eclipse Plugin 설치 ###
MoreUnit : http://moreunit.sourceforge.net/update-site

	Ctrl + j : 구현 코드와 테스트 코드 간 이동 방법
	Ctrl + r : 구현 코드에서 테스트코드를 수행
		
Checkstyle : http://eclipse-cs.sf.net/update

	View : Window > Show View > Others > Checkstyle > Checkstyle violations
	
Emma :  http://update.eclemma.org/

	프로젝트 이륾을 우클릭 후 Coverage As > Junit Test 수행 후 아래 view에서 커버리지 확인
	View : Window > Show View > Others > Java > Coverage

FindBugs : http://findbugs.cs.umd.edu/eclipse

	프로젝트 명 우클릭 > Find bugs > Find bugs 수행 후 아래 Bug Explorer에서 정적 분석 결과 확인

### STS의 Java Convention을 기본 템플릿으로 사용함 ###
	Preference > Java > Code Style > Formatter > New > Java Convention를 기반으로 기본 템플릿 생성

### Checkstyle 설정파일 불러오기 ###
	Preference > Checkstyle > New 선택하여 아래 설정대로 입력
	Type : External Configuration File
	Name : tinyCheckstyle
	Location : tinyCheckstyle.xml

### Maximum Line Width : 120 ###
	Preference > Java > Code Style > Formatter > Edit > Line Wrapping > Maximum line width : 120
	Preference > XML > XML Files > Editor > Line width : 120
	Preference > Web > JSP Files > Editor > Line Width : 120 

### Indent 설정 ###
	Preference > Java > Code Style > Formatter > edit > Indentation > 4
	Preference > Java > Code Style > Formatter > edit > Indentation > Tab policy > Tabs only

### Encoding 수정 ###
	Preference > Web > CSS Files > Encoding : ISO 10646/Unicode(UTF-8)
	Preference > Web > HTML Files > Encoding : ISO 10646/Unicode(UTF-8)
	Preference > Web > JSP Files > Encoding : ISO 10646/Unicode(UTF-8)
	Preference > General > Content Types > Text > Java Properties Files > *.properties > UTF-8을 선택 후 Update
	
### 개행문자 (LF 사용, Not CRLF) ###
	Preference > General > Workspace > New text file line delimiter : Unix

### md 파일 editor 설정 ###
	Preferences/General/Editors/File Associations/*.md 파일에 Text Editor 추가

### 자주 쓰는 static import 등록 ###
Preference > Java > Editor > Templates > Favorites > New Type에 클릭 후 아래 내용 추가

	name : ti
	context : java
	description : ti 입력 후 Ctrl + Space 입력 시 아래 package가 자동 import
	pattern : 
	import static org.hamcrest.CoreMatchers.*;
	import static org.junit.Assert.*;
	import static org.junit.matchers.JUnitMatchers.*;
	import static org.mockito.Matchers.*;
	import static org.mockito.Mockito.*;

### static import 에서 *이 풀리지 않게 설정 ###
	Preference > Java > Code Style > Organize Imports > Number of static imports를 1로 설정

### resources 순서 변경 ###
STS에서 local 설정을 적용하기 위해 다음과 같이 설정  
Project Properties > Java Build Path > Order and Export 에서 아래와 같은 순서로 설정 변경  
 	
	src/main/java
	src/main/resources
	src/main/resources-local
	src/main/resources-dev
	src/main/resources-release
	
CentOS
------
### ssh로 War 파일 배포 ###
/usr/share/tomcat6/webapps의 root권한이 필요한 폴더에 ssh로 WAR파일을 배포하기 위하여 아래 부분 수정 필요
/etc/sudoers 파일에 아래 부분 주석 처리함

	Defaults    requiretty
