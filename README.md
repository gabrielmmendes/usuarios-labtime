# usuarios-labtime
#### Projeto para a Seleção Desenvolvedor Tecnológico 2020, feita pela equipe LabTime, com o objetivo de criar uma API para consultar um banco de dados PostgreSQL, após ser modelado para uma base de dados, e devolver um JSON com as informações utilizando Spring Boot.

Resultado alcançado:
```
{
    "content": [
        {
            "codigo": 1,
            "nomeCompleto": "AAA USUÁRIO INATIVO",
            "nomeSocial": "INATIVO",
            "dataNascimento": "28/02/1979",
            "sexo": "M",
            "email": "inativo@labtime.ufg.br",
            "estado": "Goiás",
            "municipio": "Goiânia (capital)",
            "numeroAcessosCurso": 0,
            "situacaoCurso": "Aprovado",
            "dataVinculo": "18/06/2018"
        }
		
		... //mais nove elementos aqui
		
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 10,
    "totalElements": 98,
    "number": 0,
    "size": 10,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 10,
    "first": true,
    "empty": false
}
```
## Tecnologias Utilizadas
- Spring Boot
- JUnit (Framework de testes)
- Hamcrest e Mockito (Framework que automatiza os testes)
- PostgreSQL (Banco de dados)
- Postman (Analise e teste da API REST)
- Git e GitHub (Repositório local e remoto)

## Como rodar a API
Será necessário ter na sua maquina o [Eclipse](https://www.eclipse.org/downloads/) ou o [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) e o banco de dados [PostgreSQL](https://www.postgresql.org/). Quando concluído as instalações basta seguir os passos a seguir:
1. Modelar a [tabela](https://chat.google.com/api/get_attachment_url?url_type=DOWNLOAD_URL&attachment_token=AAUuIGsjoXMM8Jv8mQdpBcZQFr7kMUDoC8U9snF71Qo5wGSao0zKgHnG8Y94elo0nB3AI9KFd%2FWgxzRrMsHvI8D4GQRsgG%2B6uptUpKyMarKVZIkmYVWpe2sCccLSQ%2FExidnnL9NImvhCoQJ6ZEgroZS0B%2BajZX%2BSsWgCbXb1nPDma7AqiLbdqltYoRQxxgH1UWgTpEwztL8xCduPRcxZl51f7Prx%2FB6FCiUfFiHGlgtZddUC%2BYJ%2Bxl86s5LVJIQzdoKYiSaQxFUU6A1nhygK%2BcQfFsNsNpmRMRYUn8B2NlFyryRkzlaCgPKfr7KIdcfG1%2BJWCEJSvN6g%2BkdmTE4z9FJrJMzakyOKUnXErs4YsvRCCuKLb9GhzVAHTvWBO3%2FHctp1we6g8AmpA%2B1IHJzeRW%2BpCfWQBdGHjb5ekRK6cBcA&auto=true) (link para baixar) em uma base de dados PostgreSQL
2. Clone o repositório utilizando o comando: `git clone <https://github.com/gabrielmmendes/usuarios-labtime.git>`
3. Abra sua IDE de preferência e importe o projeto usuarios-labtime, adicione o plugin [Lombok](https://projectlombok.org/) e execute a aplicação
4. Abra seu navegador no link http://localhost:8080/usuarios?page=0

