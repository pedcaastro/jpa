package teste;

import infra.DAO;
import model.Produto;

public class NovoProduto {
    public static void main(String[] args) {

        DAO< Produto> dao = new DAO<>(Produto.class);
        Produto produto2 = new Produto("Feijao",5.45);

}
}
