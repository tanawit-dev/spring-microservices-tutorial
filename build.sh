projects="discovery-server config-server api-gateway employee-service department-service organization-service"

for project in $projects
do
    mvn -f $project/pom.xml clean package -DskipTests
    docker build -t tanawit17/$project $project/
done