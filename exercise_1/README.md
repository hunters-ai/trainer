# Trainer
## Welcome!
![](https://i.ibb.co/THF3r0h/hunters-trainer.png)


## Exercise #1 - Airflow
### Scope
The exercise is intended for people who are unfamiliar with Airflow. If you know it already - let us know and another exercise would be tailored for you.

Try doing it as simple as you can, leveraging Airflow builtin features, and minimizing the amount of code.

### Prerequisites
* Python
* Pipenv or an equivalent
* Make what is needed in order to run Airflow locally on your computer. Make sure you can browse to the local webserver and see the Airflow console.
- Note: You should be fine running it using the default and naive executor, which is the LocalExecutor and not messing up with more complicated ones.

### Description
#### Part 1 - Coding
Create a workflow that runs every 10 minutes and do the following: 
1. Download the list of AWS public IP address ranges, published by Amazon: https://docs.aws.amazon.com/general/latest/gr/aws-ip-ranges.html

1. If the publication time is older than the last processed file, this iteration can be halted.
For simplicity's sake, you're allowed to save a state locally on your computer (e.g., simple file).

1. Aggregate for every unique pair of [Region, Service] the amount of `ipv6_prefix` and `ip_prefix` (ipv4) records listed in the scanned file.

1. Print the results - it should be visible when looking at Airflow logs. 

#### Part 2 - For discussion only
We would like to upgrade your code and make it a clean dummy proof solution so that non programmers could easily add similar flows.
1. Which parts of the solution would you make more generic?
1. Would you use a configuration file? What would it contain? In general terms how would you handle it? 