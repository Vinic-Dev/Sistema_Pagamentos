class PagamentoBoleto implements IPagamento {
    @Override
    public boolean processarPagamento(double valor) {
        if (valor < 1000.0) {
            System.out.println("Pagamento com boleto aprovado: R$ " + valor); return true;
        } else {
            System.out.println("Pagamento com boleto recusado: R$ " + valor);
            return false;
        }
    }
}