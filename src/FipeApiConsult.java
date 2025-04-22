import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
//import org.json.JSONArray;
//import org.json.JSONObject;

public class FipeApiConsult {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        boolean continuar = true;

        while (continuar) {
            String tipoVeiculo = "";
            label:
            while (true) {

                System.out.println("Escolha o tipo de veicuo:");
                System.out.println(" 1 - Carro");
                System.out.println(" 2 - Moto");
                System.out.println(" 3 - Caminhão");
                System.out.println("Digite a opção: ");
                String opcao = scanner.nextLine();

                switch (opcao) {
                    case "1":
                        tipoVeiculo = "carros";
                        break label;
                    case "2":
                        tipoVeiculo = "motos";
                        break label;
                    case "3":
                        tipoVeiculo = "caminhao";
                        break label;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

            }
            String apiUrlMarcas = String.format(
                    "https://parallelum.com.br/fipe/api/v1/%s/marcas",
                    tipoVeiculo
            );
            HttpRequest requestMarcas = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrlMarcas))
                    .GET()
                    .build();

            try {
                HttpResponse<String> responseMarcas = client.send(requestMarcas, HttpResponse.BodyHandlers.ofString());

                if (responseMarcas.statusCode() == 200) {
                    System.out.println("Marcas disponíveis:");
                    String marcas = responseMarcas.body();

                    for (String marca : marcas.split(",")) {
                        System.out.println(marca);
                    }

                } else {
                    System.out.println("Erro ao consultar as marcas. Código de status: " + responseMarcas.statusCode());
                    continue;
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao realizar a requisição: " + e.getMessage());
                continue;
            }
            System.out.println("Digite o código da marca: ");
            String codigoMarca = scanner.nextLine();


            String apiUrlModelos = String.format(
                    "https://parallelum.com.br/fipe/api/v1/%s/marcas/%s/modelos",
                    tipoVeiculo, codigoMarca
            );
            HttpRequest requestModelos = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrlModelos))
                    .GET()
                    .build();
            try {
                HttpResponse<String> responseModelos = client.send(requestModelos, HttpResponse.BodyHandlers.ofString());

                if (responseModelos.statusCode() == 200) {
                    System.out.println("Modelos disponíveis:");
                    String modelos = responseModelos.body();

                    for (String modelo : modelos.split(",")) {
                        System.out.println(modelo);
                    }

                } else {
                    System.out.println("Erro ao consultar os modelos. Código de status: " + responseModelos.statusCode());
                    continue;
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao realizar a requisição: " + e.getMessage());
                continue;
            }

            System.out.println("Digite o código do modelo: ");
            String codigoModelo = scanner.nextLine();

            String apiUrlAno = String.format(
                    "https://parallelum.com.br/fipe/api/v1/%s/marcas/%s/modelos/%s/anos",
                    tipoVeiculo, codigoMarca, codigoModelo
            );

            HttpRequest requestAno = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrlAno))
                    .GET()
                    .build();
            try {
                HttpResponse<String> responseAno = client.send(requestAno, HttpResponse.BodyHandlers.ofString());

                if (responseAno.statusCode() == 200) {
                    System.out.println("Anos disponíveis:");
                    String anos = responseAno.body();

                    for (String ano : anos.split(",")) {
                        System.out.println(ano);
                    }

                    System.out.println("Digite o ano do modelo: ");
                    String anoModelo = scanner.nextLine();

                    String apiUrlFinal = String.format(
                            "https://parallelum.com.br/fipe/api/v1/%s/marcas/%s/modelos/%s/anos/%s",
                            tipoVeiculo, codigoMarca, codigoModelo, anoModelo
                    );

                    HttpRequest requestFinal = HttpRequest.newBuilder()
                            .uri(URI.create(apiUrlFinal))
                            .GET()
                            .build();

                    try {
                        HttpResponse<String> responseFinal = client.send(requestFinal, HttpResponse.BodyHandlers.ofString());

                        if (responseFinal.statusCode() == 200) {
                            System.out.println("Resposta final da API:");
                            System.out.println(responseFinal.body());
                        } else {
                            System.out.println("Erro ao consultar a API final. Código de status: " + responseFinal.statusCode());
                        }
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Erro ao realizar a requisição final: " + e.getMessage());
                    }
                } else {
                    System.out.println("Erro ao consultar os anos. Código de status: " + responseAno.statusCode());
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao realizar a requisição de anos: " + e.getMessage());
            }
        }
    }
}