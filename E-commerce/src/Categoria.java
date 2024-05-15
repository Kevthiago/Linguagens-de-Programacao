import java.util.ArrayList;
import java.util.List;

public class Categoria extends Produto{
    //Atributos
    private int IdCategoria;
    private String nomeCategoria, descCategoria;
    private List<Produto> produtosCategoria = new ArrayList<>();

    //Getters and Setters
    public int getIdCategoria() {
        return IdCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        IdCategoria = idCategoria;
    }
    public String getNomeCategoria() {
        return nomeCategoria;
    }
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    public String getDescCategoria() {
        return descCategoria;
    }
    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }
    public List<Produto> getProdutosCategoria() {
        return produtosCategoria;
    }
    public void setProdutosCategoria(List<Produto> produtosCategoria) {
        this.produtosCategoria = produtosCategoria;
    }

    //Outros métodos
    //Ex: add produto a categoria, remover, listar...
}

