public class Produto {
    
    private String nome, dtValidade;
    private int qtdEstoque;

    public Produto(String nome, String dtValidade, int qtdEstoque){
        this.nome = nome;
        this.dtValidade = dtValidade;
        this.qtdEstoque = qtdEstoque;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(String dtValidade) {
        this.dtValidade = dtValidade;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    
}
