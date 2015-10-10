#!/bin/sh

TOMCAT_HOME=/usr/local/opt/apache-tomcat-8.0.26
PROJECT_HOME=/Users/paul/Documents/workspace/MilkTea

CURRENT_PACKAGE=mm-0.0.1-SNAPSHOT.war
RELEASE_PACKAGE=mm.war

echo "Start to deploy mm...."

#shutdown & cleanup
$TOMCAT_HOME/bin/shutdown.sh

cd $TOMCAT_HOME/temp
rm *

cd $TOMCAT_HOME/webapps
rm -r mm*

#deploy package
echo "CURRENT PACKAGE: $CURRENT_PACKAGE"
cp $PROJECT_HOME/target/$CURRENT_PACKAGE $TOMCAT_HOME/webapps
echo "RELEASE PACAKGE: $RELEASE_PACKAGE"
cd $TOMCAT_HOME/webapps
echo "$TOMCAT_HOME/webapps"
mv $CURRENT_PACKAGE $RELEASE_PACKAGE

# start
$TOMCAT_HOME/bin/startup.sh


echo "mm......"

