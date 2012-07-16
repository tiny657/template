Skill Set
---------
 - Spring : Java Framework
 - Mybatis : SQL mapping Framework
 - Maven : Build & Dependency Management
 - Bootstrap : CSS Framework
 - Tiles2 : JSP Layout Framework
 - JUnit : Java Test Framework
 - Lombok : Getter/Setter 등 불필요한 코드 생략 가능한 Library
 - Cobertura : Code Coverage 검사 툴
 - Checkstyle : Coding Convention 검사 툴
 - Selenium : Automatic Web Browser Test Framework
 
 
Getting Started
---------------
 - JDK 설치  
 
   		http://www.oracle.com/technetwork/java/javaee/downloads/index.html
 
 - STS 설치

   		http://www.springsource.org/downloads/sts
 
 - Maven 설치
 
   		http://maven.apache.org/download.html

 - Mysql 설치

   		http://dev.mysql.com/downloads/mysql

 - Lombok 설치

		http://projectlombok.org/mavenrepo/index.html

 - Mysql 설정  

		id : root  
		pw :

 - Mysql 기본 template DB 생성

		$ mysql -u root -e "CREATE DATABASE template"

 - Project clone

		sts의 File -> Import -> Projects from Git -> URI 선택 후 아래 설정값을 입력한다.
		URI : ssh://git@github.com:[ID]/template.git
		Host : github.com
		Repository path : [ID]/template.git
		Protocol : ssh
		Port : 없음
		User : git
		Password : 없음

		Import existing projects 시 No projects found 라는 에러가 발생하면 아래 단계를 수행 후 다시 시도한다.
		Package Explorer에서 template 우클릭 -> Configure -> Convert To Maven Project를 수행하여 maven project로 만든다.

 - Maven eclipse project 생성

   		다운로드 받아진 template project에서 경로에서 아래와 같이 입력하여 eclipse project를 생성한다.
        $ mvn eclipse:eclipse

 - Checkstyle 적용

 		sts Package Explorer에서 template project 우클릭 -> Checkstyle -> Activate Checkstyle
 		
 - 브라우저 설치
		
		Internet Explorer, Chrome, Firefox : Selenium 테스트를 위하여 설치함

STS Setting
-------------------
 - Eclipse Plugin 설치

		MoreUnit : http://moreunit.sourceforge.net/update-site
		Checkstyle : http://eclipse-cs.sf.net/update

 - STS의 Java Convention을 기본 템플릿으로 사용함

 		Preference -> Java -> Code Style -> Formatter -> New -> Java Convention를 기반으로 기본 템플릿 생성함.

 - Checkstyle 설정파일 불러오기
 
		Preference -> Checkstyle -> New 선택하여 아래 설정대로 입력함
		Type : External Configuration File
		Name : tinyCheckstyle
		Location : tinyCheckstyle.xml

 - Maximum Line Width : 120  

   		Preference -> Java -> Code Style -> Formatter -> Edit -> Line Wrapping -> Maximum line width : 120
   		Preference -> XML -> XML Files -> Editor -> Line width : 120
   		Preference -> Web -> JSP Files -> Editor -> Line Width : 120 

 - indent 설정

   		Preference -> Java -> Code Style -> Formatter -> edit -> Indentation -> 4
   		Preference -> Java -> Code Style -> Formatter -> edit -> Indentation -> Tab policy -> Tabs only

 - Encoding을 수정함
 
   		Preference -> Web -> CSS Files -> Encoding : ISO 10646/Unicode(UTF-8)
   		Preference -> Web -> HTML Files -> Encoding : ISO 10646/Unicode(UTF-8)
   		Preference -> Web -> JSP Files -> Encoding : ISO 10646/Unicode(UTF-8)
   		Preference -> General -> Content Types -> Text -> Java Properties Files -> *.properties -> UTF-8을 선택 후 Update
	
 - LF 사용하기
 
   		Preference -> General -> Workspace -> New text file line delimiter : Unix

 - md 파일 editor 설정하기
 
   		Preferences/General/Editors/File Associations/*.md 파일에 Text Editor 추가
