package teste;

import infra.ProdutoDAO;
import model.Produto;

import java.util.List;

public class ObterProduto {
    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos1 = dao.obterTodos();

        for (Produto produto : produtos1){
            System.out.println("ID:" + produto.getId() + ", Nome:" + produto.getNome());
        }

        double precoTotal = produtos1
                .stream()
                .map(p-> p.getPreco())
                .reduce(0.0,(t,p) -> t+p)
                .doubleValue();

        System.out.println("Valor total: " + precoTotal);


    }
}
