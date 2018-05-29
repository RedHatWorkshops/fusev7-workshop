#Fuse Console Setup 


An Fuse console that eases the discovery and management of all Fuse 7 applications deployed on OpenShift. There are two options, one allows you to navigate between several namespace, it requires the cluster-admin role to be created. And one that only looks up one, this is the one we will be doing today.

![Fuse Console](images/71-Step-01.png)


First we will need to create a new project in OpenShift. 

```
oc new-app lab07user<ID>
```

And install an application to be monitored. Go to [71-artifacts/project/myapp](./71-artifacts/project/myapp)

```
clean install fabric8:deploy \
-Dkubernetes.master=<MASTERURL>
-Dkubernetes.namespace=lab07user<ID>
-Dkubernetes.auth.basic.username=<ID>
-Dkubernetes.auth.basic.password=r3dh4t1!
-Dfabric8.mode=openshift
-Dkubernetes.trust.certificates=true
-Dfabric8.build.strategy=s2i
-Dkubernetes.auth.tryServiceAccount=false
-Dfabric8.generator.from=registry.access.redhat.com/fuse7/fuse-java-openshift
-Dfabric8.generator.fromMode=docker
-Dkubernetes.auth.tryKubeConfig=false
```

We need a service account as OAuth client, which only requires admin role in a project to be created. This restricts the Fuse Online console access to this single project, and as such acts as a single tenant deployment. Go to [71-artifacts](./71-artifacts) and run : 

Namespace mode

```
$ oc create -f serviceaccount.yml
```


To deploy the Fuse Online console, go to [71-artifacts](./71-artifacts) and execute the following command:

```
oc new-app -f deployment-namespace.yml \
-p OPENSHIFT_MASTER=<MASTERURL>
```

Login to you OpenShift console, you should be able to see the two application installed.

![Fuse Console](images/71-Step-02.png)

Logon to your Fuse Console by entering the OpenShift credentials. 

![Fuse Console](images/71-Step-03.png)

Congratulations! You have successfully installed Fuse Console.  
![Fuse Console](images/71-Step-04.png)
![Fuse Console](images/71-Step-05.png)
![Fuse Console](images/71-Step-06.png)
