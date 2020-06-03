# Welcome to Oracle Coherence WebLogic Hands On Lab

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

## Coherence Introduction 

In Coherence there are several type of cache that we can use;

- Distributed Cache – A distributed, or partitioned, cache is a clustered, fault-tolerant cache that has linear scalability. Suitable for read write operations.
- Replicated Cache – A replicated cache is a clustered, fault tolerant cache where data is fully replicated to every member in the cluster. Suitable for small and heavy read operations.
- Federated Cache - A federated cached data is federated across clusters to provide redundancy, off-site backup, and multiple points of access for application users in different geographical locations.
- Optimistic Cache - An optimistic cache is a clustered cache implementation similar to the replicated cache implementation but without any concurrency control.
- Near Cache - A near cache is a hybrid cache; it typically fronts a distributed cache or a remote cache with a local cache.
- View Cache - A view cache is a clustered, fault tolerant cache that provides a local in-memory materialized view of data stored in a distributed and partitioned cache.
- Local Cache - While it is not a clustered service, the local cache implementation is often used in combination with various clustered cache services as part of a near cache.
- Remote Cache - A remote cache describes any out-of-process cache accessed by a Coherence*Extend client.

**For this labs we are going to focus on the first 3 type of caches: Distributed, Replicated, and Federated.**

## Hands On Lab

### [Step 1: Create Grid Archive (.gar) for Storing Data Cache](tutorial/create.data.gar.md)

### [Step 2: Create Grid Archive (.gar) for Proxying Data Cache](tutorial/create.proxy.gar.md)

### [Step 3: Create Web Application Archive (.war) for WebApp Demo](tutorial/create.war.md)

### [Step 4: Create Enterprise Application Archive (.ear) to Enable WebApp Demo Access Data Cache](tutorial/create.ear.md)

### [Step 5: Configure WebLogic-Coherence Cluster for Distributed or Replicated](tutorial/create.wls.data.cache.md)

### [Step 6: Configure WebLogic-Coherence Cluster for Federated Cache](tutorial/create.wls.fed.cache.md)

## References

1. [Oracle Coherence 12.2.1.4 Documentation](https://docs.oracle.com/en/middleware/fusion-middleware/coherence/12.2.1.4/index.html)
2. [Develop Coherence Application on Oracle WebLogic](https://docs.oracle.com/en/middleware/fusion-middleware/weblogic-server/12.2.1.4/wlcoh/index.html)
3. [Oracle Coherence](https://www.oracle.com/pls/topic/lookup?ctx=en/middleware/fusion-middleware/coherence/12.2.1.4&id=COHDG4979)
4. [Oracle Coherence Clusters](https://www.oracle.com/pls/topic/lookup?ctx=en/middleware/fusion-middleware/coherence/12.2.1.4&id=COHDG5163)
5. [Oracle Coherence Caches](https://www.oracle.com/pls/topic/lookup?ctx=en/middleware/fusion-middleware/coherence/12.2.1.4&id=COHDG5049)
