public class SistemaPedidos {
    public static void main(String[] args) {
        ClientePJ cliente = new ClientePJ("Tech Solutions Ltda", "contato@tech.com", "12.345.678/0001-99");

        Pedido pedidoCartaoAprovado = new Pedido(cliente);
        pedidoCartaoAprovado.adicionarItem(new ItemPedido(new ProdutoDigital("Produto A", 150.0), 1));
        pedidoCartaoAprovado.setMetodoPagamento(new PagamentoCartaoCredito());
        pedidoCartaoAprovado.processarPagamento();

        Pedido pedidoCartaoRecusado = new Pedido(cliente);
        pedidoCartaoRecusado.adicionarItem(new ItemPedido(new ProdutoDigital("Produto B", 500.0), 1));
        pedidoCartaoRecusado.setMetodoPagamento(new PagamentoCartaoCredito());
        pedidoCartaoRecusado.processarPagamento();

        Pedido pedidoBoletoAprovado = new Pedido(cliente);
        pedidoBoletoAprovado.adicionarItem(new ItemPedido(new ProdutoDigital("Produto C", 800.0), 1));
        pedidoBoletoAprovado.setMetodoPagamento(new PagamentoBoleto());
        pedidoBoletoAprovado.processarPagamento();

        Pedido pedidoBoletoRecusado = new Pedido(cliente);
        pedidoBoletoRecusado.adicionarItem(new ItemPedido(new ProdutoDigital("Produto D", 1500.0), 1));
        pedidoBoletoRecusado.setMetodoPagamento(new PagamentoBoleto());
        pedidoBoletoRecusado.processarPagamento();
    }
}