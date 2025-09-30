class PagamentoCartaoCredito implements IPagamento {
    @Override
    public boolean processarPagamento(double valor) {
        if (valor < 200.0) {
            System.out.println("Pagamento com cartão aprovado: R$ " + valor); return true;
        } else {
            System.out.println("Pagamento com cartão recusado: R$ " + valor);
            return false;
        }
    }
}