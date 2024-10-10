/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entidades.Producto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import javax.persistence.TypedQuery;
/**
 *
 * @author eduar
 */
public class ProdDAO {
   
    @PersistenceContext
    private EntityManager entityManager;

    public List<Producto> buscarProductosPorPrecioMayorA(EntityManager em, double precio) {
        TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p WHERE p.precio > :precio", Producto.class);
        query.setParameter("precio", precio);
        return query.getResultList();
    }
}
