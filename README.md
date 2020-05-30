# Welcome to Oracle Coherence Distributed Hands On Lab

## About this hands-on Hands On Lab ##

This Hands On Lab main purpose is to show how to implement Coherence caching for JAVA application on Oracle WebLogic that hosted on Oracle Cloud Infrastructure. This hands on lab has been tested by June 2020. If you have any questions or inquiries please email me to lambertus.wardana@oracle.com.

## Prerequisites

- [Oracle Cloud Infrastructure](https://cloud.oracle.com/en_US/cloud-infrastructure) enabled account. The tutorial has been tested using [Trial account](https://myservices.us.oraclecloud.com/mycloud/signup)
- Basic understanding on Oracle WebLogic and Linux.
- Basic understanding in JAVA programming language.
- Oracle WebLogic that hosted on OCI either by [Lift and Shift](https://github.com/tazlambert/weblogic-lift-shift) or by [Move and Improve](https://github.com/tazlambert/weblogic-move-improve)
- Access to bastion PC on OCI that based on Linux.

## Overview

In the following steps, you will be setting up a weblogic cluster that spans across two OCI Compute. The steps you will be performing includes:

- Create Grid Archive for storing data 
- Create Web Application Archive for WebApp demo
- Create Enterprise Application Archive that consists; Grid Archive and Web Application Archive  
- Configure a new clustered WebLogic Domain with 2 managed servers for Coherence cluster that will **store data**
- Configure a new clustered WebLogic Domain with 2 managed servers for Coherence cluster that will **access data**
- Testing

