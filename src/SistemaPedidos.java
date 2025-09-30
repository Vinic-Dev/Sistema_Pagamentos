public class SistemaPedidos {
    public static void main(String[] args) {
        ClientePF cliente = new ClientePF("Consumidor Teste", "teste@email.com", "123.456.789-00");

        Pedido pedido1 = new Pedido(cliente);
        pedido1.setMetodoPagamento(new PagamentoCartaoCredito());
        pedido1.processarPagamento(150.0);

        Pedido pedido2 = new Pedido(cliente);
        pedido2.setMetodoPagamento(new PagamentoCartaoCredito());
        pedido2.processarPagamento(500.0);


        Pedido pedido3 = new Pedido(cliente);
        pedido3.setMetodoPagamento(new PagamentoBoleto());
        pedido3.processarPagamento(800.0);

        Pedido pedido4 = new Pedido(cliente);
        pedido4.setMetodoPagamento(new PagamentoBoleto());
        pedido4.processarPagamento(1500.0);
    }
}