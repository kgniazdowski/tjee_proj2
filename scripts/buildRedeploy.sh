#!/bin/sh

echo "************ UNDEPLOYING *******************"
~/glassfish4/bin/asadmin undeploy rowerland
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
~/glassfish4/bin/asadmin deploy target/rowerland.war
