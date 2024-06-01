# NAGP Kubernetes

## Overview

This project is a Spring Boot application deployed on a Kubernetes cluster. The application includes a PostgreSQL database, an API tier to view records from the backend tier.

## Repository

The code for this project is hosted on GitHub. You can find the repository at the following link:

[Code Repository]: https://github.com/git-utsav/nagp-pub

## Docker Hub

The Docker images for this project are available on Docker Hub. You can pull the images using the following links:

- Spring Boot Application: [Docker Hub - Spring Boot App](https://hub.docker.com/repository/docker/utsav194/nagp-docker/general)
- PostgreSQL Database: [Docker Hub - PostgreSQL](https://hub.docker.com/_/postgres)

## Service API URL

The Service API tier is accessible at the following URL. You can use this endpoint to view the records from the backend tier:

[Service API URL]: http://34.93.10.112/nagp/all-user

## Screen Recording

A screen recording demonstrating the deployment process, including:

You can watch the video at the following link:

[Screen Recording Video]: https://nagarro-my.sharepoint.com/:f:/p/utsavkumar_tripathi/EvaUI2M71OVLmGN0JcvpNWAB1PFFMJIleu4PhJaZEqgG6Q?e=RjmQ1E

## Kubernetes Services Description

1. Headleass Cluster DB POD created in StatefulService.yaml
2. Deployment is created with min replica of 3 with below mentioned min resource
	resources:
			  requests:
				memory: "500Mi"
				cpu: "300m"
				
3. LoadBalance is to expose pods as there is only 1 deployment with static IP.
4. Horizontal Pod Scaling is done with 3 to 5 pods and tweaked stabilizationWindowSeconds.
