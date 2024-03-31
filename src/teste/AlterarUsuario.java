package teste;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class,1L);
        System.out.println(usuario.getEmail());

        usuario.setNome("Roberto");
        usuario.setEmail("dffsaf@gmail.com");

        em.merge(usuario);

        em.getTransaction().commit();




        emf.close();
        em.close();
    }
}
