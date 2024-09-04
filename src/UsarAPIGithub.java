import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class UsarAPIGithub {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Digite o usuário procurado no Github.");
        Scanner sc = new Scanner(System.in);
        String usuarioProcurado = sc.nextLine();
        String endereco = "https://api.github.com/users/" + usuarioProcurado;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco))
                .header("Accept", "application/vnd.github.v3+json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        Gson gson = new Gson();

        PerfilGithubIntermediario i = gson.fromJson(response.body(), PerfilGithubIntermediario.class);

        try {
            PerfilGithub p = new PerfilGithub(i);
            System.out.println(p);
        } catch(ErroConsultaGitHubException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}
