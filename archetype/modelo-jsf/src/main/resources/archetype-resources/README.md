Archetype JPA
=====================

O que é?
-----------

Este é o seu projeto! Trata-se de um projeto exemplo, compilável com Maven 3, preparado para facilitar o desenvolvimento de uma aplicação com Java EE 6 no JBoss Enterprise Application Platform 6 ou JBoss AS 7.1. 

Utilizando este projeto gerado você pode criar facilmente uma aplicação Java EE 6 usando JSF 2.0, PrimeFaces 3.5, CDI 1.0, EJB 3.1, JPA 2.0 e Bean Validation 1.0.

Requerimentos
-------------------

Para compilar este projeto você precisa do Java 6.0 (Java SDK 1.6) ou superior, Maven 3.0 ou superior e ant 1.8.2 ou superior.

A aplicação produzida por este projeto roda na JBoss Enterprise Application Platform 6 ou JBoss AS 7.1. 

 
Configurar Maven
---------------

Se ainda não o fez, você precisa [Configurar o Maven](10.13.30.148:8070/confluence/display/FRW/Maven) antes de começar.


Inicie a JBoss Enterprise Application Platform 6 ou JBoss AS 7.1
-------------------------

1. Abra a linha de comando e vá até a pasta raíz do servidor JBoss.
2. Os comandos a seguir iniciam o servidor:

        Para Linux/Mac:   JBOSS_HOME/bin/standalone.sh
        Para Windows: JBOSS_HOME\bin\standalone.bat


Compilar e implantar via Eclipse
-------------------------

_NOTA: Os comandos a seguir presumem que o ant e o maven estejam configurados corretamente. Se não o fez, [esta é a hora](10.13.30.148:8070/confluence/display/FRW/Maven)._

1. Certifique-se de que o servidor JBoss esteja iniciado corretamente.
2. No Eclipse, exiba a view _Ant_ (Window > View > Ant).
3. Na view Ant, importe o arquivo _build.xml_.
4. Expanda o arquivo importado e dê duplo-clique na task _deploy._
5. O projeto estará pronto para ser acessado.
6. Para desinstalar a aplicação do servidor, utilize a task _undeploy_.

 
Compilar e implantar via linha de comando
-------------------------

_NOTA: Os comandos a seguir presumem que o maven (e opcionalmente o ant) esteja configurado corretamente. Se não o fez, [esta é a hora](10.13.30.148:8070/confluence/display/FRW/Maven)._

1. Certifique-se de que o servidor JBoss esteja iniciado corretamene.
2. Abra a linha de comando e navegue até a raíz do projeto.
3. Utilize o seguinte comando para realizar a implantação no servidor via maven:

        mvn clean package jboss-as:deploy
		
4. Se preferir utilizar o ant, use este comando no lugar do anterior:

		ant deploy

5. O projeto estará pronto para ser acessado.
6. Para desinstalar a aplicação do servidor, utilize o seguinte comando:

		mvn jboss-as:undeploy


Acessar a aplicação
---------------------

A aplicação pode ser acessada pela seguinte URL: <http://localhost:8080/NomeDaAplicacao/>.

Executar os testes com Arquillian 
-------------------------

Este modelo de projeto utiliza o Arquillian para a realização de testes. Por padrão, os testes são pulados na compilação pois precisam de um contêiner.

_NOTA: Os comandos a seguir presumem que o ant e o maven estejam configurados corretamente. Se não o fez, [esta é a hora](10.13.30.148:8070/confluence/display/FRW/Maven)._

1. Certifique-se de que o servidor JBoss esteja iniciado corretamene.
2. Para testar via maven, execute o comando a seguir após acessar a pasta do projeto na linha de comando:

        mvn clean test -Parq-jbossas-remote

3. Para testar via ant, execute a task _test-ejb_.

Debugar a aplicação
---------------------

Se você quer debugar a aplicação ou ver os _javadocs_ de alguma biblioteca, rode qualquer um dos dois comandos a seguir para copiar os fontes no seu repositório:

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc
