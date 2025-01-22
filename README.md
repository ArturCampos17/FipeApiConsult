# Fipe API Consult - Java Application

Este projeto é uma aplicação Java que consulta os preços da Tabela Fipe através de uma API pública. A aplicação permite que o usuário forneça informações sobre o tipo de veículo, código da marca, modelo e ano, e exibe os dados retornados pela API no formato JSON.

## 🚀 Funcionalidades

- Consulta preços de veículos da Tabela Fipe.
- Suporte para carros, motos e caminhões.
- Retorno de informações detalhadas sobre o veículo, como preço médio, marca e modelo.


## 🛠️ Pré-requisitos

1. *Java 11 ou superior*:
   - Certifique-se de que o Java está instalado corretamente.
   - Verifique a versão do Java com o comando:
     bash
     java -version
     

2. *Editor de texto ou IDE*:
   - Use uma IDE como IntelliJ IDEA, Eclipse ou um editor como VS Code.

3. *Conexão com a Internet*:
   - Necessária para realizar consultas na API.

---

## 🔧 Como Executar o Projeto

### 1. Clone o repositório ou baixe os arquivos

bash
git clone https://github.com/seu-usuario/fipe-api-project.git
cd fipe-api-project


### 2. Compile o programa

No terminal, use o seguinte comando para compilar o código-fonte:

bash
javac -d bin src/main/java/com/exemplo/fipe/FipeApiConsult.java


### 3. Execute o programa

Após a compilação, execute o programa com o comando:

bash
java -cp bin com.exemplo.fipe.FipeApiConsult


---

## 📋 Exemplo de Uso

1. Execute o programa.
2. Insira as informações solicitadas:
   - Tipo de veículo: carros, motos ou caminhoes
   - Código da marca: Exemplo: 21 (Fiat)
   - Código do modelo: Exemplo: 4828 (Uno)
   - Ano do modelo: Exemplo: 2013-1

3. O programa retornará informações detalhadas sobre o veículo:

json
{
  "Valor": "R$ 25.000,00",
  "Marca": "Fiat",
  "Modelo": "Uno",
  "AnoModelo": 2013,
  "Combustivel": "Gasolina",
  "CodigoFipe": "001234-5",
  "MesReferencia": "Janeiro de 2025",
  "TipoVeiculo": 1,
  "SiglaCombustivel": "G"
}


---

## 🌐 API Utilizada

O projeto utiliza a API gratuita [Fipe API](https://deividfortuna.github.io/fipe/), que fornece dados da Tabela Fipe no formato JSON.

### Endpoints principais:

- *Buscar marcas:*
  
  GET https://parallelum.com.br/fipe/api/v1/{tipo}/marcas
  
- *Buscar modelos:*
  
  GET https://parallelum.com.br/fipe/api/v1/{tipo}/marcas/{codigoMarca}/modelos
  
- *Buscar anos:*
  
  GET https://parallelum.com.br/fipe/api/v1/{tipo}/marcas/{codigoMarca}/modelos/{codigoModelo}/anos
  
- *Consultar preço:*
  
  GET https://parallelum.com.br/fipe/api/v1/{tipo}/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{anoModelo}
  

---

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias no projeto.

1. Faça um fork do repositório.
2. Crie uma branch para sua feature:
   bash
   git checkout -b minha-feature
   
3. Commit suas mudanças:
   bash
   git commit -m 'Adiciona nova feature'
   
4. Envie para o repositório remoto:
   bash
   git push origin minha-feature
   
5. Abra um pull request.

---

## 📜 Licença

Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.

---

## 💡 Notas

- Caso você encontre algum problema com a API, verifique se ela está online e se os parâmetros foram fornecidos corretamente.
- Para mais informações, consulte a [documentação oficial](https://deividfortuna.github.io/fipe/).

---

## ✉️ Contato

Para dúvidas ou sugestões, entre em contato:
- Nome: Artur Campos Pereira
- E-mail: arturp282@gmail.com
- GitHub: https://github.com/ArturCampos17
