# How to Create Grid Archive (.gar) for Storing Data Cache

## Pre-requisite

This guide assumes you have already have Linux client. For optimal experience running the installer, provision a Windows compute within the same OCI subnet and run MobaTerm within the Windows server, it's a lot faster.

## Hands on Lab

First thing to do is clone this repo to the client PC
```
cd
git clone https://github.com/tazlambert/coherence-distributed.git
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
To create .gar we need to go to artifacts directory
```
cd artifacts
ls
```
It will shows the directory that will be used during this labs
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
The file above is the first file that will be picked up by coherence and it will read cache config that is named coherence-cache-config.xml, since we are focusing on 3 type of caches:

### Distributed Cache
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
|service-name|DistributedCache|the type of data cache|

### Replicated Cache
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
      <replicated-scheme>
         <scheme-name>datacachescheme</scheme-name>
         <service-name>ReplicatedCache</service-name>
         <backing-map-scheme>
            <local-scheme/>
         </backing-map-scheme>
         <autostart>true</autostart>
      </replicated-scheme>
   </caching-schemes>
</cache-config>
```
Above file is the configuration file that define the cache to store data, below is the explanation
| Key | Value | Descrption |
|-|-|-|
|cache-name|datacache|the name of the cache|
|scheme-name|datacachescheme|the name of the cache confugration|
|service-name|ReplicatedCache|the type of data cache|

### Federated Cache
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
      <federated-scheme>
         <scheme-name>datacachescheme</scheme-name>
         <service-name>FederatedCache</service-name>
         <backing-map-scheme>
            <local-scheme/>
         </backing-map-scheme>
         <autostart>true</autostart>
         <topologies>
	    <topology>
	      <name>MyTopology</name>
	    </topology>
	 </topologies>
      </federated-scheme>
   </caching-schemes>
</cache-config>
```
Above file is the configuration file that define the cache to store data, below is the explanation
| Key | Value | Descrption |
|-|-|-|
|cache-name|datacache|the name of the cache|
|scheme-name|datacachescheme|the name of the cache confugration|
|service-name|FederatedCache|the type of data cache|
|topology<br>name |MyTopology|the name of topology for federated cluster|

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
