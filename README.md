Skill Set
---------
 - Spring : Java Framework
 - Mybatis : SQL maaping Framework
 - Maven : Build & Dependency Management
 - Bootstrap : CSS Framework
 - Tiles2 : JSP Layout Framework
 - JUnit : Java Test Framework
 - Lombok : Getter/Setter 등 불필요한 코드 생략 Library
 - Cobertura : Code Coverage check
 - Checkstyle : Coding Convention check
 
 
Getting Started
---------------
 - jdk 설치  
 
   		http://www.oracle.com/technetwork/java/javaee/downloads/index.html
 
 - sts 설치

   		http://www.springsource.org/downloads/sts
 
 - maven 설치
 
   		http://maven.apache.org/download.html

 - mysql 설치

   		http://dev.mysql.com/downloads/mysql

 - Lombok 설치

   		http://projectlombok.org/mavenrepo/index.html

 - mysql 설정  

   		id : root  
   		pw :

 - mysql 기본 DB 생성

   		DB명 : template

 - project clone

   		git clone https://github.com/tiny657/template.git

 - maven eclipse project 생성

   		mvn eclipse:eclipse로 프로젝트 생성한다.

 - CheckStyle 적용

 		STS Package Explorer에서 project 우클릭 -> CheckStyle -> Activate CheckStyle


STS 환경 설정
-------------------
 - Eclipse Plugin 설치

        MoreUnit : http://moreunit.sourceforge.net/update-site
        Checkstyle : http://eclipse-cs.sf.net/update

 - sts의 Java Convention을 기본 템플릿으로 사용함

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
	
 - LF 사용하기
 
   		Preference -> General -> Workspace -> New text file line delimiter : Unix

 - md 파일 editor 설정하기
 
   		Preferences/General/Editors/File Associations/*.md 파일에 Text Editor 추가