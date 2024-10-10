/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Venta;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.TypedQuery;

public class VentaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Venta> buscarVentasPorRangoDeFechas(EntityManager em, LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Venta> query = em.createQuery("SELECT v FROM Venta v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin", Venta.class);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        return query.getResultList();
    }
}

