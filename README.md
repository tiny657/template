Skill Set
---------
 - Spring : Java Framework
 - Mybatis : SQL maaping Framework
 - Maven : Build & Dependency Management
 - Bootstrap : CSS Framework
 - Tiles2 : JSP Layout Framework
 - JUnit : Test Framework
 - Lombok : Getter/Setter 등 불필요한 코드 생략 Library
 
 
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
 
 
 
Develop Environment
-------------------
 - sts의 Java Convention을 기본 템플릿으로 사용하고 아래 내용 수정함

 - Maximum Line Width : 120  
 
   		Preference -> Java -> Code Style -> Formatter -> Edit -> Line Wrapping -> Maximum line width : 120
   		Preference -> XML -> XML Files -> Editor -> Line width : 120
   		Preference -> Web -> JSP Files -> Editor -> Line Width : 120 

 - indent 설정
 
   		Preference -> Java -> Code Style -> Formatter -> edit -> Indentation -> 4
   		Preference -> Java -> Code Style -> Formatter -> edit -> Indentation -> Tab policy -> Tabs only
	
 - sts의 Encoding을 수정함
 
   		Preference -> Web -> CSS Files -> Encoding : ISO 10646/Unicode(UTF-8)
   		Preference -> Web -> HTML Files -> Encoding : ISO 10646/Unicode(UTF-8)
   		Preference -> Web -> JSP Files -> Encoding : ISO 10646/Unicode(UTF-8)
	
 - LF 사용하기
 
   		Preference -> General -> Workspace -> New text file line delimiter : Unix

 - etc파일 eclipse editor 사용하기
 
   		Preferences/General/Editors/File Associations/*.md 파일에 Text Editor 추가
	
 - MoreUnit eclipse plugin 설치
 
   		http://moreunit.sourceforge.net/update-site