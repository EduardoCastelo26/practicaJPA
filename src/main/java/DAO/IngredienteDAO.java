/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entidades.Ingrediente;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
/**
 *
 * @author eduar
 */
public class IngredienteDAO {
    
    
    private EntityManager entityManager;
    
     public IngredienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Ingrediente> buscarIngredientesPorNombre(String letra) {
        String columna = "SELECT A FROM Ingrediente A WHERE A.nombre LIKE :inicio OR A.nombre LIKE :fin";
        return entityManager.createQuery(columna, Ingrediente.class)
                .setParameter("inicio", letra + "%")
                .setParameter("fin", "%" + letra)
                .getResultList();
    }
    
    
    
    
}
