import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Imprimivel {
    private LocalDate data;
    private List<ItemPedido> itens;
    private Cliente cliente;
    private IPagamento metodoPagamento;

    public Pedido(Cliente cliente) {
        this.data = LocalDate.now();
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        this.metodoPagamento = null;
    }

    public void setMetodoPagamento(IPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public boolean processarPagamento(double valor) {
        if (this.metodoPagamento == null) {
            System.out.println("ERRO: Nenhum método de pagamento foi definido.");
            return false;
        }
        return this.metodoPagamento.processarPagamento(valor);
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : this.itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public String gerarRecibo() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("---------------- RECIBO ----------------\n");
        sb.append("Cliente: ").append(this.cliente.getNome()).append("\n");
        sb.append("Data: ").append(this.data.format(dtf)).append("\n\n");
        sb.append("Itens:\n");

        for (ItemPedido item : this.itens) {
            sb.append(String.format("- %-25s | Qtd: %2d | Subtotal: R$ %8.2f\n",
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    item.getSubtotal()));
        }

        sb.append(String.format("\nTOTAL DO PEDIDO: R$ %.2f\n", this.calcularTotal()));
        sb.append("----------------------------------------\n");
        return sb.toString();
    }
}