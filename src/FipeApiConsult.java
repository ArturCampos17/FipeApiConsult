import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class FipeApiConsult {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        boolean continuar = true;

        while (continuar) {
    String tipoVeiculo = "";
            while (true) {

                System.out.println("Escolha o tipo de veicuo:");
                System.out.println(" 1 - Carro");
                System.out.println(" 2 - Moto");
                System.out.println(" 3 - Caminhão");
                System.out.println("Digite a opção: ");
                String opcao = scanner.nextLine();

                if (opcao.equals("1")){
                    tipoVeiculo = "carros";
                    break;
                }
                else if (opcao.equals("2")){
                    tipoVeiculo = "motos";
                    break;
                }
                else if (opcao.equals("3")){
                    tipoVeiculo = "caminhao";
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
            System.out.println("Digite o código da marca: ");

            String codigoMarca = scanner.nextLine();

            System.out.println("Digite o código do modelo: ");
            String codigoModelo = scanner.nextLine();

            System.out.println("Digite o ano do modelo: ");
            String anoModelo = scanner.nextLine();


            String apiUrl = String.format(
                    "https://parallelum.com.br/fipe/api/v1/%s/marcas/%s/modelos/%s/anos/%s",
                    tipoVeiculo, codigoMarca, codigoModelo, anoModelo
            );


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            try {

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    System.out.println("Resposta da API:");
                    System.out.println(response.body());
                } else {
                    System.out.println("URL gerada: " + apiUrl);
                    System.out.println("Erro ao consultar a API. Código de status: " + response.statusCode());
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao realizar a requisição: " + e.getMessage());
            }


            System.out.println("\nDeseja realizar outra consulta? Digite 1 para sim ou qualquer outra tecla para sair: ");
            String resposta = scanner.nextLine();
            continuar = resposta.equals("1");
        }

        System.out.println("Encerrando o programa. Até logo!");
        scanner.close();
    }
}
