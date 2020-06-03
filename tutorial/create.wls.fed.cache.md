# How to Configure WebLogic-Coherence Cluster for Federated Cache

## Pre-requisite

This guide assumes you have already have installed clustered WebLogic domain 12.2.1.4. Also .gar and .ear file that will be deployed.

## Hands on Lab

We will continue the lab using previous setup for deployment and cluster setup for WebLogic and Coherence. We need to delete the existing deployment first, but make sure all managed server are shutdown first

![alt text](images/CohFed01.jpg)
![alt text](images/CohFed01.jpg)

After delteing the deployment files we need to re-create the .ear and .gar files, this is because the cache configuration must be changed from distributed/replicated to federated cache. If you clone the gir repo from this Hands on Lab then go to directory artifacts.
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
### Create .gar file

Go to directory myFedCache.gar and do the same steps like in the [Step 1](create.data.gar.md)
