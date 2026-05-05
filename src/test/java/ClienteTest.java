package test.java;

import org.junit.jupiter.api.Test;
import main.java.Cliente;
import main.java.Produto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Produto produto = new Produto("Notebook", 3000.00);
        Cliente cliente = new Cliente("João");
        cliente.monitorar(produto);

        produto.atualizarPreco(2500.00);

        assertNotNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Produto produto = new Produto("Notebook", 3000.00);
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");
        cliente1.monitorar(produto);
        cliente2.monitorar(produto);

        produto.atualizarPreco(2500.00);

        assertNotNull(cliente1.getUltimaNotificacao());
        assertNotNull(cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteNaoMonitorando() {
        Produto produto = new Produto("Notebook", 3000.00);
        Cliente cliente = new Cliente("João");

        produto.atualizarPreco(2500.00);

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasClientesDoProdutoCorreto() {
        Produto produtoA = new Produto("Notebook", 3000.00);
        Produto produtoB = new Produto("Celular", 1500.00);
        Cliente cliente = new Cliente("João");
        cliente.monitorar(produtoA);

        produtoB.atualizarPreco(1200.00);

        assertNull(cliente.getUltimaNotificacao());
    }
}
