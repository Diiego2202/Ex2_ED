import javax.swing.JOptionPane;

public class Estoque {

    static No inicio, fim;
    int tamanho=0;

    public void inserir(Produto prod){
        No aux = new No(prod);
        
        if(inicio == null){
            inicio = aux;
            fim = aux;

        } else if (aux.prod.getDtValidade().compareTo(fim.prod.getDtValidade()) >= 0){                
                aux.esq = fim;
                fim.dir = aux;
                fim = aux;
        } else if (aux.prod.getDtValidade().compareTo(inicio.prod.getDtValidade()) <= 0) {
                aux.dir = inicio;
                inicio.esq = aux;
                inicio = aux;
            } else {
                No aux2 = inicio;
                No aux3 = aux;
                while(aux2 != null) {
                    if(aux.prod.getDtValidade().compareTo(aux2.prod.getDtValidade()) <= 0 ) {
                        aux3.dir = aux;
                        aux.esq = aux3;
                        aux.dir = aux2;
                        aux2.esq = aux;
                        break;
                    } else {
                        aux3 = aux2;
                        aux2 = aux2.dir;
                    }
			    } 
            }
        
        tamanho++;
    }
    

    public No pesquisar(String nome){
        No aux = inicio;
        boolean achou = false;
        while(aux != null && !achou){
            if(aux.prod.getNome().equals(nome)){
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
            aux = aux.dir;
        }
    }

    
}
