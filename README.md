# demo_elasticsearch

**docker network create elasticsearch-network**

**docker run --rm --name elasticsearch-container -p 9200:9200 -p 9300:9300 --network elasticsearch-network -e "discovery.type=single-node" -e "xpack.security.enabled=false" elasticsearch:8.18.0**

**mvn clean install -Dmaven.test.skip=true**

**docker build -t pawan41281/employeeapi:latest .**

**docker run --rm -p 8080:8080 --network elasticsearch-network pawan41281/employeeapi:latest**
