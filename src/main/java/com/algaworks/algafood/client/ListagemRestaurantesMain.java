package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import org.springframework.web.client.RestTemplate;

public class ListagemRestaurantesMain {

    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            RestauranteClient restauranteClient = new RestauranteClient(
                    restTemplate, "http://localhost:8080");

            restauranteClient. listar().stream()
                    .forEach(restaurante -> System.out.println(restaurante));
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem());
            } else {
                System.out.println("Erro desconhecido");
                e.printStackTrace();
            }
        }
    }

}
