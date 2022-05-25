import javax.swing.JOptionPane;

public class Processo {

    static Estoque estoque = new Estoque();

    public static void cadastrarProduto(){
        String nome = JOptionPane.showInputDialog(null, "Nome do produto: ");
        int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia de vencimento: "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Mês de vencimento: "));
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano de vencimento: "));
        String dtValidade = ano + "/" + mes + "/" + dia;
        int qtdEstoque = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade em estoque: "));

        Produto prod = new Produto(nome, dtValidade, qtdEstoque);
        estoque.inserir(prod);

    }

    public static void listarProduto(){
        estoque.imprimir();
    }

    public static void venderProduto(){
        String nome = JOptionPane.showInputDialog("Nome do produto: ");
        No aux = estoque.pesquisar(nome);
        if(aux == null){
            JOptionPane.showMessageDialog(null, "ERRO!! Produto não encontrdo!");
        } else{
            JOptionPane.showMessageDialog(null, "Produto: " + aux.prod.getNome() + "\nData de validade: " + aux.prod.getDtValidade() + "\nQuantidade: " + aux.prod.getQtdEstoque());
            int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade desejada: "));
            if(qtd > aux.prod.getQtdEstoque()){
                JOptionPane.showMessageDialog(null, "ERRO!! Quantidade inválida!");
            } else{
                aux.prod.setQtdEstoque(aux.prod.getQtdEstoque() - qtd);
                JOptionPane.showMessageDialog(null, "Venda realizada :)");
            }
        }
        
    }
    
}
