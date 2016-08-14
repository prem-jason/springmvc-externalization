# springmvc-externalization

This project gives example of property file externalization i.e. The same jar can be used with external properties file (env.properties) for differnet environments (DEV or IST or UAT or PROD)
You can maintain different folders \User\Enviroment\DEV or \User\Enviroment\IST etc., with env.properties points to those individual environments

copy the env.properties to external location for e.g. \User\Enviroment

set the system property in shell script - setEnv.sh 
export JAVA_OPTS="-Denv=\User\Enviroment"

