# How to Create Grid Archive (.gar) for Storing Data Cache

## Pre-requisite

This guide assumes you have already have Linux client. For optimal experience running the installer, provision a Windows compute within the same OCI subnet and run MobaTerm within the Windows server, it's a lot faster.

## Hands on Lab

First thing to do is clone this repo to the client PC
```
cd
git clone https://github.com/tazlambert/coherence-distributed.git
cd coherence-dsitributed
ls
```
It will shows the base directory to create the application in step 2
```
[opc@bastion1 coherence-distributed]$ ls -al
total 20
drwxrwxr-x.  5 opc opc   93 May 30 07:49 .
drwx------. 30 opc opc 4096 May 30 07:49 ..
drwxrwxr-x.  6 opc opc   77 May 30 07:49 artifacts
drwxrwxr-x.  8 opc opc 4096 May 30 07:49 .git
-rw-rw-r--.  1 opc opc 1211 May 30 07:49 LICENSE
-rw-rw-r--.  1 opc opc 2449 May 30 07:49 pom.xml
-rw-rw-r--.  1 opc opc 2604 May 30 07:49 README.md
drwxrwxr-x.  3 opc opc   18 May 30 07:49 src
```
To create .gar we need to go to artifacts directory
```
cd artifacts
ls
```
It will shows the directory that will be used during this labs
```
[opc@bastion1 artifacts]$ ls -al
total 0
drwxrwxr-x. 6 opc opc 77 May 30 07:49 .
drwxrwxr-x. 5 opc opc 93 May 30 07:49 ..
drwxrwxr-x. 2 opc opc 69 May 30 07:49 cohOverride
drwxrwxr-x. 3 opc opc 40 May 30 07:49 javaCode
drwxrwxr-x. 3 opc opc 22 May 30 07:49 myApp.ear
drwxrwxr-x. 3 opc opc 22 May 30 07:49 myCache.gar
```
Now we go to directory myCache.gar and make sure the directory structure like this:
```
[opc@bastion1 artifacts]$ tree myCache.gar
myCache.gar
└── META-INF
    ├── coherence-application.xml
    └── coherence-cache-config.xml

1 directory, 2 files
```
The content of coherence-application.xml will be like below:
```
<?xml version = '1.0' encoding = 'windows-1252'?>
<coherence-application xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                       xsi:schemaLocation="http://xmlns.oracle.com/coherence/coherence-application http://xmlns.oracle.com/coherence/coherence-application/1.0/coherence-application.xsd"
                       xmlns="http://xmlns.oracle.com/coherence/coherence-application">
   <cache-configuration-ref>META-INF/coherence-cache-config.xml
   </cache-configuration-ref>
</coherence-application>
```
The file above is the first file that will be picked up by coherence and it will read cache config that is named coherence-cache-config.xml, which the content is:
```
<?xml version="1.0"?>
<cache-config xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns='http://xmlns.oracle.com/coherence/coherence-cache-config' xsi:schemaLocation='http://xmlns.oracle.com/coherence/coherence-cache-config coherence-cache-config.xsd'>
   <scope-name>datacache</scope-name>

   <caching-scheme-mapping>
      <cache-mapping>
         <cache-name>datacache</cache-name>
         <scheme-name>datacachescheme</scheme-name>
      </cache-mapping>
   </caching-scheme-mapping>

   <caching-schemes>
      <distributed-scheme>
         <scheme-name>datacachescheme</scheme-name>
         <service-name>DistributedCache</service-name>
         <backing-map-scheme>
            <local-scheme/>
         </backing-map-scheme>
         <autostart>true</autostart>
      </distributed-scheme>
   </caching-schemes>
</cache-config>
```
Above file is the configuration file that define the cache to store data, below is the explanation
| Key | Value | Descrption |
|-|-|-|
|cache-name|datacache|the name of the cache|
|scheme-name|datacachescheme|the name of the cache confugration|
|service-name|DistributedCache|the mechanism on how data being stored, can be; replicated, distributed, federated|

After that we can package the directory into .gar file:
```
cd myCache.gar
jar cvf myCache.gar *
```
The expected result will be
```
added manifest
ignoring entry META-INF/
adding: META-INF/coherence-application.xml(in = 520) (out= 212)(deflated 59%)
adding: META-INF/coherence-cache-config.xml(in = 1478) (out= 435)(deflated 70%)
```
A new file is created inside the directory that will be deployed later:
```
[opc@bastion1 artifacts]$ tree myCache.gar
myCache.gar
├── META-INF
│   ├── coherence-application.xml
│   └── coherence-cache-config.xml
└── myCache.gar

1 directory, 3 files
```
For now keep files myCache.gar
