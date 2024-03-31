package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        }
        catch (Exception e){

        }
    }

    public DAO(){
        this(null);
    }
    public DAO(Class<E> classe){
        this.classe = classe;
        em = emf.createEntityManager();
    }

   public DAO<E> abrirT(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fechar(){
        em.getTransaction().commit();
        return this;
    }

   public DAO<E> incluir(E entidade){
        em.persist(entidade);
       return this;
   }

    public DAO<E> incluirAtomico(E entidade){
        return this.abrirT().incluir(entidade).fechar();
    }

    public List<E> obterTodos(){
        return this.obterTodos(10,0);
    }
    public List<E> obterTodos(int qtdeRegistro, int deslocamento){
        if (classe == null){
            throw new UnsupportedOperationException(("Classe nula"));
        }
        String jpql = "select e from " + classe.getName() +" e";
        TypedQuery<E> query = em.createQuery(jpql,classe);
        query.setMaxResults(qtdeRegistro);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    public void fecharDAO(){
    em.close();
    }
}
