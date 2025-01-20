    // src/main/java/com/ruraltech/App.java

    package com.ruraltech;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class App {
        public static Map<String, Integer> estoque = new HashMap<>();
        public static List<Map<String, String>> agendamentos = new ArrayList<>();

        static {
            estoque.put("arroz", 100);
            estoque.put("feijao", 200);
            estoque.put("batata", 150);
            estoque.put("tomate", 120);
        }

        public static void agendarEntrega(String cliente, String endereco, String produto, int quantidade, String dataEntrega) {
            if (!estoque.containsKey(produto)) {
                System.out.println("Produto " + produto + " não encontrado no estoque.");
                return;
            }

            if (estoque.get(produto) < quantidade) {
                System.out.println("Estoque insuficiente para " + produto + ". Apenas " + estoque.get(produto) + " kg disponível.");
                return;
            }

            estoque.put(produto, estoque.get(produto) - quantidade);

            Map<String, String> agendamento = new HashMap<>();
            agendamento.put("cliente", cliente);
            agendamento.put("endereco", endereco);
            agendamento.put("produto", produto);
            agendamento.put("quantidade", String.valueOf(quantidade));
            agendamento.put("dataEntrega", dataEntrega);

            agendamentos.add(agendamento);

            System.out.println("Entrega agendada para " + cliente + " no endereço " + endereco + " no dia " + dataEntrega + ".");
        }

        public static void verificarEstoque() {
            for (Map.Entry<String, Integer> entry : estoque.entrySet()) {
                System.out.println("Produto: " + entry.getKey() + ", Quantidade em estoque: " + entry.getValue() + " kg");
            }
        }

        public static void verificarAgendamentos() {
            if (agendamentos.isEmpty()) {
                System.out.println("Nenhum agendamento registrado.");
            } else {
                for (Map<String, String> agendamento : agendamentos) {
                    System.out.println("Cliente: " + agendamento.get("cliente") + ", Produto: " + agendamento.get("produto") +
                            ", Quantidade: " + agendamento.get("quantidade") + " kg, Data de entrega: " + agendamento.get("dataEntrega"));
                }
            }
        }

        public static void main(String[] args) {
            agendarEntrega("Bia", "Rua A, 123", "arroz", 20, "2024-05-01");
            agendarEntrega("Angélica", "Rua B, 456", "feijao", 50, "2024-05-02");

            System.out.println("\nEstoque atualizado:");
            verificarEstoque();

            System.out.println("\nAgendamentos:");
            verificarAgendamentos();
        }
    }
