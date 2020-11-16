# Trainer
## Welcome!
![](https://i.ibb.co/THF3r0h/hunters-trainer.png)


## Exercise #2 - Spark

### Description

We have a huge snapshot of all the domains in the world and their features, i.e. things we know about them.
We would like to create a batch job that every hour merges a new batch of domains and their features (aka update), some could be new domains that do not exist in the snapshot and some could be existing domains that already appear in the snapshot.
* Size of snapshot: 10TB
* Size of new batch of domains that need to be merged: 10MB

An example schema for the data: 

```
val snapshotSchema = new StructType()
    .add(“domain”, StringType)
    .add(“features”, MapType(StringType, DoubleType))
```

We would like features to propagate from father domain, e.g. `paypal.com` to subdomain, e.g. `signing.paypal.com`. But not the other way around.
In case of conflict, where a domain appears in both the snapshot and the update and some features appear in both - you should take the newer features from the update (but make sure to not lose existing features).

Example:
```
paypal.com
signing.paypal.com
app.paypal.com
stream.app.paypal.com
malicious.my-paypal.com
```

In the above example, features should  only propagate:
1. from paypal.com to all 3 subdomains: signing.paypal.com, app.paypal.com, stream.app.paypal.com
2. from  app.paypal.com to stream.app.paypal.com


The data in the snapshot may vary - some domains may have a huge number of sub domains (one domain could take 10% of the snapshot) and some domains may have no subdomains at all.

Example of features: 
```
number_of_resolved_ips=10
dns_record_ttl_seconds=86400
distinct_users_per_hour=120
entropy=0.75
...
```

Please write down all of your considerations in comments - why you chose certain paths.
Be careful not to hit "out of memory" exceptions in production!

### How to run

Please fill the implementation in [Logic::newSnapsho()](src/main/scala/com/example/exercise/Logic.scala)

In order to run with the example inputs you can run: [MyTest](src/test/scala/com/example/exercise/MyTest.scala)

Do note that the example json files are only for help and the solution should represent much bigger data sets in Production (see numbers above).

