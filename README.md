# Welcome to Oracle Coherence Distributed Hands On Lab

## About this hands-on Hands On Lab ##

This Hands On Lab main purpose is to show how to implement Coherence caching for JAVA application on Oracle WebLogic that hosted on Oracle Cloud Infrastructure. This hands on lab has been tested by June 2020. If you have any questions or inquiries please email me to lambertus.wardana@oracle.com.

## Prerequisites

- [Oracle Cloud Infrastructure](https://cloud.oracle.com/en_US/cloud-infrastructure) enabled account. The tutorial has been tested using [Trial account](https://myservices.us.oraclecloud.com/mycloud/signup)
- Basic understanding on Oracle WebLogic and Linux.
- Basic understanding in JAVA programming language.
- Oracle WebLogic that hosted on OCI either by [Lift and Shift](https://github.com/tazlambert/weblogic-lift-shift) or by [Move and Improve](https://github.com/tazlambert/weblogic-move-improve)
- Access to client PC that based on Linux.

## Overview

In the following steps, you will be setting up a weblogic cluster that spans across two OCI Compute. The steps you will be performing includes:

- Create Grid Archive for storing data cache
- Create Web Application Archive for WebApp demo
- Create Enterprise Application Archive that consists; Grid Archive and Web Application Archive  
- Configure a new WebLogic cluster with 2 managed servers for Coherence cluster that will **store data**
- Configure a new WebLogic cluster with 2 managed servers for Coherence cluster that will **access data**

## Hands On Lab

### Step 1: Create Grid Archive (.gar) for Storing Data Cache

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

### Step 2: Create Web Application Archive (.war) for WebApp Demo

### Step 3: Create Enterprise Application Archive (.ear) to Enable WebApp Demo Access Data Cache

### Step 4: Configure WebLogic-Coherence Cluster to Store Data Cache

### Step 5: Configure WebLogic-Coherence Cluster to Access Data Cache

## References

1. [Oracle Coherence 12.2.1.4 Docuemntation](https://docs.oracle.com/en/middleware/fusion-middleware/coherence/12.2.1.4/index.html)
2. [Develop Coherence Application on Oracle WebLogic](https://docs.oracle.com/en/middleware/fusion-middleware/weblogic-server/12.2.1.4/wlcoh/index.html)
3. [Oracle Coherence](https://www.oracle.com/pls/topic/lookup?ctx=en/middleware/fusion-middleware/coherence/12.2.1.4&id=COHDG4979)
4. [Oracle Coherence Clusters](https://www.oracle.com/pls/topic/lookup?ctx=en/middleware/fusion-middleware/coherence/12.2.1.4&id=COHDG5163)
5. [Oracle Coherence Caches](https://www.oracle.com/pls/topic/lookup?ctx=en/middleware/fusion-middleware/coherence/12.2.1.4&id=COHDG5049)
