package com.limbo.service;

import com.limbo.DAO.CompraAccess;
import com.limbo.DAO.CompraDAO;
import com.limbo.entities.Compra;
import com.limbo.entities.DetallCompra;

public class CompraServiceAccess implements CompraService {
    @Override
    public Compra save(Compra compra) throws Exception {
        CompraDAO cd = new CompraAccess();
        return cd.save(compra);
    }

    @Override
    public DetallCompra saveDetall(DetallCompra detallCompra) throws Exception {
        CompraDAO cd = new CompraAccess();
        return cd.saveDetall(detallCompra);
    }
}
