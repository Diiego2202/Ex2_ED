import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String opcao;

        do{
            opcao = JOptionPane.showInputDialog(menu());
                try{   
                    if("".equals(opcao)){               
                    }else if ("1".equals(opcao)){
                        Processo.cadastrarProduto();
                    }else if ("2".equals(opcao)){
                        Processo.listarProduto();
                    }else if ("3".equals(opcao)){
                        Processo.venderProduto();
                    }else if ("4".equals(opcao)){
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"Opção inválido! \nDigite um numero entre 1 e 4");
                        throw new UnsupportedOperationException();
                    }
                
                    }  catch (UnsupportedOperationException e) {
                        e.printStackTrace();
                    }
        }while (opcao != "4");

    }

    public static String menu(){
        String aux  = "Escolha uma opção:";
            aux += "\n1. Cadastrar produto";
            aux += "\n2. Listar produtos";
            aux += "\n3. Vender produto";
            aux += "\n4. Encerrar aplicação";
        
        return aux;   
    }
}
