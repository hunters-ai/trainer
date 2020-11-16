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
Create a workflow that runs every 10 minutes and do the following: 
1. Download the list of AWS public IP address ranges, published by Amazon: https://docs.aws.amazon.com/general/latest/gr/aws-ip-ranges.html

2. If the the publication time is newer than that of the last processed file, then process this one (step 3).

- For simplicity's sake, you're allowed to save a state locally on your computer (as a file or whatever you want).

3. Aggregate for every unique pair of [Region, Service] the amount of `ipv6_prefix` and `ip_prefix` (ipv4) records listed in the scanned file.

4. Print the results - it should be visible when looking at Airflow logs. 