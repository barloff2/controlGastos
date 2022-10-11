clear 

#Revisar el .class del todas las clases.
#cd /Library/WebServer/Documents/script/controlDeGastos/WEB-INF/classes/modelo
#javac -cp /Users/mitzymo/Documents/Programs/wildfly-26.1.2.Final/modules/system/layers/base/javax/servlet/api/main/jboss-servlet-api_4.0_spec-2.0.0.Final.jar *.java

#echo -e '\033[0;101m' "modelo.class created." '\033[0m'

#cd /Library/WebServer/Documents/project/ControlDeGastos/WEB-INF/classes

#javac -cp /Users/mitzymo/Documents/Programs/wildfly-26.1.2.Final/modules/system/layers/base/javax/servlet/api/main/jboss-servlet-api_4.0_spec-2.0.0.Final.jar *.java

#echo -e '\033[0;101m' "servlet.class created." '\033[0m'

cd /Library/WebServer/Documents/project/ControlDeGastos

jar -cvf controlDeGastos.war .

echo -e '\033[0;101m' ".war created." '\033[0m'

mv /Library/WebServer/Documents/project/ControlDeGastos/controlDeGastos.war /Users/mitzymo/Documents/Programs/wildfly-26.1.2.Final/standalone/deployments/

echo -e '\033[0;101m' ".was relocated." '\033[0m'

open -a "Brave Browser.app" http://localhost:8080/controlDeGastos

echo -e '\033[0;101m' "File deployed in browser." '\033[0m'