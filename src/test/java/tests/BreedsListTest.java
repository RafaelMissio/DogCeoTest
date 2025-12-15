package tests;

import base.BaseTest;
import io.qameta.allure.*;
import models.BreedsListResponse;
import org.junit.jupiter.api.Test;
import services.BreedsService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Dog API")
@Feature("Listar Raças")
@Owner("Rafael Missio")
@Severity(SeverityLevel.NORMAL)
public class BreedsListTest extends BaseTest {

    BreedsService service = new BreedsService();

    @Test
    @Story("Validar lista completa de raças")
    @Description("Confirma que o endpoint /breeds/list/all retorna todas as raças disponíveis")
    public void validarListaDeRacas() {
        BreedsListResponse response = service.listarTodasAsRacas().as(BreedsListResponse.class);

        assertAll("Validações da lista de raças",
                () -> assertNotNull(response, "Response não pode ser nulo"),
                () -> assertNotNull(response.getStatus(), "Status não pode ser nulo"),
                () -> assertEquals("success", response.getStatus(), "Status esperado: 'success'"),
                () -> assertNotNull(response.getMessage(), "Message não pode ser nulo"),
                () -> assertFalse(response.getMessage().isEmpty(), "Message não deve estar vazia"),
                () -> assertTrue(response.getMessage().keySet().stream().allMatch(k -> k instanceof String), "Todas as chaves devem ser String"),
                () -> assertTrue(response.getMessage().containsKey("hound"), "Deve conter a chave 'hound'")
        );
    }

    @Test
    public void CT02_validarEstruturaDoJson_service() {

        BreedsListResponse response = service.listarTodasAsRacas().as(BreedsListResponse.class);

        assertAll("Validar estrutura básica do JSON",
                () -> assertNotNull(response, "Response não pode ser nulo"),
                () -> assertNotNull(response.getStatus(), "Status não pode ser nulo"),
                () -> assertEquals("success", response.getStatus(), "Status esperado: 'success'"),
                () -> {
                    Map<?,?> message = assertInstanceOf(Map.class, response.getMessage(), "Message deve ser um Map");
                    assertFalse(message.isEmpty(), "Message não deve estar vazio");
                    assertTrue(message.keySet().stream().allMatch(k -> k instanceof String), "Todas as chaves devem ser String");

                    if (message.containsKey("hound")) {
                        Object val = message.get("hound");
                        assertNotNull(val, "Valor de 'hound' não pode ser nulo");
                        assertTrue(
                                val instanceof java.util.Collection || val instanceof String || val.getClass().isArray(),
                                "Valor de 'hound' deve ser uma coleção, string ou array"
                        );
                    }
                }
        );
    }
}
