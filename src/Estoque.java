import javax.swing.JOptionPane;

public class Estoque {

    No inicio, fim;
    int tamanho=0;

    public static void inserir(Produto prod){
        No aux = new No(prod);


    }

    public No pesquisar(String nome){
        No aux = inicio;
        boolean achou = false;
        while(aux != null && !achou){
            if(aux.prod.getNome() == nome){
                achou = true;
            } else{
                aux = aux.dir;
            }
        }
        return aux;
    }

    public boolean remover(String nome){
        No aux = pesquisar(nome);
        boolean realizado = false;

        if(aux != null){
            if(tamanho == 1){
                aux.dir = null;
                aux.esq = null;
                inicio = null;
                fim = null;
            } else if(aux == inicio){
                inicio = aux.dir;
                inicio.esq = null;
                aux.dir = null;
            } else if(aux == fim){
                fim = aux.esq;
                fim.dir = null;
                aux.esq = null;
            } else{
                aux.esq.dir = aux.dir;
                aux.dir.esq = aux.esq;
                aux.dir = null;
                aux.esq = null;
            }
            tamanho--;
            realizado = true;
        }
        return realizado;
    }


    public void imprimir(){
        No aux = inicio;
        while(aux!=null){
            JOptionPane.showMessageDialog(null, "Produto: " + aux.prod.getNome() + "\nData de validade: " + aux.prod.getDtValidade() + "\nQuantidade: " + aux.prod.getQtdEstoque());
        }
    }

    
}
