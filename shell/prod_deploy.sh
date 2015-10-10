#!/bin/sh

BASE=/root

TOMCAT_HOME=/opt/apache-tomcat-8.0.26

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
cp $BASE/$CURRENT_PACKAGE $TOMCAT_HOME/webapps
echo "RELEASE PACAKGE: $RELEASE_PACKAGE"
cd $TOMCAT_HOME/webapps
echo "$TOMCAT_HOME/webapps"
mv $CURRENT_PACKAGE $RELEASE_PACKAGE

# start
$TOMCAT_HOME/bin/startup.sh


echo "mm......"

