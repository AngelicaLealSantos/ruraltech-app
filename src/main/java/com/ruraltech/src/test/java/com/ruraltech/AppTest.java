    // src/test/java/com/ruraltech/AppTest.java

    package com.ruraltech;

    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    public class AppTest {

        @Test
        public void testAgendarEntregaProdutoNaoEncontrado() {
            String produto = "milho";
            App.agendarEntrega("Teste", "Rua Teste", produto, 10, "2024-06-01");
            assertFalse(App.estoque.containsKey(produto));
        }

        @Test
        public void testAgendarEntregaEstoqueInsuficiente() {
            String produto = "arroz";
            int quantidade = 200;
            int estoqueInicial = App.estoque.get(produto);
            App.agendarEntrega("Teste", "Rua Teste", produto, quantidade, "2024-06-01");
            assertEquals(estoqueInicial, (int) App.estoque.get(produto));
        }

        @Test
        public void testAgendarEntrega() {
            String produto = "arroz";
            int quantidade = 20;
            int estoqueInicial = App.estoque.get(produto);
            App.agendarEntrega("Teste", "Rua Teste", produto, quantidade, "2024-06-01");
            assertEquals(estoqueInicial - quantidade, (int) App.estoque.get(produto));
        }
    }
