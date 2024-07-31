# Rohit ahuja dev - simple key generator written in java

## objective
Generate cryptography keys in java and save them in a file. <br/>
Use them later for your cryptography operations - encryption, decryption

## how to build
clone the project and run maven build using command`mvn clean package`<br/>
This project uses maven assembly plugin and creates a single jar with all the dependencies inside folder 
> target\simple-key-generator-1.0-SNAPSHOT-jar-with-dependencies.jar

## Run the application and paramters
Run the generate using command :- <br/>
`java -jar simple-key-generator-1.0-SNAPSHOT-jar-with-dependencies.jar CIPHER KEY_SIZE STORAGE_LOCATION` <br/>
Examples :-
>java -jar simple-key-generator-1.0-SNAPSHOT-jar-with-dependencies.jar AES 256 E:/ <br/>
>java -jar simple-key-generator-1.0-SNAPSHOT-jar-with-dependencies.jar AES 256 E:/
## Supported algos
It supports algorithms that are supported JDK KeyGenerator and KeyPairGenerator class for symmetric and asymmetric cryptography respectively.<br/>
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/javax/crypto/KeyGenerator.html <br/>
https://docs.oracle.com/en%2Fjava%2Fjavase%2F11%2Fdocs%2Fapi%2F%2F/java.base/java/security/KeyPairGenerator.html
