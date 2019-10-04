# InsuranceApp

### Dependencias
* Java 1.8
* Maven

### Para executar localmente
````
mvn spring-boot:run
````

### Testes
````
mvn test
````

### Exemplo chamada cURL

Especialidades cadastradas
```json
["Psiquiatria","Alergia","Endoscopia","Homeopatia","Cardiologia","Cirurgia","Neurologia","Ortopedia","Urologia","Radioterapia"]
```
Requisição
````
curl "http://localhost:8080/obterPrestadoresSaude?latitude=-23.955354&longitude=-46.4104784&especialidade=Radioterapia"
````

