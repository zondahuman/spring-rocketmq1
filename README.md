march action

# Rocketmq Note:

 using method:


# Broker
nohup sh mqbroker -n 172.16.2.133:9876 autoCreateTopicEnable=true > ~/logs/rocketmqlogs/broker.log 2>&1 &

# NameSvr
nohup mqnamesrv 1>/opt/alibaba-rocketmq/log/ng.log 2>/opt/alibaba-rocketmq/log/ng-err.log &

# WebConsole
https://github.com/apache/rocketmq-externals.git
cd rocketmq-externals
mvn clean install -Dmaven.test.skip=true -U

java -jar rocketmq-console-ng-1.0.0.jar --server.port=12581 --rocketmq.config.namesrvAddr=172.16.2.133:9876

http://172.16.2.133:12581












