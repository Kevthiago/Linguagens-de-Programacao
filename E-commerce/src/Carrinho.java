import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    //Atributos
    private int IdCarrinho;
    private Usuario usuario;
    private List<Carrinho> itensCarrinhos = new ArrayList<>();
    private double valorTotal;

    //Getters and Setters
    public int getIdCarrinho() {
        return IdCarrinho;
    }
    public void setIdCarrinho(int idCarrinho) {
        IdCarrinho = idCarrinho;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setItensCarrinhos(List<Carrinho> itensCarrinhos) {
        this.itensCarrinhos = itensCarrinhos;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    //Outros métodos
    //Método para add itens ao carrinho
    public void addItemCarrinho(Carrinho item){
        itensCarrinhos.add(item);
        calcularValorTotal();
    }

    //Método para remover itens do carrinho
    public void removerItemCarrinho(Carrinho item){
        itensCarrinhos.remove(item);
        calcularValorTotal();
    }

    //Método para retornar os itens do carrinho
    public List<Carrinho> getItensCarrinhos(){
        return itensCarrinhos;
    }

    //Método para calcular valor do carrinho
    private void calcularValorTotal() {
        itensCarrinhos.clear();
        valorTotal = 0;
    }

    //Método para esvaziar o carrinho
    private void esvaziarCarrinho(){
        itensCarrinhos.clear();
        valorTotal = 0;
    }
}

