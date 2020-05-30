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

### [Step 1: Create Grid Archive (.gar) for Storing Data Cache](tutorial/create.gar.md)

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
