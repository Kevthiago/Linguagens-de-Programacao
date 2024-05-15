public class Produto {
    //Atributos
    private int IdProduto;
    private String nomeProduto, descProduto, categoriaProduto, marcaProduto;
    private double preco;
    private int estoqueProduto;

    //Getters and Setters
    public int getIdProduto() {
        return IdProduto;
    }
    public void setIdProduto(int idProduto) {
        IdProduto = idProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getDescProduto() {
        return descProduto;
    }
    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }
    public String getCategoriaProduto() {
        return categoriaProduto;
    }
    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
    public String getMarcaProduto() {
        return marcaProduto;
    }
    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getEstoqueProduto() {
        return estoqueProduto;
    }
    public void setEstoqueProduto(int estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

    //Outros métodos

}
