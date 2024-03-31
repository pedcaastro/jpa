package infra;

import model.Produto;

public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO(){
        super(Produto.class);
    }
}
