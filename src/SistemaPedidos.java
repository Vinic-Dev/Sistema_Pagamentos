public class SistemaPedidos {
    public static void main(String[] args) {
        ClientePJ cliente = new ClientePJ("Tech Solutions Ltda", "contato@tech.com", "12.345.678/0001-99");

        Pedido pedido1 = new Pedido(cliente);
        pedido1.adicionarItem(new ItemPedido(new ProdutoDigital("Produto A", 150.0), 1));
        pedido1.setMetodoPagamento(new PagamentoCartaoCredito());
        pedido1.processarPagamento();

        Pedido pedido2 = new Pedido(cliente);
        pedido2.adicionarItem(new ItemPedido(new ProdutoDigital("Produto B", 500.0), 1));
        pedido2.setMetodoPagamento(new PagamentoCartaoCredito());
        pedido2.processarPagamento();

        Pedido pedido3 = new Pedido(cliente);
        pedido3.adicionarItem(new ItemPedido(new ProdutoDigital("Produto C", 800.0), 1));
        pedido3.setMetodoPagamento(new PagamentoBoleto());
        pedido3.processarPagamento();

        Pedido pedido4 = new Pedido(cliente);
        pedido4.adicionarItem(new ItemPedido(new ProdutoDigital("Produto D", 1500.0), 1));
        pedido4.setMetodoPagamento(new PagamentoBoleto());
        pedido4.processarPagamento();
    }
}