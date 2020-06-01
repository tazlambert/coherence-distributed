# How to Create Grid Archive (.gar) for Accessing Data Cache Outside Coherence Cluster

## Pre-requisite

This guide assumes you have already have Linux client. For optimal experience running the installer, provision a Windows compute within the same OCI subnet and run MobaTerm within the Windows server, it's a lot faster.

## Hands on Lab

This .gar will be deployed to separated MS but inside the Coherence cluster, and it have the function as proxy to access Coherence cluster data from application that is not joining Coherence Cluster.

First thing to do is to create directory named myProxyCache.gar and META-INF dir inside. Also create 2 empty files named coherence-application.xml and coherence-cache-config.xml. Now we go to directory myCache.gar and make sure the directory structure like this:
```
[opc@bastion1 artifacts]$ tree myProxyCache.gar
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
      <proxy-scheme>	  
         <service-name>ExtendTcpProxyService</service-name>
         <thread-count>10</thread-count>
         <acceptor-config>
            <tcp-acceptor>
               <local-address>
                  <address>localhost</address>
                  <port>1111</port>
               </local-address>
            </tcp-acceptor>
         </acceptor-config>
         <autostart>true</autostart>
      </proxy-scheme>
   </caching-schemes>
</cache-config>
```
Above file is the configuration file that define the cache to store data, below is the explanation
| Key | Value | Descrption |
|-|-|-|
|cache-name|datacache|the name of the cache|
|scheme-name|datacachescheme|the name of the cache confugration|
|service-name|DistributedCache|the type of data cache|
|local-address<br>address|localhost|the IP that will be access by client outside cluster|
|local-address<br>port|1111|the port that will be access by client outside cluster|

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
      <proxy-scheme>	  
         <service-name>ExtendTcpProxyService</service-name>
         <thread-count>10</thread-count>
         <acceptor-config>
            <tcp-acceptor>
               <local-address>
                  <address>localhost</address>
                  <port>1111</port>
               </local-address>
            </tcp-acceptor>
         </acceptor-config>
         <autostart>true</autostart>
      </proxy-scheme>
   </caching-schemes>
</cache-config>
```
Above file is the configuration file that define the cache to store data, below is the explanation
| Key | Value | Descrption |
|-|-|-|
|cache-name|datacache|the name of the cache|
|scheme-name|datacachescheme|the name of the cache confugration|
|service-name|ReplicatedCache|the type of data cache|
|local-address<br>address|localhost|the IP that will be access by client outside cluster|
|local-address<br>port|1111|the port that will be access by client outside cluster|

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
      <proxy-scheme>	  
         <service-name>ExtendTcpProxyService</service-name>
         <thread-count>10</thread-count>
         <acceptor-config>
            <tcp-acceptor>
               <local-address>
                  <address>localhost</address>
                  <port>1111</port>
               </local-address>
            </tcp-acceptor>
         </acceptor-config>
         <autostart>true</autostart>
      </proxy-scheme>
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
|local-address<br>address|localhost|the IP that will be access by client outside cluster|
|local-address<br>port|1111|the port that will be access by client outside cluster|

After that we can package the directory into .gar file:
```
cd myProxyCache.gar
jar cvf myProxyCache.gar *
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
[opc@bastion1 artifacts]$ tree myProxyCache.gar
myProxyCache.gar
├── META-INF
│   ├── coherence-application.xml
│   └── coherence-cache-config.xml
└── myProxyCache.gar

1 directory, 3 files
```
For now keep files myProxyCache.gar
