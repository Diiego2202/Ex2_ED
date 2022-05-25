import javax.swing.JOptionPane;

public class Processo {

    Estoque estoque = new Estoque();

    public static void cadastrarProduto(){


    }

    public void listarProduto(){
        estoque.imprimir();
    }

    public void venderProduto(){
        String nome = JOptionPane.showInputDialog("Nome do produto: ");
        No aux = estoque.pesquisar(nome);
        if(aux == null){
            JOptionPane.showMessageDialog(null, "ERRO!! Produto não encontrdo!");
        } else{
            JOptionPane.showMessageDialog(null, "Produto: " + aux.prod.getNome() + "\nData de validade: " + aux.prod.getDtValidade() + "\nQuantidade: " + aux.prod.getQtdEstoque());
            Integer.parseInt(JOptionPane.showInputDialog(""));
        }
        
    }
    
}
