package teste;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class,1L);
        em.detach(usuario); // objeto não gerenciado
        System.out.println(usuario.getEmail());

        usuario.setNome("roberto");
        usuario.setEmail("dfffdsaf@gmail.com");

        em.merge(usuario); // mudança no banco de dados

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
