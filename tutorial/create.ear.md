# How to Create Enterprise Application Archive (.ear) to Enable WebApp Demo Access Data Cache

## Pre-requisite

This guide assumes you have already have Linux client. For optimal experience running the installer, provision a Windows compute within the same OCI subnet and run MobaTerm within the Windows server, it's a lot faster. Make sure the client already installed with Java SDK.

## Hands on Lab

First thing to do is to go the directory of the cloned repo:
```
cd
cd coherence-distributed/artifacts
ls
```
It will shows the directory artifacts:
```
drwxrwxr-x. 9 opc opc     4096 Jun  3 07:45 .
drwxrwxr-x. 6 opc opc     4096 Jun  3 07:45 ..
-rw-rw-r--. 1 opc opc 13505055 Jun  3 07:45 coherence.jar
drwxrwxr-x. 2 opc opc       69 Jun  3 07:45 cohOverride
drwxrwxr-x. 3 opc opc       40 Jun  3 07:45 javaCode
drwxrwxr-x. 3 opc opc       22 Jun  3 07:45 myApp.ear
drwxrwxr-x. 3 opc opc       22 Jun  3 07:45 myCache.gar
drwxrwxr-x. 3 opc opc       22 Jun  3 07:45 myFedApp.ear
drwxrwxr-x. 3 opc opc       22 Jun  3 07:45 myFedCache.gar
drwxrwxr-x. 3 opc opc       22 Jun  3 07:45 myFedCacheProxy.gar
```
To create .ear we need to go inside myApp.ear directory and copy previous .gar and .ear files into it.
```
cd myApp.ear
cp ../myCache.gar/myCache.gar .
cp ../../target/myWebApp-1.0.0.war myWebApp.war
ls
```
This will make the directory structure will be like this
```
[opc@bastion1 myApp.ear]$ tree .
.
├── META-INF
│   ├── application.xml
│   └── weblogic-application.xml
├── myCache.gar
└── myWebApp.war

1 directory, 4 files
```
Now we need to understand 2 xml files inside META-INF directory, the first one is application.xml that have content like this:
```
<?xml version="1.0" encoding="UTF-8"?>
<application>
  <display-name></display-name>
  <module>
    <web>
      <web-uri>myWebApp.war</web-uri>
      <context-root>demo</context-root>
    </web>
  </module>
</application>
```
This will tell that the .ear file will host web application from myWebApp.war with context root demo which make to access the web application http://IP:PORT/demo. Next file is weblogic-application.xml that will have content like this:
```
<?xml version="1.0"?>
<weblogic-application xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://xmlns.oracle.com/weblogic/weblogic-application
   http://xmlns.oracle.com/weblogic/weblogic-application/1.6/
   weblogic-application.xsd"
   xmlns="http://xmlns.oracle.com/weblogic/weblogic-application">
   <module>
      <name>myCache</name>
      <type>GAR</type>
      <path>myCache.gar</path>
   </module>
</weblogic-application>
```
This will tell that .ear file will have module coherence cache by including .gar file in it. After that we need to execute this command to create .ear file:
```
jar cvf myApp.ear *
```
Which will give output like this:
```
ignoring entry META-INF/
adding: META-INF/application.xml(in = 228) (out= 143)(deflated 37%)
adding: META-INF/weblogic-application.xml(in = 462) (out= 207)(deflated 55%)
adding: myCache.gar(in = 1298) (out= 966)(deflated 25%)
adding: myWebApp.war(in = 4912291) (out= 4910245)(deflated 0%)
```
In this directory new file is created named myApp.ear that can be saved for deployment later.
