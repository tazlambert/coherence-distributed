# How to Create Web Application Archive (.war) for WebApp Demo

## Pre-requisite

This guide assumes you have already have Linux client. For optimal experience running the installer, provision a Windows compute within the same OCI subnet and run MobaTerm within the Windows server, it's a lot faster. Make sure the client already installed with Java SDK.

## Hands on Lab

First thing to do is to go the directory of the cloned repo:
```
cd
cd coherence-distributed
ls
```
It will shows the base directory to create the application in step 2
```
drwxrwxr-x. 6 opc opc 4096 Jun  3 07:45 .
drwx------. 7 opc opc 4096 Jun  3 07:44 ..
drwxrwxr-x. 9 opc opc 4096 Jun  3 07:45 artifacts
drwxrwxr-x. 8 opc opc 4096 Jun  3 07:45 .git
-rw-rw-r--. 1 opc opc 1211 Jun  3 07:45 LICENSE
-rw-rw-r--. 1 opc opc 2449 Jun  3 07:45 pom.xml
-rw-rw-r--. 1 opc opc 4370 Jun  3 07:45 README.md
drwxrwxr-x. 3 opc opc   18 Jun  3 07:45 src
drwxrwxr-x. 3 opc opc 4096 Jun  3 07:45 tutorial
```
To create .war we need to have maven command first and install coherence in the local maven repository
```
sudo yum install maven -y
```
Now we can install coherence lib,which located in artifacts dir, into the maven repo, using this command below.
```
mvn install:install-file -DgroupId=com.oracle.coherence -DartifactId=coherence -Dversion=12.2.1-4-0 -Dfile=artifacts/coherence.jar -Dpackaging=jar -DgeneratePom=true
```
We need to take a look at pmo.xml in this repo, one part related about dependency to cherence is like below:
```
		<!-- Coherence dependencies -->
		<dependency>
			<groupId>com.oracle.coherence</groupId>
			<artifactId>coherence</artifactId>
			<version>12.2.1-4-0</version>
			<scope>provided</scope>
		</dependency>
```
With this we will build .war but no coherence.jar will be included in the .war file. Then we can create .war by using these 2 commands:
```
mvn clean install
mvn clean package
```
After that we can see that a new directory named target has just been created
```
total 4808
drwxrwxr-x. 8 opc opc    4096 May 30 14:18 .
drwxrwxr-x. 7 opc opc    4096 May 30 14:18 ..
drwxrwxr-x. 3 opc opc      17 May 30 14:18 classes
drwxrwxr-x. 3 opc opc      25 May 30 14:18 generated-sources
drwxrwxr-x. 2 opc opc      28 May 30 14:18 maven-archiver
drwxrwxr-x. 3 opc opc      35 May 30 14:18 maven-status
drwxrwxr-x. 4 opc opc      54 May 30 14:18 myWebApp-1.0.0
-rw-rw-r--. 1 opc opc 4912291 May 30 14:18 myWebApp-1.0.0.war
drwxrwxr-x. 2 opc opc       6 May 30 14:18 surefire
```
For now keep files myWebApp-1.0.0.war
