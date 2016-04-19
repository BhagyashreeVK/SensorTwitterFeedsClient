# SensorTwitterFeedsClient

Project Description: 
Client to consume Sensor Twitter Feeds Web Service

Prerequisites:
1. SensorTwitterFeeds project should be deployed on Tomcat Server
2. Tomcat server should be up and running

Import project from GitHub:
1. Import this project into Eclipse IDE
   a. In Eclipse, Click File -> Import
   b. Under Git folder , select "Projects from Git". Click Next
   c. Select "Clone URI". Click Next.
   d. Paste the below URI of this project in the URI field-
      https://github.com/BhagyashreeVK/SensorTwitterFeedsClient.git  
      Click next
   e. Select "master" branch. Click Next.
   f. Set the destination directory and click next.
   g. Select "import as general project" and click next.
   h. Set the "project name" and click Finish.

Invoking Web Service Operations:
In the WebServiceClient.java class, you can configure a client object 
to invoke different operations by defining the resource url of the operation.
The sample method getTweetsResponse method, sends authentication keys as a query parameter 
using a  multivalued map. This is for demonstration purpose, to show how access tokens can be sent over the URL.
For other operations, access tokens are intialized at server side with default access token keys present at server side.

There are two ways of making web service operation calls using this project.

1. Run "WebServiceClient.java" as Java Application.

2. Open a web browser and access the url to the operations 
   and pass the required parameters through the url
   The base url is "http://localhost:8080/SensorTwitterFeeds/twitterfeeds/"
   Add in below parameters to invoke the operations -
   
   a. getTweets: This operation has one parameter "count"
      "count" is the number of tweets to be returned from the timeline. 
       At the most 200 results can be obtained at a time. 
       An sample operation call would look like 
      "http://localhost:8080/SensorTwitterFeeds/twitterfeeds/getTweets?count=4"
   
   b. searchTweets: This operation has two parameters - the "query" and "count"
      "query" is the search term and "count" is the number of results to be returned.
       At the most 100 results can be obtained at a time.  
       An sample operation call would look like 
      "http://localhost:8080/SensorTwitterFeeds/twitterfeeds/searchTweets?query=Maryland&count=5"  
   
   c. postTweet: This operation has two parameters - the "text" and "media"
      The "text" parameter is the text of the status to be posted.
      The "media" parameter is optional. As of now the web service only supports posting images through this parameter, using the URL of the image. 
      The supported formats are - PNG, JPEG, BMP, WEBP, GIF, Animated GIF
      An sample operation call would look like 
      "http://localhost:8080/SensorTwitterFeeds/twitterfeeds/postTweet?text=TestTweet&media=http://www.tesimages.test-post.jpg"