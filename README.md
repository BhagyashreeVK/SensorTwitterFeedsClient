# SensorTwitterFeedsClient

Project Description: 
Client to consume Sensor Twitter Feeds Web Service

Prerequisites:
1. SensorTwitterFeeds project should be deployed on Tomcat Server
2. Tomcat server should be up and running

Invoking Web Service Operations:
In the WebServiceClient.java class, you can configure a client object 
to invoke different operations by defining the resource url of the operation.
The sample method getTweetsResponse method, sends authentication keys as a query parameter 
using a  multivalued map.